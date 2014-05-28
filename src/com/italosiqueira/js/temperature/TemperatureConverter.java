package com.italosiqueira.js.temperature;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TemperatureConverter
 */
@WebServlet("/TemperatureConverter")
public class TemperatureConverter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TemperatureConverter() {
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
		int inputTemp = 0;
		String inputTempType = null;
		int outputTemp = 0;
		String outputTempType = null;

		if (request.getParameter("temp") == null) {
			inputTemp = 0;
		} else {
			inputTemp = Integer.parseInt(request.getParameter("temp"));
		}

		if (request.getParameter("tempType") == null) {
			inputTempType = "";
		} else {
			inputTempType = request.getParameter("tempType");
		}

		if ("f2c".equalsIgnoreCase(inputTempType)) {
			outputTemp = (inputTemp - 32) * (5 / 9);
			outputTempType = "C";
		}

		if ("c2f".equalsIgnoreCase(inputTempType)) {
			outputTemp = inputTemp * (9 / 5) + 32;
			outputTempType = "F";
		}

		String str = "{ \"Temp\": \"" + outputTemp + "\", "
				+ " \"TempType\": \"" + outputTempType + "\" " + "}";

		PrintWriter writer = response.getWriter();
		response.setContentType("text/plain");

		writer.print(str);
		writer.flush();
		writer.close();
	}
}
