package hu.ma.cfl.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import hu.ma.cfl.bo.Customer;
import hu.ma.cfl.dao.CustomerDao;
import hu.ma.cfl.dao.Dao;
import hu.ma.cfl.util.SecurityUtils;

public class UpdatePasswordServlet extends HttpServlet {

    @Resource(name = "jdbc/mysql")
    private DataSource dataSource;

    private Dao<Customer> customerDao;

    @Override
    public void init() throws ServletException {
        customerDao = new CustomerDao(dataSource);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String newPassword = req.getParameter("password");
        String oldPassword = req.getParameter("password-old");

        HttpSession session = req.getSession();
        Customer loggedInCustomer = (Customer) session.getAttribute("loggedInCustomer");

        String encryptedOldPassword = SecurityUtils.encryptPassword(oldPassword, loggedInCustomer.getSalt());

        if (loggedInCustomer.getPassword().equals(encryptedOldPassword)) {

        	loggedInCustomer.setPassword(SecurityUtils.encryptPassword(newPassword, loggedInCustomer.getSalt()));

        	customerDao.update(loggedInCustomer);
        	resp.sendRedirect(req.getContextPath() + "/customer-center/profile.jsp?passwordUpdated=true");
        } else {
        	resp.sendRedirect(req.getContextPath() + "/customer-center/profile.jsp?invalidPassword=true");
        }

    }
}
