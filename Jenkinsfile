pipeline {
    agent any

    stages {
        stage('build') {
            steps {
                echo 'Build'
            }
        }

        stage('SoanrQube') {
            steps {
                echo 'SonarQube Running'
                build job: "Automation_Jobs/SonarQube", wait: true
            }
        }

        stage('Parallel Jobs  |Chrome|Edge|Firefox|') {
            steps {
                script {
                    def QA_Automation_EDGE = {
                        build job: "Automation_Jobs/QA_Automation_EDGE", wait: true
                        echo "Running QA_Automation_EDGE job"
                    }

                    def QA_Automation_CHROME = {
                        build job: "Automation_Jobs/QA_Automation_CHROME", wait: true
                        echo "Running QA_Automation_CHROME job"
                    }

                    def QA_Automation_FIREFOX = {
                        build job: "Automation_Jobs/QA_Automation_FIREFOX", wait: true
                        echo "Running QA_Automation_FIREFOX job"
                    }

                    parallel QA_Automation_EDGE: QA_Automation_EDGE, QA_Automation_CHROME: QA_Automation_CHROME, QA_Automation_FIREFOX: QA_Automation_FIREFOX
                }
            }
        }
    }

    post {
        always {
            echo "Running 'Automation Data' stage in the 'always' post-build step"
            build job: "Automation_Jobs/AutomationData", wait: true
            echo "AutomationData job (in 'always' post-build step)"
        }
    }
}
