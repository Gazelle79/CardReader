
# CARD READER :arrows_clockwise:

SUMMARY
-------
**A small java application that reads contact information from a text file.** It extracts a name, phone number & e-mail address from business card data, and writes it to a file.

**This application doesn't have a GUI. You run it from a command prompt.**


### Input:
Data is read in from:

 - ``../CardReader/InputFiles/BusinessCardInput.txt``

As long as data is read in from ``BusinessCardInput.txt``, the user can specify their own path to that file. But the file 
**must** be named ``BusinessCardInput.txt``.


REQUIREMENTS
------------
 - [x] Java 14 or higher  (https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html)

 - [x] Apache Maven 3.6.2 (https://maven.apache.org/download.cgi)

 - [x] Stanford Core NLP Libraries, version 4.4.0 - English
(Automatically downloaded by project)



TO START
--------
 - Open a command prompt in Linux or Windows
 - Change directories to the location of CardReader
 - Compile the application
 - Unit test everything (all unit tests in all classes must pass)
 - Execute the application

### Run all steps in this order:

 ### COMPILE:
``mvn clean compile``

### UNIT TEST:
``mvn clean test``

### EXECUTE:

#### WITHOUT any arguments:

``mvn exec:java``

Default argument, when none are given:

``../CardReader/InputFiles/BusinessCardInput.txt``


#### WITH input path as argument:

``mvn exec:java -Dexec.args=" ../Your/path/to/BusinessCardInput.txt " ``

