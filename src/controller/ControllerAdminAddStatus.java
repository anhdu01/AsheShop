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
import model.ModelStatus;
import bean.Status;


/**
 * Servlet implementation class ControllerAdminAddUsers
 */

public class ControllerAdminAddStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminAddStatus() {
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
		ModelStatus  mStatus = new ModelStatus();
		if(request.getParameter("submit") != null){
			int idorder = Integer.parseInt(request.getParameter("idorder"));
			String status = request.getParameter("status");
			status = new String(status.getBytes("ISO-8859-1"), "UTF-8");
			String date = request.getParameter("date");
			java.util.Date date2 = TimeConvert.getDateTime(date);
			Date date3 = TimeConvert.getSqlDate(date2);
			Status objStatus = new  Status(idorder, status, date3);
			if(mStatus.addItem(objStatus)>0){
				response.sendRedirect(request.getContextPath()+"/admin/indexStatus?pid="+objStatus.getIdorder());
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/addStatus?msg=add0");
			}
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/addStatus.jsp");
			rd.forward(request, response);
		}
		
	}

}
