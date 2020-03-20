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
                sh 'mvn clean deploy'
            }
        }
        stage('compile'){
            steps {
                sh 'cd shopizer-canadapost && docker build -t shopizer-canadapost:v1 .'
                sh 'docker tag shopizer-canadapost:v1 3.224.130.86:8082/shopizer-canadapost:v1'
                sh 'docker push 3.224.130.86:8082/shopizer-canadapost:v1'
            }
        }
        
    }
}
