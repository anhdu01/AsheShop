package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import library.LibraryConstant;
import library.LibraryPer;
import model.ModelUsers;

/**
 * Servlet implementation class ControllerAdminIndexUsers
 */

public class ControllerAdminIndexUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminIndexUsers() {
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
		ModelUsers mUsers = new ModelUsers();
		int tongSoDong = mUsers.getSum();
		int soTrang = (int)Math.ceil((float)tongSoDong/LibraryConstant.ROW_COUNT);
		int currentPage = 1;
		if(request.getParameter("page") != null){
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		request.setAttribute("page", currentPage);
		request.setAttribute("soTrang", soTrang);
		int offset = (currentPage-1) * LibraryConstant.ROW_COUNT;
		request.setAttribute("alUsers", mUsers.getListForPagination(offset,LibraryConstant.ROW_COUNT));
		RequestDispatcher rd = request.getRequestDispatcher("/admin/indexUsers.jsp");
		rd.forward(request, response);
	}

}
