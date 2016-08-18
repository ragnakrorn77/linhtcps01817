package com.atp.moneymanager.DoiTuong;

import android.graphics.Bitmap;

public class DoiTuongThongkeTietKiem {
	
	
	public String date;
	public String tien;
	public int rut_gui; // 0 : ko co gi, 1 : ban dang no , 2 : dang no ban;
	
	public DoiTuongThongkeTietKiem(String date,String tien,int rut_gui)
	{
		
		this.date = date;
		this.tien = tien;
		this.rut_gui = rut_gui;
	}
	
	
	
	
}
