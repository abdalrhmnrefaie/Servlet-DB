package com.abdalrhmn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updateServelt
 */
@WebServlet("/updateServelt")
public class updateServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter=response.getWriter();
		printWriter.println("<h1> UpDate Info </h1>");
		String Proudectid=request.getParameter("id");
		int id=Integer.parseInt(Proudectid);
		
		Product product=ProductDB.getProductId(id);
		printWriter.print("<head>");
		printWriter.print("<link href='css/bootstrap.min.css'rel='stylesheet'>");
		printWriter.print("</head>");
		printWriter.print("<body>");
		printWriter.print("<form action='UpdateServlet2' method='post'>");
		printWriter.print("<taple>");
		printWriter.print("<tr><td>Id : </td><td><input name='id' value='"+product.getId()+"'/></td></tr><br><br>");
		
		printWriter.print("<tr><td>Name : </td><td><input type='text' name='name' value='"+product.getName()+"'/></td></tr><br><br>");
		
		printWriter.print("<tr><td>Price : </td><td><input type='number' name='price' value='"+product.getPrice()+"'/></td></tr><br><br>");
		
		printWriter.print("</td></tr>");
		printWriter.print("<tr><td colspan='2'><input type='submit' value='submit'/></td></tr>");
		printWriter.print("</taple>");
		printWriter.print("</form>");
		printWriter.print("</body>");





		
		
		
		
		
	}

	
}
