# KNOWN ISSUES

## MAVEN

### Plugins

jlink-maven-plugin: 0.1.12-SNAPSHOT - (0.1.12)
jpackage-maven-plugin: 0.1.6-SNAPSHOT - (0.1.6)

### Dependencies

*** spock-core ***
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

### Warnings

*** maven-compiler-plugin:testCompile ***

```console
The following options were not recognized by any processor: '[project]'
```

Возможно это из-за конфигурации maven-compiler-plugin:
```xml
<arg>-Aproject=${project.groupId}/${project.artifactId}</arg>
```
Можно отключить предупреждения, но это плохо
```xml
<showWarnings>false</showWarnings>
```

*** maven-resources-plugin:* ***

```console
Parameter 'resources' is read-only, must not be used in configuration
```

### Notes

*** plugins ***

Что это за параметр конфигурации skip = true

```xml
<plugin> <!-- maven-install-plugin -->
  <artifactId>maven-install-plugin</artifactId>
  <version>${version.maven-install-plugin}</version>
  <configuration>
    <skip>true</skip>
  </configuration>
</plugin>
<plugin> <!-- maven-deploy-plugin -->
  <artifactId>maven-deploy-plugin</artifactId>
  <version>${version.maven-deploy-plugin}</version>
  <configuration>
    <skip>true</skip>
  </configuration>
</plugin>
```

*** maven-compiler-plugin:testCompile ***

```console
24-10-2024 13:21:03 DEBUG r.a.l.LauncherTest:104 - Здравствуйте!
```

Не раскрашивается вывод тестов в консоль при сборке.
Наверное это в коде тестов надо добиваться, а не от Maven?
Наверное это настроить можно в SLF4J или Logback?

### Application

- Не работает ключ командной строки --debug
- Показывать версию Java в информации о версии
