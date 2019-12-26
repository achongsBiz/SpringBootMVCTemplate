# SpringBootMVCTemplate

## Introduction
This is a simple Gradle SpringBoot starter template with a H2 in-memory database and JSP's to render views.

## Example Code
The template contains an example of data transmitted across the stack from the H2 Database to a JSP file or a RESTful endpoint. 

The sample database contains one table with an id and description column. Three rows have been inserted into this table.
Through a DAO class and a set of controllers the rows are transmitted to the user via the following endpoints:

* ```http://localhost:8080/``` : renders samplePage.jsp

* ```http://localhost:8080/v1/retrieve```: example GET RESTful call

## How To Prepopulate Data
Data is populated in **TemplateApplication.java**. The following pattern within the run() method may be used or abstracted:

```
log.info("Creating example table");
jdbcTemplate.execute("DROP TABLE sampleTab IF EXISTS");
jdbcTemplate.execute("CREATE TABLE sampleTab(id SERIAL,  description VARCHAR(100))");
jdbcTemplate.execute("INSERT INTO sampleTab(description) VALUES ('gym')");
jdbcTemplate.execute("INSERT INTO sampleTab(description) VALUES ('ultraviolet radiation')");
jdbcTemplate.execute("INSERT INTO sampleTab(description) VALUES ('laundry')");
```

Note that by default H2 is a volatile in-memory database. If the application is stopped and restarted, data will return to its original state. In this example, the original state will be that the application has a table called sampleTab with 3 rows populated.

## Start the Application from the IDE

This is a SpringBoot application. From IntelliJ, you should right click on **TemplateApplication.java** and select Run. Verify you had a clean start by reviewing the console and ensuring that the server is up and running.

## Accessing the H2 Database

The H2 database can be accessed through the following URL: ```http://localhost:8080/h2-console/``` after you have started the application from the IDE. Ensure that the JDBC URL is set to: ```jdbc:h2:mem:testdb``` . You can connect with the default credential.

If you have made no changes to the template, you should see the sampleTab table discussed in the "How To Prepopulate Data" section on the left. 

This site plays a similar role as a SQL client, allowing you to write SQL queries against your tables.

## Configuration
The ***application.properties*** file has two note worthy things to point out:
* The ```spring.mvc.view.prefix``` and the ```spring.mvc.view.suffix``` properties point to where the JSP's are defined. The location defined by the former is already part of the template! The file structure does not need to be recreated.
* The ```db.url``` and ```db.username``` properties are used by the H2 database. These properties are meant to be injected into the DAO, see **MyClassJDBCDAO.java** in the /data package as an example.
  * If you do want to continue to inject these values, the concrete DAO classes must be defined as components, and the consumers of the DAO must autowire these objects in. See **TestMVCController.java** in the /controller package for an example.



