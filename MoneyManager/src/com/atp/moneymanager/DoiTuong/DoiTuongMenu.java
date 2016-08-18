package com.atp.moneymanager.DoiTuong;

import android.graphics.Bitmap;

public class DoiTuongMenu {
	private String tenmenu;
	private int Section;
	private Bitmap icon;
	public int ID;
	public DoiTuongMenu(String tenmenu,int Section,Bitmap icon)
	{
		this.tenmenu = tenmenu;
		this.Section = Section;
		this.icon = icon;
	}
	
	
	
	public String Gettenmenu()
	{
		return this.tenmenu;
	}
	
	public int GetSection()
	{
		return this.Section;
	}
	
	public Bitmap Geticon()
	{
		return this.icon;
	}
}
