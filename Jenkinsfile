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
                bat 'mvn clean verify'  // Use mvn instead of mvnw.cmd
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'  // Use mvn instead of mvnw.cmd
            }
        }

        stage('Report') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/**/*.jar', fingerprint: true
        }
    }
}
