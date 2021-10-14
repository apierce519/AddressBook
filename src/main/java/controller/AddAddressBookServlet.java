package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddressBook;
import model.Contact;

/**
 * Servlet implementation class AddAddressBookServlet
 */
@WebServlet("/addAddressBookServlet")
public class AddAddressBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAddressBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		retrieveAndSetNewValues(request);
		sendToNextPage(request, response);
	}
	
	public void retrieveAndSetNewValues(HttpServletRequest request) {
		AddressBookHelper dao = new AddressBookHelper();
		AddressBook ab = new AddressBook();
				
		ab.setListName(request.getParameter("abName"));
		
		try {
		ab.setContactList(addContactsToAddressbook(request));
		}catch(NullPointerException e) {
			List<Contact> emptyList = new ArrayList<Contact>();
			ab.setContactList(emptyList);
		}
		
		ab.updateContactCountAndCreationDate();
		dao.insertNewAddressBook(ab);
		
		System.out.println("Task Successfully Succeeded.");
		System.out.println(ab.toString());
				
	}
	
	private List<Contact> addContactsToAddressbook(HttpServletRequest request) {
		ContactHelper contactDao = new ContactHelper();
		String[] selectedContacts = request.getParameterValues("contactsToAdd"); 
		List<Contact> contactsToAdd = new ArrayList<Contact>();
		
		for(int i = 0; i < selectedContacts.length; i++) {
			System.out.println(selectedContacts[i]);
			Contact c = contactDao.searchForEntryById(Integer.parseInt(selectedContacts[i]));
			contactsToAdd.add(c);
		}
		
		return contactsToAdd;
	}

	private void sendToNextPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			getServletContext().getRequestDispatcher("/viewAllAddressBooksServlet").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
