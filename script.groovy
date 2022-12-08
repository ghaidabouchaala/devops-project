/*def pushToNexus() {
    echo "pushing the jar file to Nexus maven-snapshots repo..."
    sh 'mvn clean package -D maven.test.skip=true deploy:deploy-file -D groupId=com.example -D artifactId=demo -D version=3.0.0 -D packaging=jar -D repositoryId=deploymentRepo -D url=http://localhost:8081/repository/maven-releases/ -D file=target/demo-0.0.1-SNAPSHOT.jar'
}*/

def sonarScan() {
    echo "Run sonarQube scan..."
    echo "went through the command..."
    //devops
    }

return this