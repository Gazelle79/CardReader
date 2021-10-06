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
		
		if(args.length > 1)
		{
			inputFileNameAndPath =  args[0];
		}
		
		//Get *all* business card information.
		BusinessCardParser cardParser = new BusinessCardParser();
		try
		{
			businessContactInfo = cardParser.readCardInfo(inputFileNameAndPath);
			System.out.println("Reading from: \n" + inputFileNameAndPath
					+ "\n\nData: \n\n" + businessContactInfo + "\n");
		}
		catch(Exception e)
		{ 
			System.out.println("Something went wrong: " + e.getMessage()); 
		}
		
		//Parse all that business card info for specific contact information.
		IContactInfo contact = cardParser.getContactInfo(businessContactInfo);

		//Write contact information to a file.
		String contactOutput = "Formatted data: \n\n"
				+ "Name: " + contact.getName() + "\n"
				+ "Phone: " + contact.getPhoneNumber() + "\n"
				+ "Email: " + contact.getEmail() + "\n";

		System.out.println( contactOutput);
	}

}
