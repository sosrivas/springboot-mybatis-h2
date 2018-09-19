## Steps to run this springboot application.

-   Check out the application from git 
-   run the following commands in the project root directory 
       1.   ./gradlew build
       2.   docker build -f Dockerfile -t springboot-mybatis .
       3.   docker images
       4.   docker run -p 8080:8080 springboot-mybatis    
