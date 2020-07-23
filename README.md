# pokemon-shakespeare-description

This API help to get Shakespearean description of pokemon. We need to pass pokemon name to the end-point, and it will give you Shakespearean description of that pokemon.
It has a GET end-point, It looks like below.
```URL 
/pokemon/<pokemon name>
``` 
For more details refer API docs details.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.truelayer.pokemon.PokemonShakespeareDescriptionApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```mvn
mvn spring-boot:run
```

## Test Case Introduction
Integration test has created for the API and scope is not enough for unit testing, so we didn't create unit test case.
Generally if any method of unit of code has some manipulation or calculation logic then we need to create unit test cases.
You can run below maven command to execute integration test.
 
```mvn
mvn test
```

## API documentation details

Documentation done using swagger, after running the application you will find the documentation of endpoint at below mentioned URL

Swagger UI URL
```url
http://localhost:8191/api-docs-ui
```
Json API docs URL
```url
http://localhost:8191/v3/api-docs
```
## Actuator end point details
Actuator endpoints let you monitor and interact with your application. Spring Boot includes a number of built-in endpoints and lets you add your own. For example, the health endpoint provides basic application health information.
Actuator endpoint URL:

```url
http://localhost:8191/actuator
```


## REST API use internally for pokemon details and shakespeare translation

Public url end point used to [Get Pokemon details](https://courses.cs.washington.edu/courses/cse154/webservices/pokedex/pokedex.php?pokemon={pokemonname})

Public url end point used to [Get Shakespeare translation](https://api.funtranslations.com/translate/shakespeare.json?text={text})

Above end point configured into [yaml configuration](https://github.com/viveklad1/pokemon-shakespeare-description/blob/develop/src/main/resources/application.yml) file, so we can update it without code changes.

## DockerFile 

[DockerFile url](https://github.com/viveklad1/pokemon-shakespeare-description/blob/develop/Dockerfile) for reference 

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.