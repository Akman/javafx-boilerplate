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

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
   * Default logger.
   */
  private static final Logger LOG = LogManager.getLogger(Launcher.class);

  /**
   * Default charset.
   */
  private static final Charset CHARSET = Charset.defaultCharset();

  /**
   * Message strings from resource bundle.
   */
  private static ResourceBundle messages =
      ResourceBundle.getBundle("messages", Locale.getDefault());

  private Launcher() {
    // not called
    throw new UnsupportedOperationException();
  }

  /**
   * Get greeting string from the application resources.
   * @return greeting string
   */
  public static String getGreeting() {
    return messages.getString("app.greeting");
  }

  /**
   * Get parting string from the application resources.
   * @return parting string
   */
  public static String getParting() {
    return messages.getString("app.parting");
  }

  /**
   * Main entry point of application.
   * @param args system CLI arguments
   * @throws IOException uses console IO
   */
  public static void main(final String... args) throws IOException {

    CommonUtils.dumpEncoding(LOG);

    System.setOut(new PrintStream(System.out, true, CHARSET));
    System.setErr(new PrintStream(System.err, true, CHARSET));

    try {
      final Properties properties = CommonUtils.loadResource(
          "/application.properties", CHARSET);
      properties.stringPropertyNames().forEach(name -> {
        if (LOG.isDebugEnabled()) {
          LOG.debug(name + " = " + properties.getProperty(name));
        }
      });
    } catch (IOException ex) {
      LOG.error(ex);
    }

    if (LOG.isDebugEnabled()) {
      LOG.debug(getGreeting());
    }
    System.out.println(getGreeting());

    if (args.length > 0 && CLI_NO_GUI.equals(args[0])) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("CLI Mode");
      }
      ru.akman.cli.LauncherHelper.run(args);
    } else {
      if (LOG.isDebugEnabled()) {
        LOG.debug("GUI Mode");
      }
      ru.akman.gui.LauncherHelper.run(args);
    }

    if (LOG.isDebugEnabled()) {
      LOG.debug(getParting());
    }
    System.err.println(getParting());

  }

}
