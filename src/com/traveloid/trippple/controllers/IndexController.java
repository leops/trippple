package com.traveloid.trippple.controllers;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.traveloid.trippple.dao.TripDao;
import com.traveloid.trippple.dao.jpa.JpaTripDao;

/**
 * Servlet implementation class IndexController
 */
@WebServlet("/")
public class IndexController extends HttpServlet {
	/**
	 * Necessaire pour Serializable
	 */
	private static final long serialVersionUID = -5922364041527559015L;
	private TripDao dao = null;
	
	/**
	 * @throws ServletException 
	 * @see HttpServlet#init(ServletConfig config)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.dao = new JpaTripDao();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("trips", this.dao.findAll());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
