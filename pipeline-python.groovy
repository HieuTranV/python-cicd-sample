pipeline {
    agent any
    stages {
    stage('Test Localhost') {
      steps {
        sh 'pip install -r requirements.txt'
        sh 'python3 -m uvicorn index:app --host 0.0.0.0 --port 8077'
      }
    }
    stage('Docker Build') {
      steps {
        sh 'docker build -t 10.1.1.210:30001/ptest:0.0.3 -f Dockerfile .'
        sh 'docker push 10.1.1.210:30001/ptest:0.0.3'
      }
    }
  }
}