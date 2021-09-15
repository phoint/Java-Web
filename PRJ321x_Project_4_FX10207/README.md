# PRJ321x_Project_4_FX10207
 Dynamic Web App at FUNiX PRJ321x Course
 This project run on Tomcat8.5.69 with JDK 11 and all needed jar file in library, using mssql JDBC 9.2 to interact with SQL Server and apply Springframework MVC. The sql file is attached in zip file. 
 Just few functions were completed, another are still developing:
 1. homepage
 2. login
 3. Searching product
 
 ## Note:
- ViewResolver: using Apache Tile configure (web.xml) displaying master layout for web page (look for mapping in Tiles.xml)
- Admin account: login checking with user in ShoppingDB, please run ShoppingDB.sql in SQL Server, setting accessible (user: sa, password: sa) before checking login function. You may find information for JDBC connection in Beans.xml (in src/main/java).
- Login webpage with username: duongdt@fpt.com.vn / password: 123

## Error:
- Could not get resources (style.css)