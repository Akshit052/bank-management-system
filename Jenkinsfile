pipeline {
   agent any

   stages {
      stage('Verify Branch') {
         steps {
            echo "$GIT_BRANCH"
         }
      }
      stage('Build and Package') {
         steps {
            // Compile and package your Spring application
            sh 'mvn clean package'
         }
      }
      stage('Run Unit Tests') {
         steps {
               // Run unit tests and publish the results
               sh 'mvn test'
         }
      }
   }
}
