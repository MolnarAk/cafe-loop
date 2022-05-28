package hu.ma.cfl.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		if (req.getSession().getAttribute("loggedInCustomer") != null) {
			super.doFilter(req, res, chain);
		} else {

			res.sendRedirect(req.getContextPath() + "/login.jsp");

		}

	}

}