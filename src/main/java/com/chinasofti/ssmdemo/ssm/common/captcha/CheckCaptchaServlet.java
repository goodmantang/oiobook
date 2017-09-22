package com.chinasofti.ssmdemo.ssm.common.captcha;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckCaptchaServlet
 */
@WebServlet("/check")
public class CheckCaptchaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String captcha=request.getParameter("captcha");
		Object captchaObj = request.getSession().getAttribute("captcha");
		System.out.println(captcha.length());
		if(captchaObj!=null&&captcha.length()>0){
			
			response.getWriter().print(((String)captchaObj).equalsIgnoreCase(captcha));
		}
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
