# Thorntail POC

This is a POC to validate how thorntail.io works.

## Database Migration

On this POC you have the alternative of creating the database 
in two ways (you must choose one):

* flyway
* liquibase

Regarding the schema it should match the one declared on the entities.

### Flyway

To create the tables with Flyway is needed to fill the data on
src/main/resources/flyway.conf:

```
flyway.url=jdbc_url
flyway.user=database_user
flyway.password=database_pwd
flyway.schemas=database_schema
```  

Then run: 

```
$ mvn flyway:migrate
```

### Liquibase

To create the tables with Liquibase is needed to fill the data 
on src/main/resources/liquibase.properties:

```
driver: org.postgresql.Driver
url: jdbc_url?currentSchema=schema
username: db_usr
password: db_pwd
```

It's important to explicit the schema on the connection url 
on liquibase

Then run:

```
$ mvn liquibase:update
```

## Application connection:

The application connects through a datasource. It is declared on
src/main/resources/project-defaults.yml:

```
thorntail:
  datasources:
    data-sources:
      appDS:
        driver-name: postgresql
        connection-url: jdbc_url
        user-name: db_usr
        password: db_pwd
```

## Application running

To run the application, on the root of the project run:

```
$ mvn package && java -jar target/poc-thorntail-thorntail.jar
```

Hope you like it!