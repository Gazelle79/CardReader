package com.cardreader.businesslogic;

import java.io.*;

import com.cardreader.interfaces.IContactInfo;


public class BusinessCardMain 
{
	public static void main(String[] args)
	{
		String businessContactInfo = "";
		String currentPath = new File("").getAbsolutePath();		
		
		String inputFileNameAndPath =  currentPath + "/InputFiles/BusinessCardInput.txt";
		String outputFileNameAndPath = currentPath + "/OutputFiles/BusinessCardOutput.txt";
		
		if(args.length > 1)
		{
			inputFileNameAndPath =  args[0];
			outputFileNameAndPath = args[1];
		}
		
		//Get *all* business card information.
		BusinessCardParser cardParser = new BusinessCardParser();
		try
		{
			businessContactInfo = cardParser.readCardInfo(inputFileNameAndPath);
			System.out.println("Reading from file: \n" + inputFileNameAndPath
					+ "\n\nCard information: \n\n" + businessContactInfo + "\n");
		}
		catch(Exception e)
		{ 
			System.out.println("Something went wrong: " + e.getMessage()); 
		}
		
		//Parse all that business card info for specific contact information.
		IContactInfo contact = cardParser.getContactInfo(businessContactInfo);
		cardParser.writeCardInfo(contact, outputFileNameAndPath);
		
		//Write contact information to a file.
		String contactOutput = "Formatted card information: \n\n" 
				+ "Name: " + contact.getName() + "\n"
				+ "Phone: " + contact.getPhoneNumber() + "\n"
				+ "Email: " + contact.getEmailAddress() + "\n";

		
		/*
		if(contact.getFaxNumber() != null)
		{ 
			contactOutput += "Fax: " + contact.getFaxNumber() + "\n\n";
		}
		else { contactOutput += "\n\n"; }
		*/

		System.out.println( contactOutput
				+ "\n Formatted contact information written to file: \n"
				+ outputFileNameAndPath);
	}

}
