/*
  Java Boilerplate Project

  https://github.com/akman/java-boilerplate-gradle

  MIT License (MIT)

  Copyright (C) 2019 - 2020 Alexander Kapitman <akman.ru@gmail.com>

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
import java.util.concurrent.Callable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import ru.akman.commons.CommonUtils;

/**
 * Application launcher.
 */
@Command(
    name = "launcher",
    description = "Launcher application",
    version = "Version 1.0",
    mixinStandardHelpOptions = true
)
public final class Launcher implements Callable<Integer> {

  /**
   * Logger level for debug mode.
   */
  private static final String LOG_LEVEL_DEBUG = "DEBUG";

  /**
   * Messages resource bundle name.
   */
  private static final String MESSAGES_NAME = "messages";

  /**
   * Application properties name.
   */
  private static final String PROPS_NAME = "/application.properties";

  /**
   * Application properties charset.
   */
  private static final String PROPS_CHARSET = "UTF-8";

  /**
   * Application propertie for greeting.
   */
  private static final String PROP_APP_GREETING = "app.greeting";

  /**
   * Application propertie for CLI mode.
   */
  private static final String PROP_APP_MODE_CLI = "app.mode.cli";

  /**
   * Application propertie for GUI mode.
   */
  private static final String PROP_APP_MODE_GUI = "app.mode.gui";

  /**
   * Application propertie for parting.
   */
  private static final String PROP_APP_PARTING = "app.parting";

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
   * Debug mode.
   */
  @Option(
      names = {"-d", "--debug"},
      description = "Log in debug mode."
  )
  private boolean debugEnabled;

  /**
   * GUI mode.
   */
  @Option(
      names = {"-g", "--gui"},
      description = "Run application in GUI mode."
  )
  private boolean guiEnabled;

  /**
   * Is DEBUG mode enabled.
   * @return true if DEBUG mode is enabled
   */
  public boolean isDebugEnabled() {
    return debugEnabled;
  }

  /**
   * Is GUI mode enabled.
   * @return true if GUI mode is enabled
   */
  public boolean isGuiEnabled() {
    return guiEnabled;
  }

  /**
   * Get string from the application resources.
   * @param key resource string key
   * @return resource string value
   */
  public static String getString(final String key) {
    return MESSAGES.getString(key);
  }

  /**
   * Get string from the application properties.
   * @param key property string key
   * @return property string value
   */
  public static String getProperty(final String key) {
    return PROPERTIES.getProperty(key);
  }

  /**
   * Get application properties.
   * @return application properties
   */
  public static Properties getProperties() {
    return PROPERTIES;
  }

  /**
   * Main entry point of application.
   * @param args system CLI arguments
   */
  public static void main(final String[] args) {
    CommonUtils.setupSystemStreams();
    final CommandLine cmdLine = new CommandLine(new Launcher());
    System.exit(cmdLine.execute(args));
  }

  /**
   * Command line user interface.
   *
   * @return Exit code
   */
  @Override
  public Integer call() throws Exception {
    if (isDebugEnabled()) {
      CommonUtils.setLoggerLevel(LOG_LEVEL_DEBUG);
    }
    if (LOG.isDebugEnabled()) {
      LOG.debug(getString(PROP_APP_GREETING));
    }
    CommonUtils.dumpProperties(PROPERTIES);
    if (isGuiEnabled()) {
      if (LOG.isDebugEnabled()) {
        LOG.debug(getString(PROP_APP_MODE_GUI));
      }
      ru.akman.gui.LauncherHelper.run();
    } else {
      if (LOG.isDebugEnabled()) {
        LOG.debug(getString(PROP_APP_MODE_CLI));
      }
      ru.akman.cli.LauncherHelper.run();
    }
    if (LOG.isDebugEnabled()) {
      LOG.debug(getString(PROP_APP_PARTING));
    }
    return 0;
  }

}
