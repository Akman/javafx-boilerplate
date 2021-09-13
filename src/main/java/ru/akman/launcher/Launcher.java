/*
  JavaFX Boilerplate Project

  https://github.com/akman/javafx-boilerplate

  MIT License (MIT)

  Copyright (C) 2019 - 2021 Alexander Kapitman <akman.ru@gmail.com>

  Permission is hereby granted, free of charge, to any person obtaining
  a copy of this software and associated documentation files (the "Software"),
  to deal in the Software without restriction, including without limitation
  the rights to use, copy, modify, merge, publish, distribute, sublicense,
  and/or sell copies of the Software, and to permit persons to whom
  the Software is furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included
  in all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFINGEMENT. IN NO EVENT SHALL
  THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
  FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
  DEALINGS IN THE SOFTWARE.
*/
package ru.akman.launcher;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine;
import ru.akman.commons.CommonUtils;

/**
 * Application launcher.
 */
public final class Launcher {

  /**
   * Messages resource bundle name.
   */
  private static final String MESSAGES_NAME = "messages";

  /**
   * CLI resource bundle name.
   */
  private static final String CLI_NAME = "cli";

  /**
   * Application properties name.
   */
  private static final String PROPS_NAME = "/application.properties";

  /**
   * Application properties charset.
   */
  private static final String PROPS_CHARSET = "UTF-8";

  /**
   * Application propertie for application name.
   */
  private static final String PROP_APP_NAME = "application.launcher.name";

  /**
   * Application propertie for application version.
   */
  private static final String PROP_APP_VERSION = "application.version";

  /**
   * Default logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(Launcher.class);

  /**
   * Message strings from resource bundle.
   */
  private static final ResourceBundle MESSAGES = ResourceBundle.getBundle(
      MESSAGES_NAME, Locale.getDefault());

  /**
   * Application properties from properties file.
   */
  private static final Properties PROPERTIES = CommonUtils.loadResource(
      PROPS_NAME, Charset.forName(PROPS_CHARSET));

  /**
   * Application command.
   */
  private static final LauncherCommand COMMAND = new LauncherCommand();

  /**
   * Get string from the application resources.
   *
   * @param key resource string key
   *
   * @return resource string value
   */
  public static String getString(final String key) {
    return MESSAGES.getString(key);
  }

  /**
   * Get string from the application properties.
   *
   * @param key property string key
   *
   * @return property string value
   */
  public static String getProperty(final String key) {
    return PROPERTIES.getProperty(key);
  }

  /**
   * Get application properties.
   *
   * @return application properties
   */
  public static Properties getProperties() {
    Properties properties = new Properties();
    properties.putAll(PROPERTIES);
    return properties;
  }

  /**
   * Get application command.
   *
   * @return application command
   */
  public static LauncherCommand getCommand() {
    return COMMAND;
  }

  /**
   * Private constructor.
   * All methods are static.
   */
  private Launcher() {
  }

  /**
   * Main entry point of application.
   *
   * @param args system CLI arguments
   */
  public static void main(final String[] args) {
    if (LOG.isDebugEnabled()) {
      LOG.debug(getProperty(PROP_APP_NAME) + " - "
          + getProperty(PROP_APP_VERSION));
    }
    CommonUtils.setupSystemStreams();
    final CommandLine cmdLine = new CommandLine(COMMAND);
    cmdLine
        .setResourceBundle(ResourceBundle.getBundle(
            CLI_NAME, Locale.getDefault()))
        .getCommandSpec()
        .mixinStandardHelpOptions(true)
        .name(getProperty(PROP_APP_NAME))
        .version(new String[] {
          "%n@|bold " + getProperty(PROP_APP_NAME) + "|@ @|bold,yellow v"
              + getProperty(PROP_APP_VERSION) + "|@"
        });
    System.exit(cmdLine.execute(args));
  }

}
