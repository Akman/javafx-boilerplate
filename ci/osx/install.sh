#!/bin/bash

# ci/osx/install.sh

set -ev

JPACKAGE_JDK_BASE_URL=https://download.java.net/java/early_access/jdk14/32/GPL
JPACKAGE_JDK_ARCHIVE_NAME=openjdk-14-ea+32_osx-x64_bin.tar.gz
JPACKAGE_JDK_HOME=jdk-14.jdk/Contents/Home

wget -q $JPACKAGE_JDK_BASE_URL/$JPACKAGE_JDK_ARCHIVE_NAME
tar xzfp $JPACKAGE_JDK_ARCHIVE_NAME
echo "export BADASS_JLINK_JPACKAGE_HOME=$(pwd)/$JPACKAGE_JDK_HOME" >> .travis.env
