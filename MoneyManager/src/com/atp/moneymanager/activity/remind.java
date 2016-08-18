package com.atp.moneymanager.activity;

import java.util.ArrayList;

import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView.OnItemClickListener;
import nAdapter.LoaiHinhChiAdapter;
import nAdapter.LoaiHinhThuAdapter;
import nAdapter.VayNoAdapter;

import com.atp.moneymanager.BootComplete;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
public class remind extends Activity {
	
	public static PopupWindow popupWindow;
	public static RelativeLayout back_dim_layout;
	static String remind[];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.remind);	
		
		back_dim_layout = (RelativeLayout)findViewById(R.id.bac_dim_layout);
		final EditText edt1 = (EditText)findViewById(R.id.editText1);
		final EditText edt2 = (EditText)findViewById(R.id.editText2);
		final EditText edt3 = (EditText)findViewById(R.id.editText3);
		
		 remind = FuncDungChung.getstateremind().split("/");
		final String time[] = remind[1].split(":");
		edt1.setText(time[0]);
		edt2.setText(time[1]);
		edt3.setText(remind[2]);
		final Button onoff=(Button)findViewById(R.id.onoff);
		 if (Integer.parseInt(remind[0]) == 0)
		 {
			 onoff.setBackgroundResource(R.drawable.buttonoff);
			 onoff.setText("OFF");
		 }
		 else
		 {
			 onoff.setBackgroundResource(R.drawable.buttonpopup);
			 onoff.setText("ON");
		 }
		 
		 onoff.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					remind = FuncDungChung.getstateremind().split("/");
					 if (Integer.parseInt(remind[0])  == 0)
					 {
						 onoff.setBackgroundResource(R.drawable.buttonpopup);
						 onoff.setText("ON");
						 FuncDungChung.setstateremind(1);//,edt1.getText().toString() + ":" + edt2.getText().toString(),Integer.parseInt(edt3.getText().toString()));
						 BootComplete alarm = new BootComplete();
						 alarm.SetAlarm(remind.this);		 
					 }
					 else
					 {
						 onoff.setBackgroundResource(R.drawable.buttonoff);
						 onoff.setText("OFF");
						 FuncDungChung.setstateremind(0);//,edt1.getText().toString() + ":" + edt2.getText().toString(),Integer.parseInt(edt3.getText().toString()));
					 } 
					 
					 System.out.println(Integer.parseInt(remind[0]));
				}
			});
		 
		 final Context mContext = this;
		 final Button set=(Button)findViewById(R.id.set);
		 set.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					String passcode = edt1.getText().toString();
					FuncDungChung.SetPasscode(passcode);
					 if (FuncDungChung.getStatePasscode())
					 {
						 popupWindow = FuncDungChung.ShowPopupThongBao(mContext, back_dim_layout, back_dim_layout, "Seted", "Notification");
						 
					 }
					 else
					 {
						 popupWindow = FuncDungChung.ShowPopupThongBao(mContext, back_dim_layout, back_dim_layout, "Đã set", "Thông báo");
					 }	
					 FuncDungChung.settimeremind(edt1.getText().toString() + ":" + edt2.getText().toString(),Integer.parseInt(edt3.getText().toString()));
					 
				}
			});
		 
		 
		 final TextView txtDate = (TextView)findViewById(R.id.txtDate);
		 final TextView txtAt = (TextView)findViewById(R.id.txtAt);
		 final TextView txtrepeat = (TextView)findViewById(R.id.txtrepeat);
		 final TextView txtSet = (TextView)findViewById(R.id.txtSet);
		 if (FuncDungChung.GetLanguage(this) == 0)
		 {
			 txtDate.setText("Set time to remind you at anytime");
			 txtAt.setText("At:");
			 txtrepeat.setText("Repeat:");
			 txtSet.setText("days 1 times");
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
