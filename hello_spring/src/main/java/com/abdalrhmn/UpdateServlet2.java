package com.abdalrhmn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet2
 */
@WebServlet("/UpdateServlet2")
public class UpdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter printWriter=response.getWriter();
		
		String Proudectid=request.getParameter("id");
		int id=Integer.parseInt(Proudectid);
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		double price1=Double.parseDouble(price);

		Product product=new Product();
		product.setId(id);
		product.setName(name);
		product.setPrice(price1);
		
		int num =ProductDB.update(product);
		if (num>0) {
			response.sendRedirect("ViewServlet");
		}else {
			printWriter.println("<h2> Sorry Not updated </h2> ");
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
