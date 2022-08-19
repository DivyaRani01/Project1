/*
  @author Divya
  Illustrating banking operation using Regular Expression and Exception Handling
 
 */
package com.banking;

import java.util.Scanner;
import static java.lang.System.*;

import com.bankApp.controller.bankController;
import com.bankApp.model.bankModel;

public class App 
{    //main method for our banking application
    public static void main( String[] args )
    {
    	//creating object for bankcontroller as well as bank model
        bankController bc =new bankController();
        bankModel bm = new bankModel();
        
        //Creating scanner object for taking input from the user
        Scanner obj=new Scanner(System.in);
        
        out.println("\t\t\t\t____________________WELCOME TO BANKING APPLICATION_____________________");
        
        out.println("\n\t\t*Kindly provide the following Inforamation*");
        
        //here we are taking input from user- Name ,account number ,account balance etc.
        out.println("\nEnter the Account holder Name!");
        String accHolderName = obj.next();
        bm.setAccHolderName(accHolderName);bm.getAccHolderName();         //calling get set method for accHolder name 
        
        out.println("Enter Your Account Number ");
        int accNum = obj.nextInt();
        bm.setAccNum(accNum); bm.getAccNum();       //calling get set method for accnumber
        out.println("Enter Your Amount : ");
        int accBal = obj.nextInt();
        bm.setAccBal(accBal); bm.getAccBal();        //calling get set method for accBalance
        out.println("Enter Your Password : ");
        String accPswd = obj.next();
        bm.setAccPswd(accPswd); bm.getAccPswd();     //calling get set method for accPassword
        
        //using exception handling 
        try
        {
        	if(bc.checkUserName(bm)) {
        		try {	     			
        			// Checking validity of Password
        			if(bc.checkPswd(bm)) {
        				out.println(" --------Your Account Details------- ");
        				
        				// Calling toString method to print Account Details.
        				out.println(bm.toString());
        				
        				int choice = 0;
        				while(choice<3) {
        					out.println("Enter 1 to Withdraw Amount\nEnter 2 to Deposit Amount \nEnter 3 to Exit *****");
        					choice = obj.nextInt();
        				// Using switch case to perform user selected operation
        				switch(choice) {
        				case 1 :	 out.println("Enter Your Password");
        							 String pswd  = obj.next();
        							 bm.setUserPswd(pswd); bm.getUserPswd();
        					try {
        						// ---------------Matching Password
        						if(bc.verifyPswd(bm)) {
        							out.println("Enter Amount : ");
        							int amount = obj.nextInt();
        							bm.setAmount(amount); bm.getAmount();
        							try {
        								// Checkinguser's balance having sufficient amount to withdraw.
        								if(bc.checkBal(bm)) {
        									out.println("----------\nAccount Balance  "+bm.getAmtWithdraw());
        									bm.setAccBal(bm.getAmtWithdraw()); // Updating Account Balance
        								}
        							}
        							// throwing exception if Amount is more than balance.
        							catch(Exception e) {
                						out.println(e.getMessage());
        							}	
        						}
        					}
        					// Throwing Exception if Password does'nt match.
        					catch(Exception e) {
        						out.println(e.getMessage());	
        					}
        					break;
        					
        					case 2 :	 out.println("Enter Password");
        								pswd  = obj.next();
        								bm.setUserPswd(pswd); bm.getUserPswd();
        					try {
        						// Matching Password
        						if(bc.verifyPswd(bm)) {
        							out.println("Enter Amount : ");
        							int amount = obj.nextInt();
        							bm.setAmount(amount); bm.getAmount();
        									out.println("----------\nAccount Balance : "+bm.getAmtDeposit());
        									bm.setAccBal(bm.getAmtDeposit()); // Updating Account Balance
        							}
        						}
        						// throwing exception if Amount is more than balance.
        						catch(Exception e) {
        							out.println(e.getMessage());	
        						}
        					break;
        					
        					case 3 :
        						out.println("----------\nAccount Details : ");
                				
                				// Calling toString method to print Account Details.
                				out.println(bm.toString());
        					
        					default : System.exit(0);
        				}
        			}
        		}
        	}
        	// Throwing Exception if Password is Invalid
        	catch(Exception e){
        			out.println(e.getMessage());
        		}
        	}
        }
        // Throwing Exception if Name is Invalid
        catch (Exception e) {
        	out.println(e.getMessage());      	
        }
        obj.close();
    }

    
}
