package contactmanagementinterface;

import contactmanagement.Contacts;


public interface ContactInfoInterface {
	Boolean addContact(Contacts c) ;
	Boolean deleteContact(Contacts c);
	Boolean updateContact(Contacts c,String firstName,String lastName);
	Boolean viewContact(Contacts c);
}
