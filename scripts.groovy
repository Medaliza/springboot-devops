def git_clone(){
    git "https://github.com/Medaliza/spring-devops-project"
}
def run_unit_tests(){
    sh "mvn clean"
    sh "mvn test"
}
def sonarqube_scan(){
    sh "mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=admin123"

}
def nexus_deploy(){
    sh "mvn clean package -Dmaven.test.skip=true deploy:deploy-file -DgroupId=com.example -DartifactId=devops-project -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/devops-project-0.0.1-SNAPSHOT.jar"
}
def build_docker_image(){
    sh "docker build -t devopsproject ."
}
def deploy(){
    sh "docker-compose up -d"
}
return this