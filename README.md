# JavaFX Boilerplate Project v0.48.0

[![Build Status][travis_badge]][travis_href]
[![Code Coverage][codecov_badge]][codecov_href]
[![Latest Release][release_badge]][release_href]
[![License][license_badge]][license_href]

JavaFX application boilerplate project using gradle and maven build tools. This project aims to cover best practices for JavaFX application development as a whole. It provides tool recommendations for linting, testing and packaging.

[The source for this project is available here][src_href]

[The latest release for this project is available here][release_href]

[The documentation for this project is available here][docs_href]

You can use either Gradle or Maven to build this boilerplate project.

Most of the configuration for the Gradle is done in the `build.gradle` file.
Most of the configuration for the Maven is done in the `pom.xml` file.

You should edit these files accordingly to adapt this boilerplate project
to your needs.

This is the README file for the project.

The file should use UTF-8 encoding and can be written using
[GitHub Flavored Markdown][md_href] with the appropriate key set.
It will be displayed as the project homepage on common code-hosting services,
and should be written for that purpose.

Typical contents for this file would include an overview of the project, basic
usage examples, etc. Generally, including the project changelog in here
is not a good idea, although a simple "What's New" section for the most
recent version may be appropriate.

All tasks are performed from the project directory itself
where placed `gradlew`, `gradlew.bat` and `mvnw`, `mvnw.cmd` files.

## Using the wrappers

It is recommended to always execute a build with the wrappers to ensure
a reliable, controlled and standardized execution of the build.
Using the wrappers looks almost exactly like running the build with
the Gradle or the Maven installation. Depending on the operating
system you either run `gradlew` or `gradlew.bat` for the Gradle and
run `mvnw` or `mvnw.cmd` for the Maven instead of the `gradle` or `mvn`
command.

## Generate or update maven wrapper

Generating the wrapper files requires an installed version of the Maven
on your machine.

```console
mvn -N io.takari:maven:wrapper
```

To switch the version of the Maven used to build a project simply pass in
the new version.

```console
mvn -N io.takari:maven:wrapper -Dmaven=3.6.3
```

## Generate or update gradle wrapper

Generating the wrapper files requires an installed version of the Gradle
on your machine.

```console
gradle wrapper
```

To switch the version of the Gradle used to build a project simply pass in
the new version as well as the distribution type, either `all` which includes
sources and documentation or `bin` which only ships with the binaries.

```console
gradle wrapper --gradle-version 6.5.1
gradle wrapper --gradle-version 6.5.1 --distribution-type bin
```

## Setup maven properties

You can set settings by export environment variable `MAVEN_OPTS`:

```console
export MAVEN_OPTS="-Xmx1024m -XX:MaxMetaspaceSize=512m -XX:+HeapDumpOnOutOfMemoryError -Dfile.encoding=UTF-8"
```

## Setup gradle properties

Edit default gradle properties in the file `.gradle/gradle.properties`
in the user’s home directory.

For example you can set gradle console output to plain mode, set running
gradle builds without gradle daemon.

```properties
org.gradle.daemon = false
org.gradle.parallel = true
org.gradle.console = plain
org.gradle.jvmargs = -Xms512m -Xmx1024m -Dfile.encoding=UTF-8
```

Or you can set above settings by export environment variable `GRADLE_OPTS`:

```console
export GRADLE_OPTS="-Dorg.gradle.daemon=false -Dorg.gradle.parallel=true -Dorg.gradle.console=plain -Xms512m -Xmx1024m -Dfile.encoding=UTF-8"
```

## Maven build lifecycle

Maven is based around the central concept of a build lifecycle.
The build process is clearly defined. There are three built-in build
lifecycles: `default`, `clean` and `site`.

The default lifecycle comprises of the following phases:

- `validate` - validate the project is correct
- `compile` - compile the source code of the project
- `test` - test the compiled source code
- `package` - take the compiled code and package it
- `verify` - run any checks on results of integration tests
- `install` - install the package into the local repository
- `deploy` - deploy the final package to the remote repository

Each of a build phase is made up of plugin goals, and this is done
by declaring the plugin goals bound to those build phases.

## Display available gradle tasks

To see which tasks are available for your Gradle build you can run:

```console
./gradlew tasks
```

By default only the tasks which are dependencies on other tasks are shown.
To see all tasks we must add the command-line option `--all`.

```console
./gradlew tasks --all
```

To see more detail about a task, run:

