package com.traveloid.trippple.controllers;

import java.io.IOException;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String home = request.getContextPath();

		User user = (User) request.getAttribute("user");
		if(user == null) {
			response.sendRedirect(home);
			return;
		}

		long tripId = Long.parseLong(request.getParameter("id"));

		JpaTripDao tripDao = new JpaTripDao();
		Trip trip = tripDao.findById(tripId);
		if(trip == null) {
			response.sendRedirect(home);
			return;
		}

		user.getBag().add(trip);

		response.sendRedirect(home);
	}
}
