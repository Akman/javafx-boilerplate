#!/bin/bash

# ci/windows/install.sh

set -ev

JPACKAGE_JDK_BASE_URL=https://download.java.net/java/early_access/jdk15/15/GPL
JPACKAGE_JDK_ARCHIVE_NAME=openjdk-15-ea+15_windows-x64_bin.zip
JPACKAGE_JDK_HOME=jdk-15
wget -q $JPACKAGE_JDK_BASE_URL/$JPACKAGE_JDK_ARCHIVE_NAME
7z x -bd $JPACKAGE_JDK_ARCHIVE_NAME
echo "export BADASS_JLINK_JPACKAGE_HOME=$(pwd)/$JPACKAGE_JDK_HOME" >> .travis.env

# FeatureMain	Core AdoptOpenJDK installation (DEFAULT)
# FeatureEnvironment	Update the PATH environment variable (DEFAULT)
# FeatureJarFileRunWith	Associate .jar files with Java applications (DEFAULT)
# FeatureJavaHome	Update the JAVA_HOME environment variable
# FeatureIcedTeaWeb	Install IcedTea-Web
# FeatureJNLPFileRunWith	Associate .jnlp files with IcedTea-web
# FeatureOracleJavaSoft	Updates registry keys HKLM/SOFTWARE/JavaSoft/
choco install adoptopenjdk --version 13.102.8 -y -ia ADDLOCAL=FeatureMain,FeatureEnvironment,FeatureJavaHome
echo 'export JAVA_HOME="/c/Program Files/AdoptOpenJDK/jdk-13.0.2.8-hotspot"' >> .travis.env

# choco install wixtoolset -y
wget -q https://github.com/wixtoolset/wix3/releases/download/wix3112rtm/wix311-binaries.zip
7z x -bd -owixtoolset wix311-binaries.zip
echo 'export WIX=$(pwd)/wixtoolset' >> .travis.env

echo 'export PATH="$JAVA_HOME/bin":"$WIX":$PATH' >> .travis.env

# special for Windows
echo 'export GRADLE_OPTS="-Dorg.gradle.daemon=false"' >> .travis.env
