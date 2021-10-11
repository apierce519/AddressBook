package tests;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import controller.ContactHelper;
import model.Contact;


/**
 * @author Christian O'Brien - cpobrien3
 * CIS175 - Fall 2021
 * Oct 10, 2021
 */
public class ContactTester {
	public static void main(String[] args) {
		
		Contact contact1 = new Contact("Bill", LocalDate.of(2002, 10, 25), "555 North Ave.", "641-123-4567", LocalDateTime.now());
		Contact contact2 = new Contact("Alex", LocalDate.of(1999, 12, 05), "678 South Road", "641-008-9999", LocalDateTime.now());
		ContactHelper ch = new ContactHelper();
		
		ch.insertEnrty(contact1);
		ch.insertEnrty(contact2);
		
		List<Contact> allContacts = ch.showAllEntries();
		
		for(Contact c: allContacts) {
			System.out.println(c.toString());
		}
	}
}
