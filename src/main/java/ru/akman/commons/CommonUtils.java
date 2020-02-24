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

package ru.akman.commons;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.MissingResourceException;
import java.util.Properties;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

/**
 * Utils.
 */
public final class CommonUtils {

  static {
    // configuration: /log4j2.xml
    // ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF
    Configurator.setRootLevel(Level.ERROR);
    Configurator.setLevel(CommonUtils.class.getName(), Level.DEBUG);
  }

  /**
   * Default logger.
   */
  private static final Logger LOG = LogManager.getLogger(CommonUtils.class);

  private CommonUtils() {
    // not called
    LOG.error("Call private constructor");
    throw new UnsupportedOperationException();
  }

  /**
   * Setup system output and error streams.
   */
  public static void setupSystemStreams() {
    System.setOut(new PrintStream(System.out, true, Charset.defaultCharset()));
    System.setErr(new PrintStream(System.err, true, Charset.defaultCharset()));
  }

  /**
   * Load resource by name and charset.
   * @param resourceName resource name (path)
   * @param resourceCharset resource charset
   * @return properties object
   */
  public static Properties loadResource(final String resourceName,
      final Charset resourceCharset) {
    final URL resourceUrl = CommonUtils.class.getResource(resourceName);
    if (resourceUrl == null) {
      throw new MissingResourceException(
          "Resource not found", CommonUtils.class.getName(), resourceName);
    }
    final Properties properties = new Properties();
    try (InputStreamReader isr = new InputStreamReader(
        resourceUrl.openStream(), resourceCharset)) {
      properties.load(isr);
    } catch (IOException ex) {
      throw (MissingResourceException)new MissingResourceException(
          "Can't load resource", CommonUtils.class.getName(), resourceName)
          .initCause(ex);
    }
    return properties;
  }

}
