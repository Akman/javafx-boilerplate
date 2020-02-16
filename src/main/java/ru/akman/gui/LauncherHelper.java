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

package ru.akman.gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Main GUI class.
 */
public final class LauncherHelper extends Application {

  /**
   * Default logger.
   */
  private static final Logger LOG = LogManager.getLogger(LauncherHelper.class);

  /**
   * Default scene.
   */
  private static Scene scene;

  // PMD: Each class should declare at least one constructor

  /**
   * Run the application.
   * @param args CLI arguments
   */
  public static void run(final String... args) {
    LOG.info("Launching application ...");
    Application.launch(LauncherHelper.class, args);
  }

  @Override
  public void start(final Stage stage) {
    try {
      stage.getIcons().add(
          new Image(LauncherHelper.class.getResourceAsStream("/icon.png")));
      // SPOTBUGS: Write to static field from instance method
      scene = new Scene(loadFxml("primary"));
      stage.setScene(scene);
    } catch (IOException ex) {
      LOG.error(ex);
    }
    stage.show();
  }

  /**
   * Load FXML document into default scene.
   * @param fxml name of FXML document without extension
   */
  public static void setRoot(final String fxml) {
    try {
      scene.setRoot(loadFxml(fxml));
    } catch (IOException ex) {
      LOG.error(ex);
    }
  }

  private static Parent loadFxml(final String fxml) throws IOException {
    final FXMLLoader fxmlLoader = new FXMLLoader(
        LauncherHelper.class.getResource("/" + fxml + ".fxml"));
    return fxmlLoader.load();
  }

}
