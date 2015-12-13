/**
 * 
 */
package com.traveloid.trippple.controllers.api;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import com.traveloid.trippple.dao.UserDao;
import com.traveloid.trippple.dao.jpa.JpaTripDao;
import com.traveloid.trippple.dao.jpa.JpaUserDao;
import com.traveloid.trippple.entity.Trip;
import com.traveloid.trippple.entity.User;

/**
 * @author leops
 */
@Path("/bag")
public class BagController {
	@GET
	@Path("/order")
	public void processBag(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		try {
			User user = (User) request.getAttribute("user");
			if(user == null) {
				response.sendError(401);
				return;
			}

			Collection<Trip> orders = user.getOrdered();
			Collection<Trip> bag = user.getBag();
			for(Trip trip : bag) {
				orders.add(trip);
			}
			bag.clear();

			UserDao dao = new JpaUserDao();
			dao.updateUser(user);

			response.sendRedirect(request.getContextPath());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	@GET
	@Path("/clear")
	public void clearBag(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		try {
			User user = (User) request.getAttribute("user");
			if(user == null) {
				response.sendError(401);
				return;
			}

			user.getBag().clear();

			UserDao dao = new JpaUserDao();
			dao.updateUser(user);

			response.sendRedirect(request.getContextPath());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	@GET
	@Path("/add")
	public void addTrip(@Context HttpServletRequest request, @Context HttpServletResponse response) throws IOException {
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

		Collection<Trip> bag = user.getBag();
		if(!bag.contains(trip)) {
			bag.add(trip);
		}

		response.sendRedirect(home);
	}
}
