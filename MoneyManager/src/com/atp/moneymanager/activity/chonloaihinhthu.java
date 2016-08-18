package com.atp.moneymanager.activity;

import java.util.ArrayList;

import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView.OnItemClickListener;
import nAdapter.LoaiHinhThuAdapter;
import nAdapter.VayNoAdapter;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.DoiTuong.DoiTuongLoaiHinhThu;
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
public class chonloaihinhthu extends Activity {
	
	public static PopupWindow popupWindow;
	
	public static RelativeLayout back_dim_layout;
	
	TextView txtpopupTien;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chonloaihinhthu);	
		
		TextView textView1 = (TextView)findViewById( R.id.textView1  );
		
		if (FuncDungChung.GetLanguage(this) == 0)
		{
			textView1.setText("Create Category");
		}
		
		
		ArrayList<DoiTuongLoaiHinhThu> list = FuncDungChung.GetAllLoaiHinhThu();
		
		final ListView list1 = ( ListView )findViewById( R.id.listView1 );  // List defined in XML ( See Below )
		final LoaiHinhThuAdapter adapter = new LoaiHinhThuAdapter( this,list);
        list1.setAdapter( adapter );
        
        
        list1.setOnItemClickListener( new OnItemClickListener() {
        public void onItemClick(AdapterView<?> arg0, View arg1, int myItemInt, long arg3) {
        	//int selectedFromList = arg0.getItemAtPosition(myItemInt);
        	ArrayList<DoiTuongLoaiHinhThu> list = FuncDungChung.GetAllLoaiHinhThu();
        	
        	System.out.println(list.get(myItemInt).GetTen());
        	Thu.txtMucthu.setText(list.get(myItemInt).GetTen());
        	Thu.ma_thu = list.get(myItemInt).GetId();
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
        		   
        		   FuncDungChung.ShowPopupThemThu(chonloaihinhthu.this,btThem,back_dim_layout,adapter);
        		    
        		
        	   }});
	}
	
	
	void BackToMain()
	{
		super.onBackPressed();
	}
}
