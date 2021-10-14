package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contact;

/**
 * Servlet implementation class ContactNavigationServlet
 */
@WebServlet("/contactNavigationServlet")
public class ContactNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContactNavigationServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ContactHelper ch = new ContactHelper();
		String act = request.getParameter("doThisToContact");

		String path = "/viewAllContactsServlet";
		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Contact contactToDelete = ch.searchForEntryById(tempId);
				try {
					ch.deleteEntry(contactToDelete);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("This contact is tied to an Address Book and cannot be deleted.");
					getServletContext().getRequestDispatcher(path).forward(request, response);
				}
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a contact");
			}

		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Contact contactToEdit = ch.searchForEntryById(tempId);
				request.setAttribute("contactToEdit", contactToEdit);
				path = "/edit-contact.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an contact");
			}
		} else if (act.equals("add")) {
			path = "/add-contact.jsp";
		}

		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
