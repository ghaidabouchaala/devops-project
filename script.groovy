def pushToNexus() {
    echo "pushing the jar file to Nexus maven-snapshots repo..."
    sh 'mvn clean package -D maven.test.skip=true deploy:deploy-file -D groupId=org.springframework.samples -D artifactId=spring-petclinic -D version=2.7.3 -D packaging=jar -D repositoryId=deploymentRepo -D url=http://localhost:8081/repository/maven-releases/ -D file=target/spring-petclinic-2.7.3.jar'
}

def sonarScan() {
    echo "Running sonarQube scan..."
    sh 'mvn test'
    sh 'mvn sonar:sonar -Dsonar.login=sqp_8703a5f6a7ab98a1e4f116a701c94c3885c795fe'
}

return this