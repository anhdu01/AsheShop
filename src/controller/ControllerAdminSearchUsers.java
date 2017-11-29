package controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector.Matcher;

import model.ModelUsers;

/**
 * Servlet implementation class ControllerAdminSearchUsers
 */

public class ControllerAdminSearchUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminSearchUsers() {
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
		ModelUsers mUsers = new ModelUsers();
		String input = "";
		if(request.getParameter("submit") != null){
			input = request.getParameter("input");
		}
		String input2 = new String(input.getBytes("ISO-8859-1"), "UTF-8");
		try {
			Integer.parseInt(input2);
			request.setAttribute("alUsers", mUsers.getListForSearch1(input2));
		} catch (Exception e) {
			request.setAttribute("alUsers",mUsers.getListForSearch(input2));
		}
		RequestDispatcher rd = request.getRequestDispatcher("/admin/searchUsers.jsp");
		rd.forward(request, response);
		
	}

}
