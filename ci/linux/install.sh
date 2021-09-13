#!/bin/bash

# ci/linux/install.sh

set -ev

# https://jdk.java.net/archive
JPACKAGE_JDK_BASE_URL=https://download.java.net/java/GA/jdk14.0.2/205943a0976c4ed48cb16f1043c5c647/12/GPL
JPACKAGE_JDK_ARCHIVE_NAME=openjdk-14.0.2_linux-x64_bin.tar.gz
JPACKAGE_JDK_HOME=jdk-14
wget -q $JPACKAGE_JDK_BASE_URL/$JPACKAGE_JDK_ARCHIVE_NAME
tar xzfp $JPACKAGE_JDK_ARCHIVE_NAME
echo "export JPACKAGE_HOME=$(pwd)/$JPACKAGE_JDK_HOME" >> .travis.env

sudo apt-get update -y
sudo apt-get install -y fakeroot
sudo apt-get install -y rpm
