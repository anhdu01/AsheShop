package controller;

import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Status;
import bean.Users;
import library.TimeConvert;
import model.ModelStatus;
import model.ModelUsers;

/**
 * Servlet implementation class ControllerEditUsers
 */

public class ControllerAdminEditStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminEditStatus() {
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
		ModelStatus mStatus = new ModelStatus();
		TimeConvert cv = new TimeConvert();
		int sid = 0;
		if(request.getParameter("sid") != null){
			sid = Integer.parseInt( request.getParameter("sid"));
		}
		if(request.getParameter("sua") != null){
			int idorder = Integer.parseInt(request.getParameter("idorder"));
			String status = request.getParameter("status");
			status = new String(status.getBytes("ISO-8859-1"), "UTF-8");
			String date1 = request.getParameter("date");
			Date  date2 = cv.getDateTime(date1);
			java.sql.Date date3 = cv.getSqlDate(date2);
			Status objStatus = new Status(sid, idorder, status, date3);
			if(mStatus.editItem(objStatus)>0){
				response.sendRedirect(request.getContextPath()+"/admin/indexStatus?pid="+objStatus.getIdorder());
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/editStatus?msg=edit0&sid="+sid);
			}
		}else{
			request.setAttribute("objStatus", mStatus.getItem(sid));
			System.out.println(mStatus.getItem(sid).getDate());
			RequestDispatcher rd = request.getRequestDispatcher("/admin/editStatus.jsp");
			rd.forward(request, response);
		}
	}

}
