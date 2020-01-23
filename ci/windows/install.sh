#!/bin/bash

# ci/windows/install.sh

set -ev

JPACKAGE_JDK_BASE_URL=https://download.java.net/java/early_access/jdk14/32/GPL
JPACKAGE_JDK_ARCHIVE_NAME=openjdk-14-ea+32_windows-x64_bin.zip
JPACKAGE_JDK_HOME=jdk-14

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

echo 'export GRADLE_OPTS="-Dorg.gradle.daemon=false"' >> .travis.env

choco install innosetup --version 5.6.1 -y
