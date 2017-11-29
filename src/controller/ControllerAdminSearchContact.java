package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.LibraryConstant;
import library.LibraryPer;
import model.ModelContact;
import model.ModelOrder;

/**
 * Servlet implementation class ControllerAdminIndexUsers
 */

public class ControllerAdminSearchContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminSearchContact() {
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
		String input = "";
		if(request.getParameter("submit") != null){
			input = request.getParameter("input");		
		}
		String input2 = new String(input.getBytes("ISO-8859-1"), "UTF-8");
		try {
			Integer.parseInt(input2);
			request.setAttribute("alContact",mContact.getListForSearch1(input2));
		} catch (Exception e) {
			request.setAttribute("alContact",mContact.getListForSearch(input2));
		}
		RequestDispatcher rd = request.getRequestDispatcher("/admin/searchContact.jsp");
		rd.forward(request, response);
	}

}
