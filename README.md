# Automovil-Concesionaria

# Concesionaria Project development Java with Spring Boot

[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)
[![Coverage Status](https://coveralls.io/repos/github/codecentric/springboot-sample-app/badge.svg?branch=master)](https://coveralls.io/github/codecentric/springboot-sample-app?branch=master)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `de.codecentric.springbootsample.Application` class from your IDE.


```shell
mvn spring-boot:run
```

## Accces console H2

If you want to access visit the page and view of the data base, acces in  :

```
https://localhost:port/h2-console
```

```shell
oc new-app codecentric/springboot-maven3-centos~https://github.com/codecentric/springboot-sample-app
```

This will create:

* A Web Application called "AutomovilController"
* Service called "AutomovilService"

If you want to access the code, you have  springboot service:

```shell
git clone https://github.com/facundocardenas11/Automovil-Concesionaria.git
```

```shell
cd Automovil-Concesionaria
```

```shell
git pull
```

## Copyright

Spring Boot spring.io

