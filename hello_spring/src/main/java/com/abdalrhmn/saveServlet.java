package com.abdalrhmn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/saveServlet")
public class saveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public saveServlet() {
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter=response.getWriter();
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		double price1=Double.parseDouble(price);

		Product product=new Product();
		product.setName(name);
		product.setPrice(price1);
		
		int num =ProductDB.save(product);
		if (num>0 ) {
			printWriter.println("<h2> Saved Successfuly </h2>");
		//	request.getRequestDispatcher("index.html").include(request, response);

			
			// redirect
			response.sendRedirect("index.html");
		}else {
			printWriter.println("<h2> Sorry Not Saved </h2> ");
		}

	
	
	}

}
