package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddressBook;

/**
 * Servlet implementation class ViewAllAddressBooksServlet
 */
@WebServlet("/viewAllAddressBooksServlet")
public class ViewAllAddressBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String path = "/view-all-address-books.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewAllAddressBooksServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<AddressBook> tempList = getAddressBooks();
		validateAddressBooks(request, tempList);
		sendToNextPage(request, response, path);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private HttpServletRequest validateAddressBooks(HttpServletRequest request, List<AddressBook> tempList) {
		if (tempList.isEmpty()) {
			path = "/generateContactListForAddressBookServlet";
			System.out.println("No address books found.");
		} else {
			request.setAttribute("allAddressBooks", tempList);
			System.out.println("Its not empty.");
			System.out.println(tempList.toString());
		}
		return request;

	}

	private void sendToNextPage(HttpServletRequest request, HttpServletResponse response, String path) {
		try {
			getServletContext().getRequestDispatcher(path).forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public List<AddressBook> getAddressBooks() {
		AddressBookHelper abh = new AddressBookHelper();
		List<AddressBook> addressBookList = abh.getAddressBooks();
		return addressBookList;
	}

}
