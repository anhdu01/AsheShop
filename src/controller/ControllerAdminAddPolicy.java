package controller;

import java.io.File;
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
import org.apache.commons.io.FilenameUtils;
import bean.Policy;
import model.ModelPolicy;


/**
 * Servlet implementation class ControllerAdminIndex
 */
//@WebServlet("/ControllerAdminIndex")
public class ControllerAdminAddPolicy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminAddPolicy() {
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
		// TODO Auto-generated method stub
		if("load".equals(request.getParameter("type"))){
			RequestDispatcher rd = request.getRequestDispatcher("/admin/addPolicy.jsp");
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
			String name = "";
			int idProduct = 0;
			String preview ="";
			String detail = "";
			String picture = "";
			String pictureNew = "";
			for (FileItem fileItem : fileItems) {
				if(fileItem.isFormField()){
					String fileName = fileItem.getFieldName();
					String fileValue = new String(fileItem.getString().getBytes("ISO-8859-1"),"UTF-8");
					switch (fileName) {
					case "nameProduct":
						name = fileValue;
						break;
					case "preview":
						preview = fileValue;
						break;
					case "detail":
						detail = fileValue;
						break;	
					default:
						break;
					}
				}else{ // nếu là file
					picture = fileItem.getName();
					if(!picture.isEmpty()){ // có upload
						// đổi tên ảnh
						pictureNew = FilenameUtils.getBaseName(picture) + System.nanoTime() + "." + FilenameUtils.getExtension(picture);
						String filePath = request.getServletContext().getRealPath("")+ File.separator + "files" + File.separator + pictureNew;
						File file = new File(filePath);
						try {
							fileItem.write(file);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(request.getServletContext().getRealPath(""));
					}else{ // khong upload
					}
				}
			} // hết for
			// insert news into database
			ModelPolicy mPol = new ModelPolicy();
			Policy objPol = new Policy(0, name, preview, detail, pictureNew);
			if(mPol.addItem(objPol) > 0){
				response.sendRedirect(request.getContextPath() + "/admin/indexPolicy");
				return ;
			}else{
				response.sendRedirect(request.getContextPath() + "/admin/addPolicy");
				return ;
			}
		}
	}

}
