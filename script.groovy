def pushToNexus() {
    echo "pushing the jar file to Nexus maven-snapshots repo..."
    sh 'mvn clean package -D maven.test.skip=true deploy:deploy-file -D groupId=org.springframework.samples -D artifactId=spring-petclinic -D version=2.7.3 -D packaging=jar -D repositoryId=deploymentRepo -D url=http://localhost:8081/repository/maven-releases/ -D file=target/spring-petclinic-2.7.3.jar'
}

def sonarScan() {
    echo "Running sonarQube scan..."
    withSonarQubeEnv('devops-project') {
        // sh "${scannerHome}/bin/sonar-scanner"
        sh "mvn clean verify sonar:sonar -Dsonar.projectKey=devops-project -Dmaven.test.skip=true"
    }
}

return this