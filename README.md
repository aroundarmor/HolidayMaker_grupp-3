# HolidayMaker_grupp-3
FullStack Application hotel management system. Newton project.


## Table of contents
* [General info](#general-info)
* [Screenshots](#screenshots)
* [Technologies](#technologies)
* [Setup](#setup)
* [Features](#features)


## Screenshots
![Example screenshot](https://github.com/musicollins/HolidayMaker_grupp-3/issues/38#issue-707644003)

## Technologies

Following technologies are being used in this project or contribute to some extent in project. The documentations are given below :
* HTML        - [Documentation](https://devdocs.io/html/) 
* CSS         - [Documentation](https://developer.mozilla.org/en-US/docs/Web/CSS)
* Java        - [Documentation](https://docs.oracle.com/en/java/)
* JavaScript  - [Documentation](https://developer.mozilla.org/en-US/docs/Web/JavaScript)
* JQuery      - [Documentation](https://api.jquery.com/)
* Mysql       - [Documentation](https://dev.mysql.com/doc/)
* SpringBoot  - [Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)

## Setup

#### 1. Clone repository
```
$ git clone https://github.com/musicollins/HolidayMaker_grupp-3.git
```
#### 2. Database information
```
$ cd HolidayMaker_grupp-3/holidaymaker/src/main/resources
```

Open `application.properties` with any text editor and edit the following:
```
spring.datasource.username= < DATABASE USER     >
spring.datasource.password= < DATABASE PASSWORD >
```

#### 4. Execute
```
Nagivate back to mvnw path. ( HolidayMaker_grupp-3/holidaymaker )
$ cd ../../../

Make executable
$ chmod +x ./mvnw

Execute
$ ./mvnw spring-boot:run
```

Open your browser and type http://localhost:8091

## Features
List of features ready and TODOs for future development
*  Booking feature
*  Change booking feature
*  Search filtration feature
*  Delete booking feature
