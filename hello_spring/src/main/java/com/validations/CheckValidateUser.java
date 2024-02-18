package com.validations;

public class CheckValidateUser {
	
	public boolean checkUser(String name,String password) {
		
		if (name.equals("Abdalrhmn") && password.equals("12345")) {
			return true;
			
		} else {

			return false;
		}
		
	}
}
