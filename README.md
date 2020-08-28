# Hello world application

# Steps to run the hello-world application. Application will run on port: 8080
# Prerequisite:
You should have Docker running on your machine\
If not, download and install docker on your machine\

Follow the below steps to run the helloworld application.( Docker should be running on your machine.)\
1. Clone the hello-world application\
https://github.com/menakaprabu/hello-world.git
2. Go to project folder where the Dockerfile is present
3. docker build -f Dockerfile -t docker-helloworld . 
4. docker run -p 8080:8080 docker-helloworld . 
5. Launch http://localhost:8080/ Hello! will get displayed
6. Launch http://localhost:8080/healthz the health details will get displayed

What other information would you add to health endpoint json object in step 2? Explain what would be the use case for that extra information?
1. Add single line error detail in case if the application is down. Usecase: Helps to fix the issue fast

What branching strategy would you use for development?
* 		master — This branch contains production code. All development code is merged into master in sometime
* 		develop — This branch contains pre-production code. When the features are finished then they are merged into develop

Below are the branches during the development cycle
* 		feature-* — feature branches are used to develop new features for the upcoming releases. Feature branch is cut off from develop and must merge into develop
* 		hotfix-* — hotfix branches are necessary to act immediately on the production fixes. Hotfix branch is cut off from from master and must merge into master and develop
* 		release-* — release branches support preparation of a new production release. They allow many minor bug to be fixed and preparation of meta-data for a release. release branch is cut off from from develop and must merge into master and develop

How would you automate the build/test/deploy process for this application?\
Use Jenkins tool to automate the process.\
Stages to build/test/deploy (Pipeline script)\
Developer pushes the code into GIT repo\
Pipeline job code - I will be having below stages\
2a: SCM checkout\
2b: Gradle clean build - It compiles, build and runs the test cases. If there is any failure in test the build generation will fail\
If everything is good it generates the jar file for helloworld application\
2c:  Build docker image - command: docker build - t myusername/helloworld:0.0.1 . \
2d: Push the docker image - command: docker push yourusername/helloworld:0.0.1\
2e: Run the container on the Dev server - command: docker run -p 8080:8080 -d helloworld:0.0.1\
Using sshagent run the docker container in the remote machine(dev server) 

What would be the purpose of each stage in CICD pipeline?
Once git push happens  - Build and Test job gets triggered\
SONAR - To validate that the code adhere the coding standard and junit coverages. (Setup the coverage as 85% so that maximum code is covered)
Deployment job - Deploy the docker container in the pre-prod or prod environment

What CICD tool/service would you use?\
Jenkins, Docker, gradle

