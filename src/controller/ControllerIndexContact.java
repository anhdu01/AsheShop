package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Contact;
import model.ModelContact;

/**
 * Servlet implementation class ControllerAdminIndexUsers
 */

public class ControllerIndexContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerIndexContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelContact mContact = new ModelContact();
		if(request.getParameter("submit")!=null){
			String fullname = request.getParameter("name");
			fullname = new String(fullname.getBytes("ISO-8859-1"), "UTF-8");
			String email = request.getParameter("email"); 
			String address = request.getParameter("address");
			address = new String(address.getBytes("ISO-8859-1"), "UTF-8");
			String phone = request.getParameter("phone");
			phone = new String(phone.getBytes("ISO-8859-1"), "UTF-8");
			String job = request.getParameter("job");
			job = new String(job.getBytes("ISO-8859-1"), "UTF-8");
			String notes = request.getParameter("notes");	
			notes = new String(notes.getBytes("ISO-8859-1"), "UTF-8");
			Contact objContact = new Contact(0, fullname, email, address, phone, job, notes);
			if(mContact.addItem(objContact)>0){
				response.sendRedirect(request.getContextPath()+"/indexContact?contact=contact1");
			}else{
				response.sendRedirect(request.getContextPath()+"/indexContact?contact=contact0");
			}
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/public/indexContact.jsp");
			rd.forward(request, response);
		}
		
	}

}
