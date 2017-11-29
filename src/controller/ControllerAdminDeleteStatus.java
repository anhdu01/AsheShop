package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelStatus;
import model.ModelUsers;

/**
 * Servlet implementation class ControllerAdminDeleteUsers
 */

public class ControllerAdminDeleteStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminDeleteStatus() {
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
		ModelStatus mStatus = new ModelStatus();
		int sid = Integer.parseInt(request.getParameter("sid"));
		int id = mStatus.getItem(sid).getIdorder();
		if(mStatus.delItem(sid) > 0){
			response.sendRedirect(request.getContextPath()+"/admin/indexStatus?del=del1&pid="+id);
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/indexStatus?del=del0");
		}
	}

}
