#!/bin/bash

# ci/osx/install.sh

set -ev

# https://jdk.java.net/archive
JPACKAGE_JDK_BASE_URL=https://download.java.net/java/GA/jdk14.0.2/205943a0976c4ed48cb16f1043c5c647/12/GPL
JPACKAGE_JDK_ARCHIVE_NAME=openjdk-14.0.2_osx-x64_bin.tar.gz

#/Users/travis/build/Akman/javafx-boilerplate/jdk-14.jdk/Contents/Home/bin/jpackage does not exist.

JPACKAGE_JDK_HOME=jdk-14.jdk/Contents/Home
wget -q $JPACKAGE_JDK_BASE_URL/$JPACKAGE_JDK_ARCHIVE_NAME
tar xzfp $JPACKAGE_JDK_ARCHIVE_NAME
pwd
ls -al
echo "export JPACKAGE_HOME=$(pwd)/$JPACKAGE_JDK_HOME" >> .travis.env
