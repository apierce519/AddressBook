package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "addressBooks")

/**
 * @author Andrew Pierce - ajpierce1 CIS175 - Fall 2021 Oct 7, 2021
 */
public class AddressBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String owner;
	private int contactCount;
	private LocalDate creationDate;
	private List<ContactEntry> contactList;

	/**
	 * 
	 */
	public AddressBook() {
		// TODO Auto-generated constructor stub
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
	public List<ContactEntry> getContactList() {
		return contactList;
	}

	/**
	 * @param contactList the contactList to set
	 */
	public void setContactList(List<ContactEntry> contactList) {
		this.contactList = contactList;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
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
	public void setContactCount(int contactCount) {
		this.contactCount = contactCount;
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

	@Override
	public String toString() {
		return "AddressBook [id=" + id + ", owner=" + owner + ", contactCount=" + contactCount + ", creationDate="
				+ creationDate + ", contactList=" + contactList + "]";
	}

}