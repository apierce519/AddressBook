/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Oct 10, 2021
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.AddressBook;

/**
 * @author Andrew Pierce - ajpierce1
 */
public class AddressBookHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AddressBook");

	/**
	 * 
	 */
	public AddressBookHelper() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public List<AddressBook> getAddressBooks() {
		EntityManager em = emfactory.createEntityManager();
		return em.createQuery("SELECT ab FROM AddressBooks ab").getResultList();

	}

	public void insertNewAddressBook(AddressBook ab) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ab);
		em.getTransaction().commit();
		em.close();

	}

	public void deleteAddressBook(AddressBook instanceToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		TypedQuery<AddressBook> typedQuery = em.createQuery("SELECT ab FROM AddressBooks WHERE ab.id = :selectedId",
				AddressBook.class);
		typedQuery.setParameter("selectedId", instanceToDelete.getId());

		typedQuery.setMaxResults(1);

		em.remove(typedQuery.getSingleResult());

		em.getTransaction().commit();

		em.close();

	}

	public AddressBook searchForAddressBookById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		AddressBook result = em.find(AddressBook.class, tempId);
		em.close();
		return result;
	}

	public void updateAddressBook(AddressBook instanceToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(instanceToEdit);
		em.getTransaction().commit();
		em.close();
	}
}
