# Description
The goal of the program is to explore the given table for treasure. The values in the table are clues with values between 11 and 55 (the ten’s digit represents the row and the unit’s digit represents the column). Starting with the given clue, search through the table until the treasure is found (or not found). The treasure is a cell whose value is the same as its coordinates.

The project features two different approaches to solve the same task.
The object-oriented way uses domain model, small classes fulfilling SRP and some patterns (Repository, Value Object).
The functional way uses pure functions with the functions as first-class citizens, recursion, native data structures and Groovy functional language support.

The project is based on the [Micronaut](https://micronaut.io) framework for handling the REST requests and bean management (dependency injection).
# Pre-requirements
* Java 8+

# Usage
The below command will run Micronaut server on port 8080:
```
./gradlew run
```
Once started, the below commands (or web browser) can be used to invoke the REST service:
```
#treasure found
curl --request GET http://localhost:8080?clue=11

#treasure not found
curl --request GET http://localhost:8080?clue=41

#invalid clue value
curl --request GET http://localhost:8080?clue=WRONG
```