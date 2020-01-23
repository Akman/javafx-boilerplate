#!/bin/bash

# ci/linux/install.sh

set -ev

JPACKAGE_JDK_BASE_URL=https://download.java.net/java/early_access/jdk14/32/GPL
JPACKAGE_JDK_ARCHIVE_NAME=openjdk-14-ea+32_linux-x64_bin.tar.gz
JPACKAGE_JDK_HOME=jdk-14

wget -q $JPACKAGE_JDK_BASE_URL/$JPACKAGE_JDK_ARCHIVE_NAME
tar xzfp $JPACKAGE_JDK_ARCHIVE_NAME
echo "export BADASS_JLINK_JPACKAGE_HOME=$(pwd)/$JPACKAGE_JDK_HOME" >> .travis.env

echo 'export GRADLE_OPTS="-Dorg.gradle.daemon=true"' >> .travis.env

sudo apt-get update -y
sudo apt-get install -y fakeroot
sudo apt-get install -y rpm
