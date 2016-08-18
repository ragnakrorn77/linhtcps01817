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
import com.atp.moneymanager.DoiTuong.DoiTuongNganSach;
import com.atp.moneymanager.Thread.AsyncChangePass;
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
public class changepass extends Activity {
	
	public static PopupWindow popupWindow;
	public static RelativeLayout back_dim_layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.changepass);	
		
		final RelativeLayout loading = (RelativeLayout)findViewById(R.id.loading);
		final LinearLayout linearLayout1 = (LinearLayout)findViewById(R.id.linearLayout1);
		back_dim_layout = (RelativeLayout)findViewById(R.id.bac_dim_layout);
		
		final TextView txt2 = (TextView)findViewById(R.id.textView2);
        final TextView txt3 = (TextView)findViewById(R.id.textView3);
        final EditText passcu = (EditText)findViewById(R.id.editText1);
		final EditText passmoi = (EditText)findViewById(R.id.editText2);
		
		
		if (FuncDungChung.GetLanguage(this) == 0)
		{
			txt2.setText("Old Password");
			txt3.setText("New Password");

		}
        
		final Button onoff =(Button)findViewById(R.id.onoff);
		onoff.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String user = FuncDungChung.GetUser();
				AsyncChangePass reg = new AsyncChangePass(changepass.this,loading,linearLayout1);
				reg.execute(user,passcu.getText().toString(),passmoi.getText().toString());
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
