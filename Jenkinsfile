pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/Entorkrasniqi/in_class_assignment_1'
            }
        }

        stage('Build / Test') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn -B clean test'
                    } else {
                        bat 'mvn -B clean test'
                    }
                }
                junit '**/target/surefire-reports/TEST-*.xml'
            }
        }
    }
}