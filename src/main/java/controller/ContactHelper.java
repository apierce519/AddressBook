package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Contact;

/**
 * @author Christian O'Brien - cpobrien3
 * CIS175 - Fall 2021
 * Oct 10, 2021
 */
public class ContactHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AddressBook");
	
	public void insertEnrty(Contact c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public List<Contact> showAllEntries(){
		EntityManager em = emfactory.createEntityManager();
		List<Contact> allEntries = em.createQuery("select i from Contact i").getResultList();
		return allEntries;
	}
	
	public void deleteEntry(Contact toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Contact> typedQuery = em.createQuery("select c FROM Contact c where c.id := selectedId ", Contact.class);

		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
 
		Contact result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public Contact searchForEntryById(Contact entryToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Contact found = em.find(Contact.class, entryToEdit);
		em.close();
		return found;
	}
	
	public void editEntry(Contact toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	
}
