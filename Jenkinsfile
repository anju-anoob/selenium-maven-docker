pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //bat - windows
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //bat - windows
                sh "docker build -t='anjuabraham/selenium-maven-docker' ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
                    //bat - windows
			        sh "docker login --username=${user} --password=${pass}"
			        sh "docker push anjuabraham/selenium-maven-docker:latest"
			    }
            }
        }
    }
}