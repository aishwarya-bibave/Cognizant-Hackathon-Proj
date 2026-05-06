pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Run TestNG') {
            steps {
                sh 'mvn test -DsuiteXmlFile=testng.xml'
            }
        }

    }
}