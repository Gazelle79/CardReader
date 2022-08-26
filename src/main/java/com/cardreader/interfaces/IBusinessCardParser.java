package com.cardreader.interfaces;

public interface IBusinessCardParser 
{
	/**
	 Returns a fully-populated IContactInfo object by reading in all business card data as a String.

	 @param document The entire contents of a business card file as a string.
	 @return ContactInfo object, containing all information about a contact.
	 @see IContactInfo
	 */
    IContactInfo getContactInfo(String document);  
}
