SAI
===

SKIMS App Installation Interceptor

Overview
--------

SAI is a proof of concept, which intercepts the installation of an Android app and
sends a specific BroadcastIntent. Because of modifying the Android Framework, SAI
intercepts every kind of installations (Market, ADB and other apps like Dropbox,
Filemanager, etc...). 3rd party apps can receive this BroadcastIntent
and operate on the APK to be installed. For example, the 3rd party can check the
APK for interesting facts or start an Activity, where some extra information is
presented to the user. Finally, the 3rd party has to send an Intent back to the
SAI App with the decision, whether the APK should be installed or not.

IMPORTANT: Please remember every time that this piece of code is a prototype which
can help you with developing, testing and playing around. SAI is not designed and
implemented for productive environments.

This software is tested with Android Icecream 4.0.3. But it should work with
newer versions too.

For more details see OVERVIEW.md in /doc.

History
-------

This software was developed at DFN-CERT Services GmbH (https://www.dfn-cert.de)
in the context of the research project SKIMS (http://www.realmv6.org/skims.htm).

Installation and usage
----------------------

See INSTALL.md in /doc.
See USAGE.md in /doc.

Contact
-------

concept and author: timo.schaepe at web.de
concept: keil at dfn-cert.de
