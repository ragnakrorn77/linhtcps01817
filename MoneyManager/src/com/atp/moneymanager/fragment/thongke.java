package com.atp.moneymanager.fragment;

import java.util.ArrayList;

import nAdapter.LoaiHinhChiAdapter;
import nAdapter.ThongKeAdapter;
import nAdapter.childAdapterThongKe;
import nAdapter.childAdapterThuChi;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.DoiTuong.DoiTuongDay;
import com.atp.moneymanager.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
public class thongke extends Fragment {
	
	int current = 1;
	Spinner spinner;
	ViewPager viewPager;
	RelativeLayout layout1;
	RelativeLayout layout2;
	RelativeLayout layout3;
	TextView tv1;
	TextView tv2;
	TextView tv3;
	 @Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                             Bundle savedInstanceState) {
	        
	        View rootView = inflater.inflate(R.layout.thongke, container, false);
	        
	        
    		viewPager = (ViewPager) rootView.findViewById(R.id.pager);
			
			
			
    		childAdapterThongKe adapter = new childAdapterThongKe(getChildFragmentManager());
			 
			viewPager.setAdapter(adapter);

			viewPager.setCurrentItem(1);
	        layout1=(RelativeLayout)rootView.findViewById(R.id.rltlayout1);
			layout2=(RelativeLayout)rootView.findViewById(R.id.rltlayout2);
			layout3=(RelativeLayout)rootView.findViewById(R.id.rltlayout3);
			
			 tv1=(TextView)rootView.findViewById(R.id.textView1);
			 tv2=(TextView)rootView.findViewById(R.id.textView2);
			 tv3=(TextView)rootView.findViewById(R.id.textView3);
			
			layout1.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					viewPager.setCurrentItem(0);
					current = 0;
					layout1.setBackgroundColor(0xFFFFFFFF);
					layout2.setBackgroundColor(0xFF058022);
					layout3.setBackgroundColor(0xFF058022);
					
					
					tv1.setTextColor(0xFF175615);
					tv2.setTextColor(0xFFFFFFFF);
					tv3.setTextColor(0xFFFFFFFF);
					//	ln1.setBackgroundResource(R.drawable.bordertop);
				}
			});
			
			
			layout2.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					viewPager.setCurrentItem(1);
					current = 1;
					layout2.setBackgroundColor(0xFFFFFFFF);
					layout1.setBackgroundColor(0xFF058022);
					layout3.setBackgroundColor(0xFF058022);
				
					tv2.setTextColor(0xFF175615);
					tv1.setTextColor(0xFFFFFFFF);
					tv3.setTextColor(0xFFFFFFFF);
					//	ln1.setBackgroundResource(R.drawable.bordertop);
				}
			});
			
			
			layout3.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					
					viewPager.setCurrentItem(2);
					current = 2;
					layout3.setBackgroundColor(0xFFFFFFFF);
					layout1.setBackgroundColor(0xFF058022);
					layout2.setBackgroundColor(0xFF058022);
		
					tv3.setTextColor(0xFF175615);
					tv1.setTextColor(0xFFFFFFFF);
					tv2.setTextColor(0xFFFFFFFF);
					
				//	ln1.setBackgroundResource(R.drawable.bordertop);
				}
			});
			
			final TextView txt1 = (TextView)rootView.findViewById(R.id.textView1);
			final TextView txt2 = (TextView)rootView.findViewById(R.id.textView2);
			final TextView txt3 = (TextView)rootView.findViewById(R.id.textView3);
	        // txt4 = (TextView)rootView.findViewById(R.id.textView4);
	        if (FuncDungChung.GetLanguage(getActivity()) == 0)
			{
	        	txt1.setText("Before Month");
	        	txt2.setText("This Month");
	        	txt3.setText("All");
	        	//txt4.setText("Total:");
			}
	
	        
	        return rootView;
	 }
	 
	 @Override
	   	public void onResume() {
	   		super.onResume();
	   		viewPager.setCurrentItem(1);
			current = 1;
			layout2.setBackgroundColor(0xFFFFFFFF);
			layout1.setBackgroundColor(0xFF058022);
			layout3.setBackgroundColor(0xFF058022);
		
			tv2.setTextColor(0xFF175615);
			tv1.setTextColor(0xFFFFFFFF);
			tv3.setTextColor(0xFFFFFFFF);
	   	}
	 

}
