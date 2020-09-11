# Healthcare Application

Healthcare application
- API version: 1.0.0-SNAPSHOT

Application created for a small healthcare company that needs an application to solve common problems.

### Links
- [Healthcare Application Confluence](https://mentormate.atlassian.net/wiki/spaces/~570638838/pages/2021490741/Healthcare+Application)
- [Jira Ticket MD02-1255](https://mentormate.atlassian.net/browse/MD02-1255)


## Requirements

Building the API requires:
1. Java 11+
2. Maven
3. MySQL Server
4. Windows/Linux OS

## Installation
**MySQL Setup**
1. Run the MySQL server on port 3306
2. Set the account properties **username** and **password** for the MySQL Server in the **application.properties**
3. Run the API to generate the database

*Default credentials by the application*:
```
username=root  
password=password
```
*application.properties file path:*

```
./Healthcare-Application/src/main/resources/application.properties
```

**Maven**
To install the API to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```
## Others
**API Server Port**
To change the server port simply navigate to the path below and change the **server.port**
```
./Healthcare-Application/src/main/resources/application.properties
```
## Author
Borislav Arangelov
