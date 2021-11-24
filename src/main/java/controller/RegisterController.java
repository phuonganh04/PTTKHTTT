package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.customerdao.CustomerDAOImpl;
import model.customer.Account;
import model.customer.Address;
import model.customer.Customer;
import model.customer.FullName;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {
	private CustomerDAOImpl customerDAOImpl;

	@Override
	public void init() {
		customerDAOImpl = new CustomerDAOImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("register.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String tel = req.getParameter("tel");
		String city = req.getParameter("city");
        String street = req.getParameter("street");
        String district = req.getParameter("district");
        int nohome = Integer.parseInt(req.getParameter("noHome"));
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        
        Address address = new Address(city, district, nohome, street);
        Account account = new Account(username, password);
        FullName fullname = new FullName(firstname,lastname);
        Customer customer = new Customer(tel, fullname, email, address, account);
        Boolean isSuccess = customerDAOImpl.addCustomer(customer);
        if(isSuccess) {
        	req.setAttribute("status", "register_success");
        	req.setAttribute("customer", customer);	
        	RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
        	rd.forward(req, resp);
        }
        else {
        	req.setAttribute("status", "register_failed");
        	RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
        	rd.forward(req, resp);
        	
        }

	}
}
