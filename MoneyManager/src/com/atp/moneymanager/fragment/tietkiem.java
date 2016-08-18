package com.atp.moneymanager.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.activity.SlideMenuAttribute;
import com.atp.moneymanager.activity.chonloaihinhchi;
import com.atp.moneymanager.activity.chonloaihinhthu;
import com.atp.moneymanager.activity.chonngansach;
import com.atp.moneymanager.activity.naptien;
import com.atp.moneymanager.activity.ruttien;
import com.atp.moneymanager.activity.thongketietkiem;
import com.atp.moneymanager.R;
public class tietkiem extends Fragment {


	TextView tientietkiem;
	TextView txt1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.tietkiem, container, false);
        tientietkiem = (TextView)rootView.findViewById(R.id.textView2);
        Button report = (Button)rootView.findViewById(R.id.report);
        TextView naptien = (TextView)rootView.findViewById(R.id.textView3);
        TextView ruttien = (TextView)rootView.findViewById(R.id.textView4);
        if (FuncDungChung.GetLanguage(getActivity()) == 0)
		{
        	txt1 = (TextView)rootView.findViewById(R.id.textView1);
        	txt1.setText("Saving Money");
			tientietkiem.setText("Saving Budget: " + FuncDungChung.formatso(Integer.toString(FuncDungChung.GetTienTietKiem())) + " " + FuncDungChung.GetCurrency());
			report.setText("Report");
			naptien.setText("Add Money");
			ruttien.setText("Withdraw");
		}
		else
		{
			tientietkiem.setText("Ngân Sách: " + FuncDungChung.formatso(Integer.toString(FuncDungChung.GetTienTietKiem())) + " " + FuncDungChung.GetCurrency());
			
		}
        
        
        report.setOnClickListener(new View.OnClickListener() {

 			@Override
 			public void onClick(View v) {
 				Intent mainactivity = new Intent(getActivity(), thongketietkiem.class);
 				getActivity().startActivity(mainactivity);
 			}
 		});
        
        
        
       
       naptien.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent mainactivity = new Intent(getActivity(), naptien.class);
				getActivity().startActivity(mainactivity);
			}
		});
        
       
       ruttien.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent mainactivity = new Intent(getActivity(), ruttien.class);
				getActivity().startActivity(mainactivity);
			}
		});
        
        return rootView;
    }

    @Override
   	public void onResume() {
   		super.onResume();
   	 if (FuncDungChung.GetLanguage(getActivity()) == 0)
		{
     
     	txt1.setText("Saving Money");
		tientietkiem.setText("Saving Budget: " + FuncDungChung.formatso(Integer.toString(FuncDungChung.GetTienTietKiem())) + " " + FuncDungChung.GetCurrency());
		}
		else
		{
			tientietkiem.setText("Ngân Sách: " + FuncDungChung.formatso(Integer.toString(FuncDungChung.GetTienTietKiem())) + " " + FuncDungChung.GetCurrency());
			
		}
   	}
}


