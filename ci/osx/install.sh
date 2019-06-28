#!/bin/bash

# ci/osx/install.sh

JPACKAGE_JDK_BASE_URL=https://download.java.net/java/early_access/jpackage/49
JPACKAGE_JDK_ARCHIVE_NAME=openjdk-13-jpackage+49_osx-x64_bin.tar.gz
JPACKAGE_JDK_HOME=jdk-13.jdk/Contents/Home

wget -q $JPACKAGE_JDK_BASE_URL/$JPACKAGE_JDK_ARCHIVE_NAME
tar xzfp $JPACKAGE_JDK_ARCHIVE_NAME
echo "export BADASS_JLINK_JPACKAGE_HOME=$(pwd)/$JPACKAGE_JDK_HOME" >> .travis.env

echo 'export GRADLE_OPTS="-Dfile.encoding=utf-8"' >> .travis.env
