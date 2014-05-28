package com.italosiqueira.js.spacedemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Flight
 */
@WebServlet("/Flight")
public class FlightService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlightService() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String str = "[ " + "{ \"trip\": \"Around the block\", "
				+ " \"price\": 10000 " + "}, "
				+ "{ \"trip\": \"Earth to Moon\", " + " \"price\": 50000 "
				+ "}, " + "{ \"trip\": \"Earth to Venus\", "
				+ " \"price\": 200000 " + "}, "
				+ "{ \"trip\": \"Earth to Mars\", " + " \"price\": 100000 "
				+ "}, " + "{ \"trip\": \"Venus to Mars\", "
				+ " \"price\": 250000 " + "}, "
				+ "{ \"trip\": \"Earth to Jupiter\", " + " \"price\": 300000 "
				+ "}, " + "{ \"trip\": \"Earth to Sun - One Way\", "
				+ " \"price\": 450000 " + "}, "
				+ "{ \"trip\": \"Earth to Neptune\", " + " \"price\": 475000 "
				+ "}, " + "{ \"trip\": \"Earth to Uranus\", "
				+ " \"price\": 499000 " + "} " + "]";
	    
		PrintWriter writer = response.getWriter();
		response.setContentType("text/plain");

		writer.print(str);
		writer.flush();
		writer.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
