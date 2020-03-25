/*
  Java Boilerplate Project

  https://github.com/akman/java-boilerplate-gradle

  The MIT License (MIT)

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
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import ru.akman.commons.CommonUtils;

/**
 * Application launcher.
 */
public final class Launcher {

  /**
   * CLI option to run the application without GUI.
   */
  private static final String CLI_NO_GUI = "--no-gui";

  /**
   * Messages resource bundle name.
   */
  private static final String MESSAGES_NAME = "messages";

  /**
   * Application properties name.
   */
  private static final String PROPERTIES_NAME = "/application.properties";

  /**
   * Application properties charset.
   */
  private static final String PROPERTIES_CHARSET = "UTF-8";

  /**
   * Default logger.
   */
  private static final Logger LOG = LogManager.getLogger(Launcher.class);

  /**
   * Message strings from resource bundle.
   */
  private static final ResourceBundle MESSAGES = ResourceBundle.getBundle(
      MESSAGES_NAME, Locale.getDefault());

  /**
   * Application properties from properties file.
   */
  private static final Properties PROPERTIES = CommonUtils.loadResource(
      PROPERTIES_NAME, Charset.forName(PROPERTIES_CHARSET));

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

  static {
    CommonUtils.setupSystemStreams();
    // configuration: /log4j2.xml
    // ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF
    Configurator.setRootLevel(Level.ERROR);
    Configurator.setLevel(Launcher.class.getName(), Level.DEBUG);
  }

  private Launcher() {
    // not called
    throw new UnsupportedOperationException();
  }

  /**
   * Main entry point of application.
   * @param args system CLI arguments
   */
  public static void main(final String... args) {

    if (LOG.isDebugEnabled()) {
      LOG.debug(getString("app.greeting"));
      LOG.debug("locale = " + Locale.getDefault());
      LOG.debug("charset = " + Charset.defaultCharset());
      LOG.debug("file.encoding = " + System.getProperty("file.encoding"));
    }

    PROPERTIES.stringPropertyNames().forEach(name -> {
      if (LOG.isDebugEnabled()) {
        LOG.debug(name + " = " + PROPERTIES.getProperty(name));
      }
    });

    if (args.length > 0 && CLI_NO_GUI.equals(args[0])) {
      if (LOG.isDebugEnabled()) {
        LOG.debug(getString("app.mode.cli"));
      }
      ru.akman.cli.LauncherHelper.run(args);
    } else {
      if (LOG.isDebugEnabled()) {
        LOG.debug(getString("app.mode.gui"));
      }
      ru.akman.gui.LauncherHelper.run(args);
    }

    if (LOG.isDebugEnabled()) {
      LOG.debug(getString("app.parting"));
    }

  }

}
