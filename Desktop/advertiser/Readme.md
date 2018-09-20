## Steps to run this springboot application.

-   Check out the application from git 
-   run the following commands in the project root directory 
       1.   ./gradlew build
       2.   docker build -f Dockerfile -t springboot-mybatis .
       3.   docker images
       4.   docker run -p 8080:8080 -p 9000:9000 springboot-mybatis   
       
### EndPoint of the Rest Service

Best way to test the application is to import advertiser.postman_collection.json(located in the root of the project folder) file in postman. Postman can be downloaded from 
[here](https://www.getpostman.com/apps)        

The Endpoint urls can also be found at : [Swagger UI](http://localhost:8080/swagger-ui.html#/controller)
Actuator URLs:

- [Health](http://localhost:9000/actuator/health)
- [Metrics](http://localhost:9000/actuator/metrics)
