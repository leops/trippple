package com.traveloid.trippple.controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.traveloid.trippple.dao.UserDao;
import com.traveloid.trippple.dao.jpa.JpaUserDao;
import com.traveloid.trippple.entity.User;
import com.traveloid.trippple.util.TextUtils;

/**
 * Servlet implementation class ProfileController
 */
@WebServlet("/profile")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		dao = new JpaUserDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getAttribute("user");
		if(user == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}

		request.getRequestDispatcher("profile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String home = request.getContextPath();

		User user = (User) request.getAttribute("user");
		if(user == null) {
			response.setStatus(401);
			return;
		}

		user.setEmail(TextUtils.escapeHTML(request.getParameter("email")));
		user.setFirstName(TextUtils.escapeHTML(request.getParameter("firstName")));
		user.setLastName(TextUtils.escapeHTML(request.getParameter("lastName")));

		String primPass = request.getParameter("primPassword"), secPass = request.getParameter("secPassword");

		if(primPass.length() > 0 && primPass.equals(secPass)) {
			try {
				user.setPassword(primPass);
			} catch(NoSuchAlgorithmException e) {
				// Pas d'algo, pas de crypto
			}
		} else {
			request.getSession().setAttribute("flash", "Passwords did not match");
		}

		dao.updateUser(user);

		response.sendRedirect(home);
	}

}
