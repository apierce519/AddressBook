package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AddressBooks")

/**
 * @author Andrew Pierce - ajpierce1 CIS175 - Fall 2021 Oct 7, 2021
 */
public class AddressBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String listName;
	private int contactCount;
	private LocalDate creationDate;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<Contact> contactList;

	/**
	 * 
	 */
	public AddressBook() {
		// TODO Auto-generated constructor stub
		setCreationDate();

	}

	/**
	 * @param listName
	 */
	public AddressBook(String listName) {
		super();
		this.listName = listName;
		setCreationDate();
	}

	/**
	 * @param listName
	 * @param contactList
	 */
	public AddressBook(String listName, List<Contact> contactList) {
		super();
		this.listName = listName;
		this.contactList = contactList;
		setContactCount();
		setCreationDate();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the contactList
	 */
	public List<Contact> getContactList() {
		return contactList;
	}

	/**
	 * @param contactList the contactList to set
	 */
	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
		setContactCount();
	}

	/**
	 * @return the owner
	 */
	public String getListName() {
		return listName;
	}

	/**
	 * @param listName the owner to set
	 */
	public void setListName(String listName) {
		this.listName = listName;
	}

	/**
	 * @return the contactCount
	 */
	public int getContactCount() {
		return contactCount;
	}

	/**
	 * @param contactCount the contactCount to set
	 */
	private void setContactCount() {
		this.contactCount = this.contactList.size();
	}

	/**
	 * @return the creationDate
	 */
	public LocalDate getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	private void setCreationDate() {
		this.creationDate = LocalDate.now();
	}
	
	public void updateContactCountAndCreationDate() {
		setCreationDate();
		setContactCount();
	}

	@Override
	public String toString() {
		return "AddressBook [id=" + id + ", listName=" + listName + ", contactCount=" + contactCount + ", creationDate="
				+ creationDate + ", contactList=" + contactList + "]";
	}

}