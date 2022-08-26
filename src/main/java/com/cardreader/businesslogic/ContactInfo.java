package com.cardreader.businesslogic;

import com.cardreader.interfaces.IContactInfo;

public class ContactInfo implements IContactInfo
{
	private String name = "";
	private String phoneNumber = "";
	private String email = "";

	public String getName()
	{
		return name;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

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
