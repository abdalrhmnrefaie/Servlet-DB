package com.abdalrhmn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {
	
	public static Connection getConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost/servletdb";
			connection=DriverManager.getConnection(url,"abdalrhmn123456","abdalrhmn123456");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}
	
	public static int save(Product product) {
		int p=0;
		
		try {
			String sql="INSERT INTO `productinfo`(`name`, `price`) VALUES (?,?)";
			Connection connection=ProductDB.getConnection();
			PreparedStatement  preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setDouble(2, product.getPrice());

			
			p=preparedStatement.executeUpdate();
			preparedStatement.close();
			
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return p;
		}
	
	
   public static int update(Product product) {
		int p=0;
		
		try {
			String sql="UPDATE `productinfo` SET `name`=?,`price`=? WHERE id=?";
			Connection connection=ProductDB.getConnection();
			PreparedStatement  preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setString(1, product.getName());
			preparedStatement.setDouble(2, product.getPrice());
			preparedStatement.setInt(3, product.getId());
			p=preparedStatement.executeUpdate();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return p;
		}
   

	
   public static int delete(int id) {
		int p=0;
		
		try {
			String sql="DELETE FROM `productinfo` WHERE id=?";
			Connection connection=ProductDB.getConnection();
			PreparedStatement  preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			p=preparedStatement.executeUpdate();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return p;
		}
   
  
   public static Product getProductId(int id) {
	   Product product=new Product();
		
		try {
			String sql=" SELECT * FROM `productinfo` WHERE id=?";
			Connection connection=ProductDB.getConnection();
			PreparedStatement  preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				product.setId(resultSet.getInt(1));
				product.setName(resultSet.getString(2));
				product.setPrice(resultSet.getDouble(3));

			}
			
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return product;
		}
   
   
   
   public static List<Product> getProducts() {
	   List<Product> list=new ArrayList<Product>();
		
		try {
			String sql=" SELECT * FROM `productinfo`WHERE 1";
			Connection connection=ProductDB.getConnection();
			PreparedStatement  preparedStatement=connection.prepareStatement(sql);
	
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Product product=new Product();
				product.setId(resultSet.getInt(1));
				product.setName(resultSet.getString(2));
				product.setPrice(resultSet.getDouble(3));
				list.add(product);

			}
			
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return list;
		}
   
   

}
