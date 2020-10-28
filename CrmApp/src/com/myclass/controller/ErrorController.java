package com.myclass.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/error/403", "/error/404", "/error/500" })
public class ErrorController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getServletPath();
		switch (action) {
		case "/error/403":
			req.getRequestDispatcher("/WEB-INF/views/error/403.jsp")
			.forward(req, resp);
			break;
		case "/error/404":
			req.getRequestDispatcher("/WEB-INF/views/error/404.jsp")
			.forward(req, resp);
		case "/error/500":
			req.getRequestDispatcher("/WEB-INF/views/error/500.jsp")
			.forward(req, resp);
			break;
		default:
			break;
		}
	}
}
