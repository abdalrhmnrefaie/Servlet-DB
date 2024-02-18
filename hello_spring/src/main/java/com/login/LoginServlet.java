package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.validations.CheckValidateUser;

@WebServlet (urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	
    private	CheckValidateUser checkuser =new CheckValidateUser();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		//System.out.println(req.getParameter("name"));
		req.setAttribute("name",req.getParameter("name") );
		req.setAttribute("password",req.getParameter("password") );

	req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
	
	
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		String userName=req.getParameter("name") ;
		String password=req.getParameter("password") ;
		
	     boolean isValidate =checkuser.checkUser(userName, password);
		
		if (isValidate) {
			     req.setAttribute("name",userName);
			     req.setAttribute("password",password);
					req.getRequestDispatcher("index.html").forward(req, resp);
		} else {
			req.setAttribute("errorMassage","isvalid userName or password");
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
		}
	}
}
