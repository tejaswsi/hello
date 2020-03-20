pipeline{
    agent{ label  'maven' }
    tools { maven "MAVEN_HOME" }
    parameters{
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'origin/devlop', name: 'BRANCH', type: 'PT_BRANCH'
        gitParameter name: 'TAG',type: 'PT_TAG', selectedValue: 'NONE'
    }
    stages{
        stage ('dev&build') {
            when {
                expression { BRANCH == 'origin/devlop' || BRANCH == 'devlop'  }
            }
            steps{
                sh 'mvn deploy'
            }
        }
        stage('compile'){
            steps {
                sh 'cd shopizer-canadapost && docker build -t shopizer-canadapost:v1'
                sh 'docker tag shopizer-canadapost:v1 3.224.134.102shopizer-canadapost:v1'
                sh 'docker push 3.224.134.102shopizer-canadapost:v1'
            }
        }
        stage('sonar'){
            steps{
                echo "sonar"
            }
        }
        stage("test"){
            steps{
                sh "mvn test"
            }
        }
        stage("deploy"){
            steps{
                sh "mvn deploy"
                echo "shabbir"
            }
        }
    }
}
