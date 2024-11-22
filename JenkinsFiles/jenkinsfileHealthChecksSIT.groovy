package JenkinsFiles

def createEmailSendingList() {
    if ("true" == "%send_emailtoAll%") {
        emailfinalList = emailmultipleList
    } else {
        emailfinalList = emailsingleList
    }
    echo "%emailfinalList%"
}

pipeline {
    agent { label 'master' }
    parameters {

        choice(name: 'EnvironmentToExecute', choices: ['sit', 'prelive', 'prod'], description: 'Select Environment to Execute')
        choice(name: 'Browser', choices: ['chrome', 'jenkins', ''], description: 'Select Browser')
        choice(name: 'Browser Mode', choices: ['', 'headless'], description: 'Select Browser Mode')
        string(name: 'Tags', defaultValue: '@SIT-EnvironmentHealthCheck', description: 'Select Tags to run, eg: @HC')
        booleanParam(defaultValue: true, description: 'Enable Screenshots', name: 'EnableScreenshots')
        booleanParam(defaultValue: false, description: 'Enable Recording - select only when foreground mode', name: 'EnableRecording')
        booleanParam(defaultValue: false, description: 'Attach All screenshots to Report', name: 'AttachAllScreenshots')
        booleanParam(defaultValue: false, description: 'Select / Check if sample tag to be tested - bypass Tags parameter', name: 'sampleRun')
        string(name:'EmailID',defaultValue: 'OrbitTestTeam@domesticandgeneral.com;a.bedford@pccsuk.com',description: 'email to send the report')

    }
    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/orbitreg23']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '3bc3e482-4987-47a6-8004-60a11a15e5ca', url: 'http://vantipv@bedwtstapp002/git/OrbitRegression.git']]])
                echo 'checkout stage...'
            }
        }
        stage('Clean & Build') {
            steps {
                bat 'mvn clean install -DskipTests'
                echo 'Build stage'
            }
        }
        stage('Test Execution') {
            steps {

                bat 'mvn clean test -Dcucumber.filter.tags="%Tags%" -DENV=%EnvironmentToExecute% -Dbroswer=%Browser% -DbrowserState=%BrowserState%  -Ddataproviderthreadcount=4'
                echo 'Executing Tests in Parallel - Main Tests'

            }
        }
        stage('Generate Report') {
            steps {
                cucumber expandAllSteps: true, failedFeaturesNumber: -1, failedScenariosNumber: 1, failedStepsNumber: -1, fileIncludePattern: 'cucumber.json', hideEmptyHooks: true, jsonReportDirectory: 'target', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
                echo 'Generate Cucumber Report'
            }
        }
        stage('Send Email') {
            steps {
                echo 'Send Email'
                emailext body: '''
                   <!DOCTYPE html>
                    <html>
                    <head>
                    <title>Automation Test Packs - Orbit</title>
                    </head>
                    <body>
                    <style>
                        table, th, td {
                        border: 1px solid #ddd;
                        padding: 8px;
                        }
                       th, td {
                        padding: 5px;
                        }
                    </style>
                    <style>
                        #customers {
                        font-family: Arial, Helvetica, sans-serif;
                        border-collapse: collapse;
                        width: 100%;
                        }
                        #customers td, #customers th {
                         border: 1px solid #ddd;
                            padding: 8px;
                        }
                        #customers tr:nth-child(even){background-color: #f2f2f2;}
                        #customers tr:hover {background-color: #ddd;}
                        #customers th {
                        padding-top: 12px;
                        padding-bottom: 12px;
                        text-align: left;
                        background-color: #4CAF50;
                        color: white;
                    }
                    </style>
                    
                     <h1 style="text-decoration: underline;">Automation Test Execution Status </h1><br/>
                    <h3><p> Please click the below link to view the complete Test Report</h3>
                    <a href="$BUILD_URL/cucumber-html-reports/overview-features.html">$BUILD_URL/cucumber-html-reports/overview-features.html</a> </p>
                    <br/><br/>
           
           
                    <br/><table id="customers">
                    <tr>
                    <th>TEST EXECUTION DETAILS :</th>
                    </tr>
                    </table>

<table id="customers" style="width:100%">
  <tr>
    <td><h4 style="color:black;">Job Name</h4> </td>
    <td>$JOB_NAME</td>
  </tr>
  <tr>
    <td><h4 style="color:black;">Build No </h4></td>
    <td> $BUILD_NUMBER</td>
  </tr>
    <tr>
    <td><h4 style="color:black;">Build Status </h4></td>
    <td> $BUILD_STATUS</td>
  </tr>
      <tr>
    <td><h4 style="color:black;">Build URL </h4></td>
    <td> $BUILD_URL</td>
  </tr>
    </tr>
      <tr>
    <td><h4 style="color:black;">Automation Test Report </h4></td>
    <td><a href="$BUILD_URL/cucumber-html-reports/overview-features.html">$JOB_NAME</a></td>
  </tr>
  
</table>

<p><strong>Note:</strong> Execution statistics are as per the current day run,
                     to check the complete log please go to the console output at <a href="$BUILD_URL">Build</a>.</p>
                    
                   <h4><p style="font-style: italic;">Regards,<br/>
                   Orbit Test Team,<br/>
                   Domestic & General.</p></h4><br/>

</body>
</html>
                   
                  

               ''', subject: '$JOB_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS!', from: 'Jenkins_notifications@domesticandgeneral.com', to: '$EmailID'

            }
        }

    }
}