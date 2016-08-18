package com.atp.moneymanager.DoiTuong;

import android.graphics.Bitmap;

public class DoiTuongThongkeDetail {
	
	public int section;// 1 : section,0 : ko section
	public String ten_section;
	public String ghichu;
	public String date;
	public String who;
	public int dang; // 0 : thu,1 : chi, 2: ban dang no,3:dang no ban
	public String tien;
	public int vay_no; // 0 : ko co gi, 1 : ban dang no , 2 : dang no ban;
	public String ngansach;
	public int id;
	public DoiTuongThongkeDetail(int id,int section,String ten_section,String ghichu,String date,String who,int vay_no,int dang,String tien,String ngansach)
	{
		this.id = id;
		this.section = section;
		this.ghichu = ghichu;
		this.date = date;
		this.who = who;
		this.dang = dang;
		this.tien = tien;
		this.ten_section = ten_section;
		this.vay_no = vay_no;
		this.ngansach = ngansach;
	}
	
	
	
	
}
