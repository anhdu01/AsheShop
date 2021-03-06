package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ModelOrder;

/**
 * Servlet implementation class ControllerAdminAjaxRegister
 */

public class ControllerAdminAjaxOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminAjaxOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelOrder  mPro = new ModelOrder();
		PrintWriter out = response.getWriter();
		int id = Integer.valueOf(request.getParameter("aid"));
	    int active = Integer.valueOf(request.getParameter("aactive"));
		String imgActive = "";
		String result = "";
		if(mPro.setActive(id, active) > 0){
			if(active == 1){
				imgActive = request.getContextPath() + "/templates/admin/images/nottick.png";
				active = 0;
			}else{
				imgActive = request.getContextPath() + "/templates/admin/images/tick.png";
				active = 1;
			}
			result = "<a href='avascript:void(0)' onclick='return setActive("+id +","+ active +")' title=''><img style='width:30px; height:30px;'' src='" + imgActive + "'></a>";
			out.print(result);
		}
	}

}
