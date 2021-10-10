package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	private String owner;
	private int contactCount;
	private LocalDate creationDate;
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Contact> contactList;

	/**
	 * 
	 */
	public AddressBook() {
		// TODO Auto-generated constructor stub
		setCreationDate();

	}

	/**
	 * @param owner
	 */
	public AddressBook(String owner) {
		super();
		this.owner = owner;
		setCreationDate();
	}

	/**
	 * @param owner
	 * @param contactList
	 */
	public AddressBook(String owner, List<Contact> contactList) {
		super();
		this.owner = owner;
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

	@Override
	public String toString() {
		return "AddressBook [id=" + id + ", owner=" + owner + ", contactCount=" + contactCount + ", creationDate="
				+ creationDate + ", contactList=" + contactList + "]";
	}

}