package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.TimeConvert;
import model.ModelUsers;
import bean.Users;

/**
 * Servlet implementation class ControllerAdminAddUsers
 */

public class ControllerAdminAddUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminAddUsers() {
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
		ModelUsers  mUser = new ModelUsers();
		if(request.getParameter("submit")!=null){
			String userName = request.getParameter("userName");
			String passWord = request.getParameter("passWord");
			String fullName = request.getParameter("fullName");
			fullName = new String(fullName.getBytes("ISO-8859-1"), "UTF-8");
			String date = request.getParameter("birthDay");
			java.util.Date date2 = TimeConvert.getDateTime(date);
			Date birthDay = TimeConvert.getSqlDate(date2);
			String addDress = request.getParameter("address");
			addDress = new String(addDress.getBytes("ISO-8859-1"), "UTF-8");
			String phoneNumber = request.getParameter("phoneNumber");
			Users objUser = new Users(0, userName, passWord, fullName, birthDay, addDress, phoneNumber);
			if(mUser.addItem(objUser)>0){
				response.sendRedirect(request.getContextPath()+"/admin/indexUsers");
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/addUsers?msg=add0");
			}
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/addUsers.jsp");
			rd.forward(request, response);
		}
		
	}

}
