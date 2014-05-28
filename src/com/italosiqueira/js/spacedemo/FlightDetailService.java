package com.italosiqueira.js.spacedemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FlightDetailService
 */
@WebServlet("/FlightDetailService")
public class FlightDetailService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlightDetailService() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String flightID = request.getParameter("flightID");

		String outputStr;

		if (flightID == null || flightID.isEmpty()) {
			flightID = "Unknown";
		}

		if ("flight0".equalsIgnoreCase(flightID)) {
			outputStr = "1 minute";
		} else if ("flight1".equalsIgnoreCase(flightID)) {
			outputStr = "5 Days";
		} else if ("flight2".equalsIgnoreCase(flightID)) {
			outputStr = "7 Days";
		} else if ("flight3".equalsIgnoreCase(flightID)) {
			outputStr = "8 Days";
		} else if ("flight4".equalsIgnoreCase(flightID)) {
			outputStr = "9 Days";
		} else if ("flight5".equalsIgnoreCase(flightID)) {
			outputStr = "12 Days";
		} else {
			outputStr = "15 Days";
		}

		String str = "{ \"duration\": \"" + outputStr + "\"}";
		
		PrintWriter writer = response.getWriter();
		response.setContentType("text/plain");

		writer.print(str);
		writer.flush();
		writer.close();
	}
}
