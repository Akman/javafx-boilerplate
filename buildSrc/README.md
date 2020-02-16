# Gradle Build Boilerplate Project

This project aims to cover best practices for gradle build development
as a whole. It provides tool recommendations for linting, testing and packaging.

[The source for this project is available here][src]

[The documentation for this project is available here][docs]

Most of the configuration for project is done in the `build.gradle` file.
You should edit this file accordingly to adapt this boilerplate project
to your needs.

This is the README file for the project.

The file should use UTF-8 encoding and can be written using
[GitHub Flavored Markdown][md] with the appropriate key set.
It will be displayed as the project
homepage on common code-hosting services, and should be written for that
purpose.

Typical contents for this file would include an overview of the project, basic
usage examples, etc. Generally, including the project changelog in here is not a
good idea, although a simple "What's New" section for the most recent version
may be appropriate.

All tasks are performed from the project directory itself where placed
***gradlew*** and ***gradlew.bat***.

## Update gradle wrapper

Simply pass in the new version as well as the distribution type, either
***all*** which includes sources and documentation or ***bin*** which only
ships with the binaries.

```bash
./gradlew wrapper
./gradlew wrapper --gradle-version 6.0.1 --distribution-type bin
./gradlew wrapper --gradle-version 6.0.1 --distribution-type all
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
- codenarc
- spok

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

### CodeNarc

The CodeNarc plugin performs quality checks on your project’s Groovy source
files and generates reports from these checks.

```bash
./gradlew codenarcMain
./gradlew codenarcTest
```

### Spok

Run unit tests.

```bash
./gradlew test
```

## Build project

Assemble and test this project.

```bash
./gradlew build
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

[src]: https://github.com/akman/java-boilerplate-gradle/buildSrc
[docs]: https://akman.github.io/java-boilerplate-gradle/buildSrc
[md]: https://help.github.com/articles/basic-writing-and-formatting-syntax
