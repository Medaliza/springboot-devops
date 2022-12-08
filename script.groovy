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
return this