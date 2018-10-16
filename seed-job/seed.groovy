folder('student') {
    displayName('Student Project')
    description('Folder for Student Project Jobs')
}

pipelineJob('student/StudentCICD-RELEASE') {
  configure { flowdefinition ->
    flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
      'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
        'configVersion'(2)
        'userRemoteConfigs' {
          'hudson.plugins.git.UserRemoteConfig' {
            'url'('https://github.com/cit31/jenkins-code.git')
          }
        }
        'branches' { 
          'hudson.plugins.git.BranchSpec' {
            'name'('*/master')
          }
        }
      }
      'scriptPath'('StudentProject-CICD/Jenkinsfile')
      'lightweight'(true)
    }
  }
}
