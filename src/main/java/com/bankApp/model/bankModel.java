package com.bankApp.model;

public class bankModel {
	private int accNum;
	private int amount, accBal;
	private String accPswd ,accHolderName ,userPswd;
	
	/**
	 * @return the accNum
	 */
	public int getAccNum() {
		return accNum;
	}

	/**
	 * @param accNum the accNum to set
	 */
	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the accBal
	 */
	public int getAccBal() {
		return accBal;
	}

	/**
	 * @param accBal the accBal to set
	 */
	public void setAccBal(int accBal) {
		this.accBal = accBal;
	}

	/**
	 * @return the accPswd
	 */
	public String getAccPswd() {
		return accPswd;
	}

	/**
	 * @param accPswd the accPswd to set
	 */
	public void setAccPswd(String accPswd) {
		this.accPswd = accPswd;
	}

	/**
	 * @return the accHolderName
	 */
	public String getAccHolderName() {
		return accHolderName;
	}

	/**
	 * @param accHolderName the accHolderName to set
	 */
	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	/**
	 * @return the userPswd
	 */
	public String getUserPswd() {
		return userPswd;
	}

	/**
	 * @param userpswd the userpswd to set
	 */
	public void setUserPswd(String userPswd) {
		this.userPswd = userPswd;
	}

	@Override
	public String toString() {
		return "bankModel [accNum=" + accNum + ", amount=" + amount + ", accBal=" + accBal + ", accPswd=" + accPswd
				+ ", accHolderName=" + accHolderName + ", userPswd=" + userPswd + "]";
	}

	public int getAmtDeposit() {
		return this.accBal+=amount;
	}
	
	public int getAmtWithdraw() {
		return this.accBal-=amount;
	}
	
	

}
