package com.cardreader.unittests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.cardreader.businesslogic.*;
import com.cardreader.interfaces.IContactInfo;

public class ContactInfoTest {

	private String name = "Mike Smith";
	private String email = "msmith@acme.com";
	private String phoneNumber = "(410)555-1234";

	private IContactInfo contact = new ContactInfo(name, phoneNumber, email);

	@Test
	public void getNameTest() 
	{
		assertEquals(name, contact.getName());
	}

	@Test
	public void getPhoneNumberTest() 
	{
		assertEquals(phoneNumber, contact.getPhoneNumber());
	}

	@Test
	public void getEmailTest()
	{
		assertEquals(email, contact.getEmail());
	}

}
