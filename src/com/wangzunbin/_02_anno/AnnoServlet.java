package com.wangzunbin._02_anno;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(value= {"/anno", "/anno2"}, loadOnStartup=0,
	initParams= {@WebInitParam(name="encoding", value="UTF-8")})
public class AnnoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5829543851087910004L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("初始化的encoding:  " + getInitParameter("encoding"));
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		System.out.println("收到请求了.,..................................");
	}
}
