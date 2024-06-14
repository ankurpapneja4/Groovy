package com.github.ankurpapneja4

def any = "ANY";

def agent = { agentName ->
    println "Agent Name - ${agentName}"
}

def steps = { shellScript ->
    shellScript()
}

def environment = { setEnvScript ->
    setEnvScript()
}

def stage = { name,_stage ->
    println "Stage Name: ${name}"
    _stage();
}

def stages = { _stages ->
    _stages();
}

def pipeline = { _pipeline ->
    _pipeline()
}

pipeline {
    agent any
    stages {
        stage('Execute Groovy Script') {
            environment { println "POM_VERSION = 1.0.0" }
            steps { println "Stage 1"}
        }
        stage('Execute Groovy Script') {
            environment { println "POM_VERSION = 2.0.0" }
            steps { println "Stage 2"}
        }
    }
}