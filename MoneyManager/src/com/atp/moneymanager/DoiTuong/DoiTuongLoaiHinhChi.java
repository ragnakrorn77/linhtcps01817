package com.atp.moneymanager.DoiTuong;

public class DoiTuongLoaiHinhChi { 
	
	private int ma_chi;
	private String ten;
	private String icon;
	
	public DoiTuongLoaiHinhChi(int ma_chi,String ten,String icon)
	{
		this.ma_chi = ma_chi;
		this.ten = ten;
		this.icon = icon;
	}
	
	public int GetId()
	{
		return this.ma_chi;
	}
	
	public String GetTen()
	{
		return this.ten;
	}
	
	public String GetIcon()
	{
		return this.icon;
	}
	
	
}
