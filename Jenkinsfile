def VERSION = "v0"
def GITREPO = "git@github.com:YellowBicycleee/Yanzhu.git"
pipeline{  
    agent { label 'master' }
    tools { 
        jdk 'jdk11'
        maven 'maven3.8.6' 
    }
    stages{
        stage("代码克隆"){
            steps{
                sh "cd /var/lib/jenkins/workspace/backend-pipeline && rm -rf ./*"
                git branch: 'main', credentialsId: '1', url: "${GITREPO}"
                echo "代码克隆完成"
            }
        }
        
        stage("代码构建打包"){
            steps{
                sh "cd /var/lib/jenkins/workspace/backend-pipeline/Yanzhu && mvn clean package"
                echo "代码构建打包完成"
            }
        }
		
        stage("更新服务"){
            steps{
                sh "cd /var/lib/jenkins/workspace/backend-pipeline/Yanzhu"
				sh "chmod +x restart_jar.sh"
				sh "./restart_jar.sh"
                echo "更新服务"
            }
        }
    }
}