#!/usr/bin/env python
# -*- coding: utf-8 -*-

import sys
import os
import time
import commands
import codecs
import json
import platform
import tempfile

from bottle import Bottle, run, request, static_file

def createResponseJson(source, result, error):
    return json.dumps({'source': source, 'result': result, 'error': error})

def createSourceFile(name, contents):
    f = codecs.open(name, 'w', 'utf-8')
    f.write(contents)
    f.close()

def compileCommand(name, target):
    return commands.getoutput('java -jar {0}/../libzen.jar -l {1} {2} > {2}.txt'.format(rootPath, target, name))

def readCompiledFile(name):
    if os.path.exists(name+".txt"):
        a = open(name+'.txt', 'r')
        return a.read()
    return ''

#Server settings
app = Bottle()
rootPath = os.path.abspath(os.path.dirname(__file__))

#Server routings
@app.get('/')
def indexfile():
    return static_file('index.html', root=rootPath)

@app.post('/compile')
def compile():
    file = tempfile.NamedTemporaryFile(mode='w', suffix='.zen', prefix='tmp', dir='/tmp')
    name = file.name
    file.close() #tempfile cannot use utf-8 in python 2.7, so need to reopen

    if not hasattr(request, 'json'):
        return 'error'
    req = request.json

    createSourceFile(name, req["source"])
    message = compileCommand(name, req["option"])

    filecontent = readCompiledFile(name)
    return createResponseJson(filecontent, '', message)

@app.route('/<filepath:path>')
def server_static(filepath):
    return static_file(filepath, root=rootPath)

run(app, host='0.0.0.0', port=3000)
