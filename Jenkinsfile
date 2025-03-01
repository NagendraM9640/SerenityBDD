pipeline {
    agent {
        label 'Performance-Testing-Jenkins-Node'
    }
    environment {
        ENVIRONMENT                     = "${env.GIT_BRANCH == "master" ? "prod" : env.GIT_BRANCH}"
        BITBUCKET_REPO_URL              = "${env.GIT_URL}"
        AWX_TOKEN                       = "awx-token"
        AWX_SERVER                      = "ansible-tower"
        BITBUCKET_TOKEN                 = "s-service-jenkins"
        // EMAIL_INFORM                    = getEmailAddressesForApproval(env.GIT_BRANCH)
    }
    stages {
        stage('Git Checkout') {
            steps {
                deleteDir()
                git branch: "${env.GIT_BRANCH}", credentialsId: "${BITBUCKET_TOKEN}", url: "${BITBUCKET_REPO_URL}"
            }
        }
        stage('Functional Test') {
            steps {
                script {
                    results=ansibleTower(
                            importTowerLogs: true,
                            importWorkflowChildLogs: false,
                            towerLogLevel: 'full',
                            jobTemplate: "pmi-app-clipp-ansible-ft-dev-conc-cc-regression",
                            jobType: 'run',
                            removeColor: true,
                            templateType: 'job',
                            throwExceptionWhenFail: false,
                            towerCredentialsId: "${AWX_TOKEN}",
                            towerServer: "${AWX_SERVER}",
                            verbose: true
                    )
                }
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
