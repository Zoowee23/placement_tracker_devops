pipeline {

    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }


    stages {

        stage('Pull Code') {
            steps {
                git branch: 'main',
                url: 'https://github.com/Zoowee23/placement_tracker_devops.git'
            }
        }

        stage('Build Project') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Execute Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
               bat 'docker build -t placement-tracker .'
            }
        }

        stage('Deploy App') {
            steps {
                bat 'docker stop placement-container || exit 0'
                bat 'docker rm placement-container || exit 0'
                bat 'docker run -d -p 9090:8080 --name placement-container placement-tracker'

            }
        }
    }
}