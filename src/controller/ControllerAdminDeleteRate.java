package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelRate;
import model.ModelStatus;
import model.ModelUsers;

/**
 * Servlet implementation class ControllerAdminDeleteUsers
 */

public class ControllerAdminDeleteRate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminDeleteRate() {
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
		ModelRate mRate = new ModelRate();
		int rid = Integer.parseInt(request.getParameter("rid"));
		if(mRate.delItem(rid) > 0){
			response.sendRedirect(request.getContextPath()+"/admin/indexRate?del=del1");
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/indexRate?del=del0");
		}
	}

}
