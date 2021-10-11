/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Oct 10, 2021
 */
package tests;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import controller.AddressBookHelper;
import model.AddressBook;
import model.Contact;

/**
 * @author Andrew Pierce - ajpierce1
 */
public class AddressBookTester {

	/**
	 * 
	 */
	public AddressBookTester() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddressBookHelper abh = new AddressBookHelper();

		Contact testContactOne = new Contact("Todd", LocalDate.of(2000, 12, 12), "123 East Road Street", "515-867-5309",
				LocalDateTime.now());

		Contact testContactTwo = new Contact("Randy", LocalDate.of(2001, 01, 01), "456 West Street Road",
				"515-903-5768", LocalDateTime.now());

		List<Contact> contactList = new ArrayList<Contact>();

		AddressBook coworkerList = new AddressBook("Work List");

		contactList.add(testContactOne);
		contactList.add(testContactTwo);

		coworkerList.setContactList(contactList);

		abh.insertNewAddressBook(coworkerList);
		for (int i = 0; i < contactList.size(); i++) {
			System.out.println((contactList.get(i)).toString());
		}

		System.out.println(coworkerList.toString());

	}

}
