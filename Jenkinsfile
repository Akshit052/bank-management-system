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
   }
}
