package com.cardreader.unittests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.*;

import com.cardreader.businesslogic.*;
import com.cardreader.interfaces.IContactInfo;
import org.junit.jupiter.api.function.Executable;


public class BusinessCardParserTest
{
	private String filePathWithoutFile = "";  //a directory path with no filename attached
	private String fileNameWithoutPath = "";  //a file with no directory path attached

	private String inputFileNameAndPath =  ""; //read in data for a contact card
	private String outputFileNameAndPath = ""; //path to write data to for a contact card

	private String helper = "";
	private String pathToCardReader = "";

	private BusinessCardParser parser = new BusinessCardParser();

	public BusinessCardParserTest() throws IOException {
		helper = new File(".").getAbsolutePath();
		pathToCardReader = helper.substring(0, helper.indexOf("/CardReader"));

		inputFileNameAndPath =  pathToCardReader + "/CardReader/InputFiles/BusinessCardInput.txt";
		outputFileNameAndPath = pathToCardReader + "/CardReader/OutputFiles/BusinessCardOutput.txt";
		filePathWithoutFile = pathToCardReader + "/CardReader/InputFiles/";
		fileNameWithoutPath = "/BusinessCardInput.txt";
	}

	@Test
	public void readCardInfoTest() throws IOException
	{
		//Write a good test.
		String inputString = parser.readCardInfo(inputFileNameAndPath);
		assertTrue(inputString.length() > 0);
	}
	
	@Test
	public void getContactInfoTest()  throws IOException
	{
		String document = parser.readCardInfo(inputFileNameAndPath);
		IContactInfo person = parser.getContactInfo(document);
		
		assertTrue(document.length() > 0);
		assertTrue(person.getName().length() > 0);
		assertTrue(person.getEmailAddress().length() > 0);
		assertTrue(person.getPhoneNumber().length() > 0);
		
		System.out.println("Name: " + person.getName());
		System.out.println("E-mail: " + person.getEmailAddress());
		System.out.println("Phone: " + person.getPhoneNumber());

	}
	
	@Test
	public void writeCardInfoTest() throws IOException
	{
		String document = parser.readCardInfo(inputFileNameAndPath);
		boolean wasWrittenToFile = false;
		
		//Write to file successfully.
		IContactInfo goodContact = parser.getContactInfo(document);
		wasWrittenToFile = parser.writeCardInfo(goodContact, outputFileNameAndPath);
		assertTrue(wasWrittenToFile);
		
		//Write a bad one to file.
		IContactInfo badContact = null;
		wasWrittenToFile = parser.writeCardInfo(badContact, outputFileNameAndPath);
		assertFalse(wasWrittenToFile);
	}


	//Asserts correctly if an exception is thrown.
	@Test
	public void readFilePathWithoutFileNameTest() throws IOException
	{
		//Write a bad test. Make sure it fails.
		Throwable exception = assertThrows(FileNotFoundException.class, new Executable() {
					public void execute() throws Throwable {
						String inputString = parser.readCardInfo(filePathWithoutFile);
					}
				}
		);
	}
		
	//Asserts correctly if an exception is thrown.
	@Test
	public void readFileNameWithoutFilePathTest() throws IOException
	{
		//Write a bad test. Make sure it fails.
		Throwable exception = assertThrows(FileNotFoundException.class, new Executable() {
					public void execute() throws Throwable {
						String inputString = parser.readCardInfo(fileNameWithoutPath);
					}
				}
		);
	}
		

}
