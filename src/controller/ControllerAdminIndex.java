package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.LibraryPer;
import model.ModelContact;
import model.ModelOrder;

/**
 * Servlet implementation class ControllerAdminIndex
 */

public class ControllerAdminIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerAdminIndex() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if(!LibraryPer.isLogin(request, response)){ 
			return; 
		}
		ModelOrder mOrder = new ModelOrder();
		ModelContact mContact = new ModelContact();
		int sodon = mOrder.getSoDon();
		int lienhe = mContact.getLienHe();
		request.setAttribute("sodon", sodon);
		request.setAttribute("lienhe", lienhe);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/index.jsp");
		rd.forward(request, response);
	}

}
