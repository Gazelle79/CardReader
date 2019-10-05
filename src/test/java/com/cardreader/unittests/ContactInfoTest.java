package com.cardreader.unittests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.cardreader.businesslogic.*;
import com.cardreader.interfaces.IContactInfo;

public class ContactInfoTest {
	
	private IContactInfo contact = new ContactInfo();

	String name = "Mike Smith";
	String phoneNumber = "(410)555-1234";
	String email = "msmith@asymmetrik.com";
	
	@Test
	public void setNameTest() 
	{
		contact.setName(name);
		assertEquals("Mike Smith", contact.getName());
	}

	@Test
	public void getNameTest() 
	{
		contact.setName(name);
		assertEquals("Mike Smith", contact.getName());
	}

	@Test
	public void setPhoneNumberTest() 
	{
		contact.setPhoneNumber(phoneNumber);
		assertEquals("(410)555-1234", contact.getPhoneNumber());
	}

	@Test
	public void getPhoneNumberTest() 
	{
		contact.setPhoneNumber(phoneNumber);
		assertEquals("(410)555-1234", contact.getPhoneNumber());
	}

	@Test
	public void setEmailAddressTest() 
	{
		contact.setEmailAddress(email);
		assertEquals("msmith@asymmetrik.com", contact.getEmailAddress());
	}

	@Test
	public void getEmailAddressTest() 
	{
		contact.setEmailAddress(email);
		assertEquals("msmith@asymmetrik.com", contact.getEmailAddress());
	}

}
