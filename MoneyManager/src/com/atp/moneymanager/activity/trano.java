package com.atp.moneymanager.activity;

import java.util.ArrayList;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.DoiTuong.DoiTuongVayNo;
import com.atp.moneymanager.fragment.vayno;
import com.atp.moneymanager.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
public class trano extends Activity {
	
	public static PopupWindow popupWindow;
	
	public static RelativeLayout back_dim_layout;
	TextView txtNganSach;
	TextView txtpopupTien;
	static String msg = "Đã Thêm";
	static String Notifycation = "Thông báo";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.trano);	
		
		Bundle b = getIntent().getExtras();
		String Tien = b.getString("tien");
		final int xloai_hinh = b.getInt("xloai_hinh");
		String who = b.getString("who");
		final int id = b.getInt("id");
		
		final TextView txtDate = (TextView)findViewById(R.id.txtDate);
        txtDate.setText(FuncDungChung.Date);
        final TextView txt2 = (TextView)findViewById(R.id.textView2);
        final TextView txt3 = (TextView)findViewById(R.id.textView3);
        final TextView txt4 = (TextView)findViewById(R.id.textView4);
	
		final TextView txttien = (TextView)findViewById(R.id.txtTien);
		txttien.setText(FuncDungChung.formatso(Tien));
		final TextView txtGhiChu = (TextView)findViewById(R.id.txtGhiChu);
		
		if (FuncDungChung.GetLanguage(this) == 0)
		{
			if (xloai_hinh == 1) txtGhiChu.setText("You lent for " + who);
	    	else txtGhiChu.setText(who + " lent for you");
		}
		else
		{
			if (xloai_hinh == 1) txtGhiChu.setText("Bạn trả nợ cho " + who);
	    	else txtGhiChu.setText(who + " trả nợ cho bạn");
		}
		
		txtNganSach = (TextView)findViewById(R.id.txtNganSach);
		final TextView txtcurrency = (TextView)findViewById(R.id.currency);
		final TextView title = (TextView)findViewById(R.id.title);
		
		
        txtcurrency.setText(FuncDungChung.currency);
        
		txtNganSach = (TextView)findViewById(R.id.txtNganSach);
		final RelativeLayout back=(RelativeLayout)findViewById(R.id.back);
		back.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				BackToMain();
			}
		});
		
		if (FuncDungChung.GetLanguage(this) == 0)
		{
			msg = "Saved";
        	Notifycation = "Notification";
        	title.setText("Lent");
        	txttien.setHint("Amount");
        	txtNganSach.setText("Wallet");
		}
        
        
		
		
		
		final Button btnSave = (Button)findViewById(R.id.Save);
        btnSave.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String Tien = txttien.getText().toString().replace(".", "");
				if (xloai_hinh == 1)
				{
					if (Integer.parseInt(Tien) > Integer.parseInt(FuncDungChung.getTienNganSach(FuncDungChung.ma_ngan_sach)))
					{
						if (FuncDungChung.GetLanguage(trano.this) == 0)
						{
							popupWindow = FuncDungChung.ShowPopupThongBao(trano.this,btnSave, back_dim_layout,"This budget no money",Notifycation);
						}
						else
						{
							popupWindow = FuncDungChung.ShowPopupThongBao(trano.this,btnSave, back_dim_layout,"Ngân Sách Này Không Đủ Tiền",Notifycation);
						}
						
						return;
					}
					FuncDungChung.UpdateDataChiNganSach(FuncDungChung.ma_ngan_sach,Integer.parseInt(Tien));
					FuncDungChung.InsertDataChi(txtDate.getText().toString(),Integer.parseInt(Tien),0,txtGhiChu.getText().toString(),FuncDungChung.ma_ngan_sach);
					String tachdate[] = txtDate.getText().toString().split(" ");		
					FuncDungChung.CreateDate(tachdate[1]);
					FuncDungChung.UpdateDataVayNo(id);
				}
				else
				{
					FuncDungChung.UpdateDataThuNganSach(FuncDungChung.ma_ngan_sach,Integer.parseInt(Tien));
					FuncDungChung.InsertDataThu(txtDate.getText().toString(),Integer.parseInt(Tien),0,txtGhiChu.getText().toString(),FuncDungChung.ma_ngan_sach);
					String tachdate[] = txtDate.getText().toString().split(" ");		
					FuncDungChung.CreateDate(tachdate[1]);
					FuncDungChung.UpdateDataVayNo(id);
				}
				
				ArrayList<DoiTuongVayNo> list = FuncDungChung.GetAllVayNo();
				vayno.adapter.setData(list);
				vayno.adapter.notifyDataSetChanged();
				BackToMain();
			}
		});
        
        
		final RelativeLayout btnNganSach = (RelativeLayout)findViewById(R.id.btnNganSach);
        btnNganSach.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				Intent mainactivity = new Intent(trano.this, chonngansach.class);
				trano.this.startActivity(mainactivity);
			}
		});
        
        
	        
	        
	        
		final RelativeLayout btnDate = (RelativeLayout)findViewById(R.id.btnDate);
        btnDate.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				System.out.println("dsdsad");
				popupWindow = FuncDungChung.ShowPopupDate(trano.this,back_dim_layout,btnDate,txtDate);
			}
		});
		
		
		
		
		back_dim_layout = (RelativeLayout)findViewById(R.id.bac_dim_layout);
		
		back_dim_layout.setOnClickListener(new View.OnClickListener(){

	     	   @Override
	     	   public void onClick(View arg0) {
	     		  popupWindow.dismiss();
	     		 back_dim_layout.setVisibility(View.GONE);
	     	
	     	   }
	        });
		
		final TextView txt1 = (TextView)findViewById(R.id.textView1);
		final TextView txtdate = (TextView)findViewById(R.id.textdate);
		
		txtNganSach.setText(FuncDungChung.Ngan_Sach);
		if (FuncDungChung.GetLanguage(this) == 0)
		{
        	txt2.setText("Note");
    
        	txt3.setText("Account To");
        	
        	txt4.setText("Date");
        	
		}
	}
	
	@Override
	public void onResume() {
    	txtNganSach.setText(FuncDungChung.Ngan_Sach);
		super.onResume();
	}
	
	void BackToMain()
	{
		super.onBackPressed();
	}
}
