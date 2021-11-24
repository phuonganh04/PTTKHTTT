package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import dao.bookdao.BookDAOImpl;
import model.book.*;
import model.order.Cart;
@WebServlet("/cart")
public class CartController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String action = request.getParameter("action");
		System.out.printf(action);
		if(action == null) {
			doGet_DisplayCart(request, response);	
		}
		else if(action.equalsIgnoreCase("buy")){
			System.out.printf(action);
			doGet_Buy(request, response);
		}
		else if(action.equalsIgnoreCase("detail")) {
			System.out.printf(action);
			doGet_Detail(request, response);
		}
	}
	
	public void doGet_DisplayCart(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		req.getRequestDispatcher("cart.jsp").forward(req, res);
		
	}
	public void doGet_Detail(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		BookDAOImpl bookDaoImpl = new BookDAOImpl();
		ItemBook itemBook = bookDaoImpl.getItemBookByID(id);
		req.setAttribute("itemBook", itemBook);
		System.out.printf(itemBook.getBook().getAuthor().getName());
		RequestDispatcher rd = req.getRequestDispatcher("product_detail.jsp");
		rd.forward(req, res);
	}
	public void doGet_Buy(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		BookDAOImpl bookDaoImpl = new BookDAOImpl();
		Cart cart = new Cart();
		HttpSession session = req.getSession();
		int amount = 1;

		
		if(session.getAttribute("cart") == null) {
			List<ItemBook> items = new ArrayList<>();
			ItemBook itemBook = bookDaoImpl.getItemBookByID(Integer.parseInt(req.getParameter("id")));
			itemBook.setAmount(amount);
			items.add(itemBook);
			cart.setItemBook(items);
			session.setAttribute("cart", items);
		}
		else {
			List<ItemBook> items = (List<ItemBook>) session.getAttribute("cart");
			int id = Integer.parseInt(req.getParameter("id"));
			int index = isExisting(id, items);
			if(index == -1) {
				ItemBook itemBook = bookDaoImpl.getItemBookByID(id);
				itemBook.setAmount(amount);
				items.add(itemBook);
			}
			else {
				amount = items.get(index).getAmount()+1;
				items.get(index).setAmount(amount);
			}
			session.setAttribute("cart", items);

		}
		res.sendRedirect("products.jsp");
	}
	public int isExisting(int id, List<ItemBook> listItem) {
		for(int i=0; i< listItem.size(); i++) {
			if(listItem.get(i).getId()==id) {
				return i;
			}
		}
		return -1;
	}
}
