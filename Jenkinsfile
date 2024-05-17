pipeline {
    agent any 


    environment {
        GITHUB_ORG = 'test-nsavinda'
        CONTAINER_REGISTRY = "ghcr.io/${GITHUB_ORG}/"
        CONTAINER_REGISTRY_URL = "https://{CONTAINER_REGISTRY}"
        ARTIFACT_ID = readMavenPom().getArtifactId()
        JAR_NAME = "${ARTIFACT_ID}-${BUILD_NUMBER}"
        JAR_LOCATION = "target/${JAR_NAME}.jar"
        IMAGE_NAME = "${CONTAINER_REGISTRY}${ARTIFACT_ID}"
        IMAGE_TAG = "${IMAGE_NAME}:${BUILD_NUMBER}"

    }

    stages {
        stage('Build Application'){

            agent{
                docker {
                    image "openjdk:23-jdk-bookworm"
                    reuseNode true
                }
            }
            steps{
                sh 'echo Performing Maven Build: ${ARTIFACT_ID}'
                sh './mvnw -DjarName=${JAR_NAME} clean verify'
            }
        }
        stage('Build Container Image'){
            steps{
                sh 'echo Building Container Image: ${IMAGE_NAME}'
                sh 'docker build --build-arg JAR_FILE=${JAR_LOCATION} -t ${IMAGE_TAG} .'
            }
        }
        stage('Push Container Image'){
            steps{
                sh 'echo publishing Container Image to ${CONTAINER_REGISTRY}'

                script {
                    docker.withRegistry('${CONTAINER_REGISTRY_URL}', 'github-nsavinda') {
                        sh 'docker push ${IMAGE_TAG}'

                        

                    }
                }
            }
        }
    }
}
