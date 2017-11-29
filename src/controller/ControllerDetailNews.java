package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ModelNews;

/**
 * Servlet implementation class ControllerDetailIntroduces
 */
public class ControllerDetailNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerDetailNews() {
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
		ModelNews mNews = new ModelNews();
		int nid = 0;
		if(request.getParameter("nid")!= null){
			nid = Integer.parseInt(request.getParameter("nid"));
		}
		request.setAttribute("objNews", mNews.getItem(nid));
		RequestDispatcher rd = request.getRequestDispatcher("/public/detailNews.jsp");
		rd.forward(request, response);
		
	}

}
