# hello-world
Hello world application to greet

Steps to run the hello-world application. Application will run on port: 8080
Prerequisite:
You should have Docker running on your machine. 
If not, download and install docker on your machine.
Follow the below steps once you have docker running on your machine.

1. Clone the hello-world application 
https://github.com/menakaprabu/hello-world.git
2. Go to project folder where the Dockerfile is present
3. docker build -f Dockerfile -t docker-helloworld . 
4. docker run -p 8080:8080 docker-helloworld .
5. Launch http://localhost:8080/ Hello! will get displayed
6. Launch http://localhost:8080/healthz the health details will get displayed

What other information would you add to health endpoint json object in step 2? Explain what would be the use case for that extra information?
1. I would like to add the error details in case if the application is down.
2. I would like to add diskspace to know the diskspace.

What branching strategy would you use for development?
* 		master — This branch contains production code. All development code is merged into master in sometime.
* 		develop — This branch contains pre-production code. When the features are finished then they are merged into develop.

Below are the branches during the development cycle.
* 		feature-* — feature branches are used to develop new features for the upcoming releases. Feature branch is cut off from develop and must merge into develop.
* 		hotfix-* — hotfix branches are necessary to act immediately on the production fixes. Hotfix branch is cut off from from master and must merge into master and develop.
* 		release-* — release branches support preparation of a new production release. They allow many minor bug to be fixed and preparation of meta-data for a release. release branch is cut off from from develop and must merge into master and develop.
