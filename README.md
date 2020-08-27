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


