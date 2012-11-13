Installation
============

To use this software you have to compile your own Android image, which can be
started in an emulator (or deployed on a device, of course).

The building procedure was testet on Ubuntu LTS (10.04).

For building your own Android image with SAI support the following steps are
necessary:

* Download the Android sources from google
* Patch the sources with the SAI software
* Build your own image

Download Android Sources
------------------------

You can find a detailed tutorial at
http://source.android.com/source/initializing.html.
Please follow these steps until you reach the moment, where you have to type
'make -j4' to build the image. Before you do that, you have to patch the sources.

Patch the Android Sources
-------------------------

Under /src you find the files which have to be patched. The path to these files
in the git repo is the path, where you can find the files in the Android source
code. Replace the original files with this versions (or you can write the diff
by yourself ;).

Build the Image
---------------

Now you can type 'make -j4' to build your own Android image with the SAI patch.
To start the emulator, type 'emulator' after building.
