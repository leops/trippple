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
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
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
		if(user != null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}

		// TODO Forward vers register.jsp
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getAttribute("user");
		if(user != null) {
			response.setStatus(403);
			return;
		}

		user = new User();

		long id;
		try {
			id = Long.parseLong(request.getParameter("id"));
		} catch(NumberFormatException e) {
			response.setStatus(400);
			return;
		}

		user.setId(id);
		user.setEmail(TextUtils.escapeHTML(request.getParameter("email")));
		user.setFirstName(TextUtils.escapeHTML(request.getParameter("firstName")));
		user.setLastName(TextUtils.escapeHTML(request.getParameter("lastName")));

		String primPass = request.getParameter("primPassword"), secPass = request.getParameter("secPassword");

		if(primPass.equals(secPass)) {
			try {
				user.setPassword(primPass);
			} catch(NoSuchAlgorithmException e) {
				// Pas d'algo, pas de crypto
			}
		}

		dao.addUser(user);
	}

}
