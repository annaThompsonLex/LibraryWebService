LibraryWebService: Assortment of technologies including Arquillian
========================
Author: Tommy Steger, Anna Thompson, Olof Wahlund
Level: Intermediate.
Technologies: JPA, EJB, JPA and JAX-RS.
Database: MySQL
Summary: A practical REST service example of library solution.
Target Project: WildFly.
Source: <https://github.com/annaThompsonLex/LibraryWebService>.

Add User and Password
-----------
1. You need to have a user account to get access to http methods, you find it in the web.xml file in the project.
2. How to set up a new user see example:

\wildfly-10.1.0.Final\bin>
add-user.bat -a -u "guest1" -p "guest1" -g "guest"


What is it?
-----------

This project! is a book library Maven 3 project on JBoss WildFly.
Using  EJB 3.3, JPA 2.1. 

The solution allows you to add books, add users, loan and return books. 
You find the http methods in the  API_doc.pdf.

System requirements
-------------------

The project is based on:  
Java 7.0 (Java SDK 1.7) or better, Maven 3.1 or better and JBoss WildFly.
MySQL.


How to set up MySQL database
-------------------------

1. In MySQL run: CREATE SCHEMA mysqllib.
2. Open  WildFly Console, locahost:9990.
3. Configuration/Subsystems/Datasources/Non-XA/Add "MySQL Datasource".
4. Make sure you test it with successful outcome.

Start JBoss WildFly with the Web Profile
-------------------------

1. Open a command line and navigate to the root of the JBoss server directory.
2. The following shows the command line to start the server with the web profile:

        For Linux:   JBOSS_HOME/bin/standalone.sh
        For Windows: JBOSS_HOME\bin\standalone.bat

 
Build and Deploy
-------------------------

1. Make sure you have started the JBoss Server as described above.
2. Open a command line and navigate to the root directory of this project.
3. Type this command to build and deploy the archive:

        mvn clean package wildfly:deploy

4. This will deploy `target/LibraryWebService.war` to the running instance of the server.
 

Access the application 
---------------------

The application will be running at the following URL: <http://localhost:8080/LibraryWebService/>.


Undeploy the Archive
--------------------

1. Make sure you have started the JBoss Server as described above.
2. Open a command line and navigate to the root directory of this project.
3. When you are finished testing, type this command to undeploy the archive:

        mvn wildfly:undeploy


Run the project in JBoss Developer Studio or Eclipse
-------------------------------------
You can also start the server and deploy the project from Eclipse using JBoss tools. For more information, see [Use JBoss Developer Studio or Eclipse to Run the project](https://github.com/jboss-developer/jboss-developer-shared-resources/blob/master/guides/USE_JBDS.md) 


Debug the Application
------------------------------------

If you want to debug the source code or look at the Javadocs of any library in the project, run either of the following commands to pull them into your local repository. The IDE should then detect them.

    mvn dependency:sources
    mvn dependency:resolve -Dclassifier=javadoc
    
    
    
    
    
