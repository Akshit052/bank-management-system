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
      // stage('Deploy to Tomcat') {
      //       steps {
      //          // Deploy the WAR file to Tomcat using the Deploy to Container plugin
      //          deploy adapters: [tomcatAdapter(credentialsId: 'tomcat-credentials', url: 'http://localhost:8081/manager/text', path: '/bms', war: 'target/BMS_TeamB-0.0.1-SNAPSHOT.war')], contextPath: '/bms'
      //       }
      // }
      // stage('Deploy to Tomcat') {
      //    steps {
      //          script {
      //             def tomcatAdapters = [
      //                [$class: 'TomcatAdapter', credentialsId: 'tomcat-credentials', url: 'http://localhost:8081/manager/text', path: '/bms', war: 'target/BMS_TeamB-0.0.1-SNAPSHOT.war']
      //             ]
      //             deploy adapters: tomcatAdapters
      //          }
      //    }
      // }
      stage('Run SonarQube Analysis') {
         steps {
            script {
               // Defining SonarQube scanner configuration
               def scannerHome = tool 'SonarQube'; // Assuming SonarQube is configured in Jenkins as a tool named 'SonarQube'
               withSonarQubeEnv('SonarQube') {
                  sh "${scannerHome}/bin/sonar-scanner"
               }
            }
         }
      }
   }
}
