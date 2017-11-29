package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.Order;
import model.ModelOrder;


/**
 * Servlet implementation class ControllerAdminIndex
 */
//@WebServlet("/ControllerAdminIndex")
public class ControllerAdminEditOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminEditOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelOrder mPro = new ModelOrder();
		int pid = 0; 
		if(request.getParameter("pid") != null){
			pid = Integer.parseInt(request.getParameter("pid"));
		}
		// TODO Auto-generated method stub
		if("load".equals(request.getParameter("type"))){
			request.setAttribute("objPro", mPro.getItem(pid));
			RequestDispatcher rd = request.getRequestDispatcher("/admin/editOrder.jsp");
			rd.forward(request, response);
		}else{
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(fileItemFactory);
			List<FileItem> fileItems = null;
			try {
				fileItems = sfu.parseRequest(request);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String fullName = "";
			int idProduct = 0;
			String cmt ="";
			String email = "";
			String address = "";
			String phoneNumber = "";
			String link = "";
			String notes = "";
			float price = 0 ;
			for (FileItem fileItem : fileItems) {
				if(fileItem.isFormField()){
					String fileName = fileItem.getFieldName();
					String fileValue = new String(fileItem.getString().getBytes("ISO-8859-1"),"UTF-8");
					switch (fileName) {
					case "name":
						fullName = fileValue;
						break;
					case "cmt":
						cmt = fileValue;
						break;
					case "email":
						email = fileValue;
						break;
					case "address":
						address = fileValue;
						break;
					case "price":
						price = Float.parseFloat(fileValue);
						break;
					case "phone":
						phoneNumber = fileValue;
						break;
					case "link":
						link = fileValue;
						break;
					case "notes":
						notes = fileValue;
						break;
					
					default:
						break;
					}
				}
			} 
			Order objPro = new Order(pid, fullName, cmt, email, address, phoneNumber, link, notes, price);
			if(mPro.editItem(objPro) > 0){
				response.sendRedirect(request.getContextPath() + "/admin/indexOrder");
				return ;
			}else{
				response.sendRedirect(request.getContextPath() + "/admin/editOrder");
				return ;
			}
		}
	}

}
