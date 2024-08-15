pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'demo-app-imagen:latest'
        DOCKER_CONTAINER = 'demo-app-container'
    }

    stages {
        stage('Checkout') {
            steps {
                // Clona el repositorio desde GitHub
                git 'https://github.com/TroyanoMax/demo-app.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    // Construye el proyecto con Maven
                    sh 'mvn clean package'
                }
            }
        }
jen
        stage('Build Docker Image') {
            steps {
                script {
                    // Construye la imagen Docker
                    // sh "docker build -t ${DOCKER_IMAGE} ."
                    sh "docker exec docker-builder docker build -t ${DOCKER_IMAGE} /path/to/context ."
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                script {
                    // Detiene y elimina cualquier contenedor existente con el mismo nombre
                    sh "docker stop ${DOCKER_CONTAINER} || true"
                    sh "docker rm ${DOCKER_CONTAINER} || true"

                    // Ejecuta el nuevo contenedor
                    // sh "docker run -d -p 8080:8080 --name ${DOCKER_CONTAINER} ${DOCKER_IMAGE}"
                    sh "docker run -p 8080:8080 --env VAULT_BACKEND=services --env VAULT_TOKEN=hvs.8BV9BpKW2rsmLy3eXqD6Uu92 --env VAULT_URL=http://192.168.0.193:8200 --env VAULT_APPLICATION_NAME=demo --name ${DOCKER_CONTAINER} ${DOCKER_IMAGE}"
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
