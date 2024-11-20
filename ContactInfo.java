package contactmanagement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import contactmanagementinterface.ContactInfoInterface;


//public class InvalidPhoneNoException extends Exception{
//	public InvalidPhoneNoException(String message) {
//		//super(message);
//	}
//}

public class ContactInfo implements ContactInfoInterface {
	public static HashMap<String,Contacts> hm =new HashMap<String, Contacts>();
	//Contacts c=new Contacts();
	
	public Boolean addContact(Contacts c) {
		try {
		Long num=Long.parseLong(c.phone);
		
		}catch(NumberFormatException e) {
			System.out.println("Enter only digits");
			return false;
		}
		
		if (c.phone.length()!=10)
			return false;
		if(c.firstName==null)//(c.firstName instanceof String==false)
			return false;
		if(c.lastName==null)//(c.lastName instanceof String==false)
			return false;
		hm.put( c.phone,c);
		
		return true;
		
		
	}
	public Boolean  deleteContact(Contacts c) {
		if (hm.containsKey(c.phone)){
			hm.remove(c.phone);
			return true;
		}
		return false;
	}
	public Boolean viewContact(Contacts c) {
	    if (hm.containsKey(c.phone)) {
	        System.out.println("Details: \n" + hm.get(c.phone));
	        
	        return true;
			
	    } else {
	        System.out.println("No contact found for the phone number: " + c.phone);
	        return false;
	    }
	}

public Boolean updateContact(Contacts c,String firstName,String lastName) {
	if (hm.containsKey(c.phone)){
		Contacts detail=hm.get(c.phone);
		detail.firstName=firstName;//edit fname
		detail.lastName=lastName;//edit lname
		hm.put(c.phone, detail);//save it to hm
		return true;
	}
		return false;
	}
	
}
