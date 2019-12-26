# SpringBootMVCTemplate

## Introduction
This is a simple SpringBoot starter template with a H2 volatile database. By default, the data will revert to the original state defined by your data prop in TemplateApplication.java class.

## Example Code
The template contains one end to end transmission of data from the H2 Database to a JSP file called samplePage.jsp. The sample database contains one table with an id and description column. Through a DAO class and ultimately a set of controllers the three rows are transmitted:

'''http://localhost:8080/''' : 
renders samplePage.jsp

'''http://llocalhost:8080/v1/retrieve''':
Example GET RESTful call



