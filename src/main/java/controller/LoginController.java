 package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.bookdao.BookDAOImpl;
import dao.customerdao.CustomerDAOImpl;
import model.book.ItemBook;
import model.customer.Customer;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet{
	private CustomerDAOImpl customerDAOImpl;
	private BookDAOImpl itemBookDAOImpl;
	@Override
	public void init() {
		customerDAOImpl = new CustomerDAOImpl();
		 itemBookDAOImpl = new BookDAOImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		Customer customer = customerDAOImpl.getCustomer(username, password);
		
		if(customer==null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
			req.setAttribute("status", "logFailed");
			requestDispatcher.forward(req, resp);
		}
		else {
//			List<ItemBook>listItemBook = itemBookDAOImpl.getAllItemBook();
//			RequestDispatcher requestDispatcher = req.getRequestDispatcher("products.jsp");
//			req.setAttribute("listItemBook", listItemBook);
//			requestDispatcher.forward(req, resp);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("products.jsp");
					requestDispatcher.forward(req, resp);
			
		}
	}
}
