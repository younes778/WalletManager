package com.example.WalletManager;

public class Date {
	
	public static enum  Mois{
		JANVIER, FEVRIER,  MARS, AVRIL, MAI , JUIN , JUILLET ,
		AOUT , SEPTEMBRE, OCTOBRE, NOVEMBRE, DECEMBRE		
	}
	

	
	private String day;
	private String month;
	private String year;
	public Date(String month, String day, String year) {
		super();
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	
	
	@Override
	public String toString() {
		return month +" "+ day +" "+ year;
	}



	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	

}
