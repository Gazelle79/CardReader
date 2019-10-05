package com.cardreader.businesslogic;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.*;
import java.io.*;
import java.util.Map;
import java.util.Properties;
import java.util.List;
import java.util.regex.Pattern;

import com.cardreader.interfaces.*;
import edu.stanford.nlp.util.CoreMap;

public class BusinessCardParser implements IBusinessCardParser
{

	private final Double confidenceThreshold = 0.98;
	private String phoneNumberRegex = "^*\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
	private String phonePrefixRegex = "^(Phone.*)*\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
	private String telPrefixRegex = "^(Tel.*)*\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
	private String faxPrefixRegex = "^(Fax.*)*\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
	private String charactersToKeepRegex = "[^a-zA-Z0-9.@&' ']";

	Pattern phoneNumberPattern = Pattern.compile(phoneNumberRegex);
	Pattern phonePrefixPattern = Pattern.compile(phonePrefixRegex, Pattern.CASE_INSENSITIVE);
	Pattern telPrefixPattern = Pattern.compile(telPrefixRegex, Pattern.CASE_INSENSITIVE);
	Pattern faxPrefixPattern = Pattern.compile(faxPrefixRegex, Pattern.CASE_INSENSITIVE);

	private String givenName = "";
	private String surname = "";
	private String fullName = "";
	private String phoneNumber = "";
	private String email="";

	
	/**
	 Reads all business card input from a text file, specified by fileNameAndPath.
	 @param fileNameAndPath - the name and path of the input file to read from.
	 */
	public String readCardInfo(String fileNameAndPath) throws IOException 
	{
		BufferedReader reader = null;
		String contactInfoText = null;
		StringBuilder contents = new StringBuilder();
				
			/*Not put in try / catch statement so error could be sent back to method caller.*/
			InputStream is = new FileInputStream(fileNameAndPath);
			reader = new BufferedReader(new InputStreamReader(is));
			
			while ((contactInfoText = reader.readLine()) != null) 
			{
				contents.append(contactInfoText + "\n");
			}
			reader.close();
				
		return contents.toString();

	}

	/**
	Reads the contents of an OCR input file as a string. Returns a single, populated ContactInfo object.
	@param document - the entire contents of a business card file as a string.
	*/
	public IContactInfo getContactInfo(String document) 
	{

		ContactInfo newContact = null;

        Properties props = new Properties();
		props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner");
		StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

		String[] contactInfoLines = document.split("\n");

		for (String contactInfoLine : contactInfoLines)
		{
			contactInfoLine = contactInfoLine.replaceAll(charactersToKeepRegex, "");
			Annotation thisContactInfoLine = new Annotation(contactInfoLine);
			pipeline.annotate(thisContactInfoLine);


			// these are all the sentences in this document
			// a CoreMap is essentially a Map that uses class objects as keys and has values with custom types
			List<CoreMap> words = thisContactInfoLine.get(CoreAnnotations.SentencesAnnotation.class);

			for (CoreMap thisWord : words)
			{
				// traversing the words in the current sentence
				// a CoreLabel is a CoreMap with additional token-specific methods
				for (CoreLabel token : thisWord.get(CoreAnnotations.TokensAnnotation.class))
				{
					//Text of the token
					String wordText = token.get(CoreAnnotations.TextAnnotation.class);
					//Named Entity Relationship (NER) label of the token
					String namedEntity = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);

					//Get a map of this word. Structure: Map<key, value>
					Map wordMap = token.get(CoreAnnotations.NamedEntityTagProbsAnnotation.class);
					//Get the value of this Maps' key-value pair. Get a confidence value by casting it into a double.
					// 0.98 == "I'm 98% sure this named entity is a Person, Email, etc."
					Object confidenceObject = wordMap.get(namedEntity);
					Double confidence = 0.0;
					if(confidenceObject != null)
					{
						confidence = Double.parseDouble(wordMap.get(namedEntity).toString());
					}

					switch(namedEntity)
					{
						case "PERSON":
						{
							if(fullName.isEmpty())
							{
								if(givenName.isEmpty() && confidence >= confidenceThreshold)
								{
									givenName = wordText;
								}
								else if (surname.isEmpty() && confidence >= confidenceThreshold)
								{
									surname = wordText;
								}
							}
							else
							{	/*This person already has a first & last name. Do nothing*/	}
							break;
						}

						case "EMAIL":
						{
							email += wordText;
							break;
						}

						case "NUMBER":
						{
							if( (phoneNumberPattern.matcher(wordText).matches() ||
								telPrefixPattern.matcher(wordText).matches() ||
								phonePrefixPattern.matcher(wordText).matches())
								&& phoneNumber.isEmpty())
							{
								phoneNumber = wordText;
							}
							break;
						}

						default:
						{
							break;
						}
					}

				}
			}

		}

		if (!document.isEmpty()) 
		{
			newContact = new ContactInfo();
			fullName = givenName + " " + surname;
			newContact.setName(fullName);
			newContact.setEmailAddress(email);
			newContact.setPhoneNumber(phoneNumber);
		}
		//return a null contact if the contact "document" was empty.
		
		return newContact;
	}


	/** 
	 Writes contact information to an output file for a single contact. If an output
	 file already exists, it's deleted, so a new file can be made.
	 @param contact - the contact to be written to a file.
	 @param fileNameAndPath - the name & path of the file to write the data to.
	*/
	public boolean writeCardInfo(IContactInfo contact, String fileNameAndPath) 
	{
		boolean wasWrittenToFile = false;

		if(contact != null)
		{
			try 
			{
				File businessCardFile = new File(fileNameAndPath);
				
				if(businessCardFile.exists())
				{
					businessCardFile.delete();
				}
				
				FileWriter writer = new FileWriter(businessCardFile);
				String contactInfo = "Name: " + contact.getName() + "\n"
						+ "Phone: " + contact.getPhoneNumber() + "\n"
						+ "E-mail: " + contact.getEmailAddress() + "\n";
				
				/*
				if(contact.getFaxNumber() != null)
				{ contactInfo += "Fax number: " + contact.getFaxNumber() + "\n"; }
				 */
				writer.write(contactInfo);
				writer.close();
				wasWrittenToFile = true;
								
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		
		return wasWrittenToFile;
	}
	


}
