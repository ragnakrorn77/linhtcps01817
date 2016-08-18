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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
public class chonngansach extends Activity {
	
	public static PopupWindow popupWindow;
	
	public static RelativeLayout back_dim_layout;
	static String Notifycation = "Thông báo";
	static String msg = "Ngân Sách Này Đã Hết Tiền";
	TextView txtpopupTien;
	static NganSachAdapter adapter;
	int fromedit = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chonngansach);	
		if (getIntent().hasExtra("fromedit"))
		{
			Bundle extras = getIntent().getExtras(); 
			fromedit = extras.getInt("fromedit");
		}
		else
		{
			fromedit = 0;
		}
		
		TextView textView1 = (TextView)findViewById( R.id.textView1  );
		
		if (FuncDungChung.GetLanguage(this) == 0)
		{
			msg = "This budget no money";
			Notifycation = "Notifycation";
			textView1.setText("Create Budget");
		}
		
		ArrayList<DoiTuongNganSach> list = FuncDungChung.GetAllNganSach();
		final ListView list1 = ( ListView )findViewById( R.id.listView1 );  // List defined in XML ( See Below )
		
		
		adapter = new NganSachAdapter( this,list);
        list1.setAdapter( adapter );
	
    
    list1.setOnItemClickListener( new OnItemClickListener() {
    public void onItemClick(AdapterView<?> arg0, View arg1, int myItemInt, long arg3) {
    	//int selectedFromList = arg0.getItemAtPosition(myItemInt);
    	ArrayList<DoiTuongNganSach> list = FuncDungChung.GetAllNganSach();
    	
    	
    	if (FuncDungChung.thu_chi == 1 && list.get(myItemInt).GetTien() == 0 && fromedit == 0)
    	{
    		popupWindow = FuncDungChung.ShowPopupThongBao(chonngansach.this,list1,back_dim_layout,msg,Notifycation);
    		return;
    	}
    	FuncDungChung.Ngan_Sach = list.get(myItemInt).GetTen();
    	FuncDungChung.ma_ngan_sach = list.get(myItemInt).GetId();
    	//Thu.txtMucthu.setText(list.get(myItemInt).GetTen());
    	//Thu.ma_thu = list.get(myItemInt).GetId();
    	BackToMain();
    }
    });
    
    
    
    final RelativeLayout back=(RelativeLayout)findViewById(R.id.back);
	back.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			BackToMain();
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
	
	final LinearLayout btThem=(LinearLayout)findViewById(R.id.add);
    btThem.setOnClickListener(new View.OnClickListener(){

    	   @Override
    	   public void onClick(View arg0) {
    		   
    		   //FuncDungChung.ShowPopupThemNganSach(chonngansach.this,btThem,back_dim_layout,adapter);
    		   Intent mainactivity = new Intent(chonngansach.this, createngansach.class);
    		   chonngansach.this.startActivity(mainactivity);
    		   FuncDungChung.fromchonngansach = 1;
    	   }});
	
		
	}
	
	
	void BackToMain()
	{
		super.onBackPressed();
	}
}
