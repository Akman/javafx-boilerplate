/**
 * The MIT License (MIT)
 *
 * Copyright (C) 2019 Alexander Kapitman <akman.ru@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import org.gradle.api.tasks.StopExecutionException
import groovy.json.JsonSlurper

class GitHub {

    private static final String API_URL = 'https://api.github.com/repos'
    private static final String UPLOADS_URL = 'https://uploads.github.com/repos'

    private static final JsonSlurper jsonSlurper = new JsonSlurper()

    private String owner
    private String token
    private String repo
    private String branch
    private String tag

    private String releaseId

    private static String execute(List<String> command) {
        return execute(command.join(' '))
    }

    private static String execute(String command) {
        StringBuffer outputStream = new StringBuffer()
        Process process = command.execute()
        process.waitForProcessOutput(outputStream, System.err)
        return outputStream.toString().trim()
    }

    private String getAuthToken() {
        return '-H "Authorization: token ' + token + '"'
    }

    private String getAuthUrl() {
        return [ API_URL, owner, repo ].join('/')
    }

    private String getTagUrl() {
        List<String> result = [ API_URL, owner, repo, 'releases' ]
        result += tag == 'latest' ? [ 'latest' ] : [ 'tags', tag ]
        return result.join('/')
    }

    private String getAssetUrl(String fileName) {
        return [
            UPLOADS_URL, owner, repo, 'releases', releaseId, 'assets?name='
        ].join('/') + fileName
    }

    private String git(List<String> command) {
        return git(command.join(' '))
    }

    private String git(String command) {
        return execute('git ' + command)
    }

    private String curl(List<String> command) {
        return curl(command.join(' '))
    }

    private String curl(String command) {
        return execute('curl ' + getAuthToken() + ' ' + command)
    }

    private void auth() {
        logger.lifecycle('Authorization begin ...')
        String response = curl([ '-s', getAuthUrl() ])
        def json = jsonSlurper.parseText(response)
        if (json.name != repo) {
            logger.error('Error: Authorization failed!')
            logger.error(response)
            throw new StopExecutionException('Error: Authorization failed!')
        } else {
            logger.lifecycle('OK')
        }
    }

    private void release() {
        logger.lifecycle('Get release ...')
        String response = curl([ '-s', getTagUrl() ])
        def json = jsonSlurper.parseText(response)
        if (!json.id) {
            logger.error('Error: Failed to get release!')
            logger.error(response)
            throw new StopExecutionException('Error: Failed to get release!')
        } else {
            releaseId = json.id
            logger.lifecycle('OK')
        }
    }

    public GitHub() {
        this('latest')
    }

    public GitHub(String releaseTag) {
        tag = releaseTag
        logger.lifecycle('Tag: ' + tag)
        branch = git([ 'rev-parse', '--abbrev-ref', 'HEAD' ])
        logger.lifecycle(Branch: ' + branch)
        (owner, repo) = git([ 'config', '--get', 'remote.origin.url' ])
            .replaceAll(/^.+\:/, '')
            .replaceAll(/\.git$/, '')
            .tokenize('/')
        logger.lifecycle('Owner: ' + owner)
        logger.lifecycle('Repo: ' + repo)
        token = git([ 'config', '--global', 'github.token' ])
        auth()
        release()
    }

    public void upload(File file) {
        logger.lifecycle('Uploading file: ' + file.getName() + ' ...')
        String response = curl([
            '-s',
            '-H', '"Content-Type: application/octet-stream"',
            '--data-binary', '@' + file.toString(),
            getAssetUrl(file.getName())
        ])
        def json = jsonSlurper.parseText(response)
        if (json.state != 'uploaded') {
            logger.error('Error: Failed to upload file!')
            logger.error(response)
            throw new StopExecutionException('Error: Failed to upload file!')
        } else {
            logger.lifecycle('OK')
        }
    }

}

// import java.io.*
// import groovyx.net.http.HTTPBuilder
// import groovyx.net.http.EncoderRegistry
// import static groovyx.net.http.Method.*
// import static groovyx.net.http.ContentType.*
// def http = new groovyx.net.http.HTTPBuilder("http://local.com:8983/solr/update/json")
// http.request(POST, JSON ) { req ->
//     req.body{
// 
//     }
//     response.success = { resp, reader ->
//         println "$resp.statusLine   Respond rec"
// 
//     }
// }
