package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelNews;

/**
 * Servlet implementation class ControllerAdminDeleteIntroduce
 */

public class ControllerAdminDeleteNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminDeleteNews() {
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
		String pictureOld = "";
		if(request.getParameter("nid") != null){
			nid = Integer.parseInt(request.getParameter("nid"));
		}
		pictureOld = mNews.getPicture(nid);
		if(!pictureOld.isEmpty()){
			String filePathOld = request.getServletContext().getRealPath("") + File.separator + "files" + File.separator
					+ pictureOld;
			System.out.println(filePathOld);
			File fileOld = new File(filePathOld);
			fileOld.delete();
		}
		if(mNews.delItem(nid)>0){
			response.sendRedirect(request.getContextPath()+"/admin/indexNews");
		}
	}

}
