#!/bin/bash

# ci/windows/install.sh

set -ev

JAVA_JDK_BASE_URL=https://download.bell-sw.com/java/18.0.1+12
JAVA_JDK_ARCHIVE_NAME=bellsoft-jdk18.0.1+12-windows-amd64.zip
JAVA_JDK_HOME=jdk-18.0.1
echo "export JAVA_HOME=$(pwd)/$JAVA_JDK_HOME" >> .travis.env

JPACKAGE_JDK_BASE_URL=https://download.java.net/java/GA/jdk14.0.2/205943a0976c4ed48cb16f1043c5c647/12/GPL
JPACKAGE_JDK_ARCHIVE_NAME=openjdk-14.0.2_windows-x64_bin.zip
JPACKAGE_JDK_HOME=jdk-14.0.2
echo "export JPACKAGE_HOME=$(pwd)/$JPACKAGE_JDK_HOME" >> .travis.env

WIX_BASE_URL=https://github.com/wixtoolset/wix3/releases/download/wix3112rtm
WIX_ARCHIVE_NAME=wix311-binaries.zip
WIX_HOME=wix-3.11.2
echo "export WIX=$(pwd)/$WIX_HOME" >> .travis.env

echo "export PATH=$JAVA_HOME/bin:$WIX:$PATH" >> .travis.env

echo 'export GRADLE_OPTS="-Dorg.gradle.daemon=false -Dfile.encoding=UTF-8"' >> .travis.env

wget -q $JAVA_JDK_BASE_URL/$JAVA_JDK_ARCHIVE_NAME
7z x -bd $JAVA_JDK_ARCHIVE_NAME

wget -q $JPACKAGE_JDK_BASE_URL/$JPACKAGE_JDK_ARCHIVE_NAME
7z x -bd $JPACKAGE_JDK_ARCHIVE_NAME

wget -q $WIX_BASE_URL/$WIX_ARCHIVE_NAME
7z x -bd -o$WIX_HOME wix311-binaries.zip
