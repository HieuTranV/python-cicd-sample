pipeline {
    agent any
    stages {
    stage('Test Localhost') {
      steps {
        sh 'pip install -r requirements.txt'
      }
    }
    stage('Docker Build') {
      steps {
        sh 'docker build -t 10.1.1.210:30001/ptest:0.0.7 -f Dockerfile .'
        sh 'docker push 10.1.1.210:30001/ptest:0.0.7'
      }
    }

    stage('Deployment') {
      steps {
        sshagent(['ansible_demo']) {
          sh 'ssh -o StrictHostKeyChecking=no 10.1.1.210'
          sh 'env'
        }
      }
    }
  }
}