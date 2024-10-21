/*
  JavaFX Boilerplate Project

  https://github.com/akman/javafx-boilerplate

  MIT License (MIT)

  Copyright (C) 2019 - 2024 Alexander Kapitman <akman.ru@gmail.com>

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

import javafx.fxml.FXML;

/**
 * Secondary controller.
 */
public class SecondaryController {

  /**
   * Primary FXML.
   */
  private static final String PRIMARY_FXML = "primary.fxml";

  /**
   * Default constructor.
   */
  public SecondaryController() {
    // nop
  }

  @FXML
  private void switchToPrimary() {
    // TODO: Private method 'switchToPrimary()' is never called.
    // [SpotBugs] Perfomance.
    // This private method is never called. Although it is possible that
    // the method will be invoked through reflection, it is more likely that
    // the method is never used, and should be removed.
    LauncherHelper.setRoot(PRIMARY_FXML);
  }

}
