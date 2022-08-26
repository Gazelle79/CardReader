package com.cardreader.businesslogic;

import java.io.*;

import com.cardreader.interfaces.IContactInfo;


/**
 * @author  Frederick Boyd Jr.
 */

public class BusinessCardMain
{

	/**
	 * Main point of entry. Parses business card data & displays a name, phone number, & email address
	 * to the user, as plain text.
	 *
	 * @param  args A filepath & filename that point to a file <code>BusinessCardInput.txt</code>.<br>
	 *              If no argument is given, a default value is used.
	 *
	 * @return      None. Output is displayed to the console, as plain text.
	 *
	 */

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
