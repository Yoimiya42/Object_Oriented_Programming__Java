package com.exp;

import jakarta.servlet.*;
//import jakarta.servlet.Servlet;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.ServletConfig;
//import jakarta.servlet.ServletException;

import java.io.IOException;

public class MyServlet implements Servlet {
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {

	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

	}

	@Override
	public String getServletInfo() {
		return "";
	}

	@Override
	public void destroy() {

	}
}
