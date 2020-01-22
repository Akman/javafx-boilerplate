#!/bin/bash

# ci/windows/install.sh

set -ev

JPACKAGE_JDK_BASE_URL=https://download.java.net/java/early_access/jdk14/32/GPL
JPACKAGE_JDK_ARCHIVE_NAME=openjdk-14-ea+32_windows-x64_bin.zip
JPACKAGE_JDK_HOME=jdk-14

wget -q $JPACKAGE_JDK_BASE_URL/$JPACKAGE_JDK_ARCHIVE_NAME
7z x -bd $JPACKAGE_JDK_ARCHIVE_NAME
echo "export BADASS_JLINK_JPACKAGE_HOME=$(pwd)/$JPACKAGE_JDK_HOME" >> .travis.env

choco install adoptopenjdk --version 13.0.1.9 -y
echo 'export JAVA_HOME="/c/Program Files/AdoptOpenJDK/jdk-13.0.1+9"' >> .travis.env
echo 'export PATH="/c/Program Files/AdoptOpenJDK/jdk-13.0.1+9/bin":$PATH' >> .travis.env

echo 'export GRADLE_OPTS="-Dfile.encoding=utf-8 -Dorg.gradle.daemon=false"' >> .travis.env

choco install innosetup --version 5.6.1 -y
