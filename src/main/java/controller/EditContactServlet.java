package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contact;

/**
 * Servlet implementation class EditContactServlet
 */
@WebServlet("/editContactServlet")
public class EditContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditContactServlet() {
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
		ContactHelper ch = new ContactHelper();
		
		String name = request.getParameter("name");
		String phoneNum = request.getParameter("phone#");
		String address = request.getParameter("address");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		LocalDateTime creationDate = LocalDateTime.now();
		LocalDate dateOfBirth;
		try {
			dateOfBirth = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			dateOfBirth = LocalDate.now();
		}
		
		Contact contactToEdit = ch.searchForEntryById(tempId);
		contactToEdit.setName(name);
		contactToEdit.setPhoneNumber(phoneNum);
		contactToEdit.setAddress(address);
		contactToEdit.setDob(dateOfBirth);
		contactToEdit.setContactCreated(creationDate);
		
		ch.editEntry(contactToEdit);
		getServletContext().getRequestDispatcher("/viewAllContactsServlet").forward(request, response);
		
	}

}
