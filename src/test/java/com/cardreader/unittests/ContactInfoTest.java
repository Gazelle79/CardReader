package com.cardreader.unittests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.cardreader.businesslogic.*;
import com.cardreader.interfaces.IContactInfo;

public class ContactInfoTest {

	private String name = "Mike Smith";
	private String phoneNumber = "(410)555-1234";
	private String email = "msmith@asymmetrik.com";

	private IContactInfo contact = new ContactInfo(name, email, phoneNumber);

	@Test
	public void setNameTest() 
	{
		assertEquals("Mike Smith", contact.getName());
	}

	@Test
	public void getNameTest() 
	{
		assertEquals(name, contact.getName());
	}

	@Test
	public void setPhoneNumberTest() 
	{
		assertEquals("(410)555-1234", contact.getPhoneNumber());
	}

	@Test
	public void getPhoneNumberTest() 
	{
		assertEquals(phoneNumber, contact.getPhoneNumber());
	}

	@Test
	public void setEmailAddressTest() 
	{
		assertEquals("msmith@asymmetrik.com", contact.getEmail());
	}

	@Test
	public void getEmailAddressTest() 
	{
		assertEquals(email, contact.getEmail());
	}

}
