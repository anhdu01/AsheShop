package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ModelPolicy;

/**
 * Servlet implementation class ControllerAdminAjaxRegister
 */

public class ControllerAdminAjaxPolicy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminAjaxPolicy() {
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
		ModelPolicy  mPol = new ModelPolicy();
		PrintWriter out = response.getWriter();
		int id = Integer.valueOf(request.getParameter("aid"));
		System.out.println(id);
		int active = Integer.valueOf(request.getParameter("aactive"));
		System.out.println(active);
		String imgActive = "";
		String result = "";
		if(mPol.setActive(id, active) > 0){
			if(active == 1){
				imgActive = request.getContextPath() + "/templates/admin/images/icon-fail.png";
				active = 0;
			}else{
				imgActive = request.getContextPath() + "/templates/admin/images/icon-success.png";
				active = 1;
			}
			result += "<a href='avascript:void(0)' onclick='return setActive("+id +","+ active +")' title=''><img style='width:30px; height:30px;'' src='" + imgActive + "'></a>";
			out.print(result);
		}
	}

}
