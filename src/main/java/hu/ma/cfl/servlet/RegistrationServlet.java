package hu.ma.cfl.servlet;

import java.io.IOException;
import java.security.SecureRandom;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import hu.ma.cfl.bo.Customer;
import hu.ma.cfl.dao.CustomerDao;
import hu.ma.cfl.dao.Dao;
import hu.ma.cfl.util.SecurityUtils;



public class RegistrationServlet extends HttpServlet {

	// Dependency injection / az Inversion of Control megvalósítása

	@Resource(name = "jdbc/mysql")
	private DataSource dataSource;

	private Dao<Customer> customerDao;

	@Override
	public void init() throws ServletException {
		customerDao = new CustomerDao(dataSource);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		
		// TODO ellenőrzés: email egyedisége, email formátuma
		
		Customer customer = new Customer();
		customer.setEmail(email);
		customer.setName(name);

		byte[] salt = SecureRandom.getSeed(16);
		String encryptedPassword = SecurityUtils.encryptPassword(password, salt);
		customer.setPassword(encryptedPassword);
		customer.setSalt(SecurityUtils.encodeSalt(salt));

		Customer createdCustomer = customerDao.create(customer);

		resp.sendRedirect("login.jsp?email=" + email);
	}

}