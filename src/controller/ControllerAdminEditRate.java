package controller;

import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.rate;
import bean.Users;
import library.TimeConvert;
import model.ModelRate;
import model.ModelStatus;
import model.ModelUsers;

/**
 * Servlet implementation class ControllerEditUsers
 */

public class ControllerAdminEditRate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminEditRate() {
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
		ModelRate mRate = new ModelRate();
		int rid = 0;
		if(request.getParameter("rid") != null){
			rid = Integer.parseInt( request.getParameter("rid"));
		}
		if(request.getParameter("sua") != null){
			String money = request.getParameter("money");
			money = new String(money.getBytes("ISO-8859-1"), "UTF-8");
			float rate = Float.parseFloat(request.getParameter("rate"));
			rate objRate = new rate(rid, money, rate);
			if(mRate.editItem(objRate)>0){
				response.sendRedirect(request.getContextPath()+"/admin/indexRate");
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/editRate?edit=edit2&rid="+rid);
			}
		}else{
			request.setAttribute("objRate", mRate.getItem(rid));
			RequestDispatcher rd = request.getRequestDispatcher("/admin/editRate.jsp");
			rd.forward(request, response);
		}
	}

}
