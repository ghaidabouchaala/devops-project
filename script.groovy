def pushToNexus() {
    echo "pushing the jar file to Nexus maven-snapshots repo..."
    sh 'mvn clean package -D maven.test.skip=true deploy:deploy-file -D groupId=org.springframework.samples -D artifactId=spring-petclinic -D version=2.7.3 -D packaging=jar -D repositoryId=deploymentRepo -D url=http://localhost:8081/repository/maven-releases/ -D file=target/spring-petclinic-2.7.3.jar'
}

def sonarScan() {
    echo "Running sonarQube scan..."
    sh 'mvn clean verify sonar:sonar  -D maven.test.skip=true -Dsonar.projectKey=devops-project   -Dsonar.host.url=http://localhost:9000   -Dsonar.login=sqp_33ae35f230cde39c3a7c91be0867bc801545ba87'
}

return this