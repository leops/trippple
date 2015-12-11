package com.traveloid.trippple.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.traveloid.trippple.dao.jpa.JpaUserDao;
import com.traveloid.trippple.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id = null;
		try {
			id = Long.parseLong(request.getParameter("id"));
		} catch (ParseException exception )
		{
			exception.printStackTrace();
		}
		String password = request.getParameter("password");
		HttpSession session = request.getSession(); // récupère la session associée à la requête, ou en créé une s'il n'y a pas de session
		
		JpaUserDao userdao = new JpaUserDao();
		User userInDb = userdao.findById(id);
		if(id.equals(userInDb.getId()) && userInDb.comparePassword(password))
		{
			Cookie cookie = new Cookie("id", id.toString());
			session.setAttribute("id", id);
		}
		
	}

}
