pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout your code from the repository
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Set up Maven
                tool name: 'Maven', type: 'hudson.tasks.Maven$MavenInstallation'

                // Run Maven build
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                // Run tests and generate JUnit report
                sh 'mvn test'
                junit '**/target/surefire-reports/*.xml'
            }
        }

        stage('Deliver') {
            steps {
                // Deploy or deliver your application (e.g., to a server)
                // Add relevant steps here
            }
        }
    }
}
