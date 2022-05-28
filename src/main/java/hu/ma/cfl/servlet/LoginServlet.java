package hu.ma.cfl.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import hu.ma.cfl.bo.Customer;
import hu.ma.cfl.dao.CustomerDao;
import hu.ma.cfl.util.SecurityUtils;

public class LoginServlet extends HttpServlet {

    @Resource(name="jdbc/mysql")
    private DataSource dataSource;

    private CustomerDao customerDao;

    @Override
    public void init() {
    	customerDao = new CustomerDao(dataSource);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {

        	Optional<Customer> customerFound = customerDao.getCustomerByEmail(email);
        	if (customerFound.isPresent()) {
        		Customer customer = customerFound.get();
        		String salt = customer.getSalt();
        		String encryptedPassword = SecurityUtils.encryptPassword(password, salt);

        		if (encryptedPassword.equals(customer.getPassword())) {

        			HttpSession session = req.getSession();
        			session.setAttribute("loggedInCustomer", customer);

        			 resp.sendRedirect("index.jsp");

        		} else {
        			resp.sendRedirect("login.jsp?loginFailed=true");
        		}
        	}


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
