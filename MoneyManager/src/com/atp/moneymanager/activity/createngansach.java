package com.atp.moneymanager.activity;

import java.util.ArrayList;

import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView.OnItemClickListener;
import nAdapter.LoaiHinhThuAdapter;
import nAdapter.NganSachAdapter;
import nAdapter.VayNoAdapter;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.DoiTuong.DoiTuongLoaiHinhThu;
import com.atp.moneymanager.DoiTuong.DoiTuongNganSach;
import com.atp.moneymanager.Thread.upload;
import com.atp.moneymanager.Thread.uploadafterdangky;
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
public class createngansach extends Activity {
	
	public static PopupWindow popupWindow;
	
	public static RelativeLayout back_dim_layout;
	static String Notifycation = "Thông báo";
	static String msg = "Vui lòng điền đầy đủ";
	static String budget = "Vui lòng thêm ngân sách";
	TextView txtpopupTien;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.createngansach);	
		back_dim_layout = (RelativeLayout)findViewById(R.id.bac_dim_layout);
		final TextView txt1 = (TextView)findViewById(R.id.textView1);
        final TextView txt2 = (TextView)findViewById(R.id.textView2);
        final EditText edtTen = (EditText)findViewById(R.id.editText1);
		final EditText edtTien = (EditText)findViewById(R.id.editText2);
		final Button btThem =(Button)findViewById(R.id.btThem);
		final Button btNext =(Button)findViewById(R.id.btNext);
		final RelativeLayout loading = (RelativeLayout)findViewById(R.id.loading);
		final LinearLayout linearLayout1 = (LinearLayout)findViewById(R.id.linearLayout1);
		
		
		if (FuncDungChung.GetLanguage(this) == 0)
		{
			txt1.setText("Budget");
			txt2.setText("Money");
			edtTen.setHint("Wallet");
			edtTien.setHint("1$");
			msg = "Please fill to in empty textbox";
			Notifycation = "Notifycation";
			btThem.setText("Add Budget");
			btNext.setText("Next");
			budget = "Please add budget";
		}
		
		if (FuncDungChung.fromchonngansach == 1)
		{
			btNext.setText("OK");
		}
		
		ArrayList<DoiTuongNganSach> list = FuncDungChung.GetAllNganSach();
		
		final ListView list1 = ( ListView )findViewById( R.id.listView1 );  // List defined in XML ( See Below )
		final NganSachAdapter adapter = new NganSachAdapter( this,list);
        list1.setAdapter( adapter );
        
        
        
        
        
        
        
        btThem.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (edtTen.getText().toString().equals(""))
				{
					popupWindow = FuncDungChung.ShowPopupThongBao(createngansach.this, btThem, back_dim_layout, msg,Notifycation);
					return;
				}
				
				if (edtTien.getText().toString().equals(""))
				{
					popupWindow = FuncDungChung.ShowPopupThongBao(createngansach.this, btThem, back_dim_layout, msg,Notifycation);
					return;
				}
				System.out.println(edtTien.getText().toString());
				
				FuncDungChung.InsertDataNganSach(edtTen.getText().toString(),edtTien.getText().toString(),"ic_launcher.png");
				ArrayList<DoiTuongNganSach> list = FuncDungChung.GetAllNganSach();
				adapter.setData(list);
				adapter.notifyDataSetChanged();
			}
		});
      
        btNext.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (FuncDungChung.fromchonngansach == 1)
				{
					ArrayList<DoiTuongNganSach> list = FuncDungChung.GetAllNganSach();
					chonngansach.adapter.setData(list);
					chonngansach.adapter.notifyDataSetChanged();
					
					FuncDungChung.fromchonngansach = 0;
					BackToMain();
				}
				else
				{
					if (FuncDungChung.GetCountNganSach() == 0)
					{
						popupWindow = FuncDungChung.ShowPopupThongBao(createngansach.this, btThem, back_dim_layout, budget,Notifycation);
						return;
					}
					
					
					uploadafterdangky reg = new uploadafterdangky(createngansach.this,"dsadsad",loading,linearLayout1);
					reg.execute();
				}
				
			}
		});
		
		
	}
	
	
	void BackToMain()
	{
		super.onBackPressed();
	}
}
