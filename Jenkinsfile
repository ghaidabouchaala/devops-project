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
                  scannerHome = tool 'devops'
                  registry='ghaidabouchaala/devops'
                  registryCredential='dockerhub'
                  dockerImage=''
            }
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("Unit Testing") {
              steps {
                 script {
                     gv.unitTest()
                 }
              }
        }
        stage("SonarQube Testing and Scan") {

            steps {
                script {
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

        stage('Image building'){
            steps{
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
        stage('Deploy Image') {
            steps{
                script {
                    docker.withRegistry( '', registryCredential ) {
                    dockerImage.push()
                    }
                }
            }
        }
    }
}