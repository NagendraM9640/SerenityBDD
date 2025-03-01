pipeline {
    agent any

    stages {  // "stages" block was missing
        stage('Checkout') {
            steps {
                git url: 'https://github.com/NagendraM9640/SerenityBDD.git',
                    credentialsId: 'github-creds'  // Use the saved credentials ID
            }
        }

        stage('Build') {
            steps {
                bat './mvn clean verify'
            }
        }

        stage('Test') {
            steps {
                bat './mvnw test'
            }
        }

        stage('Report') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }  // Ensure this "stages" block is properly closed
}
