package com.cardreader.businesslogic;

import com.cardreader.interfaces.IContactInfo;

public class ContactInfo implements IContactInfo 
{
	private String name = null;
	private String phoneNumber = null;
	private String email = null;

	/** returns the full name of the individual (eg. John Smith, Susan Malick) */
	public String getName()
	{
		return name;
	}

	/** returns the phone number formatted as XXX-XXX-XXXX */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	/** returns the email address of the individual */
	public String getEmail()
	{
		return email;
	}

	public ContactInfo(String name, String phoneNumber, String email)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

}
