pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'demo-app-imagen:latest'
        DOCKER_CONTAINER = 'demo-app-container'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'develop', url: 'https://github.com/TroyanoMax/demo-app.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh './mvnw clean package' // Empaqueta tu aplicación
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKER_IMAGE}")
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('', "${REGISTRY_CREDENTIALS}") {
                        docker.image("${DOCKER_IMAGE}").push()
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    docker.image("${DOCKER_IMAGE}").run("-d -p 8080:8080 -e VAULT_BACKEND=services -e VAULT_TOKEN=hvs.8BV9BpKW2rsmLy3eXqD6Uu92 -e VAULT_URL=http://192.168.0.193:8200 -e VAULT_APPLICATION_NAME=demo --name ${DOCKER_CONTAINER}")
                }
            }
        }
    }

    post {
        always {
            // Limpia el espacio de trabajo después de la ejecución
            cleanWs()
        }
    }
}
