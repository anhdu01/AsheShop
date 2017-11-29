package controller;

import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Users;
import library.TimeConvert;
import model.ModelUsers;

/**
 * Servlet implementation class ControllerEditUsers
 */

public class ControllerAdminEditUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminEditUsers() {
        super();
        
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
		ModelUsers mUser = new ModelUsers();
		TimeConvert cv = new TimeConvert();
		int uid = 0;
		if(request.getParameter("uid") != null){
			uid = Integer.parseInt( request.getParameter("uid"));
		}
		if(request.getParameter("sua") != null){
			String userName = request.getParameter("userName");
			String passWord = request.getParameter("passWord");
			String fullName = request.getParameter("fullName");
			fullName = new String(fullName.getBytes("ISO-8859-1"), "UTF-8");
			String date1 = request.getParameter("birthDay");
			Date  date2 = cv.getDateTime(date1);
			java.sql.Date date3 = cv.getSqlDate(date2);
			String addDress = request.getParameter("address");
			addDress = new String(addDress.getBytes("ISO-8859-1"), "UTF-8");
			String phoneNumber = request.getParameter("phoneNumber");
			Users objUser = new Users(uid, userName, passWord, fullName, date3, addDress, phoneNumber);
			if(mUser.editItem(objUser)>0){
				response.sendRedirect(request.getContextPath()+"/admin/indexUsers");
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/editUsers?msg=edit0&uid="+uid);
			}
		}else{
			request.setAttribute("objUser", mUser.getItem(uid));
			RequestDispatcher rd = request.getRequestDispatcher("/admin/editUsers.jsp");
			rd.forward(request, response);
		}
	}

}
