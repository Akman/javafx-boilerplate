# KNOWN ISSUES

## MAVEN

### Dependency

***spock-core***
- org.apache.groovy:groovy:4.0.20 conflict with 4.0.23
- org.junit.platform:junit-platform-commons:1.10.2 conflict with 1.11.2

```xml
    <version.spock>2.4-M4-groovy-4.0</version.spock>
    <dependency>
      <groupId>org.spockframework</groupId>
      <artifactId>spock-core</artifactId>
      <version>${version.spock}</version>
      <scope>test</scope>
    </dependency>
```

### Warning

***maven-compiler-plugin:testCompile***

```xml
<showWarnings>false</showWarnings>
```
```console
The following options were not recognized by any processor: '[project]'
```

### Warning

***project-info-reports:dependencies***

```console
Site model for default locale is still using the old pre-version 2.0.0 model.
You MUST migrate to the new model as soon as possible otherwise your build
will break in the future!
```

### Warning

***maven-resources-plugin:***

```console
Parameter 'resources' is read-only, must not be used in configuration
```

### Warning

*** mockito-agent ***

```console
Sharing is only supported for boot loader classes
because bootstrap classpath has been appended
```
