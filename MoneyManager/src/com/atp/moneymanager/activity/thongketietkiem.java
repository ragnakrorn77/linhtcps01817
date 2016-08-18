package com.atp.moneymanager.activity;

import java.util.ArrayList;

import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView.OnItemClickListener;
import nAdapter.LoaiHinhChiAdapter;
import nAdapter.LoaiHinhThuAdapter;
import nAdapter.MenuAdapter;
import nAdapter.ThongkeDetailAdapter;
import nAdapter.ThongkeTietKiemAdapter;
import nAdapter.VayNoAdapter;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.DoiTuong.DoiTuongLoaiHinhChi;
import com.atp.moneymanager.DoiTuong.DoiTuongLoaiHinhThu;
import com.atp.moneymanager.DoiTuong.DoiTuongThongkeDetail;
import com.atp.moneymanager.DoiTuong.DoiTuongThongkeTietKiem;
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
public class thongketietkiem extends Activity {
	
	public static RelativeLayout back_dim_layout;
	public static PopupWindow popupWindow;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thongketietkiem);	
		
		//String Datedetail = FuncDungChung.Datedetail;
		ArrayList<DoiTuongThongkeTietKiem> list = FuncDungChung.GetAllTietKiem();
		
		final ListView list1 = ( ListView )findViewById( R.id.listView1 );  // List defined in XML ( See Below )
		ThongkeTietKiemAdapter adapter = new ThongkeTietKiemAdapter(thongketietkiem.this,list);
		list1.setAdapter( adapter );
        
        
	
        
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
