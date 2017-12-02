package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import bean.Order;
import bean.Product;
import bean.Status;
import model.ModelOrder;
import model.ModelProduct;
import model.ModelRate;

/**
 * Servlet implementation class ControllerIndexOrder
 */
public class ControllerIndexOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerIndexOrder() {
        super();
        // TODO Auto-" constructor stub
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
		ModelOrder  mOrder = new ModelOrder();
		ModelRate mRate = new ModelRate();
		Product objPro = new Product();
		Document doc;
		ModelProduct mPro = new ModelProduct();
		ArrayList<Product> alPro = new ArrayList<>();
		if (request.getParameter("price") != null) {
			int idorder = Integer.parseInt(request.getParameter("order_code"));
			float pay = Float.parseFloat(request.getParameter("price"));
			mPro.editpay(idorder, pay);
		}
		if (request.getParameter("submit1")!= null) {
			String price = "";
			String name = "";
			String image = "";
			String link = request.getParameter("link");
			try {
				if (mOrder.checkLink(link) == 1) {
					doc = Jsoup.connect(link).get();
					name = doc.select("#detail .tb-item-info-r .tb-main-title").text();
					price = doc.select("#detail .tb-rmb-num").text();
					price = price + " NDT";
					image =doc.select("#detail .tb-main-pic img").attr("src");
					objPro = new Product(name, price, link, image);
					mPro.addItem(objPro);
				} else {
					if (mOrder.checkLink(link)==2) {
						doc = Jsoup.connect(link).get();
						name = doc.select("#Body #CenterPanel #CenterPanelInternal .it-ttl").text().replaceAll("Details about", "").trim();
						price = doc.select("#Body #CenterPanel #CenterPanelInternal .lsp-de #mainContent .vi-ds3cont-box-marpad .vi-noborder .vi-price #prcIsum").attr("content");
						price = price + " $";
						image = doc.select("#Body #CenterPanel #CenterPanelInternal .pp-ic300 .img300 #linkMainImg #mainImgHldr #icImg").attr("src");
						objPro = new Product(name, price, link, image);
						mPro.addItem(objPro);
					}
			}
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (objPro.getImage() != null) {
				request.setAttribute("objPro", objPro);
			}
			request.setAttribute("NDT", mRate.getRate("NDT"));
			request.setAttribute("USD", mRate.getRate("USD"));
			RequestDispatcher rd = request.getRequestDispatcher("/public/indexOrder.jsp");
			rd.forward(request, response);
		} else {
		if(request.getParameter("submit")!=null){
			String link = request.getParameter("link");
			Float price = Float.parseFloat(request.getParameter("pricevn"));
			String name = request.getParameter("name"); 
			name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
			String cmt = request.getParameter("cmt");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			address = new String(address.getBytes("ISO-8859-1"), "UTF-8");
			String phone = request.getParameter("phone");	
			String notes = request.getParameter("notes");	
			notes = new String(notes.getBytes("ISO-8859-1"), "UTF-8");
			Order objOrder = new Order(0, name, cmt, email, address, phone, link, notes, price);
			if(mOrder.addItem(objOrder)>0){
				if (!link.equals("")) {
					mPro.addId(link, mOrder.getId(cmt, link));
				} else {
					Product obj = new Product();
					String name1 = notes;
					String price1 = String.valueOf(price);
					String image1 ="";
					obj = new Product(name1, price1, link, image1);
					mPro.addItem(obj);
					mPro.addId1(link, mOrder.getId(cmt, link));
				}
				request.setAttribute("NDT", mRate.getRate("NDT"));
				request.setAttribute("USD", mRate.getRate("USD"));
				response.sendRedirect(request.getContextPath()+"/indexOrder?id="+mOrder.getId(cmt, link));
			}else{ 
				request.setAttribute("NDT", mRate.getRate("NDT"));
				request.setAttribute("USD", mRate.getRate("USD"));
				response.sendRedirect(request.getContextPath()+"/indexOrder?order=order0");
			}
		}else{
			request.setAttribute("NDT", mRate.getRate("NDT"));
			request.setAttribute("USD", mRate.getRate("USD"));
			RequestDispatcher rd = request.getRequestDispatcher("/public/indexOrder.jsp");
			rd.forward(request, response);
		}

	}
	}

}
