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
		String fullName = req.getParameter("fullName");
		String tel = req.getParameter("tel");
		String city = req.getParameter("city");
                String street = req.getParameter("street");
                String district = req.getParameter("district");
                String no = req.getParameter("noHome");
                int nohome = Integer.parseInt(no);

		Boolean flag = false;
		for (int i = 0; i < customerDAOImpl.findAll().size(); i++) {
			if (username.compareToIgnoreCase(customerDAOImpl.findAll().get(i).getAccount().getUsername()) == 0) {
				flag = true;
				break;
			}
		}
//		
		if (flag) {
			req.setAttribute("status", "faileTenBiTrung");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("register.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			
			Address address = new Address();
			address.setCity(city);
                        address.setStreet(street);
                        address.setDistrict(district);
                        address.setNoHome(nohome);
                        

			Account account = new Account();
			account.setUsername(username);
			account.setPassword(password);
                        
                        FullName fullname=new FullName();
                        fullname.setFisrtName("firstname");
                        fullname.setLastName("lastname");
                                
			Customer customer = new Customer();
			customer.setFullName(fullname);
			customer.setTel(tel);
			customer.setAccount(account);
			customer.setAddress(address);
			boolean check = customerDAOImpl.addCustomer(customer);
			if(check) {
				resp.sendRedirect("/ShopOnline/login");
			}
			else {
				req.setAttribute("status", "faile");
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("register.jsp");
				requestDispatcher.forward(req, resp);
			}
			
		}

	}
}
