def call(String Project_Name, String Version_tag){
   echo "******** Pushing to Docker hub **********"
                withCredentials([usernamePassword(
                    credentialsId:"dockerHubCred",
                    usernameVariable:"dockerHubUser", 
                    passwordVariable:"dockerHubPass")]){
                  
                    sh 'echo $dockerHubPass | docker login -u $dockerHubUser --password-stdin'
                    sh "docker image tag ${Project_Name}:${Version_tag} $dockerHubUser/${Project_Name}:${Version_tag}"
                    sh "docker push $dockerHubUser/${Project_Name}:${Version_tag}"
                }
  echo "******** Successfully Pushed to Docker hub **********"
}
