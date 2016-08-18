package com.atp.moneymanager.fragment;


import java.util.ArrayList;

import nAdapter.ThongKeAdapter;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.DoiTuong.DoiTuongDay;
import com.atp.moneymanager.activity.SlideMenuAttribute;
import com.atp.moneymanager.activity.chonloaihinhthu;
import com.atp.moneymanager.activity.chonngansach;
import com.atp.moneymanager.activity.themvayno;
import com.atp.moneymanager.activity.thongkedetail;
import com.atp.moneymanager.R;

public class thangnay extends Fragment {

	static ArrayList<DoiTuongDay>  list;

   
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    	
        View rootView = inflater.inflate(R.layout.thangnay, container, false);

        list = FuncDungChung.GetAllDateThisMonth();
        
        final ListView list1 = ( ListView )rootView.findViewById( R.id.listView1 );  // List defined in XML ( See Below )
		final ThongKeAdapter adapter = new ThongKeAdapter( getActivity(),list);
        list1.setAdapter( adapter );
        list1.setOnItemClickListener( new OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int myItemInt, long arg3) {
            	FuncDungChung.Datedetail = list.get(myItemInt).GetDate();
            	System.out.println(list.get(myItemInt).GetDate());
            	Intent mainactivity = new Intent(getActivity(), thongkedetail.class);
            	getActivity().startActivity(mainactivity);
            }
            });
        final TextView txt4 = (TextView)rootView.findViewById(R.id.textView4);
        final TextView txt1 = (TextView)rootView.findViewById(R.id.textView1);
        final TextView txt2 = (TextView)rootView.findViewById(R.id.textView2);
        txt1.setText("Thu: " + FuncDungChung.formatso(Integer.toString(FuncDungChung.AllThuMoneyThisMonth))  + FuncDungChung.GetCurrency());
        txt2.setText("Chi: " + FuncDungChung.formatso(Integer.toString(FuncDungChung.AllChiMoneyThisMonth))  + FuncDungChung.GetCurrency());
        if (FuncDungChung.GetLanguage(getActivity()) == 0)
		{
        	txt1.setText("Income: " + FuncDungChung.formatso(Integer.toString(FuncDungChung.AllThuMoneyThisMonth))  + FuncDungChung.GetCurrency());
            txt2.setText("Expense: " + FuncDungChung.formatso(Integer.toString(FuncDungChung.AllChiMoneyThisMonth))  + FuncDungChung.GetCurrency());
        	txt4.setText("Total:");
		}
        
        
        return rootView;
    }

    @Override
	public void onResume() {
    
		super.onResume();
	}
    
}

