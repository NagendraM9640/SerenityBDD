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
        // If Maven was able to run the tests, even if some of the test
        // failed, record the test results and archive the jar file.
        success {
            publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target/site/serenity/', reportFiles: 'index.html', reportName: 'Serenity Report', reportTitles: 'Functional Testing Report', useWrapperFileDirectly: true])
        }
    }
}
