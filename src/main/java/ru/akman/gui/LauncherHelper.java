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
import java.io.InputStream;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
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
   * Default stage width.
   */
  private static final int WIDTH = 640;

  /**
   * Default stage height.
   */
  private static final int HEIGHT = 480;

  /**
   * Default logger.
   */
  private static final Logger LOG = LogManager.getLogger(LauncherHelper.class);

  /**
   * Default scene.
   */
  private static Scene scene;

  @Override
  public void start(final Stage stage) {
    setupStage(stage);
    stage.show();
  }

  /**
   * Run the application.
   * @param args CLI arguments
   */
  public static void run(final String... args) {
    if (LOG.isInfoEnabled()) {
      LOG.info("Launching application ...");
    }
    Application.launch(LauncherHelper.class, args);
  }

  /**
   * Load FXML document into default scene.
   * @param fxml name of FXML document without extension
   */
  public static void setRoot(final String fxml) {
    try {
      scene.setRoot(loadFxml(fxml));
    } catch (IOException ex) {
      if (LOG.isErrorEnabled()) {
        LOG.error(ex);
      }
    }
  }

  private static void setupStage(final Stage stage) {
    final ResourceBundle messages =
        ResourceBundle.getBundle("messages", Locale.getDefault());
    stage.setTitle(messages.getString("app.greeting"));
    final InputStream iconAsStream =
        LauncherHelper.class.getResourceAsStream("/icon.png");
    if (iconAsStream == null) {
      if (LOG.isErrorEnabled()) {
        LOG.error("Can't load application icon: '/icon.png'");
      }
    } else {
      stage.getIcons().add(new Image(iconAsStream));
    }
    try {
      scene = new Scene(loadFxml("/primary.fxml"), WIDTH, HEIGHT);
    } catch (IOException ex) {
      scene = new Scene(new Group(), WIDTH, HEIGHT);
      if (LOG.isErrorEnabled()) {
        LOG.error(ex);
      }
    }
    stage.setScene(scene);
  }

  private static Parent loadFxml(final String fxml) throws IOException {
    final FXMLLoader fxmlLoader = new FXMLLoader(
        LauncherHelper.class.getResource(fxml));
    return fxmlLoader.load();
  }

}
