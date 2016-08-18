package com.atp.moneymanager.activity;

import java.io.File;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.Thread.Asyncgetpass;
import com.atp.moneymanager.Thread.Register;
import com.atp.moneymanager.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class getpass extends Activity {

	public static PopupWindow popupWindow;
	static String msgtaikhoan = "Tài khoản không được để trống";
	static String msgbaomat = "Mã bảo mật không được để trống";
	static String Notifycation = "Thông báo";
	public static RelativeLayout back_dim_layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.getpass);
		
		
		final RelativeLayout loading = (RelativeLayout)findViewById(R.id.loading);
		final LinearLayout linearLayout1 = (LinearLayout)findViewById(R.id.linearLayout1);
		
		
		
		final EditText edtTaiKhoan = (EditText)findViewById(R.id.edtTaiKhoan);
		final EditText edtMatkhau = (EditText)findViewById(R.id.edtMatkhau);
		final EditText edtBaomat = (EditText)findViewById(R.id.edtbaomat);

		
		final Button btget = (Button)findViewById(R.id.get);
		btget.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				
				System.out.println("fsfdsf");
				if (edtTaiKhoan.getText().toString().equals(""))
				{
					popupWindow = FuncDungChung.ShowPopupThongBao(getpass.this, btget, back_dim_layout, msgtaikhoan,Notifycation);
					return;
				}
				
				
				
				if (edtBaomat.getText().toString().equals(""))
				{
					popupWindow = FuncDungChung.ShowPopupThongBao(getpass.this, btget, back_dim_layout, msgbaomat,Notifycation);
					return;
				}
				
				
				Asyncgetpass reg = new Asyncgetpass(getpass.this,loading,linearLayout1);
				reg.execute(edtTaiKhoan.getText().toString(),edtBaomat.getText().toString());
			}
			
		});
		
		Button cancel = (Button)findViewById(R.id.cancel);
		cancel.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				Intent localIntent = new Intent(getpass.this, login.class);
				getpass.this.startActivity(localIntent);
			}
			
		});
		
		if (FuncDungChung.GetLanguage(this) == 0)
		{
			msgtaikhoan = "Email don't allow empty";
			msgbaomat = "Passcode don't allow empty";
			Notifycation = "Notifycation";
			cancel.setText("Cancel");
			btget.setText("Get Password");
		}
		
		back_dim_layout = (RelativeLayout)findViewById(R.id.bac_dim_layout);
		
		back_dim_layout.setOnClickListener(new View.OnClickListener(){

	     	   @Override
	     	   public void onClick(View arg0) {
	     		  popupWindow.dismiss();
	     		 back_dim_layout.setVisibility(View.GONE);
	     	
	     	   }
	        });
	}
  

}
