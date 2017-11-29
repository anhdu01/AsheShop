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
import model.ModelProduct;
import model.ModelRate;
import model.ModelStatus;

/**
 * Servlet implementation class ControllerAdminIndexUsers
 */

public class ControllerAdminIndexProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminIndexProduct() {
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
		int pid =0;
		String link ="";
		if (request.getParameter("pid") != null) {
			pid = Integer.parseInt(request.getParameter("pid"));
			link = request.getParameter("link");
		}
		ModelProduct mPro = new ModelProduct();
		if (mPro.getItem(pid, link) != null) {
			request.setAttribute("objPro", mPro.getItem(pid,link));
			request.setAttribute("sum", mPro.getSum(pid));
			request.setAttribute("sum1", mPro.getSum1(pid));
			RequestDispatcher rd = request.getRequestDispatcher("/admin/indexProduct.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/indexOrder");
		}
	}

}
