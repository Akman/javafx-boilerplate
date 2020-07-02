# Java Boilerplate Project

[![Build Status][travis_badge]][travis_href]
[![Code Coverage][codecov_badge]][codecov_href]
[![Latest Release][release_badge]][release_href]
[![License][license_badge]][license_href]

This project aims to cover best practices for Java application development as a whole. It provides tool recommendations for linting, testing and packaging.

[The source for this project is available here][src_href]

[The latest release for this project is available here][release_href]

[The documentation for this project is available here][docs_href]

Most of the configuration for project is done in the `build.gradle` or
`pom.xml` file.
You should edit this file accordingly to adapt this boilerplate project
to your needs.

This is the README file for the project.

The file should use UTF-8 encoding and can be written using
[GitHub Flavored Markdown][md_href] with the appropriate key set.
It will be displayed as the project
homepage on common code-hosting services, and should be written for that
purpose.

Typical contents for this file would include an overview of the project, basic
usage examples, etc. Generally, including the project changelog in here is not a
good idea, although a simple "What's New" section for the most recent version
may be appropriate.

All tasks are performed from the project directory itself where placed
***gradlew***, ***gradlew.bat*** or ***mvnw***, ***mvnw.cmd***.

## Install maven wrapper

```bash
mvn -N io.takari:maven:0.7.7:wrapper
```

## Update gradle wrapper

Simply pass in the new version as well as the distribution type, either
***all*** which includes sources and documentation or ***bin*** which only
ships with the binaries.

```bash
./gradlew wrapper
./gradlew wrapper --gradle-version 6.0.1 --distribution-type bin
./gradlew wrapper --gradle-version 6.0.1 --distribution-type all
```

## Setup maven properties

You can set settings by export environment variable MAVEN_OPTS:

```bash
export MAVEN_OPTS="-Xmx1024m -XX:MaxMetaspaceSize=512m -XX:+HeapDumpOnOutOfMemoryError -Dfile.encoding=UTF-8"
```

## Setup gradle properties

Edit default gradle properties in file: ***$HOME/.gradle/gradle.properties***

For example you can set gradle console output to plain mode,
set running gradle builds without gradle daemon.

```properties
org.gradle.daemon = false
org.gradle.parallel = true
org.gradle.console = plain
org.gradle.jvmargs = -Xms512m -Xmx1024m -Dfile.encoding=UTF-8
```

Or you can set above settings by export environment variable GRADLE_OPTS:

```bash
export GRADLE_OPTS="-Dorg.gradle.daemon=false -Dorg.gradle.parallel=true -Dorg.gradle.console=plain -Xms512m -Xmx1024m -Dfile.encoding=UTF-8"
```

## Display available tasks

To see which tasks are available for our build we can run:

```bash
./gradlew tasks
```

By default only the tasks which are dependencies on other tasks are shown.
To see all tasks we must add the command-line option --all.

```bash
./gradlew tasks --all
```

To see more detail about a task, run:

```bash
./gradlew help --task <task>
```

## Clean project

Clean build.

```bash
./gradlew clean
```

## Check project

Run all checks.

```bash
./gradlew check
```

The following plugins are used to check the project:

- license
- checkstyle
- pmd
- spotbugs
- junit
- jacoco

You can use all of these tools separately.

### License

License plugin will scan and adapt your source files to include a provided
header, e.g. a LICENSE file. By default it will scan every source set and
report warnings. It will also create format tasks, which will properly format
and apply the specified header. This plugin will also report on the licenses
of your dependencies.

Check for header consistency.

```bash
./gradlew license
```

Apply the license found in the header file in files missing the header.

```bash
./gradlew licenseFormat
```

Generate reports on your runtime dependencies.

```bash
./gradlew downloadLicenses
```

### CheckStyle

The Checkstyle plugin performs quality checks on your project’s Java source
files using Checkstyle and generates reports from these checks.

```bash
./gradlew checkstyleMain
./gradlew checkstyleTest
```

### PMD

The PMD plugin performs quality checks on your project’s Java source files
using PMD and generates reports from these checks.

```bash
./gradlew pmdMain
./gradlew pmdTest
```

### SpotBugs

SpotBugs plugin performs static analysis to look for bugs in Java code using
SpotBugs and generates reports from these analysis.

```bash
./gradlew spotbugsMain
./gradlew spotbugsTest
```

### JUnit

Run unit tests.

```bash
./gradlew test
```

### JaCoCo

The JaCoCo plugin provides code coverage metrics for Java code via integration
with JaCoCo.

Verify code coverage metrics based on specified rules for the test task.

```bash
./gradlew jacocoTestCoverageVerification
```

## Reports

Plugins used to check the project generate reports also, but JaCoCo do not.

### JaCoCo Code Coverage

Generate code coverage report for the test task.

```bash
./gradlew jacocoTestReport
```

## Build project

Assemble and test this project.

```bash
./gradlew build
```

Create a modular runtime image.

```bash
./gradlew jlink
```

## Run

```bash
./gradlew exec
./gradlew exec --args="--no-gui --debug"
```

Run created modular runtime image.

```bash
./build/image/bin/launcher
```

## Distribute

Create a zip of the modular runtime image.

```bash
./gradlew jlinkZip
```

Create an installable image.

```bash
./gradlew jpackage
```

## Dependencies

Displays all dependencies declared in project.

```bash
./gradlew dependencies
```

A web-based, searchable dependency report is available by adding the
--scan option.

```bash
./gradlew dependencies --scan
```

Discover dependency updates

```bash
./gradlew dependencyUpdates -Drevision=release
```

## Properties

Display the properties of the project.

```bash
./gradlew properties
```

## Pull request

Pull request template: [.github/pull_request_template.md][pull_request_href].

[travis_badge]: https://travis-ci.org/akman/java-boilerplate-gradle.svg?branch=master
[travis_href]: https://travis-ci.org/akman/java-boilerplate-gradle
[codecov_badge]: https://codecov.io/gh/akman/java-boilerplate-gradle/branch/master/graph/badge.svg
[codecov_href]: https://codecov.io/gh/akman/java-boilerplate-gradle
[release_badge]: https://img.shields.io/github/downloads/akman/java-boilerplate-gradle/latest/total.svg
[release_href]: https://github.com/akman/java-boilerplate-gradle/releases/latest
[license_badge]: https://img.shields.io/github/license/akman/java-boilerplate-gradle.svg
[license_href]: https://github.com/akman/java-boilerplate-gradle/blob/master/LICENSE
[src_href]: https://github.com/akman/java-boilerplate-gradle
[docs_href]: https://akman.github.io/java-boilerplate-gradle
[md_href]: https://help.github.com/articles/basic-writing-and-formatting-syntax
[pull_request_href]: https://github.com/akman/java-boilerplate-gradle/blob/master/.github/pull_request_template.md
