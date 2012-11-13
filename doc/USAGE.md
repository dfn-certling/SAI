Usage
=====

Using the installation interception hook of SAI you have to write your own
Android app and install it on your SAI-build of Android as a normal user app.

To cooperate with SAI your app has to satisfy two important requirements:

* Implement a BroadcastReceiver in the AndroidManifest.xml
* Send an Intent back to the SaiService

If you app fullfills these requirements, it is called everytime an APK is
installed. From the BroadcastIntent you can get the absolute path to the APK
with "intent.getData()".

You can prevent the interception of installations by starting the SAI app in the
Launcher and disable it.

1. Implement a BroadcastReceiver in the AndroidManifest.xml
------------------------------------------------------------

As you can see in /doc/OVERVIEW.md the SAI patch intercepts the installation of
an APK and sends a specific BroadcastIntent if there is an app that implements
a BroadcastReceiver for exact this specific BroadcastIntent. So you have to
put this BroadcastReceiver in your AndroidManifest.xml into the <application>
tag, where "MyReceiver" is the name of your BroadcastReceiver class.

  <receiver android:name="MyReceiver" >
    <intent-filter>
      <action android:name="de.dfncert.sai.install_hook" />
    </intent-filter>
  </receiver>

Of course, you have to implement the BroadcastReceiver, here e.g.
MyReceiver.java.

IMPORTANT: You have to include the receiver definition into the
AndroidManifest.xml. It is not possible to register your receiver in the
BroadcastReceiver class source code, because Android and therefore the SAI code
cannot recognize this. SAI would think that no app is there to listen to the
Intent and simply proceed with the installation of the APK.

NOTE: If there is more than one app with a BroadcastReceiver for SAI each of these
apps will receive the BroadcastIntent. This leads to a race condition: The first
Intent send by one of these apps which arrives at the SaiService will be accepted
and interpreted, all other Intents will be ignored. Please remember, this is a
prototype and it is not designed for productive operation.

2. Send an Intent back to the SaiService
----------------------------------------

Your app has to send back an Intent to SaiService after ending the operation on
the APK. This Intent tells the SaiService whether the APK should be installed
or not. The following code has to be called after completing your operations,
where packageUri is the Uri of the package (you received this before via the
BroadcastIntent) and the extra is either "install" or "abort":

  Intent intent = new Intent();
  intent.setComponent(new ComponentName("de.dfncert.sai", "de.dfncert.sai.SaiService"));
  intent.setData(packageUri);
  intent.putExtra("action", "install|abort");
  startService(intent);
