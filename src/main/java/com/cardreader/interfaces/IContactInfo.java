package com.cardreader.interfaces;


/**
 * Returns card information that's read from <code>BusinessCardInput.txt</code>.
 */
public interface IContactInfo
{
    /**
     * Returns the first & last name of the business card owner.
     *
     * @return The first & last name of the business card owner. Format: FirstName, LastName
     */
    String getName();

    /**
     * Returns the phone number of the card owner.
     *
     * @return The phone number of the card owner. Format: XXX-XXX-XXXX.
     */
    String getPhoneNumber();

    /**
     * Returns the email address of the card owner.
     *
     * @return The email address of the card owner.
     */
    String getEmail();

}
