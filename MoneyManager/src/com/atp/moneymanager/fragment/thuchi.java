package com.atp.moneymanager.fragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;










import nAdapter.childAdapterThuChi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;











import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.R;
public class thuchi extends Fragment {
	
	



	    View view;
	    ViewPager viewPager;
	    RelativeLayout layout2;
	    RelativeLayout layout3;
	    TextView tv1;
	    TextView tv2;
	    int current = 0;
		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);
			
		}
		@SuppressWarnings("deprecation")
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			view = inflater.inflate(R.layout.thuchi, container, false);
			
			viewPager = (ViewPager) view.findViewById(R.id.pager);
			
			
			
			childAdapterThuChi adapter = new childAdapterThuChi(getChildFragmentManager());
			 
			viewPager.setAdapter(adapter);
		    
			final LinearLayout ln1=(LinearLayout)view.findViewById(R.id.ln1);
			layout2=(RelativeLayout)view.findViewById(R.id.rltlayout1);
			layout3=(RelativeLayout)view.findViewById(R.id.rltlayout2);
			tv1=(TextView)view.findViewById(R.id.textView1);
			tv2=(TextView)view.findViewById(R.id.textView2);

			layout2.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					current = 0;
					viewPager.setCurrentItem(0);
					layout2.setBackgroundColor(0xFFFFFFFF);
					layout3.setBackgroundColor(0xFF058022);
				
					tv1.setTextColor(0xFF175615);
					tv2.setTextColor(0xFFFFFFFF);
					//	ln1.setBackgroundResource(R.drawable.bordertop);
				}
			});
			
			
			layout3.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					current = 1;
					viewPager.setCurrentItem(1);
					layout2.setBackgroundColor(0xFF058022);
					layout3.setBackgroundColor(0xFFFFFFFF);
		
					tv2.setTextColor(0xFF175615);
					tv1.setTextColor(0xFFFFFFFF);
					
				//	ln1.setBackgroundResource(R.drawable.bordertop);
				}
			});
			
			final TextView txt1 = (TextView)view.findViewById(R.id.textView1);
	        final TextView txt2 = (TextView)view.findViewById(R.id.textView2);
	        
	        
			if (FuncDungChung.GetLanguage(getActivity()) == 0)
			{
				txt1.setText("Expense");
				txt2.setText("Income");
			}
			return view;
		}
		
		@Override
	   	public void onResume() {
	   		super.onResume();
	   		if (current == 0)
	   		{
		   		viewPager.setCurrentItem(0);
		   		layout2.setBackgroundColor(0xFFFFFFFF);
				layout3.setBackgroundColor(0xFF058022);
			
				tv1.setTextColor(0xFF175615);
				tv2.setTextColor(0xFFFFFFFF);
	   		}
	   		else
	   		{
	   			viewPager.setCurrentItem(1);
				layout2.setBackgroundColor(0xFF058022);
				layout3.setBackgroundColor(0xFFFFFFFF);
	
				tv2.setTextColor(0xFF175615);
				tv1.setTextColor(0xFFFFFFFF);
	   		}
	   	}
	
	
}
