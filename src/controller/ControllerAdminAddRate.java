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
import model.ModelRate;
import bean.rate;


/**
 * Servlet implementation class ControllerAdminAddUsers
 */

public class ControllerAdminAddRate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminAddRate() {
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
		ModelRate  mRate = new ModelRate();
		if(request.getParameter("submit") != null){
			String money = request.getParameter("money");
			money = new String(money.getBytes("ISO-8859-1"), "UTF-8");
			float rate = Float.parseFloat(request.getParameter("rate"));
			rate objRate = new  rate(money, rate);
			if(mRate.addItem(objRate)>0){
				response.sendRedirect(request.getContextPath()+"/admin/indexRate");
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/addRate?msg=add2");
			}
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/addRate.jsp");
			rd.forward(request, response);
		}
		
	}

}
