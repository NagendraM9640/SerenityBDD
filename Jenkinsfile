pipeline {
    agent any

    stage('Checkout') {
                steps {
                    git url: 'https://github.com/NagendraM9640/SerenityBDD.git',
                        credentialsId: 'github-creds'  // Use the saved credentials ID
                }
            }

        stage('Build') {
            steps {
                sh './mvn clean verify'
            }
        }

        stage('Test') {
            steps {
                sh './mvnw test'
            }
        }

        stage('Report') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }
}
