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
		// TODO Auto-generated method stub
	}

	private static String escapeHTML(String s) {
		StringBuilder out = new StringBuilder(Math.max(16, s.length()));
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c > 127 || c == '"' || c == '<' || c == '>' || c == '&') {
				out.append("&#");
				out.append((int) c);
				out.append(';');
			} else {
				out.append(c);
			}
		}
		return out.toString();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getAttribute("user");
		if(user == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}

		user.setEmail(escapeHTML(request.getParameter("email")));
		user.setFirstName(escapeHTML(request.getParameter("firstName")));
		user.setLastName(escapeHTML(request.getParameter("lastName")));

		String primPass = request.getParameter("primPassword"), secPass = request.getParameter("secPassword");

		if(primPass.equals(secPass)) {
			try {
				user.setPassword(primPass);
			} catch(NoSuchAlgorithmException e) {
				// Pas d'algo, pas de crypto
			}
		}

		dao.updateUser(user);
	}

}
