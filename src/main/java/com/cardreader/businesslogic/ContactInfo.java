package com.cardreader.businesslogic;

import com.cardreader.interfaces.IContactInfo;

public class ContactInfo implements IContactInfo 
{
	private String name = null;
	private String phoneNumber = null;
	private String faxNumber = null;
	private String emailAddress = null;

	/** sets the full name of the individual */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/** returns the full name of the individual (eg. John Smith, Susan Malick) */
	public String getName() 
	{
		return name;
	}

	/** sets the phone number of the individual */
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	/** returns the phone number formatted as XXX-XXX-XXXX */
	public String getPhoneNumber() 
	{
		return phoneNumber;
	}

	/** sets the fax number of the individual */
	public void setFaxNumber(String faxNumber)
	{
		this.faxNumber = faxNumber;
	}
	
	/** returns the fax number formatted as XXX-XXX-XXXX */
	public String getFaxNumber() 
	{
		return faxNumber;
	}
	
	/** sets the email address of the individual */
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}
	
	/** returns the email address of the individual */
	public String getEmailAddress() 
	{
		return emailAddress;
	}

}
