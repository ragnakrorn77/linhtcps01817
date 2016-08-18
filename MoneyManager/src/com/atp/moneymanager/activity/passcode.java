package com.atp.moneymanager.activity;

import java.util.ArrayList;

import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView.OnItemClickListener;
import nAdapter.LoaiHinhChiAdapter;
import nAdapter.LoaiHinhThuAdapter;
import nAdapter.VayNoAdapter;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.DoiTuong.DoiTuongLoaiHinhChi;
import com.atp.moneymanager.DoiTuong.DoiTuongLoaiHinhThu;
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
public class passcode extends Activity {
	
	TextView txt1;
	TextView txt2;
	TextView txt3;
	TextView txt4;
	TextView txtxoa;
	void setText(int value1)
	{
		String value = Integer.toString(value1);
		if (txt1.getText().toString().equals(""))
		{
			txt1.setText(value);
			return;
		}
		
		if (txt2.getText().toString().equals(""))
		{
			txt2.setText(value);
			return;
		}
		
		if (txt3.getText().toString().equals(""))
		{
			txt3.setText(value);
			return;
		}
		
		if (txt4.getText().toString().equals(""))
		{
			
			txt4.setText(value);
			String result = txt1.getText().toString() + txt2.getText().toString() + txt3.getText().toString() + txt4.getText().toString();
			
			if (FuncDungChung.getPasscode().equals(result))
			{
				Intent localIntent = new Intent(passcode.this, SlideMenuAttribute.class);
				passcode.this.startActivity(localIntent);
				txt1.setText("");
				txt2.setText("");
				txt3.setText("");
				txt4.setText("");
			}
			else
			{
				txt1.setText("");
				txt2.setText("");
				txt3.setText("");
				txt4.setText("");
			}
			return;
		}
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.passcode);	
		
		txt1 = (TextView)findViewById(R.id.textView1);
		txt2 = (TextView)findViewById(R.id.textView2);
		txt3 = (TextView)findViewById(R.id.textView3);
		txt4 = (TextView)findViewById(R.id.textView4);
		
		txtxoa = (TextView)findViewById(R.id.txtxoa);
		
		if (FuncDungChung.GetLanguage(this) == 0)
		{
			txtxoa.setText("Delete");
		}
		RelativeLayout relativeLayoutxoa = (RelativeLayout)findViewById(R.id.relativexoa);
		
		relativeLayoutxoa.setOnClickListener(new View.OnClickListener(){

	     	   @Override
	     	   public void onClick(View arg0) {
	     		  if (!txt4.getText().toString().equals(""))
	     			{
	     				txt4.setText("");
	     				return;
	     			}
	     		  
	     		 if (!txt3.getText().toString().equals(""))
	     			{
	     				txt3.setText("");
	     				return;
	     			}
	     		 
	     		 if (!txt2.getText().toString().equals(""))
	     			{
	     				txt2.setText("");
	     				return;
	     			}
	     		 
	     		 if (!txt1.getText().toString().equals(""))
	     			{
	     				txt1.setText("");
	     				return;
	     			}
	     	   }
	        });
		RelativeLayout relativeLayout0 = (RelativeLayout)findViewById(R.id.relativeLayout0);
		RelativeLayout relativeLayout9 = (RelativeLayout)findViewById(R.id.relativeLayout9);
		RelativeLayout relativeLayout8 = (RelativeLayout)findViewById(R.id.relativeLayout8);
		RelativeLayout relativeLayout7 = (RelativeLayout)findViewById(R.id.relativeLayout7);
		RelativeLayout relativeLayout6 = (RelativeLayout)findViewById(R.id.relativeLayout6);
		RelativeLayout relativeLayout5 = (RelativeLayout)findViewById(R.id.relativeLayout5);
		RelativeLayout relativeLayout4 = (RelativeLayout)findViewById(R.id.relativeLayout4);
		RelativeLayout relativeLayout3 = (RelativeLayout)findViewById(R.id.relativeLayout3);
		RelativeLayout relativeLayout2 = (RelativeLayout)findViewById(R.id.relativeLayout2);
		RelativeLayout relativeLayout1 = (RelativeLayout)findViewById(R.id.relativeLayout1);
		
		relativeLayout7.setOnClickListener(new View.OnClickListener(){

	     	   @Override
	     	   public void onClick(View arg0) {
	     		  setText(7);
	     	   }
	        });
		relativeLayout8.setOnClickListener(new View.OnClickListener(){

	     	   @Override
	     	   public void onClick(View arg0) {
	     		  setText(8);
	     	   }
	        });
		relativeLayout9.setOnClickListener(new View.OnClickListener(){

	     	   @Override
	     	   public void onClick(View arg0) {
	     		  setText(9);
	     	   }
	        });
		relativeLayout4.setOnClickListener(new View.OnClickListener(){

	     	   @Override
	     	   public void onClick(View arg0) {
	     		  setText(4);
	     	   }
	        });
		relativeLayout5.setOnClickListener(new View.OnClickListener(){

	     	   @Override
	     	   public void onClick(View arg0) {
	     		  setText(5);
	     	   }
	        });
		relativeLayout6.setOnClickListener(new View.OnClickListener(){

	     	   @Override
	     	   public void onClick(View arg0) {
	     		  setText(6);
	     	   }
	        });
		relativeLayout1.setOnClickListener(new View.OnClickListener(){

	     	   @Override
	     	   public void onClick(View arg0) {
	     		  setText(1);
	     	   }
	        });
		relativeLayout2.setOnClickListener(new View.OnClickListener(){

	     	   @Override
	     	   public void onClick(View arg0) {
	     		  setText(2);
	     	   }
	        });
		relativeLayout3.setOnClickListener(new View.OnClickListener(){

	     	   @Override
	     	   public void onClick(View arg0) {
	     		  setText(3);
	     	   }
	        });
		relativeLayout0.setOnClickListener(new View.OnClickListener(){

	     	   @Override
	     	   public void onClick(View arg0) {
	     		  setText(0);
	     	   }
	        });
	}
	
	@Override
	protected void onResume() {
		if (FuncDungChung.GetLanguage(this) == 0)
		{
			txtxoa.setText("Delete");
		}
		super.onResume();
	}
	
	
	void BackToMain()
	{
		super.onBackPressed();
	}
}
