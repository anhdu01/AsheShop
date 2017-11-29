package controller;

import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import bean.Users;
import library.TimeConvert;
import model.ModelProduct;
import model.ModelUsers;

/**
 * Servlet implementation class ControllerEditUsers
 */

public class ControllerAdminEditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminEditProduct() {
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
		ModelProduct mPro = new ModelProduct();
		int pid = 0;
		int check = 0;
		if(request.getParameter("pid") != null){
			pid = Integer.parseInt( request.getParameter("pid"));
		}
		if(request.getParameter("sua") != null){
			float weight = Float.parseFloat(request.getParameter("weight"));
			float cost = Float.parseFloat(request.getParameter("cost"));
			float costLocal = Float.parseFloat(request.getParameter("costLocal"));
			float paid = Float.parseFloat(request.getParameter("paid"));
			Product objPro = new Product(pid,weight, cost, costLocal, paid);
			if(mPro.editItem(objPro)>0){
				response.sendRedirect(request.getContextPath()+"/admin/indexProduct?pid="+pid);
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/editProduct?msg=edit3&pid="+pid);
			}
		}else{
			request.setAttribute("objPro", mPro.getItem2(pid));
			if (mPro.getItem2(pid).getPrice().contains("NDT")) {
				check = 1;
			}
			request.setAttribute("check", check);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/editProduct.jsp");
			rd.forward(request, response);
		}
	}

}
