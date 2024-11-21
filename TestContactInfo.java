package testing;
import contactmanagement.ContactInfo;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contactmanagement.ContactInfo;
import contactmanagement.Contacts;

class TestContactInfo {
Contacts c=new Contacts("Tom", "Cruise", "9810724653");

ContactInfo contact=new ContactInfo();
Boolean x=contact.addContact(c);
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		c.firstName = "Tom";
		c.lastName = "Cruise";
		c.phone = "9810724653";
	}

	@AfterEach
	void tearDown()  {
	}
	@Test
	void testValidContacts() {
		Contacts c=new Contacts("Tom", "Cruise", "9810724653");

		assertTrue(contact.addContact(c));
		
	}
	
	@Test
	void testPhoneNoType() {
		
		c.phone="328jk11111";
		try {
			assertFalse(contact.addContact(c));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testValidPhoneNo() {
		//10 digits
		c.phone="917243627";
		assertFalse(contact.addContact(c));		
	}
	
	
	@Test
	void testfirstNameNull() {
		//String
	c.firstName=null;
	assertFalse(contact.addContact(c));
	
	}
	@Test
	void testlastNameNull() {
		//String
		
		c.lastName=null;
		assertFalse(contact.addContact(c));
		
	}

	
	@Test
	void testContactNotPresent() {
		//delete
		c.phone="9437584522";
		assertFalse(contact.deleteContact(c));
	}
	void testContactPresent() {
		//delete
		Contacts c=new Contacts("Tom", "Cruise", "9810724653");

		//c.phone="9810724653";
		assertTrue(contact.deleteContact(c));
	}
	@Test
	void testViewContact() {
		//view
		Contacts c=new Contacts("Sam", "Smith", "9810724652");

		//c.phone="9810724653";
		contact.addContact(c);
		assertTrue(contact.viewContact(c));

		}
	@Test
	void testNoContactToView() {
		//view
		c.phone="9437584522";
assertFalse(contact.viewContact(c));	

	}
	
	@Test
	void testUnableToUpdate() {
		//update
		
		c.phone="18923745024";
		assertFalse(contact.updateContact(c,"Jane","Depp"));	
	}
	@Test
	void testableToUpdate() {
		//update
	//c.phone="9810724653";
	Contacts c=new Contacts("Jane", "Depp", "9081176354");
	contact.addContact(c);
	assertTrue(contact.updateContact(c,"John","Depp"));	}

}
