package com.traveloid.trippple.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.traveloid.trippple.dao.jpa.JpaTripDao;
import com.traveloid.trippple.entity.Trip;
import com.traveloid.trippple.entity.User;

/**
 * Servlet implementation class AddTripServlet
 */
@WebServlet("/addtrip")
public class AddTripControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTripControler() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/auth/addTrip.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long tripId = Long.parseLong((request.getParameter("id")));

		JpaTripDao tripDao = new JpaTripDao();
		Trip trip = tripDao.findById(tripId);

		if(trip == null) {
			response.sendRedirect(request.getContextPath());
		}

		User user = (User) request.getAttribute("user");
		if(user == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}

		user.getBag().add(trip);

	}
}
