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
import bean.News;
import model.ModelNews;


/**
 * Servlet implementation class ControllerAdminIndex
 */
//@WebServlet("/ControllerAdminIndex")
public class ControllerAdminEditNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminEditNews() {
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
		ModelNews mNews = new ModelNews();
		int nid = 0; 
		if(request.getParameter("nid") != null){
			nid = Integer.parseInt(request.getParameter("nid"));
		}
		// TODO Auto-generated method stub
		if("load".equals(request.getParameter("type"))){
			request.setAttribute("objNews", mNews.getItem(nid));
			RequestDispatcher rd = request.getRequestDispatcher("/admin/editNews.jsp");
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
			int idIntroduce = 0;
			String preview ="";
			String detail = "";
			String picture = "";
			String pictureOld = "";
			String pictureNew = "";
			for (FileItem fileItem : fileItems) {
				if(fileItem.isFormField()){
					String fileName = fileItem.getFieldName();
					String fileValue = new String(fileItem.getString().getBytes("ISO-8859-1"),"UTF-8");
					switch (fileName) {
					case "nameNews":
						name = fileValue;
						break;
					case "preview":
						preview = fileValue;
						break;
					case "detail":
						detail = fileValue;
						break;
					case "pictureOld":
						pictureOld = fileValue;
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
						String filePathOld = request.getServletContext().getRealPath("") + File.separator + "files" + File.separator
								+ pictureOld;
						File fileOld = new File(filePathOld);
						fileOld.delete();
					}else{ // khong upload
					}
				}
			} // hết for
			// insert news into database
			System.out.println(pictureOld);
			News objNews = new News(nid, name, preview, detail, pictureNew);
			if(mNews.editItem(objNews) > 0){
				response.sendRedirect(request.getContextPath() + "/admin/indexNews");
				return ;
			}else{
				response.sendRedirect(request.getContextPath() + "/admin/editNews");
				return ;
			}
		}
	}

}
