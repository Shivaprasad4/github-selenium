pipeline{
  agent any
  tools{
     maven 'M3'
	 }
  stages{
    stage('checkout'){
	  steps{
	    git "https://github.com/Shivaprasad4/github-selenium.git"
	  }
	}
	stage('Build'){
	    steps{
		bat 'mvn clean install'
        }
      }
	  stage('Test'){
	  steps{
	    bat 'mvn test'
		junit '**/target/surefire-reports/TEST-*.xml'
		
		}
	}
	stage('Package'){
	   steps{
	   bat 'mvn package'
	   }
	   }
	}
}
	  
   
