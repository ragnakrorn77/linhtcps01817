package com.atp.moneymanager.DoiTuong;

public class DoiTuongLoaiHinhThu { 
	
	private int ma_thu;
	private String ten;
	private String icon;
	
	public DoiTuongLoaiHinhThu(int ma_thu,String ten,String icon)
	{
		this.ma_thu = ma_thu;
		this.ten = ten;
		this.icon = icon;
	}
	
	public int GetId()
	{
		return this.ma_thu;
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
