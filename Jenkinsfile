pipeline {
    agent {
        kubernetes {
            yaml '''
            apiVersion: v1
            kind: Pod
            metadata:
              name: jenkins-agent
            spec:
              containers:
              - name: kubectl
                image: gcr.io/cloud-builders/kubectl
                command:
                - cat
                tty: true
              volumes:
              - name: docker-socket
                hostPath:
                  path: "/var/run/docker.sock"
            '''
        }
    }

    environment {
        GITHUB_URL = 'git@github.com:beyond-sw-camp/be08-4th-DQ-OMOS.git'
        GITHUB_CREDENTIALS_ID = 'omos_access_ssh'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', credentialsId: "${GITHUB_CREDENTIALS_ID}", url: "${GITHUB_URL}"
            }
        }

        stage('Kubernetes Deployment') {
            steps {
                container('kubectl') {
                    script {
                        sh "kubectl set image deploy auth-deploy auth=jjjwww8802/auth-service:latest -n default"
                        sh "kubectl set image deploy student-deploy student=jjjwww8802/student-service:latest -n default"
                        sh "kubectl set image deploy calendar-deploy calendar=jjjwww8802/calendar-service:latest -n default"
                        sh "kubectl set image deploy notice-deploy notice=jjjwww8802/notice-service:latest -n default"
                        sh "kubectl set image deploy notification-deploy notification=jjjwww8802/notification-service:latest -n default"
                    }
                }
            }
        }
    }

    post {
        success {
            withCredentials([string(credentialsId: 'discord-webhook', variable: 'DISCORD')]) {
                discordSend description: """
                제목 : ${currentBuild.displayName}
                결과 : ${currentBuild.result}
                실행 시간 : ${currentBuild.duration / 1000}s
                """,
                result: currentBuild.currentResult,
                title: "${env.JOB_NAME} : ${currentBuild.displayName} 성공",
                webhookURL: "${DISCORD}"
            }
        }
        failure {
            withCredentials([string(credentialsId: 'discord-webhook', variable: 'DISCORD')]) {
                discordSend description: """
                제목 : ${currentBuild.displayName}
                결과 : ${currentBuild.result}
                실행 시간 : ${currentBuild.duration / 1000}s
                """,
                result: currentBuild.currentResult,
                title: "${env.JOB_NAME} : ${currentBuild.displayName} 실패",
                webhookURL: "${DISCORD}"
            }
        }
    }
}
