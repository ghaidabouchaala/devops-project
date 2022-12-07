def gv

pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage("init") {
            environment {
                       CI = 'true'
                      scannerHome = tool 'devops-project'
            }
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("SonarQube Testing and Scan") {
            steps {
                script {
                   // sh 'mvn clean verify sonar:sonar  -D maven.test.skip=true -Dsonar.projectKey=devops-project   -Dsonar.host.url=http://localhost:9000   -Dsonar.login=sqp_33ae35f230cde39c3a7c91be0867bc801545ba87'
                    gv.sonarScan()
                }
            }
        }
        stage("Push JAR to Nexus"){
            steps {
                script {
                    gv.pushToNexus()
                }
            }
        }
    }
}