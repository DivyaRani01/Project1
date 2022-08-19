package com.bankApp.controller;

//importing required packages to be used bank controller class
import java.io.IOException;
import java.util.regex.Pattern;
import com.bankApp.model.bankModel;

public class bankController {
	//checkuserName to check validity of userName
	public boolean checkUserName(bankModel bm) throws IOException{
		String userName = bm.getAccHolderName();
		// creating matching standard using if else
		if(Pattern.matches("[a-zA-z0-9 ]{5,12}", userName)) // use of regular expression
		{
			return true;
		}
		else {
			// here creating exception that occus when username is not under the correct pattern or standard.
			throw new IOException ("Exception : Invalid Username !! \n\t\tUsername can have only alphanumeric and should be under 12 letters......!");
		}
	}

	// checkPswd method to check validity of Password
	public boolean checkPswd(bankModel bm) throws IOException{
		String userPswd = bm.getAccPswd();
		//creating matching standard using if else
		if(Pattern.matches("[a-zA-Z0-9#@ ]{6,}", userPswd)) //use of regular expression
		{
			return true;
		}
		else {
			//here creating exception that occur when password is not fit under above standard format
			throw new IOException ("Exception : Invalid Password !! \n\t\tPassword can only have alphanumeric and should have atleast 6 characters...!");
		}
	}
	
	//verifying password to match given password to user password.
	public boolean verifyPswd(bankModel bm) throws IOException{
		String userPswd = bm.getAccPswd();
		String check = bm.getUserPswd();
		// matching password
		if(userPswd.equals(check)) {
			return true;
		}
		else {
			//exception that might occur if password  not match
			throw new IOException ("Exception : Password You Entered is Incorrect..!");
		}
	}
	
	//checkBal to check if Amount exceed the Withdraw Limit
	public boolean checkBal(bankModel bm) throws IOException{
		int balance = bm.getAccBal();
		int amount = bm.getAmount();
		//Checking users balance
		if(balance>amount) {
			return true;
		}
		else {
			// exception that might occur when balance is less than amount
			throw new IOException("Exception : Amount exceed the Withdraw Limit \nBalance Insufficient !!");
		}
	}
	

}
