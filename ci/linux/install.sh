#!/bin/bash

# ci/linux/install.sh

set -ev

JPACKAGE_JDK_BASE_URL=https://download.java.net/java/early_access/jdk15/15/GPL
JPACKAGE_JDK_ARCHIVE_NAME=openjdk-15-ea+15_linux-x64_bin.tar.gz
JPACKAGE_JDK_HOME=jdk-15
wget -q $JPACKAGE_JDK_BASE_URL/$JPACKAGE_JDK_ARCHIVE_NAME
tar xzfp $JPACKAGE_JDK_ARCHIVE_NAME
echo "export JPACKAGE_HOME=$(pwd)/$JPACKAGE_JDK_HOME" >> .travis.env

sudo apt-get update -y
sudo apt-get install -y fakeroot
sudo apt-get install -y rpm
