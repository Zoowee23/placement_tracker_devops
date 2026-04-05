pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK'
    }

    stages {

        stage('Clone Repository') {
            steps {
                git branch: 'main',
                url: 'https://github.com/advika-khorgade/placement_tracker_devops.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t placement-tracker .'
            }
        }

        stage('Deploy Container') {
            steps {
                bat 'docker stop placement-container || exit 0'
                bat 'docker rm placement-container || exit 0'
                bat 'docker run -d -p 9090:8080 --name placement-container placement-tracker'
            }
        }

    }
}