
# Marketplaces Sample App

A sample app to demo a simple online marketplace.
It is developed as a fully reactive application using principles of Java Reactive programming.


## Tech Stack
```text
Java -> Reactive Java
PostgreSQL (v15)
Spring Boot
Spring WebFlux
R2DBC
Flyway (for DB setup & migration)
OpenAPI for documenting and generating APIs and models
```

## Setup
```text
Download and install postgres.app (v15) - default port is 5432
Create a db - 'marketplace-db'
Create schema - 'mktplace-schema'
Clone the repo and run as a spring boot application
```

## Swagger URL
```text
Open 'http://localhost:8080/swagger-ui.html'
Insert '/v3/api-docs' in Explore section
```
![swagger-apis.png](assets%2Fswagger-apis.png)
![swagger-models.png](assets%2Fswagger-models.png)