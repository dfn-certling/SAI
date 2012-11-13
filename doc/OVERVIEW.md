Overview
========

The patch provided with SAI is a hook in the PackageManagerService.java. Here
the code suspends the installation process of an APK and sends an Intent with
the Uri of the APK to the SaiService.java. The SaiService is checking if there
is any app installed that listens to the specific SAI BroadcastIntent. If there
is no app, the installation process proceeds as normal. But if there is an app,
the SaiService sends this specific BroadcastIntent with the Uri of the APK as
the data. The app which listens on the BroadcastIntent can unpack the Uri of the
APK and start some operations on or with this APK. After finishing these
operations, the app sends an Intent back to the SaiService with the information
whether the APK should be installed or not.

You can find an example app under /example.
