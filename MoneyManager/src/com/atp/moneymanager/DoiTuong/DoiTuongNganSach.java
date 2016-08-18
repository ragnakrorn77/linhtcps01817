package com.atp.moneymanager.DoiTuong;

public class DoiTuongNganSach { 
	
	private int _id;
	private String ten;
	private int tien;
	private String icon;
	
	public DoiTuongNganSach(int _id,String ten,int tien,String icon)
	{
		this._id = _id;
		this.ten = ten;
		this.tien = tien;
		this.icon = icon;
	}
	
	public int GetId()
	{
		return this._id;
	}
	
	public String GetTen()
	{
		return this.ten;
	}
	
	public int GetTien()
	{
		return this.tien;
	}
	
	
	public String GetIcon()
	{
		return this.icon;
	}
	
	
}
