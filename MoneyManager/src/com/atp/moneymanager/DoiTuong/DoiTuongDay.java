package com.atp.moneymanager.DoiTuong;

public class DoiTuongDay { 
	
	private String Date;
	private String dayofweek;
	private String Thu;
	private String Chi;
	public DoiTuongDay(String Date,String dayofweek,String Thu,String Chi)
	{
		this.Date = Date;
		this.dayofweek = dayofweek;
		this.Thu = Thu;
		this.Chi = Chi;
	}
	
	public DoiTuongDay()
	{
		
	}
	
	public String GetDate()
	{
		return this.Date;
	}
	
	
	public String Getdayofweek()
	{
		return this.dayofweek;
	}
	
	public String GetThu()
	{
		return this.Thu;
	}
	
	public String GetChi()
	{
		return this.Chi;
	}
	
	
	public void SetDate(String Date)
	{
		this.Date = Date;
	}
	
	
	public void Setdayofweek(String dayofweek)
	{
		this.dayofweek = dayofweek;
	}
	
	public void SetThu(String Thu)
	{
		this.Thu = Thu;
	}
	
	public void SetChi(String Chi)
	{
		this.Chi = Chi;
	}
}
