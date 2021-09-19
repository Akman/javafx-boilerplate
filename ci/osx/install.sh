#!/bin/bash

# ci/osx/install.sh

set -ev

# JPACKAGE_JDK_BASE_URL=https://download.java.net/java/GA/jdk14.0.2/205943a0976c4ed48cb16f1043c5c647/12/GPL
# JPACKAGE_JDK_ARCHIVE_NAME=openjdk-14.0.2_osx-x64_bin.tar.gz
# JPACKAGE_JDK_HOME=jdk-14.0.2.jdk/Contents/Home
# wget -q $JPACKAGE_JDK_BASE_URL/$JPACKAGE_JDK_ARCHIVE_NAME
# tar xzfp $JPACKAGE_JDK_ARCHIVE_NAME
# echo "export JPACKAGE_HOME=$(pwd)/$JPACKAGE_JDK_HOME" >> .travis.env

echo "export JPACKAGE_HOME=$JAVA_HOME" >> .travis.env
