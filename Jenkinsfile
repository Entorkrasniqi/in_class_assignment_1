pipeline {
  agent any

  environment {
    MAVEN_HOME = tool 'Maven3'
    PATH = "${MAVEN_HOME}/bin:${env.PATH}"
  }

  stages {
    stage('Checkout') {
      steps {
        git branch: 'master', url: 'https://github.com/Entorkrasniqi/in_class_assignment_1', changelog: false, poll: false
      }
    }

    stage('Build/Test') {
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

    stage('Coverage') {
      steps {
        script {
          if (isUnix()) {
            sh 'mvn -B jacoco:report'
          } else {
            bat 'mvn -B jacoco:report'
          }
        }
      }
    }

    stage('Publish Coverage') {
      steps {
        jacoco()
      }
    }
  }
}