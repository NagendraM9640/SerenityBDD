pipeline {
    agent any 

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/NagendraM9640/SerenityBDD.git', credentialsId: 'github-creds'
            }
        }

        stage('Build') {
            steps {
                bat 'mvnw.cmd clean verify'  // Windows command
            }
        }

        stage('Test') {
            steps {
                bat 'mvnw.cmd test'  // Windows command
            }
        }

        stage('Report') {
            steps {
                junit '**/target/surefire-reports/*.xml'  // Test report publishing
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/**/*.jar', fingerprint: true  // Save build artifacts
        }
    }
}
