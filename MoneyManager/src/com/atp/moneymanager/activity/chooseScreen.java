package com.atp.moneymanager.activity;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
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
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.RawContacts;
import android.util.Log;
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
public class chooseScreen extends Activity {
	
	public static PopupWindow popupWindow;
	public static RelativeLayout back_dim_layout;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choosescreen);
		

			
	
		
	
		File f = new File(FuncDungChung.PATH_EXTERNAL + FuncDungChung.FOLDER);
		if (f.exists() && f.isDirectory()) {
			
			File file = new File(FuncDungChung.PATH_EXTERNAL + FuncDungChung.FOLDER + "/thuchi.db");
			if(file.exists())      
			{
				
				
					Intent localIntent = new Intent(chooseScreen.this, SlideMenuAttribute.class);
					chooseScreen.this.startActivity(localIntent);
					finish();
				
			}
			else
			{
				Intent localIntent = new Intent(chooseScreen.this, login.class);
				chooseScreen.this.startActivity(localIntent);
				finish();
			}
			 
		} 
		else
		{
			f.mkdir();
			FuncDungChung.SetLanguage(0);
			Intent localIntent = new Intent(chooseScreen.this, login.class);
			chooseScreen.this.startActivity(localIntent);
		}
		
		final RadioButton radioVN=(RadioButton)findViewById(R.id.radioVN);
		final RadioButton radionEN=(RadioButton)findViewById(R.id.radioEN);
			
			
		
	     
	     
		 Button btnOK = (Button)findViewById(R.id.btnok);
		
	     btnOK.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				if (radioVN.isChecked())
				{
					FuncDungChung.SetLanguage(1);
				}
				else
				{
					FuncDungChung.SetLanguage(0);
				}
			
			
				Intent localIntent = new Intent(chooseScreen.this, login.class);
				chooseScreen.this.startActivity(localIntent);
			
			
		}});
		
		
	        
		
	}
	
	
	void BackToMain()
	{
		super.onBackPressed();
	}
}
