package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Users;
import model.ModelRate;
import model.ModelUsers;

/**
 * Servlet implementation class ControllerIndex
 */

public class ControllerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerLogin() {
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
		if(request.getParameter("submit")!=null){
			String username = request.getParameter("userName");
			String password = request.getParameter("passWord");
			Users objUser = mUsers.getUserByUserPass(username,password);
			if(objUser != null){
				HttpSession ss = request.getSession();
				ss.setAttribute("objUser", objUser);
				response.sendRedirect(request.getContextPath()+"/index");
				return;
			}else{
				response.sendRedirect(request.getContextPath()+"/index?login=login0");
				return;
			}
		}
	}

	
}
