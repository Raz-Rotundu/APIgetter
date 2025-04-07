# API get request program
A simple program that sends a GET request to https://jsonplaceholder.typicode.com/users, parses the resulting JSON into User objects, stores them in list, then prints them out.

## Dependencies
**Java**: JRE 16+ and/or JDK 16+ if developing
<p>**Maven**: Maven 3.6+</p>

## Installation
In the project Directory, run the following command
```Mvn clean package``
In /target, there should now be 2 files: 
<ul>
	<li>APIgetter.jar</li>
	<li>APIgetter-jar-with-dependencies.jar</li>
</ul>
Run the following command: ```java -jar APIgetter-jar-with-dependencies.jar`` to execute the program
## Features
Sends a GET request to https://jsonplaceholder.typicode.com/users, parses the resulting JSON into User objects, stores them in list, then prints them out, as well as reply headers.

## Usage
Call APIgetter at the command line to print a list of dummy user objects from https://jsonplaceholder.typicode.com/users
```java -jar APIgetter-jar-with-dependencies.jar``