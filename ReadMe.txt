CardReader
----------

SUMMARY
-------
This is a small java application that reads contact information from a text file. It extracts a name, phone number & e-mail address.

It reads several lines of text from "BusinessCardInput.txt". Data is written to "BusinessCardOutput.txt".

This application doesn't have a GUI. You run it from a command prompt.


REQUIREMENTS
------------
Java 1.8.0_181 or higher
Stanford Core NLP Libraries, version 3.9.2 - English



GETTING STARTED
---------------
 - Open a command prompt in Linux or Windows.
 - Change directories to the location of CardReader.
 - Type the following command:

java CardReader [path to input file] [path to output file]

If the input and output file paths are omitted, defaults will automatically be used. Here are two examples:

SYNTAX:
java CardReader [path to input file] [path to output file]

CONCRETE EXAMPLE:
java CardReader /[*Path to CardReader directory*]/Inputfiles/BusinessCardInput  /[*Path to CardReader directory*]/Outputfiles/BusinessCardOutput
