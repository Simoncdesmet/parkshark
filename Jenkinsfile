pipeline {
    agent any



    stages {
        stage('Build') {
            steps {
                bat 'mvn clean test-compile'
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