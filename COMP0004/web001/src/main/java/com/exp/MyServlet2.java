package com.exp;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/testServlet"}, loadOnStartup = 1)
public class MyServlet2 extends HttpServlet {

	public MyServlet2()
	{
		System.out.println("A servlet instance has been created.");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("My Servlet2.java  init() executed.");
	}

	//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.service(req, resp);
//	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
		System.out.println("doGet() executed.");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);

		System.out.println("doPost() executed.");

		req.setCharacterEncoding("UTF-8");
		System.out.println(req.getParameter("Text"));
		System.out.println(req.getParameter("gender"));

		String[] games = req.getParameterValues("entertainment");
		for(String game : games)
			System.out.println(game);

		System.out.println(req.getParameter("comment"));
		System.out.println("Your Option:" + req.getParameter("words"));

		System.out.println("--- Worked out.---");

		req.getRequestDispatcher("destination.html").forward(req, resp);
//		resp.sendRedirect("destination.html");

	}



//	@Override
//	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		System.out.println("Service() executed.");
//	}

	@Override
	public void destroy() {
		System.out.println("My Servlet2.java  destroy() executed.");
	}
}
