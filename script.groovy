def pushToNexus() {
    echo "pushing the jar file to Nexus maven-snapshots repo..."
    sh 'mvn clean package -D maven.test.skip=true deploy:deploy-file -D groupId=org.springframework.samples -D artifactId=spring-petclinic -D version=2.7.3 -D packaging=jar -D repositoryId=deploymentRepo -D url=http://localhost:8081/repository/maven-releases/ -D file=target/spring-petclinic-2.7.3.jar'
}

def sonarScan() {
    echo "Running sonarQube scan..."
    sh "mvn clean verify sonar:sonar -Dsonar.projectKey=demo -Dmaven.test.skip=true  -Dsonar.login=squ_594c07451d6adeedecdb514f8a2f9e9e3ae2f403"
    //devops
    }

return this