```console
./gradlew help --task <task>
```

## Clean project

Clean build.

```console
./gradlew clean
```

```console
./mvnw clean
```

## Check project

Run all checks.

```console
./gradlew check
```

```console
./mvnw verify
```

The following plugins are used to check the project:

- license
- checkstyle
- pmd/cpd
- spotbugs
- codenarc

You can use all of these tools separately.

### License

License plugin will scan and adapt your source files to include a provided
header, e.g. a LICENSE file. By default it will scan every source set and
report warnings. It will also create format tasks, which will properly format
and apply the specified header. This plugin will also report on the licenses
of your dependencies.

Check for header consistency.

```console
./gradlew license
```

```console
./mvnw validate license:check
```

Apply the license found in the header file in files missing the header.

```console
./gradlew licenseFormat
```

```console
./mvnw validate license:format
```

Generate reports on your runtime dependencies.

```console
./gradlew downloadLicenses
```

### CheckStyle

The Checkstyle plugin performs quality checks on your project’s Java source
files using Checkstyle and generates reports from these checks.

```console
./gradlew checkstyleMain checkstyleTest
```

```console
./mvnw checkstyle:check
```

### PMD/CPD

The PMD/CPD plugin performs quality checks on your project’s Java source files
using PMD/CPD and generates reports from these checks.

```console
./gradlew pmdMain pmdTest cpdCheck
```

```console
./mvnw pmd:check pmd:cpd-check
```

### SpotBugs

SpotBugs plugin performs static analysis to look for bugs in Java code using
SpotBugs and generates reports from these analysis.

```console
./gradlew spotbugsMain spotbugsTest
```

```console
./mvnw spotbugs:check
./mvnw spotbugs:gui
```

### CodeNarc

The CodeNarc plugin performs quality checks on your project’s Groovy source
files using CodeNarc and generates reports from these checks.

```console
./gradlew codenarcMain codenarcTest
```

```console
./mvnw antrun:run@codenarc
```

## Unit testing

Run unit tests:

```console
./gradlew test
```

```console
./mvnw test
```

The JaCoCo plugin provides code coverage metrics for Java code via
integration with JaCoCo.

## Reports

Generate reports:

```console
./gradlew projectReport buildDashboard
```

```console
./mvnw validate site
```

## Build project

Build this project

```console
./gradlew clean build
```

```console
./mvnw clean verify
```

## Run

```console
./gradlew run
./gradlew run --args="--gui --debug"
```

```console
./mvnw exec:exec
```

## Distribute

Create modular runtime image with installer:

```console
./gradlew jpackage
```

```console
./mvnw validate jlink:jlink jpackage:jpackage@image jpackage:jpackage@installer
```

## Project dependencies

Displays all dependencies declared in project.

```console
./gradlew dependencies
```

```console
./mvnw dependency:tree
```

Discover dependency updates

```console
./gradlew dependencyUpdates -Drevision=release
```

```console
./mvnw versions:display-dependency-updates
```

## Project properties

Display the properties of the project.

```console
./gradlew properties
```

```console
./mvnw help:effective-settings
./mvnw help:effective-pom
./mvnw help:system
./mvnw help:all-profiles
```

## Release project

```console
./gradlew release
```

```console
./mvnw release:clean release:prepare release:perform
```

## Pull request

Pull request template: [.github/pull_request_template.md][pull_request_href].

[travis_badge]: https://travis-ci.com/akman/javafx-boilerplate.svg?branch=master
[travis_href]: https://travis-ci.com/akman/javafx-boilerplate
[codecov_badge]: https://codecov.io/gh/akman/javafx-boilerplate/branch/master/graph/badge.svg
[codecov_href]: https://codecov.io/gh/akman/javafx-boilerplate
[release_badge]: https://img.shields.io/github/downloads/akman/javafx-boilerplate/latest/total.svg
[release_href]: https://github.com/akman/javafx-boilerplate/releases/latest
[license_badge]: https://img.shields.io/github/license/akman/javafx-boilerplate.svg
[license_href]: https://github.com/akman/javafx-boilerplate/blob/master/LICENSE
[src_href]: https://github.com/akman/javafx-boilerplate
[docs_href]: https://akman.github.io/javafx-boilerplate
[md_href]: https://help.github.com/articles/basic-writing-and-formatting-syntax
[pull_request_href]: https://github.com/akman/javafx-boilerplate/blob/master/.github/pull_request_template.md
