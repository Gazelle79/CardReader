package com.cardreader.interfaces;

public interface IContactInfo 
{
    String getName(); //returns the full name of the individual (eg. John Smith, Susan Malick)
    String getPhoneNumber(); //returns the phone number formatted as XXX-XXX-XXXX
    String getFaxNumber(); //returns the fax number formatted as XXX-XXX-XXXX
    String getEmailAddress(); //returns the email address of the individual */
	
    void setName(String name); //sets the full name of the individual
    void setPhoneNumber(String phoneNumber); //sets the phone number of the individual
    void setFaxNumber(String faxNumber); //sets the phone number of the individual
    void setEmailAddress(String emailAddress); //sets the email address of the individual
}
