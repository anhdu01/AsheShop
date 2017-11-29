package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Status;
import bean.Users;
import model.ModelProduct;
import model.ModelStatus;
import model.ModelUsers;

/**
 * Servlet implementation class ControllerSearchStatus
 */

public class ControllerSearchStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerSearchStatus() {
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
		ModelProduct mPro= new ModelProduct();
		String code ="";
		if(request.getParameter("submit")!=null){
			code = request.getParameter("code");
			int code2 = Integer.parseInt( new String(code.getBytes("ISO-8859-1"), "UTF-8"));
			request.setAttribute("alCode",mStatus.getList(code2));
			request.setAttribute("objPro", mPro.getItem1(code2));
			if ( mStatus.getList(code2).isEmpty()) {
				response.sendRedirect(request.getContextPath()+"/index?login=login1");
				return;
			} else {
			request.setAttribute("num",code2);
			request.setAttribute("sum", mPro.getSum(code2));
			request.setAttribute("sum1", mPro.getSum1(code2));
			RequestDispatcher rd = request.getRequestDispatcher("/public/search.jsp");
			rd.forward(request, response);
			}
		}
	}

}
