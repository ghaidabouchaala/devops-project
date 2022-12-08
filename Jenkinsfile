def gv

pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage("init") {

            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("SonarQube Testing and Scan") {
        environment {
                               CI = 'true'
                              scannerHome = tool 'devops'
                    }
            steps {
                script {
                   // sh 'mvn clean verify sonar:sonar  -D maven.test.skip=true -Dsonar.projectKey=devops-project   -Dsonar.host.url=http://localhost:9000   -Dsonar.login=sqp_33ae35f230cde39c3a7c91be0867bc801545ba87'
                    sh "mvn clean verify sonar:sonar -D sonar.projectKey=devops -D maven.test.skip=true  -D sonar.login=squ_9854aec5640594c23dd308012cde3301142f63fc"
                }
            }
        }
       /* stage("Push JAR to Nexus"){
            steps {
                script {
                    gv.pushToNexus()
                }
            }
        }*/
    }
}