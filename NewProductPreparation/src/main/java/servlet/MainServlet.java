package servlet;

import java.io.IOException;

import dao.ProductDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DeleteProductLogic;
import model.OutputLogic;
import model.RegisterProductLogic;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		String productList = dao.findByProductList();
		request.setAttribute("productList", productList);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/index.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String link = request.getParameter("link");
		if(link.equals("registerProduct")) {
			RegisterProductLogic rpl = new RegisterProductLogic();
			String msg = rpl.execute(request.getParameter("name"), request.getParameter("width"), request.getParameter("lot"), request.getParameter("inCase"), request.getParameter("outRate"));
			request.setAttribute("msgOnRegister", msg);
			ProductDAO dao = new ProductDAO();
			String productList = dao.findByProductList();
			request.setAttribute("productList", productList);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/index.jsp");
			rd.forward(request, response);
		}if(link.equals("deleteProduct")) {
			String productName = request.getParameter("name");
			DeleteProductLogic dpl = new DeleteProductLogic();
			String msg = dpl.execute(productName);
			request.setAttribute("msgOnList", msg);
			ProductDAO dao = new ProductDAO();
			String productList = dao.findByProductList();
			request.setAttribute("productList", productList);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/index.jsp");
			rd.forward(request, response);
		}if(link.equals("output")) {
			OutputLogic ol = new OutputLogic();
			String output = ol.execute();
			request.setAttribute("output", output);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/output.jsp");
			rd.forward(request, response);
		}
	}
}