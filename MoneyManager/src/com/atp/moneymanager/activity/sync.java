package com.atp.moneymanager.activity;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.Thread.Asyncgetpass;
import com.atp.moneymanager.Thread.Register;
import com.atp.moneymanager.Thread.upload;
import com.atp.moneymanager.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class sync extends Activity {

	public static PopupWindow popupWindow;
	static String msgtaikhoan = "Tài khoản không được để trống";
	static String msgbaomat = "Mã bảo mật không được để trống";
	static String Notifycation = "Thông báo";
	public static RelativeLayout back_dim_layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.sync);
		
		
		final RelativeLayout loading = (RelativeLayout)findViewById(R.id.loading);
		final LinearLayout linearLayout1 = (LinearLayout)findViewById(R.id.linearLayout1);
		back_dim_layout = (RelativeLayout)findViewById(R.id.bac_dim_layout);
		
		final EditText edtTaiKhoan = (EditText)findViewById(R.id.edtTaiKhoan);
		final EditText edtMatkhau = (EditText)findViewById(R.id.edtMatkhau);
		final EditText edtBaomat = (EditText)findViewById(R.id.edtbaomat);
		final TextView txt1 = (TextView)findViewById(R.id.textView1);
		final Button sync = (Button)findViewById(R.id.sync);
		txt1.setText("Lần update cuối vào lúc: " + FuncDungChung.GetSync());
		if (FuncDungChung.GetLanguage(this) == 0)
		{
			msgtaikhoan = "Email don't allow empty";
			msgbaomat = "Passcode don't allow empty";
			Notifycation = "Notifycation";
			txt1.setText("Last Sync Update: " + FuncDungChung.GetSync());
			sync.setText("Sync");
			
		}
		

		
		
		sync.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				
				
				FuncDungChung.SetSync();
				
				
				upload reg = new upload(sync.this,"dsadsad",loading,linearLayout1);
				reg.execute();
			}
			
		});
		
		final RelativeLayout back=(RelativeLayout)findViewById(R.id.back);
		back.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				BackToMain();
			}
		});
		
		
		
		back_dim_layout.setOnClickListener(new View.OnClickListener(){

	     	   @Override
	     	   public void onClick(View arg0) {
	     		  popupWindow.dismiss();
	     		 back_dim_layout.setVisibility(View.GONE);
	     	
	     	   }
	        });
	}
    
	void BackToMain()
	{
		super.onBackPressed();
	}
	
	
	
	
}
