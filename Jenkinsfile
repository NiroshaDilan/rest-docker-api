pipeline {
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                sh 'gradle assemble'
            }
        }
        stage('Test') {
            steps {
                sh 'gradle test'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'gradle docker'
            }
        }
        stage('Run Docker Image') {
            steps {
                sh 'gradle dockerRun'
            }
        }
    }
}

// final String prod_docker_host = "ssh://root@192.168.8.102"
// node {
//     def remote = [:]
//     remote.name = 'test'
//     remote.host = '192.168.8.102'
//     remote.user = 'root'
//     remote.password = 'root'
//     remote.allowAnyHosts = true
//
//     stage("SCM Checkout") {
//         git credentialsId: 'db39b925-db38-4329-a383-21788a35eb13', url: 'https://github.com/NiroshaDilan/rest-docker-api.git'
//     }
//     stage("Gradle Build") {
//         bat 'gradle clean build'
//     }
//     stage('Build Docker Image') {
//         bat 'docker build -t dilanfernando/rest-docker-api:0.0.3 .'
//     }
//     stage('Push Docker Image') {
//         withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerHubPwd')]) {
//           bat 'docker login -u dilanfernando -p %dockerHubPwd%'
//         }
//         bat 'docker push dilanfernando/rest-docker-api:0.0.3'
//     }
//     stage('Run Container on Dev Server') {
//         def dockerRun = 'docker run --network postgres-rest -p 8081:8081 -d --rm --name rest-docker-api dilanfernando/rest-docker-api:0.0.3'
//         // sshCommand remote: remote, command: 'docker stop rest-docker-api'
//         sshCommand remote: remote, command: dockerRun
//     }
//
// }