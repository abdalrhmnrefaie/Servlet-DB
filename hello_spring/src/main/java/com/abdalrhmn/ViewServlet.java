package com.abdalrhmn;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		response.setContentType("text/html");
		PrintWriter printWriter=response.getWriter();
		
		printWriter.print("<head>");
		printWriter.print("<link href='css/bootstrap.min.css' rel='stylesheet'>");
		printWriter.print("</head>");
		printWriter.print("<body>");
		printWriter.print("<a href='index.html'class='btn btn-info'role='button'>Add Product</a>");
		
		printWriter.print("<h1> Product Taple </h1>");

		List<Product> list=ProductDB.getProducts();
		
		printWriter.print("<table border='1' width='100%'>");
		printWriter.print("<tr><th>id</th><th>name</th>"
				+ "<th>price</th><th>Edit</th><th>Delete</th></tr>");
		
		for (Product product : list) {
			printWriter.print("<tr><td>"+product.getId()+"</td><td>"+product.getName()
			+"</td><td>"+product.getPrice()+"</td><td><a href='updateServelt?id="+product.getId()
		  +"'>edit</a></td> <td><a href='deleteServlet?id="+product.getId()+"'>delete</a></td></tr>");
		}
		printWriter.print("</table>");
		printWriter.print("</body>");
		
		
		
		
		
		
		
		
		
		
		
	}

}
