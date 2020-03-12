pipeline{
    agent{ label  'maven' }
    tools { maven "MAVEN_HOME" }
    parameters{
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'origin/devlop', name: 'BRANCH', type: 'PT_BRANCH'
        gitParameter name: 'TAG',type: 'PT_TAG', selectedValue: 'NONE'
    }
    stages{
        stage ('validate') {
            when {
                expression { BRANCH == 'origin/devlop' || BRANCH == 'devlop'  }
            }
            steps{
                sh 'mvn validate'
            }
        }
        stage('compile'){
            steps {
                sh "mvn compile"
            }
        }
        stage('sonar'){
            steps{
                build job : "sonar"
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
