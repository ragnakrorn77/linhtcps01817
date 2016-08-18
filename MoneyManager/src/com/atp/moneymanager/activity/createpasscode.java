package com.atp.moneymanager.activity;

import java.util.ArrayList;

import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView.OnItemClickListener;
import nAdapter.LoaiHinhChiAdapter;
import nAdapter.LoaiHinhThuAdapter;
import nAdapter.VayNoAdapter;

import com.atp.moneymanager.BootComplete;
import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.DoiTuong.DoiTuongLoaiHinhChi;
import com.atp.moneymanager.DoiTuong.DoiTuongLoaiHinhThu;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
public class createpasscode extends Activity {
	
	public static PopupWindow popupWindow;
	static String msgtaikhoan = "Tài khoản không được để trống";
	static String msgbaomat = "Mã bảo mật không được để trống";
	static String Notifycation = "Thông báo";
	public static RelativeLayout back_dim_layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.createpasscode);	
		
		back_dim_layout = (RelativeLayout)findViewById(R.id.bac_dim_layout);
		final TextView txtDate = (TextView)findViewById(R.id.txtDate);
		if (FuncDungChung.GetLanguage(this) == 0)
		 {
			 txtDate.setText("Set pass code to block app's screen");
		 }
		final EditText edt1 = (EditText)findViewById(R.id.editText1);
		edt1.setText(FuncDungChung.getPasscode());
		final Button onoff=(Button)findViewById(R.id.onoff);
		final Button set=(Button)findViewById(R.id.set);
		final LinearLayout LinearLayout10 = (LinearLayout)findViewById(R.id.LinearLayout10);
		final LinearLayout LinearLayout11 = (LinearLayout)findViewById(R.id.LinearLayout11);
		if (FuncDungChung.getStatePasscode())
		{
			LinearLayout10.setVisibility(View.VISIBLE);
			LinearLayout11.setVisibility(View.VISIBLE);
			onoff.setBackgroundResource(R.drawable.buttonpopup);
			 onoff.setText("ON");
		}
		
		
		
		onoff.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				boolean state = FuncDungChung.getStatePasscode();
				 if (!state)
				 {
					 onoff.setBackgroundResource(R.drawable.buttonpopup);
					 onoff.setText("ON");
					 FuncDungChung.setStatePasscode(1);
					 LinearLayout10.setVisibility(View.VISIBLE);
					 LinearLayout11.setVisibility(View.VISIBLE);
					 
				 }
				 else
				 {
					 onoff.setBackgroundResource(R.drawable.buttonoff);
					 onoff.setText("OFF");
					 FuncDungChung.setStatePasscode(0);
					 LinearLayout10.setVisibility(View.GONE);
					 LinearLayout11.setVisibility(View.GONE);
				 } 
				
				 
			}
		});
        
		set.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String passcode = edt1.getText().toString();
				FuncDungChung.SetPasscode(passcode);
				 if (FuncDungChung.getStatePasscode())
				 {
					 popupWindow = FuncDungChung.ShowPopupThongBao(createpasscode.this, createpasscode.back_dim_layout, createpasscode.back_dim_layout, "Seted", "Notification");
					 
				 }
				 else
				 {
					 popupWindow = FuncDungChung.ShowPopupThongBao(createpasscode.this, createpasscode.back_dim_layout, createpasscode.back_dim_layout, "Đã set", "Thông báo");
				 }	
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
