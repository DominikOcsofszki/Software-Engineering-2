pipeline {
    agent any

    stages {
      stage('Checkout code') {
            steps {
                echo 'checking out code from git, -checkout scm'
                checkout scm
            }
        }
            stage('build') {
              steps {
                echo 'mvn --version, mvn install'
                sh 'mvn --version'
                sh 'mvn install -P production,sonar-coverage'
              }
            }
    }
}