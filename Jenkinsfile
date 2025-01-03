pipeline {
    agent any

    tools {
        maven 'sonarmaven'
    }

    environment {
        SONAR_TOKEN = credentials('sonar-token')
        SONAR_SCANNER_PATH = '/Users/senthilvelmuthupandy/Downloads/sonar-scanner-6.2.1.4610-macosx-aarch64/bin'
        JAVA_HOME = '/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home'
        PATH = "${SONAR_SCANNER_PATH}:${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {

        stage('Checkout Code') {
            steps {
                echo 'Checking out code...'
                checkout scm
            }
        }

        stage('Build & Package') {
            steps {
                echo 'Building and packaging the application...'
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests and collecting code coverage...'
                sh 'mvn test jacoco:report'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                echo 'Starting SonarQube analysis...'
                sh '''
                sonar-scanner -Dsonar.projectKey=MavenTask \
                  -Dsonar.sources=. \
                  -Dsonar.java.binaries=target/classes \
                  -Dsonar.jacoco.reportPaths=target/site/jacoco/jacoco.xml \
                  -Dsonar.host.url=http://localhost:9000 \
                  -Dsonar.login=$SONAR_TOKEN
                '''
            }
        }

    }

    post {
        success {
            echo 'Pipeline completed successfully!'
            archiveArtifacts artifacts: 'target/site/jacoco/*', allowEmptyArchive: true
        }
        failure {
            echo 'Pipeline failed. Please check the logs for errors.'
        }
    }
}
