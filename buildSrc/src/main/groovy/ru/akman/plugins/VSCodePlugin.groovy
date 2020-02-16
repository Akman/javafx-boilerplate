/*
  Gradle Build Boilerplate Project

  https://github.com/akman/java-boilerplate-gradle/buildSrc

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
package ru.akman.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Simple greeting plugin.
 */
class VSCodePlugin implements Plugin<Project> {

  void apply(Project project) {
  
    project.task('vscode') {
      group 'IDE'
      description 'Generates all VS Code files.'
      dependsOn 'vscodeTasks'
      doLast {
        println 'Generates all VS Code files.'
      }
    }

    project.task('vscodeTasks') {
      description 'Generates VS Code tasks file.'
      def vscSettingsDir = new File(project.projectDir, '.vscode')
      def vscTasksFile = new File(vscSettingsDir, 'tasks.json')
      def jsonSlurper = new groovy.json.JsonSlurper()
      def jsonOutput = new groovy.json.JsonOutput()
      def vscTasksMap = [:]
      vscSettingsDir.mkdirs()
      if (vscTasksFile.exists()) {
        try {
          def json = vscTasksFile.getText()
          if (json.length() != 0) {
            vscTasksMap = jsonSlurper.parseText(json)
          }
        } catch (Exception ex) {
          println "Could not load file: '${vscTasksFile.path}'\n${ex}"
          throw ex
        }
        if (!(vscTasksMap instanceof Map)) {
          println "Could not load file: '${vscTasksFile.path}'"
          throw new Exception('Text must be a valid JSON map object')
        }
      }
      if (!vscTasksMap.containsKey('version')) {
        vscTasksMap['version'] = '2.0.0'
      }
      if (!vscTasksMap.containsKey('tasks')) {
        vscTasksMap['tasks'] = []
      }
      doLast {
        project.getTasks().each { task ->
          def label = task.name
          def description = task.description ?: ''
          def group = 'none'
          switch (task.group) {
            case 'build':
              group = 'build'
              break
            case 'verification':
              group = 'test'
              break
          }
          if (!vscTasksMap.tasks.any { it.group == group && it.label == label &&
              it.detail == description}) {
            println "Task added: ${label} [${group}] - ${description}"
            vscTasksMap.tasks << [
              'group': group,
              'label': label,
              'detail': description,
              'args': [ task.name ],
              'promptOnClose': true,
              'presentation': [
                'group': 'gradle',
                'echo': true,
                'reveal': 'always',
                'focus': false,
                'panel': 'shared',
                'showReuseMessage': true,
                'clear': false
              ],
              'type': 'shell',
              'command': './gradlew',
              'problemMatcher': [],
            ]
          }
        }
        try {
          vscTasksFile.setText(
              jsonOutput.prettyPrint(jsonOutput.toJson(vscTasksMap)))
        } catch (Exception ex) {
          println "Could not save file: '${vscTasksFile.path}'\n${ex}"
          throw ex
        }
      }
    }

  }

}
