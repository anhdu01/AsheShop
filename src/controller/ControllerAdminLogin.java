package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Users;
import model.ModelUsers;

/**
 * Servlet implementation class ControllerIndex
 */

public class ControllerAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminLogin() {
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
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Users objUser = mUsers.getUserByUserPass(username,password);
			if((objUser != null)&&(objUser.isRegister() == false)){
					HttpSession ss = request.getSession();
					ss.setAttribute("objAdmin", objUser);
					response.sendRedirect(request.getContextPath()+"/admin/index?msg=login1");
					return;
			
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/login?msg=login0");
				return;
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/admin/login.jsp");
		rd.forward(request, response);
	}

	
}
