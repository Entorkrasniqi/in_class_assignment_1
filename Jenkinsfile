pipeline {
  agent any

  environment {
    // Name must match Manage Jenkins > Global Tool Configuration > Maven
    MAVEN_HOME = tool 'Maven3'
    PATH = "${MAVEN_HOME}/bin:${env.PATH}"
  }

  stages {
    stage('Checkout') {
      steps {
        git branch: 'master', url: 'https://github.com/Entorkrasniqi/in_class_assignment_1', changelog: false, poll: false
      }
    }

    stage('Build') {
      steps {
        sh 'mvn -B -DskipTests clean install'
      }
    }

    stage('Test') {
      steps {
        // Do not fail the pipeline here; let junit capture failures
        sh 'mvn -B -Dmaven.test.failure.ignore=true test'
      }
      post {
        always {
          // Pick up both unit (Surefire) and integration (Failsafe) reports
          junit testResults: '**/target/surefire-reports/*.xml, **/target/failsafe-reports/*.xml', skipPublishingChecks: true
        }
      }
    }

    stage('Coverage Report') {
      steps {
        sh 'mvn -B jacoco:report'
      }
    }

    stage('Publish Coverage') {
      steps {
        jacoco()
      }
    }

    stage('Debug (optional)') {
      when { expression { false } } // set to true to debug
      steps {
        sh '''
          echo "PATH=$PATH"
          which mvn || true
          mvn -v || true
          echo "Listing potential report files:"
          find . -type f \\( -path "*/target/surefire-reports/*.xml" -o -path "*/target/failsafe-reports/*.xml" \\) -print || true
        '''
      }
    }
  }
}