

pipeline {
  agent any

  // Use Jenkins Maven tool named "Maven3" (Manage Jenkins > Global Tool Configuration)
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

    stage('Build') {
      steps {
        sh 'mvn -B -DskipTests clean install'
      }
    }

    stage('Test') {
      steps {
        // run tests but don’t fail the stage so junit can publish results
        sh 'mvn -B -Dmaven.test.failure.ignore=true test'
      }
      post {
        always {
          // collect both surefire and (if any) failsafe reports
          junit testResults: '**/target/surefire-reports/*.xml, **/target/failsafe-reports/*.xml',
                allowEmptyResults: true,
                skipPublishingChecks: true
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

    // Enable this if you need to troubleshoot path/tools
    stage('Debug (optional)') {
      when { expression { false } }
      steps {
        sh '''
          uname -a
          echo "PATH=$PATH"
          which mvn || true
          mvn -v || true
          echo "Looking for test reports..."
          find . -type f \\( -path "*/target/surefire-reports/*.xml" -o -path "*/target/failsafe-reports/*.xml" \\) -print || true
        '''
      }
    }
  }
}