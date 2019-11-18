pipeline {
    agent any

    tools {
        jdk 'jdk-11'
    }

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean install test-compile'
            }
        }
        stage('api') {
                    steps {
                        bat 'mvn clean test -pl :api'
                    }
                }
        stage('service') {
                    steps {
                        bat 'mvn clean test -pl :service'
                    }
        }
        stage('domain') {
            steps {
                bat 'mvn clean test -pl :domain'
            }
        }

    }
}