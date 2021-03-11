package com.cg.customerjparest.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.customerjparest.entities.Buyer;
import com.cg.customerjparest.exception.InvalidArgumentException;
import com.cg.customerjparest.exception.InvalidCustomerIdException;
import com.cg.customerjparest.exception.InvalidCustomerNameException;


public class ValidationUtil {


	public static boolean validateBuyer(Buyer buyer) {
		
		if(validatePhone(buyer.getPhoneNumber())&& validatePassword(buyer.getPassword())&& validateName(buyer.getName())&& validateEmail(buyer.getEmail())) {
			return true;
		}
		
		
		return false;
	}
	public static boolean validateName(String name) {
		
		String space = " ";
		Pattern alpha = Pattern.compile("[a-zA-Z\\s]*$");
		Matcher hasAlpha = alpha.matcher(name);
		if(name.endsWith(space) || name.startsWith(space) ) {
			return false;
		}
		else if (hasAlpha.find() == false) {
			return false;
		}
		return true;
	}
	public static boolean validateEmail(String email) {

		String emailRegex = "^(.+)@(.+)$";  
		Pattern pattern = Pattern.compile(emailRegex);  
		Matcher emailMatcher = pattern.matcher(email);  
		if(emailMatcher.find() == false) {
			return false;
		}
		return true;
		
	}
	public static boolean validatePhone(String phoneNumber) {
		String phoneRegex = "(0/91)?[7-9][0-9]{9}";
		Pattern pattern2 = Pattern.compile(phoneRegex);  
		Matcher phoMatcher = pattern2.matcher(phoneNumber); 
		if(phoMatcher.find()==false) {
			return false;
		}
		return true;
	}
	public static boolean validatePassword(String password) {
		 String passwordRegex = "^(?=.*[0-9])"+ "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{7,20}$"; 
		 Pattern pattern3 = Pattern.compile(passwordRegex);  
		Matcher passMatcher = pattern3.matcher(password);
		if(passMatcher.find()==false) {
			return false;
		}
		return true;
	}
	public static boolean validateBuyer(String email) {
		if(validateEmail(email)) {
			return true;
		}
		return false;
	}

}
