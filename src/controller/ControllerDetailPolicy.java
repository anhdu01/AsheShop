package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ModelPolicy;

/**
 * Servlet implementation class ControllerDetailIntroduces
 */
public class ControllerDetailPolicy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerDetailPolicy() {
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
		ModelPolicy mPol = new ModelPolicy();
		int pid = 0;
		if(request.getParameter("pid")!= null){
			pid = Integer.parseInt(request.getParameter("pid"));
		}
		request.setAttribute("objPol", mPol.getItem(pid));	
		RequestDispatcher rd = request.getRequestDispatcher("/public/detailPolicy.jsp");
		rd.forward(request, response);
		
	}

}
