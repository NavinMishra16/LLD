# Low Level Design of PVP Battle in Arena

## Project Overview
This project demonstrates a low-level design (LLD) of a Player vs Player (PVP) battle system between two players in Java. It includes classes for players, battles, and an arena to manage battles between players.

## Setup

### Prerequisites
- Java 21 or higher installed
- Maven installed

### Installation
1. Clone the repository:
  
   git clone <repository_url](https://github.com/NavinMishra16/LLD>
   cd <project_directory>
  
2.Build the project using Maven in bash:
    ````mvn clean install ````
 
### Running Main Class
To execute the main functionality of the project:

Navigate to the main Java source directory:
````javac org/example/Main.java````

### Run the compiled Main class:
````java org.example.Main````

### Running Tests
To run unit tests:
Navigate to the test Java source directory:

````cd src/test/java````
Run all unit tests using Maven:
Bash ````mvn test````

### UML Diagrams

UML diagrams depicting the class relationships and structure can be found in the /UMLDiagram directory.

### Project Structure

The project follows the following structure:
1.    /src/main/java/org/example : Main Class
2.    /src/main/java/org/example/domain :   (Player Interface, Abstract Player Class, Warrior Player Class).
3.   /src/main/java/org/example/services:   (Arena Class, Battle Class)
4.   /src/test/java: Contains unit tests for the project
5.  /UMLDiagram: Directory containing UML diagrams
 
