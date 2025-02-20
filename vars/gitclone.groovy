def call(String git_url, String git_branch){
  echo "******** Starting cloning Github Repositry ********"
  git url: "${git_url}", branch: "${git_branch}"
  echo "******** Successfully Cloned github repo *********"
}
