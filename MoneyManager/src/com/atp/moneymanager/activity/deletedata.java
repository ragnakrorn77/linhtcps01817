package com.atp.moneymanager.activity;

import java.util.ArrayList;

import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView.OnItemClickListener;
import nAdapter.LoaiHinhChiAdapter;
import nAdapter.LoaiHinhThuAdapter;
import nAdapter.VayNoAdapter;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.DoiTuong.DoiTuongLoaiHinhChi;
import com.atp.moneymanager.DoiTuong.DoiTuongLoaiHinhThu;
import com.atp.moneymanager.Thread.AsyncDelete;
import com.atp.moneymanager.Thread.upload;
import com.atp.moneymanager.fragment.Chi;
import com.atp.moneymanager.fragment.Thu;
import com.atp.moneymanager.fragment.vayno;
import com.atp.moneymanager.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
public class deletedata extends Activity {
	
	public static PopupWindow popupWindow;
	static String Notifycation = "Thông báo";
	public static RelativeLayout back_dim_layout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.deletedata);	
		final RelativeLayout loading = (RelativeLayout)findViewById(R.id.loading);
		final LinearLayout linearLayout1 = (LinearLayout)findViewById(R.id.linearLayout1);
		back_dim_layout = (RelativeLayout)findViewById(R.id.bac_dim_layout);
		final TextView txtDate = (TextView)findViewById(R.id.txtDate);
		if (FuncDungChung.GetLanguage(this) == 0)
		 {
			 txtDate.setText("All your data will be delete.Are you sure ? ");
		 }
        
		final Button onoff=(Button)findViewById(R.id.onoff);
		onoff.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String user = FuncDungChung.GetUser();
				AsyncDelete reg = new AsyncDelete(deletedata.this,user,loading,linearLayout1);
				reg.execute();
			}
		});
        
		
		
        final RelativeLayout back=(RelativeLayout)findViewById(R.id.back);
		back.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				BackToMain();
			}
		});
      
	}
	
	
	void BackToMain()
	{
		super.onBackPressed();
	}
}
