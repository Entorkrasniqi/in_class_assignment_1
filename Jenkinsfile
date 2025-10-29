pipeline {
    agent any
    tools {
        maven 'Maven3'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'master', url: 'https://github.com/Entorkrasniqi/in_class_assignment_1', changelog: false, poll: false
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
                junit '**/target/surefire-reports/TEST-*.xml'
            }
        }

        stage('Coverage Report') {
            steps {
                bat 'mvn jacoco:report'
            }
        }

        stage('Publish Coverage') {
            steps {
                jacoco()
            }
        }
    }
}
