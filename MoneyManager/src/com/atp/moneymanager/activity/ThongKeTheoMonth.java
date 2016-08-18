package com.atp.moneymanager.activity;

import java.util.ArrayList;

import nAdapter.ThongKeAdapter;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.DoiTuong.DoiTuongDay;
import com.atp.moneymanager.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ThongKeTheoMonth extends Activity {

static ArrayList<DoiTuongDay>  list;

   
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thongketheomonth);	

        list = FuncDungChung.GetAllDateTheoMonth(FuncDungChung.theomonth);
        
        final ListView list1 = ( ListView )findViewById( R.id.listView1 );  // List defined in XML ( See Below )
		final ThongKeAdapter adapter = new ThongKeAdapter(this,list);
        list1.setAdapter( adapter );
        list1.setOnItemClickListener( new OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int myItemInt, long arg3) {
            	FuncDungChung.Datedetail = list.get(myItemInt).GetDate();
            	System.out.println(list.get(myItemInt).GetDate());
            	Intent mainactivity = new Intent(ThongKeTheoMonth.this, thongkedetail.class);
            	ThongKeTheoMonth.this.startActivity(mainactivity);
            }
            });
        
        
        final TextView txt4 = (TextView)findViewById(R.id.textView4);
        final TextView txt1 = (TextView)findViewById(R.id.textView1);
        final TextView txt2 = (TextView)findViewById(R.id.textView2);
        txt1.setText("Thu: " + FuncDungChung.formatso(Integer.toString(FuncDungChung.AllThuMoneyTheoMonth))  + FuncDungChung.GetCurrency());
        txt2.setText("Chi: " + FuncDungChung.formatso(Integer.toString(FuncDungChung.AllChiMoneyTheoMonth))  + FuncDungChung.GetCurrency());
        if (FuncDungChung.GetLanguage(this) == 0)
		{
        	txt1.setText("Income: " + FuncDungChung.formatso(Integer.toString(FuncDungChung.AllThuMoneyTheoMonth))  + FuncDungChung.GetCurrency());
            txt2.setText("Expense: " + FuncDungChung.formatso(Integer.toString(FuncDungChung.AllChiMoneyTheoMonth))  + FuncDungChung.GetCurrency());
        	txt4.setText("Total:");
		}
        
        
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
