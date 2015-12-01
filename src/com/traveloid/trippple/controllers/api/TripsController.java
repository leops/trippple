package com.traveloid.trippple.controllers.api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONValue;

import com.traveloid.trippple.dao.jpa.JpaTripDao;

@Path("/trips")
public class TripsController {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getList() {
		JpaTripDao dao = new JpaTripDao();
		return JSONValue.toJSONString(dao.findAll());
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String getSearch(String request) {
		JpaTripDao dao = new JpaTripDao();
		return JSONValue.toJSONString(dao.findByCampus(request));
	}
}
