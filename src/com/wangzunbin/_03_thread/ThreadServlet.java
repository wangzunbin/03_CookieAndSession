package com.wangzunbin._03_thread;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet 操作成员变量不安全
 * @author Administrator
 *
 */
@WebServlet("/thread")
public class ThreadServlet extends HttpServlet implements SingleThreadModel{

	/**
	 * 下面的数据就会有线程安全问题
	 * 1.实现SingleThreadModel此接口, 就可以解决了
	 */
	private static final long serialVersionUID = 5251504887056037910L;
	private String name = "wangzunbin";
	private int i = 0;
	 
     @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	super.service(req, resp);
    	i ++;
    	try {
    		name = "wangdacui" + i;
			Thread.sleep(4000);
			System.out.println(name);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
     }
}
