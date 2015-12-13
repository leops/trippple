package com.traveloid.trippple.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.traveloid.trippple.dao.TripDao;
import com.traveloid.trippple.dao.UserDao;
import com.traveloid.trippple.dao.jpa.JpaTripDao;
import com.traveloid.trippple.dao.jpa.JpaUserDao;
import com.traveloid.trippple.entity.User;

/**
 * Servlet implementation class IndexController
 */
@WebServlet("/")
public class IndexController extends HttpServlet {
	/**
	 * Necessaire pour Serializable
	 */
	private static final long serialVersionUID = -5922364041527559015L; // Généré aléatoirement par Eclipse
	private UserDao userDao = null;
	private TripDao tripDao = null;

	/**
	 * @throws ServletException
	 * @see HttpServlet#init(ServletConfig config)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.userDao = new JpaUserDao();
		this.tripDao = new JpaTripDao();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		User user = (User) request.getAttribute("user");
		if(user == null) {
			dispatcher = request.getRequestDispatcher("home.jsp");
			request.setAttribute("users", this.userDao.findAll());
		} else {
			dispatcher = request.getRequestDispatcher("trips.jsp");
		}

		request.setAttribute("trips", this.tripDao.findAll());

		dispatcher.forward(request, response);
	}

}
