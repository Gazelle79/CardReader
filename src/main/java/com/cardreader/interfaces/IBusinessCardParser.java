package com.cardreader.interfaces;

public interface IBusinessCardParser 
{
	/**
	Reads the contents of an OCR input file as a string. Returns a single, populated ContactInfo object.
	*/
    IContactInfo getContactInfo(String document);  
}
