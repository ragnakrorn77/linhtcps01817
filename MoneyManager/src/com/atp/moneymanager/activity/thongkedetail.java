package com.atp.moneymanager.activity;

import java.util.ArrayList;

import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView.OnItemClickListener;
import nAdapter.LoaiHinhChiAdapter;
import nAdapter.LoaiHinhThuAdapter;
import nAdapter.MenuAdapter;
import nAdapter.ThongkeDetailAdapter;
import nAdapter.VayNoAdapter;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.DoiTuong.DoiTuongLoaiHinhChi;
import com.atp.moneymanager.DoiTuong.DoiTuongLoaiHinhThu;
import com.atp.moneymanager.DoiTuong.DoiTuongThongkeDetail;
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
public class thongkedetail extends Activity {
	
	public static RelativeLayout back_dim_layout;
	public static PopupWindow popupWindow;
	String Datedetail = FuncDungChung.Datedetail;
	ListView list1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thongkedetail);	
		
		
		ArrayList<DoiTuongThongkeDetail> list = FuncDungChung.ThongKeDetail(Datedetail);
		
		list1 = ( ListView )findViewById( R.id.listView1 );  // List defined in XML ( See Below )
		ThongkeDetailAdapter adapter = new ThongkeDetailAdapter(thongkedetail.this,list);
		list1.setAdapter( adapter );
        
        
		back_dim_layout = (RelativeLayout)findViewById(R.id.bac_dim_layout);
		
		back_dim_layout.setOnClickListener(new View.OnClickListener(){

	     	   @Override
	     	   public void onClick(View arg0) {
	     		  System.out.println("zo");
	     		  popupWindow.dismiss();
	     		  back_dim_layout.setVisibility(View.GONE);
	     		 
	     	   }
	        });
        
        
        
        final ImageView back=(ImageView)findViewById(R.id.back);
		back.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				BackToMain();
			}
		});
      
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		ArrayList<DoiTuongThongkeDetail> list = FuncDungChung.ThongKeDetail(Datedetail);
		ThongkeDetailAdapter adapter = new ThongkeDetailAdapter(thongkedetail.this,list);
		list1.setAdapter( adapter );
        
	}
	
	void BackToMain()
	{
		super.onBackPressed();
	}
}
