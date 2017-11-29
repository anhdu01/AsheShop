package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.LibraryConstant;
import library.LibraryPer;
import model.ModelOrder;
import model.ModelStatus;

/**
 * Servlet implementation class ControllerAdminIndexUsers
 */

public class ControllerAdminStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminStatus() {
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
		if(!LibraryPer.isLogin(request, response)){
			return;
		}
		ModelStatus mStatus = new ModelStatus();
		int pid =0;
		if (request.getParameter("pid") != null) {
			pid = Integer.parseInt(request.getParameter("pid"));
		}
		request.setAttribute("alStatus", mStatus.getList(pid));
		RequestDispatcher rd = request.getRequestDispatcher("/admin/indexStatus.jsp");
		rd.forward(request, response);
	}

}
