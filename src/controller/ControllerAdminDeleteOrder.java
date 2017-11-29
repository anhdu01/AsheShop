package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ModelOrder;

/**
 * Servlet implementation class ControllerAdminDeleteIntroduce
 */

public class ControllerAdminDeleteOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminDeleteOrder() {
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
		ModelOrder mPro = new ModelOrder();
		int pid = 0;
		if(request.getParameter("pid") != null){
			pid = Integer.parseInt(request.getParameter("pid"));
		}
		if(mPro.delItem(pid)>0){
			response.sendRedirect(request.getContextPath()+"/admin/indexOrder");
		}
	}

}
