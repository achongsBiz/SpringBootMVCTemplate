# SpringBootMVCTemplate

## Introduction
This is a simple SpringBoot starter template with a H2 volatile database. By default, the data will revert to the original state defined by your data prop in TemplateApplication.java class.

## Example Code
The template contains one end to end transmission of data from the H2 Database to a JSP file called samplePage.jsp. The sample database contains one table with an id and description column. Three rows have been inserted into this table. 

Through a DAO class and ultimately a set of controllers the rows are transmitted to the user via the following endpoints:

*```http://localhost:8080/``` : renders samplePage.jsp

*```http://llocalhost:8080/v1/retrieve```: example GET RESTful call

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


