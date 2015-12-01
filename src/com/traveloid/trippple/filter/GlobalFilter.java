package com.traveloid.trippple.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.traveloid.trippple.dao.UserDao;
import com.traveloid.trippple.dao.jpa.JpaUserDao;

@WebFilter(urlPatterns = {"/*"})
public class GlobalFilter implements Filter {
	private UserDao dao = null;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.dao = new JpaUserDao();
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		if(request != null) {
			Long id = (Long) request.getSession().getAttribute("user");
			if(id != null) {
				req.setAttribute("user", this.dao.findById(id));
			}
		}
		chain.doFilter(req, res);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
}
