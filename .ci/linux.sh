#!/bin/bash

tar xzfp $JPACKAGE_ARCHIVE_NAME

sudo apt-get update
# deb
sudo apt-get install fakeroot
# rpm
sudo apt-get install rpm
