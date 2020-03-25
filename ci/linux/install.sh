#!/bin/bash

# ci/linux/install.sh

set -ev

JPACKAGE_JDK_BASE_URL=https://github.com/AdoptOpenJDK/openjdk14-binaries/releases/download/jdk-14%2B36
JPACKAGE_JDK_ARCHIVE_NAME=OpenJDK14U-jdk_x64_linux_hotspot_14_36.tar.gz
JPACKAGE_JDK_HOME=jdk-14
wget -q $JPACKAGE_JDK_BASE_URL/$JPACKAGE_JDK_ARCHIVE_NAME
tar xzfp $JPACKAGE_JDK_ARCHIVE_NAME
echo "export BADASS_JLINK_JPACKAGE_HOME=$(pwd)/$JPACKAGE_JDK_HOME" >> .travis.env

sudo apt-get update -y
sudo apt-get install -y fakeroot
sudo apt-get install -y rpm
