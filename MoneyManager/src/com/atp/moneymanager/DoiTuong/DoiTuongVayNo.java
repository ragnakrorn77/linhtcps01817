package com.atp.moneymanager.DoiTuong;

public class DoiTuongVayNo {
	private int _id;
	private String date;
	private int Tien;
	private String who;
	private String ghi_chu;
	private int loai_hinh;//1 la ban no,2 la no ban // ban no la thu tien,no ban la chi tien
	private int giai_quyet; //1 la chua giai quyet ,2 la giai quyet
	private int ma_ngan_sach;
	public DoiTuongVayNo(int _id,String date,int Tien,String who,String ghi_chu,int loai_hinh,int giai_quyet,int ma_ngan_sach)
	{
		this._id = _id;
		this.date = date;
		this.Tien = Tien;
		this.who = who;
		this.ghi_chu = ghi_chu;
		this.loai_hinh = loai_hinh;
		this.giai_quyet = giai_quyet;
		this.ma_ngan_sach = ma_ngan_sach;
	}
	
	public int GetId()
	{
		return this._id;
	}
	
	public String GetDate()
	{
		return this.date;
	}
	
	public int GetTien()
	{
		return this.Tien;
	}
	
	public String GetTen()
	{
		return this.who;
	}
	
	
	public String GetGhiChu()
	{
		return this.ghi_chu;
	}
	
	
	public int GetTrangThai()
	{
		return this.loai_hinh;
	}
	
	public int GetGiaiQuyet()
	{
		return this.giai_quyet;
	}
	
	public int GetMaNganSach()
	{
		return this.giai_quyet;
	}
}
