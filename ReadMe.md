
# CARD READER :arrows_clockwise:

SUMMARY
-------
**A small java application that reads contact information from a text file.** It extracts a name, phone number & e-mail address from business card data, and writes it to a file.

**This application doesn't have a GUI. You run it from a command prompt.**


### Input:
Data is read in from:

 - ``BusinessCardInput.txt``
Location: ``../CardReader/InputFiles/BusinessCardInput.txt``


### Output:
Data is written to: 

 - ``BusinessCardOutput.txt``
Location: ``../CardReader/OutputFiles/BusinessCardOutput.txt``

The user can specify their own input and output file paths - as long as data is written to & read from the the right files.


REQUIREMENTS
------------
 - [x] Java 1.8.0_181 or higher 
(https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

 - [x] Apache Maven 3.6.2
(https://maven.apache.org/download.cgi)

 - [x] Stanford Core NLP Libraries, version 3.9.2 - English
(Automatically downloaded by project)



TO START
--------
 - Open a command prompt in Linux or Windows
 - Change directories to the location of CardReader
 - Compile the application
 - Execute the application

### COMPILE:
``mvn compile``


### EXECUTE:

#### WITHOUT any arguments:

EXAMPLE: ``mvn exec:java -Dexec.mainClass="com.cardreader.businesslogic.BusinessCardMain"``

Default values are automatically used to read and write data. They are:

**input file path:** ``.../CardReader/InputFiles/``
**output file path:** ``.../CardReader/OutputFiles/``


#### WITH input / output paths as arguments:

*EXAMPLE:* `` mvn exec:java -Dexec.mainClass="com.cardreader.businesslogic.BusinessCardMain"  -Dexec.args=" /[*Path to CardReader*]/CardReader/Inputfiles/BusinessCardInput  /[*Path to CardReader*]/CardReader/Outputfiles/BusinessCardOutput" ``

