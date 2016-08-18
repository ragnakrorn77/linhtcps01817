package com.atp.moneymanager.activity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.Thread.AsyncLogin;
import com.atp.moneymanager.Thread.DownloadTaskLogin;
import com.atp.moneymanager.Thread.Register;
import com.atp.moneymanager.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
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

public class login extends Activity {
	public static PopupWindow popupWindow;
	public static RelativeLayout back_dim_layout;
	public  String readFromFile() {
		
		
		

		//Get the text file
		File file = new File(FuncDungChung.PATH_EXTERNAL + FuncDungChung.FOLDER + "/" + "language.txt");

		//Read text from file
		StringBuilder text = new StringBuilder();

		try {
		    BufferedReader br = new BufferedReader(new FileReader(file));
		    String line;

		    while ((line = br.readLine()) != null) {
		        text.append(line);
		        text.append('\n');
		    }
		    br.close();
		}
		catch (IOException e) {
		    //You'll need to add proper error handling here
		}
        return text.toString();
    }
	private void writeToFile(String path,String data) {
	    try {
	        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(path + "/" + "language.txt", Context.MODE_PRIVATE));
	        outputStreamWriter.write(data);
	        outputStreamWriter.close();
	    }
	    catch (IOException e) {
	        Log.e("Exception", "File write failed: " + e.toString());
	    } 
	}
	public int GetLanguage(Context context)
	{
		
		 
		String read = readFromFile();
		if(read.indexOf("0") > -1)
		{
		 System.out.println(read);
		 return 0;
		}
	    
		return 1;
	}
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		
	
		
		final RelativeLayout loading = (RelativeLayout)findViewById(R.id.loading);
		final LinearLayout linearLayout1 = (LinearLayout)findViewById(R.id.linearLayout1);
		
		final EditText edtTaiKhoan = (EditText)findViewById(R.id.edtTaiKhoan);
		final EditText edtMatkhau = (EditText)findViewById(R.id.edtMatkhau);
		
		final TextView txtgetpass = (TextView)findViewById(R.id.txtgetpass);
		txtgetpass.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				Intent localIntent = new Intent(login.this, getpass.class);
				login.this.startActivity(localIntent);
    		  
			}
			
		});
		
		
		final Button btlogin = (Button)findViewById(R.id.login);
		btlogin.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
			
			if (GetLanguage(login.this) == 0)
			{
				if (edtTaiKhoan.getText().toString().equals(""))
				{
					popupWindow = FuncDungChung.ShowPopupThongBao(login.this, btlogin, back_dim_layout, "Email don't allow empty","Notifycation");
					return;
				}
				
				if (edtMatkhau.getText().toString().equals(""))
				{
					popupWindow = FuncDungChung.ShowPopupThongBao(login.this, btlogin, back_dim_layout, "Pasword don't allow empty","Notifycation");
					return;
				}
			}
			else
			{
				if (edtTaiKhoan.getText().toString().equals(""))
				{
					popupWindow = FuncDungChung.ShowPopupThongBao(login.this, btlogin, back_dim_layout, "Tài Khoản Không Đươc Để Trống","Notifycation");
					return;
				}
				
				if (edtMatkhau.getText().toString().equals(""))
				{
					popupWindow = FuncDungChung.ShowPopupThongBao(login.this, btlogin, back_dim_layout, "Mất khẩu Không Đươc Để Trống","Notifycation");
					return;
				}
			}
			
			
			AsyncLogin reg = new AsyncLogin(login.this,edtTaiKhoan.getText().toString(),loading,linearLayout1);
			reg.execute(edtTaiKhoan.getText().toString(),edtMatkhau.getText().toString());
		
			//	Intent localIntent = new Intent(login.this, SlideMenuAttribute.class);
			//	login.this.startActivity(localIntent);
    		  
			}
			
		});
		
		Button dangky = (Button)findViewById(R.id.dangky);
		dangky.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				Intent localIntent = new Intent(login.this, dangky.class);
				login.this.startActivity(localIntent);
    		  
			}
			
		});
		

		if (GetLanguage(login.this) == 0)
		{
			btlogin.setText("Log In");
			dangky.setText("Register");
			txtgetpass.setText(getString(R.string.passen));
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
