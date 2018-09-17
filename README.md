# assignment
Java Code Assignment

Requirement: create a maven project to implement a simple Spring based web application with a controller exposing the folloing 4 APIs
1. GET /user
2. POST /user
3. PUT /user
4. DELETE /user

These APIs will perform CRUD Operations using Hibernate as persistance framework on a User entity with at minimum the following fields
id (long)/primary key
username (String)/unique
status (String) / possible values: Activated/Deactivated

Solution:

Software Versions Used:
java version 10.0.2
Apache Maven 3.5.4

Web Server: jetty

In Memory DB: HSQL DB
Configuration 
username: sa  
password: 

Build/Run Commands
cd assignment  --> project directory
mvn clean install  --> clean and build
mvn jetty:run  --> run this command once build is successfull. It automatically deploys the war file and runs.

URL: http://localhost:8080/

1. User is having 4 fields : userId, username, password, status.
2. Above URL will open a page containing username, password to be entered with a button 'Register' to register the user data.
3. Same page also contain a 'Show All Users Data' link which will fetch all the information of registered users data.
4. The User data fetched on the same page will have 3 different links
	a. Change Password --> This will redirect a different page to change the password data only if user is in Activated State.
	b. Activate/Deactivate User  --> User is Activated or Deactivated.
	c. Delete User --> User is Deleted from DB.
