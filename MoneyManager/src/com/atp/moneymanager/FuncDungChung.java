package com.atp.moneymanager;

import java.text.ParseException;import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nAdapter.LoaiHinhChiAdapter;
import nAdapter.LoaiHinhThuAdapter;
import nAdapter.NganSachAdapter;
import nAdapter.VayNoAdapter;
import android.widget.TimePicker;

import com.atp.moneymanager.DoiTuong.DoiTuongDay;
import com.atp.moneymanager.DoiTuong.DoiTuongEdit;
import com.atp.moneymanager.DoiTuong.DoiTuongLoaiHinhChi;
import com.atp.moneymanager.DoiTuong.DoiTuongLoaiHinhThu;
import com.atp.moneymanager.DoiTuong.DoiTuongNganSach;
import com.atp.moneymanager.DoiTuong.DoiTuongThongkeDetail;
import com.atp.moneymanager.DoiTuong.DoiTuongThongkeTietKiem;
import com.atp.moneymanager.DoiTuong.DoiTuongVayNo;
import com.atp.moneymanager.DoiTuong.Doituonggido;
import com.atp.moneymanager.activity.SlideMenuAttribute;
import com.atp.moneymanager.activity.chonloaihinhchi;
import com.atp.moneymanager.activity.dangky;
import com.atp.moneymanager.activity.edit;
import com.atp.moneymanager.activity.login;
import com.atp.moneymanager.activity.themvayno;
import com.atp.moneymanager.activity.trano;
import com.atp.moneymanager.R;

import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker.OnTimeChangedListener;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Comparator;
import java.util.Date;
public class FuncDungChung {
	public static PopupWindow popupWindow;
	public static String Date;
	public static String theomonth;
	public static final String PATH_EXTERNAL = Environment.getExternalStorageDirectory().toString() + "/";
	public static final String FOLDER = "Android/data/com.atp.moneymanager";
	public static final String DATABASE = "thuchi.db";
	public static int ma_ngan_sach = 0;
	public static String Ngan_Sach = "";
	public static int thu_chi = 0;
	public static String currency = "";
	public static String linkhost = "http://moneymanager.esy.es/quanlythuchi/";
	public static String Datedetail = "";
	public static boolean isrunning = false;
	public static int AllThuMoneyThisMonth;
	public static int AllChiMoneyThisMonth;
	public static int AllThuMoneyTheoMonth;
	public static int AllChiMoneyTheoMonth;
	public static int AllThuMoneyAfterMonth;
	public static int AllChiMoneyAfterMonth;
	public static int AllThuMoneyBeforeMonth;
	public static int AllChiMoneyBeforeMonth;
	public static int fromchonngansach = 0;
	public static  String DeleteCuoiString(String text)
	{
		String result = "";
		result = text.substring(0, text.length()-1);
		return result;
	}
	
	public static boolean isUserIsOnHomeScreen(Context ctx)
	  {
		  ActivityManager manager = (ActivityManager) ctx.getSystemService(Activity.ACTIVITY_SERVICE);
		  List<ActivityManager.RunningTaskInfo> tasks = manager.getRunningTasks(Integer.MAX_VALUE);
		  
		 /* for (ActivityManager.RunningTaskInfo task : tasks) {
			  //System.out.println(task.topActivity.getPackageName());
			  if (!task.topActivity.getPackageName().equalsIgnoreCase("com.aretha.slidemenudemo"))
			  {
				  FuncDungChung.isrunning = false;
				  break;
			  }
		  }com.aretha.slidemenudemo
		  */
		  if(!tasks.get(0).topActivity.getPackageName().equalsIgnoreCase("com.atp.moneymanager"))
		  {
			  FuncDungChung.isrunning = false;
		  }

		  
	      
	      return false;

	  }
	public static String readFromFile() {
		
		
		

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
	
	public static String tach_so_1(String so)
    {
    	String result = "";
    	so = so.replace(".", "");
    	//System.out.println(so.substring(0, so.length() - 3));
    	//System.out.println(so.substring(so.length() - 3, so.length()));
    	String dautien = so.substring(0, so.length() - 3);
    	
    	String cuoi = so.substring(so.length() - 3, so.length());
    	 result = dautien + "." + cuoi;
    	
    	
    	
    	return result;
    }
    
	public static String tach_so_2(String so)
    {
    	so = so.replace(".", "");
    	String result = "";
    	
    	//System.out.println(so.substring(0, so.length() - 6));
    	//System.out.println(so.substring(so.length() - 6, so.length() - 3));
    	//System.out.println(so.substring(so.length() - 3, so.length()));
    	
    	String dautien = so.substring(0, so.length() - 6);
    	String giua = so.substring(so.length() - 6, so.length() - 3);
    	String cuoi = so.substring(so.length() - 3, so.length());
    	 result = dautien + "." + giua + "." + cuoi;
    	
    	
    	
    	return result;
    }
    
    
	public static ArrayList<DoiTuongLoaiHinhThu> GetAllLoaiHinhThu()
	{
		ArrayList<DoiTuongLoaiHinhThu> arrayList = null;
		  
	    SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
	                                                null, SQLiteDatabase.OPEN_READONLY);
	    Cursor cursor = database.rawQuery("select * from loai_hinh_thu", null);
	  
	    //kiểm tra cursor có dữ liệu không? Nếu có, thưc hiện lấy dữ liệu từ cursor 
	    //cho vào mảng arrayList
	    arrayList = new ArrayList<DoiTuongLoaiHinhThu>();
	    if(cursor.moveToFirst())
	    {
	         
			 do
			 {
				 DoiTuongLoaiHinhThu LoaiHinhThu = new DoiTuongLoaiHinhThu(
						 cursor.getInt(cursor.getColumnIndex("ma_thu")),
						 cursor.getString(cursor.getColumnIndex("ten")),
						 cursor.getString(cursor.getColumnIndex("icon")));
			     
				 	     arrayList.add(LoaiHinhThu);
			 }while(cursor.moveToNext());
		 }
	    cursor.close();
	    database.close();
	    return arrayList;
	}
	public static int GetLanguage(Context context)
	{
		
		 
		String read = readFromFile();
		if(read.indexOf("0") > -1)
		{
		 System.out.println(read);
		 return 0;
		}
	    
		return 1;
	}
	
	
	public static String GetCurrency()
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READONLY);
		Cursor cursor = database.rawQuery("select * from currency", null);
		
		int Tien = 0;
		
		if(cursor.moveToFirst())
	    {
	        
			 do
			 {
				 
				 
					return cursor.getString(cursor.getColumnIndex("currency"));
				  
				 
			 }while(cursor.moveToNext());
		 }
	    cursor.close();
	    database.close();
	    
	    
	    
		return "đ";
	}
	
	public static int GetTienTietKiem()
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READONLY);
		Cursor cursor = database.rawQuery("select * from tietkiem", null);
		
		int Tien = 0;
		
		if(cursor.moveToFirst())
	    {
	        
			 do
			 {
				 
				 
					return cursor.getInt(cursor.getColumnIndex("tien"));
				  
				 
			 }while(cursor.moveToNext());
		 }
	    cursor.close();
	    database.close();
	    
	    
	    
		return 0;
	}
	
	
	public static String GetUser()
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READONLY);
		Cursor cursor = database.rawQuery("select * from nguoidung", null);
		
		
		if(cursor.moveToFirst())
	    {
	        
			 do
			 {
				 
				 
					return cursor.getString(cursor.getColumnIndex("name"));
				  
				 
			 }while(cursor.moveToNext());
		 }
	    cursor.close();
	    database.close();
	    
	    
	    
		return "đ";
	}
	
	public static int SetUser(String name)
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READWRITE);
		
	
		  
		
		  
		  
		ContentValues values = new ContentValues();
	     values.put("name", name);
	       
	     database.update("nguoidung", values, "id" + " = ?",
	             new String[] { String.valueOf(0) });
	     
	     
	    database.close();
	    
	    
	    
		return 1;
	}
	
	public static String GetSync()
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READONLY);
		Cursor cursor = database.rawQuery("select * from sync", null);
		
		int Tien = 0;
		
		if(cursor.moveToFirst())
	    {
	        
			 do
			 {
				 
				 
					return cursor.getString(cursor.getColumnIndex("date"));
				  
				 
			 }while(cursor.moveToNext());
		 }
	    cursor.close();
	    database.close();
	    
	    
	    
		return "đ";
	}
	
	
	public static ArrayList<Float> GetExchange_rate()
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READONLY);
		Cursor cursor = database.rawQuery("select * from exchange_rate", null);
		
		
		ArrayList<Float> arr = new ArrayList<Float>();
		if(cursor.moveToFirst())
	    {
	        
			 do
			 {
				 
				    arr.add(cursor.getFloat(cursor.getColumnIndex("tien")));
					System.out.println(cursor.getInt(cursor.getColumnIndex("tien")));
				 
			 }while(cursor.moveToNext());
		 }
	    cursor.close();
	    database.close();
	    
	    
	    
		return arr;
	}
	
	public static void SetLanguage(int set){
	    try
	    {
	        File root = new File(FuncDungChung.PATH_EXTERNAL + FuncDungChung.FOLDER);
	        if (!root.exists()) {
	            root.mkdirs();
	        }
	        File gpxfile = new File(root, "language.txt");
	        FileWriter writer = new FileWriter(gpxfile);
	        if (set == 0) writer.append("0");
	        else writer.append("1");
	        writer.flush();
	        writer.close();
	    }
	    catch(IOException e)
	    {
	         e.printStackTrace();
	        
	    }
	   }  
	
	public static int SetSync()
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READWRITE);
		
	
		  
		  Calendar c = Calendar.getInstance();
		  SimpleDateFormat df = new SimpleDateFormat("HH:mm dd-MM-yyyy");
		  String Date = df.format(c.getTime());
		  
		  
		ContentValues values = new ContentValues();
	     values.put("date", Date);
	       
	     database.update("sync", values, "id" + " = ?",
	             new String[] { String.valueOf(0) });
	     
	     
	    database.close();
	    
	    
	    
		return 1;
	}
	
	
	public static int SetExchangerate(int id,float tien)
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READWRITE);
		
		ContentValues values = new ContentValues();
	     values.put("tien", tien);
	       
	     database.update("exchange_rate", values, "id" + " = ?",
	             new String[] { String.valueOf(id) });
	     
	     
	    database.close();
	    
	    
	    
		return 1;
	}
	public static int SetCurrency(int set)
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READWRITE);
		String currency = "";
		if (set == 0) currency = "đ";
		if (set == 1) currency = "$";
		if (set == 2) currency = "£";
		if (set == 3) currency = "€";
		ContentValues values = new ContentValues();
	     values.put("currency", currency);
	       
	     database.update("currency", values, "id" + " = ?",
	             new String[] { String.valueOf(0) });
	     
	     
	    database.close();
	    
	    
	    
		return 1;
	}
	
	public static int SetPasscode(String set)
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READWRITE);
		
		ContentValues values = new ContentValues();
	     values.put("passcode", set);
	       
	     database.update("passcode", values, "id" + " = ?",
	             new String[] { String.valueOf(0) });
	     
	     
	    database.close();
	    
	    
	    
		return 1;
	}
	
	public static String getPasscode()
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READONLY);
		Cursor cursor = database.rawQuery("select * from passcode", null);
		
		
		if(cursor.moveToFirst())
	    {
	        
			 do
			 {
				  
				    	return cursor.getString(cursor.getColumnIndex("passcode"));
				    
				  
				 
			 }while(cursor.moveToNext());
		 }
	    cursor.close();
	    database.close();
	    return "";
	}
	
	public static void setStatePasscode(int id)
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READWRITE);
		
		ContentValues values = new ContentValues();
	     values.put("state", id);
	       
	     database.update("passcode", values, "id" + " = ?",
	             new String[] { String.valueOf(0) });
	     
	     
	    database.close();
	  
	}
	
	public static boolean getStatePasscode()
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READONLY);
		Cursor cursor = database.rawQuery("select * from passcode", null);
		
		
		if(cursor.moveToFirst())
	    {
	        
			 do
			 {
				  if (cursor.getInt(cursor.getColumnIndex("state")) == 1)
				    	return true;
				    
				  
				 
			 }while(cursor.moveToNext());
		 }
	    cursor.close();
	    database.close();
	    return false;
	}
	public static int GetTienThuTheoNgay(String Date)
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READONLY);
		Cursor cursor = database.rawQuery("select * from thu", null);
		
		int Tien = 0;
		
		if(cursor.moveToFirst())
	    {
	        
			 do
			 {
				  int _index = cursor.getString(cursor.getColumnIndex("ngay_thu")).indexOf(Date);
				  if (_index > 0)
				  {
					  Tien = Tien + cursor.getInt(cursor.getColumnIndex("so_tien_thu"));
				  }
				 
			 }while(cursor.moveToNext());
		 }
	    cursor.close();
	    database.close();
	    
	    
		return Tien;
	}
	
	public static int GetTienBanDangNo(String Date)
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READONLY);
		Cursor cursor = database.rawQuery("select * from vay_no", null);
		
		int Tien = 0;
		
		if(cursor.moveToFirst())
	    {
	        
			 do
			 {
				  int _index = cursor.getString(cursor.getColumnIndex("date")).indexOf(Date);
				  if (_index > 0)
				  {
					  if (cursor.getInt(cursor.getColumnIndex("loai_hinh")) == 1)
					  {
						  Tien = Tien + cursor.getInt(cursor.getColumnIndex("tien"));
					  }
				  }
				 
			 }while(cursor.moveToNext());
		 }
	    cursor.close();
	    database.close();
	    
	    
		return Tien;
	}
	
	public static int GetTienDangNoBan(String Date)
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READONLY);
		Cursor cursor = database.rawQuery("select * from vay_no", null);
		
		int Tien = 0;
		
		if(cursor.moveToFirst())
	    {
	        
			 do
			 {
				  int _index = cursor.getString(cursor.getColumnIndex("date")).indexOf(Date);
				  if (_index > 0)
				  {
					  if (cursor.getInt(cursor.getColumnIndex("loai_hinh")) == 2)
					  {
						  Tien = Tien + cursor.getInt(cursor.getColumnIndex("tien"));
					  }
				  }
				 
			 }while(cursor.moveToNext());
		 }
	    cursor.close();
	    database.close();
	    
	    
		return Tien;
	}
	
	public static float getExchangerate(int id)
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READONLY);
		Cursor cursor = database.rawQuery("select * from exchange_rate", null);
		
		
		if(cursor.moveToFirst())
	    {
	        
			 do
			 {
				    if (cursor.getInt(cursor.getColumnIndex("id")) == id)
				    {
				    	return cursor.getFloat(cursor.getColumnIndex("tien"));
				    }
				   
				 
			 }while(cursor.moveToNext());
		 }
	    cursor.close();
	    database.close();
	    return 0;
	}
	
	public static String getstateremind()
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READONLY);
		Cursor cursor = database.rawQuery("select * from rebootdevice", null);
		
		String result ="";
		if(cursor.moveToFirst())
	    {
	        
			 do
			 {
				 
				    	result = Integer.toString(cursor.getInt(cursor.getColumnIndex("setenable"))) + "/" + cursor.getString(cursor.getColumnIndex("time")) + "/" + Integer.toString(cursor.getInt(cursor.getColumnIndex("repeat")));
				    	return result;
				    
				   
				 
			 }while(cursor.moveToNext());
		 }
	    cursor.close();
	    database.close();
	    return result;
	}
	
	public static int setstateremind(int state)
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READWRITE);
		
		ContentValues values = new ContentValues();
	     values.put("setenable", state);
	    
	     database.update("rebootdevice", values, "id" + " = ?",
	             new String[] { String.valueOf(0) });
	     
	     
	    database.close();
	    return 0;
	}
	
	public static int settimeremind(String time,int repeat)
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READWRITE);
		
		ContentValues values = new ContentValues();
	     
	     values.put("time", time);  
	     values.put("repeat", repeat); 
	     database.update("rebootdevice", values, "id" + " = ?",
	             new String[] { String.valueOf(0) });
	     
	     
	    database.close();
	    return 0;
	}
	
	public static int UpdateTienThu(int id)
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READWRITE);
		Cursor cursor = database.rawQuery("select * from thu", null);
		
		int Tien = 0;
		float exchange_rate = getExchangerate(id);
		if(cursor.moveToFirst())
	    {
	        
			 do
			 {
				 float tien = cursor.getFloat(cursor.getColumnIndex("so_tien_thu"));
				 float newtien = tien/exchange_rate;
			 }while(cursor.moveToNext());
		 }
	    cursor.close();
	    database.close();
	    
	    
		return Tien;
	}
	
	
	public static int GetTienChiTheoNgay(String Date)
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READONLY);
		Cursor cursor = database.rawQuery("select * from chi", null);
		
		int Tien = 0;
		
		if(cursor.moveToFirst())
	    {
	        
			 do
			 {
				  int _index = cursor.getString(cursor.getColumnIndex("ngay_chi")).indexOf(Date);
				  if (_index > 0)
				  {
					  Tien = Tien + cursor.getInt(cursor.getColumnIndex("so_tien_chi"));
				  }
				 
			 }while(cursor.moveToNext());
		 }
	    cursor.close();
	    database.close();
	    
	    
		return Tien;
	}
	
	
	public static DoiTuongEdit GetDoiTuongEdit(int id,int dang)
	{
		DoiTuongEdit edit = null;// = new DoiTuongEdit()
		if (dang == 0)
		{
			SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
	                null, SQLiteDatabase.OPEN_READONLY);
			Cursor cursor = database.rawQuery("select * from thu", null);
			
		
			
			if(cursor.moveToFirst())
		    {
		        
				 do
				 {
					 if (cursor.getInt(cursor.getColumnIndex("id")) == id)
					 {
						 edit = new DoiTuongEdit(
								 cursor.getInt(cursor.getColumnIndex("so_tien_thu")),
								 "",
								 cursor.getInt(cursor.getColumnIndex("ma_ngan_sach")),
								 cursor.getString(cursor.getColumnIndex("ngay_thu")),
								 cursor.getString(cursor.getColumnIndex("ghi_chu"))
								 );
						 break;
					 }
					 
				 }while(cursor.moveToNext());
			 }
		    cursor.close();
		    database.close();
		    
		}
	    
		if (dang == 1)
		{
			SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
	                null, SQLiteDatabase.OPEN_READONLY);
			Cursor cursor = database.rawQuery("select * from chi", null);
			
		
			
			if(cursor.moveToFirst())
		    {
		        
				 do
				 {
					 if (cursor.getInt(cursor.getColumnIndex("id")) == id)
					 {
						 edit = new DoiTuongEdit(
								 cursor.getInt(cursor.getColumnIndex("so_tien_chi")),
								 "",
								 cursor.getInt(cursor.getColumnIndex("ma_ngan_sach")),
								 cursor.getString(cursor.getColumnIndex("ngay_chi")),
								 cursor.getString(cursor.getColumnIndex("ghi_chu"))
								 );
						 break;
					 }
					 
				 }while(cursor.moveToNext());
			 }
		    cursor.close();
		    database.close();
		}
		
		if (dang == 3)
		{
			SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
	                null, SQLiteDatabase.OPEN_READONLY);
			Cursor cursor = database.rawQuery("select * from vay_no", null);
			
		
			
			if(cursor.moveToFirst())
		    {
		        
				 do	
				 {
					 if (cursor.getInt(cursor.getColumnIndex("id")) == id)
					 {
						 edit = new DoiTuongEdit(
								 cursor.getInt(cursor.getColumnIndex("tien")),
								 cursor.getString(cursor.getColumnIndex("who")),
								 cursor.getInt(cursor.getColumnIndex("ma_ngan_sach")),
								 cursor.getString(cursor.getColumnIndex("date")),
								 cursor.getString(cursor.getColumnIndex("ghi_chu"))
								 );
						 break;
					 }
					 
				 }while(cursor.moveToNext());
			 }
		    cursor.close();
		    database.close();
		}
		
		if (dang == 4)
		{
			SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
	                null, SQLiteDatabase.OPEN_READONLY);
			Cursor cursor = database.rawQuery("select * from vay_no", null);
			
		
			
			if(cursor.moveToFirst())
		    {
		        
				 do
				 {
					 if (cursor.getInt(cursor.getColumnIndex("id")) == id)
					 {
						 edit = new DoiTuongEdit(
								 cursor.getInt(cursor.getColumnIndex("tien")),
								 cursor.getString(cursor.getColumnIndex("who")),
								 cursor.getInt(cursor.getColumnIndex("ma_ngan_sach")),
								 cursor.getString(cursor.getColumnIndex("date")),
								 cursor.getString(cursor.getColumnIndex("ghi_chu"))
								 );
						 break;
					 }
					 
				 }while(cursor.moveToNext());
			 }
		    cursor.close();
		    database.close();
		}
		
		return edit;
	}
	
	
	public static ArrayList<DoiTuongDay> GetAllDateThisMonth()
	{
		AllThuMoneyThisMonth = 0;
		AllChiMoneyThisMonth = 0;
		ArrayList<DoiTuongDay> arrayList = null;
		  
	    SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
	                                                null, SQLiteDatabase.OPEN_READONLY);
	    Cursor cursor = database.rawQuery("select * from ngay", null);
	  
	    Calendar c = Calendar.getInstance();
		  SimpleDateFormat df = new SimpleDateFormat("MM-yyyy");
		  String thismonth = df.format(c.getTime());
		  
		  arrayList = new ArrayList<DoiTuongDay>();
		  ArrayList<Doituonggido> listdoituong = new ArrayList<Doituonggido>();
	    if(cursor.moveToFirst())
	    {
	         
			 do
			 {
				 
				 Doituonggido testasd = new Doituonggido(cursor.getString(cursor.getColumnIndex("date")),cursor.getString(cursor.getColumnIndex("dayofweek")));
				 listdoituong.add(testasd);
				 
				 
			 }while(cursor.moveToNext());
		 }
	    
	    Collections.sort(listdoituong, new Comparator<Doituonggido>() {
            @Override
            public int compare(Doituonggido sv1, Doituonggido sv2) {
            	String tach1[] = sv1.date.split("-");
            	String tach2[] = sv2.date.split("-");
            	int result1 = Integer.parseInt(tach1[0]);
            	int result2 = Integer.parseInt(tach2[0]);
                if (result1 < result2) {
                    return -1;
                } else {
                    if (result1 == result2) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            }
        });
	    
	    
	    
	    for(int i = 0;i<listdoituong.size();i++)
	    {
	    	int _index = listdoituong.get(i).date.indexOf(thismonth);
			  if (_index > 0)
			  {
			  
				 DoiTuongDay day = new DoiTuongDay();
				 
				 day.SetDate(listdoituong.get(i).date);
				 day.Setdayofweek(listdoituong.get(i).dateofweek);
				 int sotienthu = GetTienThuTheoNgay(listdoituong.get(i).date);
				 int sotienbandangno = GetTienBanDangNo(listdoituong.get(i).date);
				 sotienthu = sotienthu + sotienbandangno;
				 int sotienchi = GetTienChiTheoNgay(listdoituong.get(i).date);
				 int sotiendangnoban = GetTienDangNoBan(listdoituong.get(i).date);
				 sotienchi = sotienchi + sotiendangnoban;
				 day.SetThu(Integer.toString(sotienthu));
				 day.SetChi(Integer.toString(sotienchi));
				 AllThuMoneyThisMonth += sotienthu;
				 AllChiMoneyThisMonth += sotienchi;
				 if (sotienthu > 0 || sotienchi > 0)
			        arrayList.add(day);
			  }
	    }
	    cursor.close();
	    database.close();
	    return arrayList;
	}
	
	public static ArrayList<DoiTuongDay> GetAllDateTheoMonth(String month)
	{
		AllThuMoneyTheoMonth = 0;
		AllChiMoneyTheoMonth = 0;
		ArrayList<DoiTuongDay> arrayList = null;
		  
	    SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
	                                                null, SQLiteDatabase.OPEN_READONLY);
	    Cursor cursor = database.rawQuery("select * from ngay", null);
	  
	 
		  
		  arrayList = new ArrayList<DoiTuongDay>();
		  ArrayList<Doituonggido> listdoituong = new ArrayList<Doituonggido>();
	    if(cursor.moveToFirst())
	    {
	         
			 do
			 {
				 
				 Doituonggido testasd = new Doituonggido(cursor.getString(cursor.getColumnIndex("date")),cursor.getString(cursor.getColumnIndex("dayofweek")));
				 listdoituong.add(testasd);
				 
				 
			 }while(cursor.moveToNext());
		 }
	    
	    Collections.sort(listdoituong, new Comparator<Doituonggido>() {
            @Override
            public int compare(Doituonggido sv1, Doituonggido sv2) {
            	String tach1[] = sv1.date.split("-");
            	String tach2[] = sv2.date.split("-");
            	int result1 = Integer.parseInt(tach1[0]);
            	int result2 = Integer.parseInt(tach2[0]);
                if (result1 < result2) {
                    return -1;
                } else {
                    if (result1 == result2) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            }
        });
	    
	    
	    
	    for(int i = 0;i<listdoituong.size();i++)
	    {
	    	int _index = listdoituong.get(i).date.indexOf(month);
			  if (_index > 0)
			  {
			  
				 DoiTuongDay day = new DoiTuongDay();
				 
				 day.SetDate(listdoituong.get(i).date);
				 day.Setdayofweek(listdoituong.get(i).dateofweek);
				 int sotienthu = GetTienThuTheoNgay(listdoituong.get(i).date);
				 int sotienbandangno = GetTienBanDangNo(listdoituong.get(i).date);
				 sotienthu = sotienthu + sotienbandangno;
				 int sotienchi = GetTienChiTheoNgay(listdoituong.get(i).date);
				 int sotiendangnoban = GetTienDangNoBan(listdoituong.get(i).date);
				 sotienchi = sotienchi + sotiendangnoban;
				 day.SetThu(Integer.toString(sotienthu));
				 day.SetChi(Integer.toString(sotienchi));
				 AllThuMoneyTheoMonth += sotienthu;
				 AllChiMoneyTheoMonth += sotienchi;
				 if (sotienthu > 0 || sotienchi > 0)
			        arrayList.add(day);
			  }
	    }
	    cursor.close();
	    database.close();
	    return arrayList;
	}
	
	
	public static ArrayList<DoiTuongDay> GetAllDateThangSau()
	{
		AllThuMoneyAfterMonth = 0;
		AllChiMoneyAfterMonth = 0;
		
		ArrayList<DoiTuongDay> arrayList = null;
		  
	    SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
	                                                null, SQLiteDatabase.OPEN_READONLY);
	    Cursor cursor = database.rawQuery("select * from ngay", null);
	  
	    Calendar now = Calendar.getInstance();
		now.add(Calendar.MONTH, 1);
		int month = now.get(Calendar.MONTH) + 1;  
		int year = now.get(Calendar.YEAR); 
		String aftermonth = Integer.toString(month) + "-" + Integer.toString(year);
		
		System.out.println(aftermonth);
		  arrayList = new ArrayList<DoiTuongDay>();
		  ArrayList<Doituonggido> listdoituong = new ArrayList<Doituonggido>();
	    if(cursor.moveToFirst())
	    {
	         
			 do
			 {
				 
				 Doituonggido testasd = new Doituonggido(cursor.getString(cursor.getColumnIndex("date")),cursor.getString(cursor.getColumnIndex("dayofweek")));
				 listdoituong.add(testasd);
				 
				 
			 }while(cursor.moveToNext());
		 }
	    
	    Collections.sort(listdoituong, new Comparator<Doituonggido>() {
            @Override
            public int compare(Doituonggido sv1, Doituonggido sv2) {
            	String tach1[] = sv1.date.split("-");
            	String tach2[] = sv2.date.split("-");
            	int result1 = Integer.parseInt(tach1[0]);
            	int result2 = Integer.parseInt(tach2[0]);
                if (result1 < result2) {
                    return -1;
                } else {
                    if (result1 == result2) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            }
        });
	    
	    
	    
	    for(int i = 0;i<listdoituong.size();i++)
	    {
	    	int _index = listdoituong.get(i).date.indexOf(aftermonth);
			  if (_index > 0)
			  {
			  
				 DoiTuongDay day = new DoiTuongDay();
				 
				 day.SetDate(listdoituong.get(i).date);
				 day.Setdayofweek(listdoituong.get(i).dateofweek);
				 int sotienthu = GetTienThuTheoNgay(listdoituong.get(i).date);
				 int sotienbandangno = GetTienBanDangNo(listdoituong.get(i).date);
				 sotienthu = sotienthu + sotienbandangno;
				 int sotienchi = GetTienChiTheoNgay(listdoituong.get(i).date);
				 int sotiendangnoban = GetTienDangNoBan(listdoituong.get(i).date);
				 sotienchi = sotienchi + sotiendangnoban;
				 day.SetThu(Integer.toString(sotienthu));
				 day.SetChi(Integer.toString(sotienchi));
				 AllThuMoneyAfterMonth += sotienthu;
				 AllChiMoneyAfterMonth += sotienchi;
				 if (sotienthu > 0 || sotienchi > 0)
			        arrayList.add(day);
			  }
	    }
	    cursor.close();
	    database.close();
	    return arrayList;
	}
	
	public static ArrayList<String> GetAllDate()
	{
	
		
		ArrayList<String> arrayList = null;
		  
	    SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
	                                                null, SQLiteDatabase.OPEN_READONLY);
	    Cursor cursor = database.rawQuery("select * from ngay", null);
	  
	    String samedate = "";
		  arrayList = new ArrayList<String>();
	    if(cursor.moveToFirst())
	    {
	         
			 do
			 {
				 String date = cursor.getString(cursor.getColumnIndex("date"));
				 String getdate = date.substring(3, date.length());
				 
				
				 arrayList.add(getdate);
				 
			 }while(cursor.moveToNext());
		 }
	    ArrayList<String> newarrayList = new ArrayList<String>();
	    Set<String> uniqueSet = new HashSet<String>(arrayList);
	    for (String temp : uniqueSet) {
	    	newarrayList.add(temp);
	        //System.out.println(temp + ": " + Collections.frequency(arrayList, temp));
	    }
	    
	    
	   
	    
	    cursor.close();
	    database.close();
	    return newarrayList;
	}
	
	public static ArrayList<DoiTuongDay> GetAllDateThangTruoc()
	{
		AllThuMoneyBeforeMonth = 0;
		AllChiMoneyBeforeMonth = 0;
		ArrayList<DoiTuongDay> arrayList = null;
		  
	    SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
	                                                null, SQLiteDatabase.OPEN_READONLY);
	    Cursor cursor = database.rawQuery("select * from ngay", null);
	  
	    Calendar now = Calendar.getInstance();
		now.add(Calendar.MONTH, -1);
		int month = now.get(Calendar.MONTH) + 1;  
		int year = now.get(Calendar.YEAR); 
		String aftermonth = Integer.toString(month) + "-" + Integer.toString(year);
		
		System.out.println(aftermonth);
		  arrayList = new ArrayList<DoiTuongDay>();
		  ArrayList<Doituonggido> listdoituong = new ArrayList<Doituonggido>();
	    if(cursor.moveToFirst())
	    {
	         
			 do
			 {
				 
				 Doituonggido testasd = new Doituonggido(cursor.getString(cursor.getColumnIndex("date")),cursor.getString(cursor.getColumnIndex("dayofweek")));
				 listdoituong.add(testasd);
				 
				 
			 }while(cursor.moveToNext());
		 }
	    
	    Collections.sort(listdoituong, new Comparator<Doituonggido>() {
            @Override
            public int compare(Doituonggido sv1, Doituonggido sv2) {
            	String tach1[] = sv1.date.split("-");
            	String tach2[] = sv2.date.split("-");
            	int result1 = Integer.parseInt(tach1[0]);
            	int result2 = Integer.parseInt(tach2[0]);
                if (result1 < result2) {
                    return -1;
                } else {
                    if (result1 == result2) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            }
        });
	    
	    
	    
	    for(int i = 0;i<listdoituong.size();i++)
	    {
	    	int _index = listdoituong.get(i).date.indexOf(aftermonth);
			  if (_index > 0)
			  {
			  
				 DoiTuongDay day = new DoiTuongDay();
				 
				 day.SetDate(listdoituong.get(i).date);
				 day.Setdayofweek(listdoituong.get(i).dateofweek);
				 int sotienthu = GetTienThuTheoNgay(listdoituong.get(i).date);
				 int sotienbandangno = GetTienBanDangNo(listdoituong.get(i).date);
				 sotienthu = sotienthu + sotienbandangno;
				 int sotienchi = GetTienChiTheoNgay(listdoituong.get(i).date);
				 int sotiendangnoban = GetTienDangNoBan(listdoituong.get(i).date);
				 sotienchi = sotienchi + sotiendangnoban;
				 day.SetThu(Integer.toString(sotienthu));
				 day.SetChi(Integer.toString(sotienchi));
				 AllThuMoneyBeforeMonth += sotienthu;
				 AllChiMoneyBeforeMonth += sotienchi;
				 if (sotienthu > 0 || sotienchi > 0)
			        arrayList.add(day);
			  }
	    }
	    cursor.close();
	    database.close();
	    return arrayList;
	}
	
	
	public static String TuThuNgaySangSo(String thungay)
	{
		int result = 0;
		
		if (thungay.equals("Monday")) result = 2;
		if (thungay.equals("Tuesday")) result = 3;
		if (thungay.equals("Wednesday")) result = 4;
		if (thungay.equals("Thursday")) result = 5;
		if (thungay.equals("Friday")) result = 6;
		if (thungay.equals("Saturday")) result = 7;
		if (thungay.equals("Sunday")) result = 1;
		
		if (thungay.equals("hai")) result = 2;
		if (thungay.equals("ba")) result = 3;
		if (thungay.equals("tư")) result = 4;
		if (thungay.equals("năm")) result = 5;
		if (thungay.equals("sáu")) result = 6;
		if (thungay.equals("bảy")) result = 7;
		if (thungay.equals("nhật")) result = 1;
		
		return Integer.toString(result);
	}
	
	public static ArrayList<DoiTuongVayNo> GetAllVayNo()
	{
		ArrayList<DoiTuongVayNo> arrayList = null;
		  
	    SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
	                                                null, SQLiteDatabase.OPEN_READONLY);
	    Cursor cursor = database.rawQuery("select * from vay_no", null);
	  
	    //kiểm tra cursor có dữ liệu không? Nếu có, thưc hiện lấy dữ liệu từ cursor 
	    //cho vào mảng arrayList
	    arrayList = new ArrayList<DoiTuongVayNo>();
	    if(cursor.moveToFirst())
	    {
	        
			 do
			 {
				 if (Integer.parseInt(cursor.getString(cursor.getColumnIndex("giai_quyet"))) == 1)
				 {
				                      DoiTuongVayNo VayNo = new DoiTuongVayNo(
						               cursor.getInt(cursor.getColumnIndex("id")),
								       cursor.getString(cursor.getColumnIndex("date")),
								       cursor.getInt(cursor.getColumnIndex("tien")),
								       cursor.getString(cursor.getColumnIndex("who")),
								       cursor.getString(cursor.getColumnIndex("ghi_chu")),
								       Integer.parseInt(cursor.getString(cursor.getColumnIndex("loai_hinh"))),
								       Integer.parseInt(cursor.getString(cursor.getColumnIndex("giai_quyet"))),
								       cursor.getInt(cursor.getColumnIndex("ma_ngan_sach")));
						 
						 
						
			     
				 	     arrayList.add(VayNo);
				 }
			 }while(cursor.moveToNext());
		 }
	    cursor.close();
	    database.close();
	    return arrayList;
	}
	public static ArrayList<DoiTuongLoaiHinhChi> GetAllLoaiHinhChi()
	{
		ArrayList<DoiTuongLoaiHinhChi> arrayList = null;
		  
	    SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
	                                                null, SQLiteDatabase.OPEN_READONLY);
	    Cursor cursor = database.rawQuery("select * from loai_hinh_chi", null);
	  
	    //kiểm tra cursor có dữ liệu không? Nếu có, thưc hiện lấy dữ liệu từ cursor 
	    //cho vào mảng arrayList
	    arrayList = new ArrayList<DoiTuongLoaiHinhChi>();
	    if(cursor.moveToFirst())
	    {
	         
			 do
			 {
				 DoiTuongLoaiHinhChi LoaiHinhChi = new DoiTuongLoaiHinhChi(
						 cursor.getInt(cursor.getColumnIndex("ma_chi")),
						 cursor.getString(cursor.getColumnIndex("ten")),
						 cursor.getString(cursor.getColumnIndex("icon")));
			     
				 	     arrayList.add(LoaiHinhChi);
			 }while(cursor.moveToNext());
		 }
	    cursor.close();
	    database.close();
	    return arrayList;
	}
	
	public static void CreateDate()
	{
		  Calendar cal = Calendar.getInstance(); 

		 
		  
		  Calendar c = Calendar.getInstance();
		  SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		  SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		  String full_date = df.format(c.getTime());
		  String dayOfTheWeek = sdf.format(c.getTime());
		  System.out.println(dayOfTheWeek);
		  
		  SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                  null, SQLiteDatabase.OPEN_READWRITE);
			Cursor cursor = database.rawQuery("select * from ngay", null);
			boolean flag = false;
			int last_ma = 0;
			if(cursor.moveToFirst())
			{
			
			do
			{
		
				last_ma++;
			   if (full_date.equals(cursor.getString(cursor.getColumnIndex("date"))) && flag == false)
			   {
				   System.out.println("zo");
				   flag = true;
			
			   }
			
			
			}while(cursor.moveToNext());
			}
			
			
			cursor.close();
			
			
			if (flag == false)
			{
				ContentValues values = new ContentValues();
			     values.put("id", last_ma);
			     values.put("date", full_date);
			     values.put("dayofweek", dayOfTheWeek);
			     database.insert("ngay", null, values);   
			}
			
			database.close();
	}
	
	
	public static void CreateDate(String Date)
	{
		  
		String dayOfTheWeek = GetDayOfWeek(Date);
		System.out.println(dayOfTheWeek);
		  SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                  null, SQLiteDatabase.OPEN_READWRITE);
			Cursor cursor = database.rawQuery("select * from ngay", null);
			boolean flag = false;
			int last_ma = 0;
			if(cursor.moveToFirst())
			{
			
			do
			{
		
				last_ma++;
			   if (Date.equals(cursor.getString(cursor.getColumnIndex("date"))) && flag == false)
			   {
				   System.out.println("zo");
				   flag = true;
			
			   }
			
			
			}while(cursor.moveToNext());
			}
			
			
			cursor.close();
			
			
			if (flag == false)
			{
		
				ContentValues values = new ContentValues();
			     values.put("id", last_ma);
			     values.put("date", Date);
			     values.put("dayofweek", dayOfTheWeek);
			     database.insert("ngay", null, values);   
			}
			
			Calendar cal = Calendar.getInstance(); 

			 
			  
			
			  
			  
			database.close();
	}
	public static String formatso(String cleanString)
	{
		if (cleanString.length() > 3 && cleanString.length() < 7)
	    {
			return tach_so_1(cleanString);
	    }
	    else if(cleanString.length() > 6 && cleanString.length() < 10)
	    {
	 	   
	 	   return tach_so_2(cleanString);
	    }
		
		return cleanString;
	}
	
	public static ArrayList<DoiTuongNganSach> GetAllNganSach()
	{
		ArrayList<DoiTuongNganSach> arrayList = null;
		  
	    SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
	                                                null, SQLiteDatabase.OPEN_READONLY);
	    Cursor cursor = database.rawQuery("select * from Ngan_Sach", null);
	  
	    //kiểm tra cursor có dữ liệu không? Nếu có, thưc hiện lấy dữ liệu từ cursor 
	    //cho vào mảng arrayList
	    arrayList = new ArrayList<DoiTuongNganSach>();
	    if(cursor.moveToFirst())
	    {
	         
			 do
			 {
				 
				 DoiTuongNganSach NganSach = new DoiTuongNganSach(
						 cursor.getInt(cursor.getColumnIndex("_id")),
						 cursor.getString(cursor.getColumnIndex("ten")),
						 cursor.getInt(cursor.getColumnIndex("tien")),
						 cursor.getString(cursor.getColumnIndex("icon")));
			     
				 		   arrayList.add(NganSach);
			 }while(cursor.moveToNext());
		 }
	    cursor.close();
	    database.close();
	    return arrayList;
	}
	
	
	public static int GetCountNganSach()
	{
		
		int dem = 0;
	    SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
	                                                null, SQLiteDatabase.OPEN_READONLY);
	    Cursor cursor = database.rawQuery("select * from Ngan_Sach", null);
	  
	  
	    if(cursor.moveToFirst())
	    {
	         
			 do
			 {
				dem++;
			 }while(cursor.moveToNext());
		 }
	    cursor.close();
	    database.close();
	    return dem;
	}
	
	
	public static ArrayList<DoiTuongThongkeTietKiem> GetAllTietKiem()
	{
		ArrayList<DoiTuongThongkeTietKiem> arrayList = null;
		  
	    SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
	                                                null, SQLiteDatabase.OPEN_READONLY);
	    Cursor cursor = database.rawQuery("select * from report_tietkiem", null);
	  
	    //kiểm tra cursor có dữ liệu không? Nếu có, thưc hiện lấy dữ liệu từ cursor 
	    //cho vào mảng arrayList
	    arrayList = new ArrayList<DoiTuongThongkeTietKiem>();
	    if(cursor.moveToFirst())
	    {
	         
			 do
			 {
				 
				 DoiTuongThongkeTietKiem tietkiem = new DoiTuongThongkeTietKiem(
						 cursor.getString(cursor.getColumnIndex("date")),
						 cursor.getString(cursor.getColumnIndex("tien")),
						 cursor.getInt(cursor.getColumnIndex("rut_gui")));
			     
				 		   arrayList.add(tietkiem);
			 }while(cursor.moveToNext());
		 }
	    cursor.close();
	    database.close();
	    return arrayList;
	}
	
	
	public static String getNganSach(int id)
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READONLY);
		Cursor cursor = database.rawQuery("select * from Ngan_Sach", null);
		
		
		if(cursor.moveToFirst())
		{
	
		do
		{
			if (cursor.getInt(cursor.getColumnIndex("_id")) == id)
			{
				return cursor.getString(cursor.getColumnIndex("ten"));
			}
			
			
			
		}while(cursor.moveToNext());
		}
		cursor.close();
		database.close();
		return "Dasdasd";
	}
	
	public static String getTienNganSach(int id)
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READONLY);
		Cursor cursor = database.rawQuery("select * from Ngan_Sach", null);
		
		
		if(cursor.moveToFirst())
		{
	
		do
		{
			if (cursor.getInt(cursor.getColumnIndex("_id")) == id)
			{
				return cursor.getString(cursor.getColumnIndex("tien"));
			}
			
			
			
		}while(cursor.moveToNext());
		}
		cursor.close();
		database.close();
		return "0";
	}
	public static ArrayList<DoiTuongThongkeDetail> ThongKeDetail(String date)
	{
		ArrayList<DoiTuongThongkeDetail> arrayList = new ArrayList<DoiTuongThongkeDetail>();
		Context mcontext = null;
		if (FuncDungChung.GetLanguage(mcontext) == 0)
		{
			arrayList.add(new DoiTuongThongkeDetail(-1,1,"INCOME","","","",0,0,"",""));
		}
		else
		{
			arrayList.add(new DoiTuongThongkeDetail(-1,1,"THU","","","",0,0,"",""));
		}
		SQLiteDatabase database;
		Cursor cursor;
	    database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
	                                                null, SQLiteDatabase.OPEN_READONLY);
	    cursor = database.rawQuery("select * from thu", null);
	  
	   
	    if(cursor.moveToFirst())
	    {
	         
			 do
			 {
				 if (cursor.getString(cursor.getColumnIndex("ngay_thu")).indexOf(date) > 0)
				 {
					        DoiTuongThongkeDetail thongkedetail = new DoiTuongThongkeDetail(
					        cursor.getInt(cursor.getColumnIndex("id")),
							 0,
							 "",
							 cursor.getString(cursor.getColumnIndex("ghi_chu")),
							 cursor.getString(cursor.getColumnIndex("ngay_thu")),
							 "",
							 0,
							 0,
							 Integer.toString(cursor.getInt(cursor.getColumnIndex("so_tien_thu"))),
							 getNganSach(cursor.getInt(cursor.getColumnIndex("ma_ngan_sach")))
							 );
					        arrayList.add(thongkedetail);
				 }
			 }while(cursor.moveToNext());
		 }
	    cursor.close();
	    database.close();
	    if (FuncDungChung.GetLanguage(mcontext) == 0)
		{
	    	arrayList.add(new DoiTuongThongkeDetail(-1,1,"EXPENSE","","","",0,0,"",""));
		}
	    else
	    {
	    	arrayList.add(new DoiTuongThongkeDetail(-1,1,"CHI","","","",0,0,"",""));
	    }
	    database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READONLY);
		cursor = database.rawQuery("select * from chi", null);
		
		
		if(cursor.moveToFirst())
		{
		
		do
		{
			if (cursor.getString(cursor.getColumnIndex("ngay_chi")).indexOf(date) > 0)
			{
				DoiTuongThongkeDetail thongkedetail = new DoiTuongThongkeDetail(
				cursor.getInt(cursor.getColumnIndex("id")),
				0,
				"",
				cursor.getString(cursor.getColumnIndex("ghi_chu")),
				cursor.getString(cursor.getColumnIndex("ngay_chi")),
				"",
				0,
				1,
				Integer.toString(cursor.getInt(cursor.getColumnIndex("so_tien_chi"))),
				 getNganSach(cursor.getInt(cursor.getColumnIndex("ma_ngan_sach")))
				);
				arrayList.add(thongkedetail);
			}
		}while(cursor.moveToNext());
		}
		cursor.close();
		database.close();

		if (FuncDungChung.GetLanguage(mcontext) == 0)
		{
			arrayList.add(new DoiTuongThongkeDetail(-1,1,"YOU ARE OWNED","","","",0,0,"",""));
		}
		else
		{
			arrayList.add(new DoiTuongThongkeDetail(-1,1,"BẠN ĐANG NỢ","","","",0,0,"",""));
		}
		database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READONLY);
		cursor = database.rawQuery("select * from vay_no", null);
		
		
		if(cursor.moveToFirst())
		{
		
		do
		{
			if (cursor.getString(cursor.getColumnIndex("date")).indexOf(date) > 0)
			{
				if(Integer.parseInt(cursor.getString(cursor.getColumnIndex("loai_hinh"))) == 1)
				{
					DoiTuongThongkeDetail thongkedetail = new DoiTuongThongkeDetail(
					cursor.getInt(cursor.getColumnIndex("id")),
					0,
					"",
					cursor.getString(cursor.getColumnIndex("ghi_chu")),
					cursor.getString(cursor.getColumnIndex("date")),
					cursor.getString(cursor.getColumnIndex("who")),
					1,
					3,
					Integer.toString(cursor.getInt(cursor.getColumnIndex("tien"))),
					getNganSach(cursor.getInt(cursor.getColumnIndex("ma_ngan_sach")))
					);
					arrayList.add(thongkedetail);
				}
			}
		}while(cursor.moveToNext());
		}
		cursor.close();
		database.close();
		
		if (FuncDungChung.GetLanguage(mcontext) == 0)
		{
			arrayList.add(new DoiTuongThongkeDetail(-1,1,"WHO IS OWED","","","",0,0,"",""));
		}
		else
		{
			arrayList.add(new DoiTuongThongkeDetail(-1,1,"ĐANG NỢ BẠN","","","",0,0,"",""));
		}
		database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READONLY);
		cursor = database.rawQuery("select * from vay_no", null);
		
		
		if(cursor.moveToFirst())
		{
		
		do
		{
			if (cursor.getString(cursor.getColumnIndex("date")).indexOf(date) > 0)
			{
				if(Integer.parseInt(cursor.getString(cursor.getColumnIndex("loai_hinh"))) == 2)
				{
					DoiTuongThongkeDetail thongkedetail = new DoiTuongThongkeDetail(
					cursor.getInt(cursor.getColumnIndex("id")),
					0,
					"",
					cursor.getString(cursor.getColumnIndex("ghi_chu")),
					cursor.getString(cursor.getColumnIndex("date")),
					cursor.getString(cursor.getColumnIndex("who")),
					1,
					4,
					Integer.toString(cursor.getInt(cursor.getColumnIndex("tien"))),
					 getNganSach(cursor.getInt(cursor.getColumnIndex("ma_ngan_sach")))
					);
					arrayList.add(thongkedetail);
				}
			}
		}while(cursor.moveToNext());
		}
		cursor.close();
		database.close();
	    return arrayList;
	}
	
	public static void InsertDAta()
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READWRITE);
		
		
		 ContentValues values = new ContentValues();
	     values.put("_id", 2);
	     values.put("ten", "Tiết Kiệm");
	     values.put("tien", "30000");   
	     database.insert("Ngan_Sach", null, values);   
		database.close();
	}
	public static int GetNganSach(int id)
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READWRITE);
		Cursor cursor = database.rawQuery("select * from Ngan_Sach where _id=?", 
                new String[]{String.valueOf(id)});
		String Tien = "";
		if(cursor.moveToFirst())
	    {
	        do
	        {
	            
	        	Tien = cursor.getString(cursor.getColumnIndex("tien"));
	         }while(cursor.moveToNext());
	    }
		
		cursor.close();
	    database.close();
		int result = Integer.parseInt(Tien);
		return result;
	}
	
	public static void UpdateDataThuNganSach(int id,int newTien)
	{
		int Tien = GetNganSach(id);
		newTien = newTien + Tien;
		String myTien = Integer.toString(newTien);
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READWRITE);
		 ContentValues data=new ContentValues();
		 data.put("tien",myTien);
		 database.update("Ngan_Sach", data, "_id=" + id, null);
		 database.close();
	}
	
	public static void EditDataNganSach(int id,int newTien)
	{
		
		String myTien = Integer.toString(newTien);
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READWRITE);
		 ContentValues data=new ContentValues();
		 data.put("tien",myTien);
		 database.update("Ngan_Sach", data, "_id=" + id, null);
		 database.close();
	}
	
	public static void DeleteRecords(int id,String table)
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READWRITE);
		String where = "id='"+id+"'";
		database.delete(table, where, null);
		database.close();
	}
	public static void UpdateDataChiNganSach(int id,int newTien)
	{
		int Tien = GetNganSach(id);
		newTien = Tien - newTien;
		String myTien = Integer.toString(newTien);
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READWRITE);
		 ContentValues data=new ContentValues();
		 data.put("tien",myTien);
		 database.update("Ngan_Sach", data, "_id=" + id, null);
		 database.close();
	}
	
	public static void UpdateDataVayNo(int id)
	{
		
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READWRITE);
		 ContentValues data=new ContentValues();
		 data.put("giai_quyet","2");
		 database.update("vay_no", data, "id=" + id, null);
		 database.close();
	}
	
	
	public static void UpdateDataTietKiem(int Tien)
	{
		
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READWRITE);
		 ContentValues data=new ContentValues();
		 data.put("tien",Tien);
		 database.update("tietkiem", data, "id=" + 0, null);
		 database.close();

	}
	
	
	
	public static void InsertDataVayNo(String date,int Tien,String who,String ghi_chu,int loai_hinh,int giai_quyet,int ma_ngan_sach)
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READWRITE);
		
		Cursor cursor = database.rawQuery("select * from vay_no", null);
		
		int last_ma = 0;
		if(cursor.moveToFirst())
		{
		do
		{
		
		last_ma = cursor.getInt(cursor.getColumnIndex("id"));
		}while(cursor.moveToNext());
		}
		cursor.close();
		
		last_ma++;
		
		
		 ContentValues values = new ContentValues();
	     values.put("id", last_ma);
	     values.put("date", date);
	     values.put("tien", Tien);   
	     values.put("who", who);  
	     values.put("ghi_chu", ghi_chu);  
	     values.put("giai_quyet", Integer.toString(giai_quyet)); 
	     values.put("loai_hinh", Integer.toString(loai_hinh));
	     values.put("ma_ngan_sach", ma_ngan_sach); 
	     database.insert("vay_no", null, values);   
		database.close();
	}
	
	
	public static void InsertDataTietKiem(String date,int Tien,String ghi_chu,int rut_nap)
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READWRITE);
		
		Cursor cursor = database.rawQuery("select * from report_tietkiem", null);
		
		int last_ma = 0;
		if(cursor.moveToFirst())
		{
		do
		{
		
		last_ma = cursor.getInt(cursor.getColumnIndex("id"));
		}while(cursor.moveToNext());
		}
		cursor.close();
		
		last_ma++;
		
		
		 ContentValues values = new ContentValues();
	     values.put("id", last_ma);
	     values.put("date", date);
	     values.put("tien", Tien);   
	     values.put("ghi_chu", ghi_chu);  
	     values.put("rut_gui", rut_nap); 
	     database.insert("report_tietkiem", null, values);   
		database.close();
	}
	
	
	public static void InsertDataThu(String date,int so_tien_thu,int ma_thu,String ghi_chu,int ma_ngan_sach)
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READWRITE);
		
		Cursor cursor = database.rawQuery("select * from thu", null);
		
		int last_ma = 0;
		if(cursor.moveToFirst())
		{
		do
		{
		
		last_ma = cursor.getInt(cursor.getColumnIndex("id"));
		}while(cursor.moveToNext());
		}
		cursor.close();
		
		last_ma++;
		
		
		 ContentValues values = new ContentValues();
	     values.put("id", last_ma);
	     values.put("ngay_thu", date);
	     values.put("so_tien_thu", so_tien_thu);   
	     values.put("ma_thu", ma_thu);  
	     values.put("ghi_chu", ghi_chu);  
	     values.put("ma_ngan_sach", ma_ngan_sach); 
	     database.insert("thu", null, values);   
		database.close();
	}
	
	public static void InsertDataChi(String date,int so_tien_chi,int ma_chi,String ghi_chu,int ma_ngan_sach)
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READWRITE);
		
		Cursor cursor = database.rawQuery("select * from chi", null);
		
		int last_ma = 0;
		if(cursor.moveToFirst())
		{
		do
		{
		
		last_ma = cursor.getInt(cursor.getColumnIndex("id"));
		}while(cursor.moveToNext());
		}
		cursor.close();
		
		last_ma++;
		
		
		 ContentValues values = new ContentValues();
	     values.put("id", last_ma);
	     values.put("ngay_chi", date);
	     values.put("so_tien_chi", so_tien_chi);   
	     values.put("ma_chi", ma_chi);  
	     values.put("ghi_chu", ghi_chu);  
	     values.put("ma_ngan_sach", ma_ngan_sach); 
	     database.insert("chi", null, values);   
		database.close();
	}
	
	
	public static void UpdateDAta()
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READWRITE);
		
		
		 ContentValues values = new ContentValues();
	     values.put("icon", "ic_launcher.png");
	       
	     database.update("Ngan_Sach", values, "_id" + " = ?",
	             new String[] { String.valueOf(2) });
		database.close();
	}
	public static void InsertDataLoaiHinhThu_Chi(String table,String Column_ma,String Ten,String icon)
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READWRITE);
		Cursor cursor = database.rawQuery("select * from " + table, null);
		
		int last_ma = 0;
		if(cursor.moveToFirst())
		{
		do
		{
		
		last_ma = cursor.getInt(cursor.getColumnIndex(Column_ma));
		}while(cursor.moveToNext());
		}
		cursor.close();
		
		last_ma++;
		
		 ContentValues values = new ContentValues();
	     values.put(Column_ma, last_ma);
	     values.put("ten", Ten);
	     values.put("icon", icon);   
	     database.insert(table, null, values);   
		database.close();
	}
	
	public static void InsertDataNganSach(String Ten,String icon)
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READWRITE);
		Cursor cursor = database.rawQuery("select * from Ngan_Sach", null);
		
		int last_ma = 0;
		if(cursor.moveToFirst())
		{
		do
		{
		
		last_ma = cursor.getInt(cursor.getColumnIndex("_id"));
		}while(cursor.moveToNext());
		}
		cursor.close();
		
		//last_ma++;
		
		 ContentValues values = new ContentValues();
	     values.put("_id", last_ma);
	     values.put("ten", Ten);
	     values.put("icon", icon);   
	     values.put("tien", "0"); 
	     database.insert("Ngan_Sach", null, values);   
		database.close();
	}
	
	public static void InsertDataNganSach(String Ten,String Tien,String icon)
	{
		SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH_EXTERNAL + FOLDER + "/" + DATABASE, 
                null, SQLiteDatabase.OPEN_READWRITE);
		Cursor cursor = database.rawQuery("select * from Ngan_Sach", null);
		
		int last_ma = -1;
		if(cursor.moveToFirst())
		{
		do
		{
		
		last_ma = cursor.getInt(cursor.getColumnIndex("_id"));
		}while(cursor.moveToNext());
		}
		cursor.close();
		
		last_ma++;
		
		 ContentValues values = new ContentValues();
	     values.put("_id", last_ma);
	     values.put("ten", Ten);
	     values.put("icon", icon);   
	     values.put("tien", Tien); 
	     database.insert("Ngan_Sach", null, values);   
		database.close();
	}
	
	
	public static PopupWindow ShowPopupThongBao(Context context,View handle,final RelativeLayout back_dim_layout,String msg,String title)
	{
	 LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
	 View popupView = layoutInflater.inflate(R.layout.popupthongbao, null);  
	 final PopupWindow popupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  
	 
	 Button btnOK = (Button)popupView.findViewById(R.id.btnok);
	 TextView txtMsg = (TextView)popupView.findViewById(R.id.txtMsg);
	 TextView txttitle = (TextView)popupView.findViewById(R.id.textView1);
	 txttitle.setText(title);
	 txtMsg.setText(msg);
     btnOK.setOnClickListener(new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
		
		popupWindow.dismiss();
		
		
		back_dim_layout.setVisibility(View.GONE);
	}});
     
     popupWindow.showAtLocation(handle, Gravity.CENTER, 0, 0);
     
	 back_dim_layout.setVisibility(View.VISIBLE);
	 return popupWindow;
	}
	
	public static PopupWindow ShowPopupLanguage(final Context context,View handle,final RelativeLayout back_dim_layout)
	{
	 LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
	 View popupView = layoutInflater.inflate(R.layout.popuplanguage, null);  
	 final PopupWindow popupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  
	 
	 final RadioButton radioVN=(RadioButton)popupView.findViewById(R.id.radioVN);
	 final RadioButton radionEN=(RadioButton)popupView.findViewById(R.id.radioEN);
		
		
	 Button btnhuy = (Button)popupView.findViewById(R.id.btnhuy);
		
	 btnhuy.setOnClickListener(new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
			
		popupWindow.dismiss();
		
		
		back_dim_layout.setVisibility(View.GONE);
	}});
     
     
	 Button btnOK = (Button)popupView.findViewById(R.id.btnok);
	
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
		popupWindow.dismiss();
		
		
		back_dim_layout.setVisibility(View.GONE);
		
		Intent mainactivity = new Intent(context, SlideMenuAttribute.class);
		context.startActivity(mainactivity);
		
		
	}});
     popupWindow.setFocusable(true);
     popupWindow.update();
     popupWindow.showAtLocation(handle, Gravity.CENTER, 0, 0);
     
	 back_dim_layout.setVisibility(View.VISIBLE);
	 return popupWindow;
	}
	
	
	public static PopupWindow ShowPopupVayNo(final Context context,View handle,final RelativeLayout back_dim_layout,final VayNoAdapter adapter,final int id,String loai_hinh,final String who,final String Tien,String ghi_chu,String date,final int xloai_hinh)
	{
	 LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
	 View popupView = layoutInflater.inflate(R.layout.popup, null);  
	 final PopupWindow popupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  
	 TextView txtLoaiHinh = (TextView)popupView.findViewById(R.id.txtloai_hinh);
	 TextView txtwho = (TextView)popupView.findViewById(R.id.txtWho);
	 TextView txtTien = (TextView)popupView.findViewById(R.id.textView5);
	 TextView txtghichu = (TextView)popupView.findViewById(R.id.textView8);
	 TextView txtdate = (TextView)popupView.findViewById(R.id.textView10);
	 
	 txtLoaiHinh.setText(loai_hinh);
	 txtwho.setText(who);
	 txtTien.setText(formatso(Tien));
	 txtghichu.setText(ghi_chu);
	 txtdate.setText(date);
	 
	 
	 final TextView txtcurrency = (TextView)popupView.findViewById(R.id.currency);
     txtcurrency.setText(FuncDungChung.currency);
     
	 Button btnhuy = (Button)popupView.findViewById(R.id.huy);
	 Button btntrano = (Button)popupView.findViewById(R.id.trano);
	 
	 final TextView txt2 = (TextView)popupView.findViewById(R.id.textView2);
     final TextView txt4 = (TextView)popupView.findViewById(R.id.textView4);
     final TextView txt7 = (TextView)popupView.findViewById(R.id.textView7);
     final TextView txt9 = (TextView)popupView.findViewById(R.id.textView9);
     
     
     if (FuncDungChung.GetLanguage(context) == 0)
		{
     	txt2.setText("Name:");
     	txt4.setText("Money:");
     	txt7.setText("Note:");
     	txt9.setText("Date:");
     	btnhuy.setText("Exit");
     	btntrano.setText("Lent");
		}
     
     
	 
	 btnhuy.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
		
			
			popupWindow.dismiss();
			
			
			back_dim_layout.setVisibility(View.GONE);
		}});
	 
	 
	 
	 
     btntrano.setOnClickListener(new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
		
			
		//UpdateDataVayNo(id);
		
		
			 Intent mainactivity = new Intent(context, trano.class);
			 mainactivity.putExtra("tien", Tien);
			 mainactivity.putExtra("xloai_hinh", xloai_hinh);
			 mainactivity.putExtra("who", who);
			 mainactivity.putExtra("id", id);
			 context.startActivity(mainactivity);
		popupWindow.dismiss();
		
		
		back_dim_layout.setVisibility(View.GONE);
	}});
     
     popupWindow.showAtLocation(handle, Gravity.CENTER, 0, 0);
     
	 back_dim_layout.setVisibility(View.VISIBLE);
	 return popupWindow;
	}
	
	public static PopupWindow ShowPopupDetail(final Context context,View handle,final RelativeLayout back_dim_layout,String loai_hinh,String date,String Tien,String ghi_chu,String ngan_sach,final int dang,final int id)
	{
	 LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
	 View popupView = layoutInflater.inflate(R.layout.popupdetail, null);  
	 final PopupWindow popupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  
	 TextView txtLoaiHinh = (TextView)popupView.findViewById(R.id.txtloai_hinh);
	 TextView txtdate = (TextView)popupView.findViewById(R.id.txtWho);
	 TextView txtTien = (TextView)popupView.findViewById(R.id.textView5);
	 TextView txtghichu = (TextView)popupView.findViewById(R.id.textView8);
	 TextView txtNganSach = (TextView)popupView.findViewById(R.id.textView10);
	 
	 txtLoaiHinh.setText(loai_hinh);
	 txtNganSach.setText(ngan_sach);
	 txtTien.setText(formatso(Tien));
	 txtghichu.setText(ghi_chu);
	 txtdate.setText(date);
	 
	 
	 final TextView txtcurrency = (TextView)popupView.findViewById(R.id.currency);
     txtcurrency.setText(FuncDungChung.currency);
     
	
	 Button btntrano = (Button)popupView.findViewById(R.id.trano);
	 Button btnsua = (Button)popupView.findViewById(R.id.sua);
	 
	 
	 final TextView txt2 = (TextView)popupView.findViewById(R.id.textView2);
     final TextView txt4 = (TextView)popupView.findViewById(R.id.textView4);
     final TextView txt7 = (TextView)popupView.findViewById(R.id.textView7);
     final TextView txt9 = (TextView)popupView.findViewById(R.id.textView9);
     
     
     if (FuncDungChung.GetLanguage(context) == 0)
		{
     	txt2.setText("Date:");
     	txt4.setText("Money:");
     	txt7.setText("Note:");
     	txt9.setText("Account:");
     	btnsua.setText("Edit");
		}
     
     
	
	 
	 
	 
     btntrano.setOnClickListener(new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
		
			
	
	
		
		popupWindow.dismiss();
		
		
		back_dim_layout.setVisibility(View.GONE);
	}});
     
     btnsua.setOnClickListener(new Button.OnClickListener(){

 		@Override
 		public void onClick(View v) {
 			Intent localIntent = new Intent(context, edit.class);
 			localIntent.putExtra("dang", dang);
 			localIntent.putExtra("id", id);
 			context.startActivity(localIntent);
 			popupWindow.dismiss();
 			
 			
 			back_dim_layout.setVisibility(View.GONE);
 	}});
     
     
     
     popupWindow.showAtLocation(handle, Gravity.CENTER, 0, 0);
     
	 back_dim_layout.setVisibility(View.VISIBLE);
	 return popupWindow;
	}
	
	
	public static void ShowPopupGhichu(Context context,RelativeLayout btnGhiChu,final TextView tv,String title)
	{
	 LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
	 View popupView = layoutInflater.inflate(R.layout.popupghichu, null);  
	 popupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  
	 final EditText editText = (EditText)popupView.findViewById(R.id.editText1);
	 final TextView tv1 = (TextView)popupView.findViewById(R.id.textView1);
	 if (FuncDungChung.GetLanguage(context) == 0)
	 {
	      editText.setHint("type... ?");
	      
	 }
	 tv1.setText(title);
	 Button btnOK = (Button)popupView.findViewById(R.id.btnok);
     btnOK.setOnClickListener(new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
		tv.setText(editText.getText().toString());
		popupWindow.dismiss();
		
		
		SlideMenuAttribute.back_dim_layout.setVisibility(View.GONE);
	}});
     
     popupWindow.showAtLocation(btnGhiChu, Gravity.CENTER, 0, 0);
     popupWindow.setFocusable(true);
     popupWindow.update();
	 SlideMenuAttribute.back_dim_layout.setVisibility(View.VISIBLE);

	}
	
	public static PopupWindow ShowPopupGhichu(Context context,final RelativeLayout back_dim_layout,RelativeLayout btnGhiChu,final TextView tv,String title)
	{
	 LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
	 View popupView = layoutInflater.inflate(R.layout.popupghichu, null);  
	 popupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  
	 final EditText editText = (EditText)popupView.findViewById(R.id.editText1);
	 final TextView tv1 = (TextView)popupView.findViewById(R.id.textView1);
	 if (FuncDungChung.GetLanguage(context) == 0)
	 {
	      editText.setHint("type... ?");
	 }
	 tv1.setText(title);
	 Button btnOK = (Button)popupView.findViewById(R.id.btnok);
     btnOK.setOnClickListener(new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
		tv.setText(editText.getText().toString());
		popupWindow.dismiss();
		
		
		back_dim_layout.setVisibility(View.GONE);
	}});
     
     popupWindow.showAtLocation(btnGhiChu, Gravity.CENTER, 0, 0);
     popupWindow.setFocusable(true);
     popupWindow.update();
	 back_dim_layout.setVisibility(View.VISIBLE);
	 return popupWindow;
	}
	
	
	public static void ShowPopupThemNganSach(Context context,ImageView btThem,final RelativeLayout back_dim_layout,final NganSachAdapter adapter)
	{
		LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
		View popupView = layoutInflater.inflate(R.layout.popupthem, null);  
		 popupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  
		 
		 final EditText editText = (EditText)popupView.findViewById(R.id.editText1);
		 
		 
		 Button btnOK = (Button)popupView.findViewById(R.id.btnok);
	     btnOK.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
			String Ten = editText.getText().toString();
			//tv.setText(editText.getText().toString());
			InsertDataNganSach(Ten,"ic_launcher.png");
			ArrayList<DoiTuongNganSach> list = FuncDungChung.GetAllNganSach();
			adapter.setData(list);
			adapter.notifyDataSetChanged();
			popupWindow.dismiss();
			
			
			back_dim_layout.setVisibility(View.GONE);
		}});
	     
	     
		 Button btnHuy = (Button)popupView.findViewById(R.id.btnhuy);
	     btnHuy.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
			//tv.setText(editText.getText().toString());
			popupWindow.dismiss();
			
			
			back_dim_layout.setVisibility(View.GONE);
		}});
	     
	     
		 popupWindow.showAtLocation(btThem, Gravity.CENTER, 0, 0);
	     popupWindow.setFocusable(true);
	     popupWindow.update();
	     back_dim_layout.setVisibility(View.VISIBLE);
		
	}
	
	
	public static void ShowPopupThemThu(Context context,View btThem,final RelativeLayout back_dim_layout,final LoaiHinhThuAdapter adapter)
	{
		LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
		View popupView = layoutInflater.inflate(R.layout.popupthem, null);  
		 popupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  
		 
		 final EditText editText = (EditText)popupView.findViewById(R.id.editText1);
		 
		 TextView txt1 = (TextView)popupView.findViewById(R.id.textView1);
		 Button btnHuy = (Button)popupView.findViewById(R.id.btnhuy);
		 if (FuncDungChung.GetLanguage(context) == 0)
		 {
			 txt1.setText("Add Categorty");
			 editText.setHint("Salary");
			 btnHuy.setText("Cancel");
		 }
		 
		 
		 Button btnOK = (Button)popupView.findViewById(R.id.btnok);
	     btnOK.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
			String Ten = editText.getText().toString();
			//tv.setText(editText.getText().toString());
			InsertDataLoaiHinhThu_Chi("loai_hinh_thu","ma_thu",Ten,"ic_launcher.png");
			ArrayList<DoiTuongLoaiHinhThu> list = FuncDungChung.GetAllLoaiHinhThu();
			adapter.setData(list);
			adapter.notifyDataSetChanged();
			popupWindow.dismiss();
			
			
			back_dim_layout.setVisibility(View.GONE);
		}});
	     
	     
		 
	     btnHuy.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
			//tv.setText(editText.getText().toString());
			popupWindow.dismiss();
			
			
			back_dim_layout.setVisibility(View.GONE);
		}});
	     
	     
		 popupWindow.showAtLocation(btThem, Gravity.CENTER, 0, 0);
	     popupWindow.setFocusable(true);
	     popupWindow.update();
	     back_dim_layout.setVisibility(View.VISIBLE);
		
	}
	
	public static void ShowPopupThemChi(Context context,View btThem,final RelativeLayout back_dim_layout,final LoaiHinhChiAdapter adapter)
	{
		LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
		View popupView = layoutInflater.inflate(R.layout.popupthem, null);  
		 popupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  
		 
		 final EditText editText = (EditText)popupView.findViewById(R.id.editText1);
		 
		 TextView txt1 = (TextView)popupView.findViewById(R.id.textView1);
		 Button btnHuy = (Button)popupView.findViewById(R.id.btnhuy);
		 if (FuncDungChung.GetLanguage(context) == 0)
		 {
			 txt1.setText("Add Categorty");
			 editText.setHint("Eat");
			 btnHuy.setText("Cancel");
		 }
		 
		 Button btnOK = (Button)popupView.findViewById(R.id.btnok);
	     btnOK.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
			String Ten = editText.getText().toString();
			//tv.setText(editText.getText().toString());
			InsertDataLoaiHinhThu_Chi("loai_hinh_chi","ma_chi",Ten,"ic_launcher.png");
			ArrayList<DoiTuongLoaiHinhChi> list = FuncDungChung.GetAllLoaiHinhChi();
			adapter.setData(list);
			adapter.notifyDataSetChanged();
			popupWindow.dismiss();
			
			
			back_dim_layout.setVisibility(View.GONE);
		}});
	     
	     
		 
	     btnHuy.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
			//tv.setText(editText.getText().toString());
			popupWindow.dismiss();
			
			
			back_dim_layout.setVisibility(View.GONE);
		}});
	     
	     
		 popupWindow.showAtLocation(btThem, Gravity.CENTER, 0, 0);
	     popupWindow.setFocusable(true);
	     popupWindow.update();
	     back_dim_layout.setVisibility(View.VISIBLE);
		
	}
	
	
	public static void ShowPopupDate(Context context,RelativeLayout btnGhiChu,final TextView tv)
	{
	 LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
	 View popupView = layoutInflater.inflate(R.layout.popupdate, null);  
	 popupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  
	
	
	
	  
	 final TextView txtDate = (TextView)popupView.findViewById(R.id.txtDate);
	 txtDate.setText(FuncDungChung.Date);
	 
	 Button btnSettime = (Button)popupView.findViewById(R.id.btnSettime);
	 btnSettime.setOnClickListener(new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
		tv.setText(txtDate.getText().toString());
		popupWindow.dismiss();
		
		
		
		
		SlideMenuAttribute.back_dim_layout.setVisibility(View.GONE);
	}});
     
     
	 DatePicker dp = (DatePicker) popupView.findViewById(R.id.datePicker1);
	  
	  dp.init(dp.getYear(), dp.getMonth(), dp.getDayOfMonth(),new OnDateChangedListener() {
	   
	   @Override
	   public void onDateChanged(DatePicker arg0, int arg1, int arg2, int arg3) {
	    // TODO Auto-generated method stub
		  
			  Calendar c = Calendar.getInstance();
			  SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			  SimpleDateFormat dt = new SimpleDateFormat("HH:mm");
			   String Date = df.format(c.getTime());
			  String Time = dt.format(c.getTime());
			  
			  String day = "";
			  String month = "";
			  String year = "";
			  
			  if (arg3 < 10 ) day = "0" + Integer.toString(arg3);
			  else day = Integer.toString(arg3);
			  
			  if ((arg2+1) < 10 ) month = "0" + Integer.toString((arg2+1));
			  else month = Integer.toString((arg2+1));
			  
			  year = Integer.toString(arg1);
			  
			
			  txtDate.setText(Time + " "+day+ "-"+ (month) + "-"+arg1);
	   }
	  } );
	 
		  
		  
	  TimePicker tp = (TimePicker) popupView.findViewById(R.id.timePicker1);
	  Calendar c = Calendar.getInstance();
	  SimpleDateFormat dt = new SimpleDateFormat("HH:mm");
	  
	 
        
        
	  tp.setIs24HourView(true) ;
	  tp.setCurrentHour(c.get(Calendar.HOUR_OF_DAY));
	  tp.setOnTimeChangedListener(new OnTimeChangedListener() {

          public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        	 
 			  Calendar c = Calendar.getInstance();
 			 SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
 			  SimpleDateFormat dt = new SimpleDateFormat("HH:mm");
 			   String Date = df.format(c.getTime());
 			  String Time = dt.format(c.getTime());
 			  
 			  String hour = "";
			  String min = "";
			  if (hourOfDay < 10 ) hour = "0" + Integer.toString(hourOfDay);
			  else hour = Integer.toString(hourOfDay);
			  
			  if (minute < 10 ) min = "0" + Integer.toString(minute);
			  else min = Integer.toString(minute);
			  
			  
        	  txtDate.setText(hour + (":") + min + " " + Date  );
          }
      });
	 
	  
     popupWindow.showAtLocation(btnGhiChu, Gravity.CENTER, 0, 0);
     //popupWindow.setFocusable(true);
     //popupWindow.update();
	 SlideMenuAttribute.back_dim_layout.setVisibility(View.VISIBLE);

	}
	
	public static String GetDayOfWeek(String clickedDate){
		String dateStr = "";
        try {
             
            //String clickedDate = newYear + "-" + newMonth + "-" + newDay;
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date d = sdf.parse(clickedDate);
 
            SimpleDateFormat sdfDateTime = new SimpleDateFormat("EEEE");
            dateStr = sdfDateTime.format(d);
             
            
             
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return dateStr;
    }
	
	public static PopupWindow ShowPopupDate(Context context,final RelativeLayout back_dim_layout,RelativeLayout btnGhiChu,final TextView tv)
	{
	 LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
	 View popupView = layoutInflater.inflate(R.layout.popupdate, null);  
	 popupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  
	
	
	 
	  
	 final TextView txtDate = (TextView)popupView.findViewById(R.id.txtDate);
	 txtDate.setText(FuncDungChung.Date);
	 
	 Button btnSettime = (Button)popupView.findViewById(R.id.btnSettime);
	 btnSettime.setOnClickListener(new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
		tv.setText(txtDate.getText().toString());
		popupWindow.dismiss();
		
	
		back_dim_layout.setVisibility(View.GONE);
	}});
     
     
	 DatePicker dp = (DatePicker) popupView.findViewById(R.id.datePicker1);
	  
	  dp.init(dp.getYear(), dp.getMonth(), dp.getDayOfMonth(),new OnDateChangedListener() {
	   
		  @Override
		   public void onDateChanged(DatePicker arg0, int arg1, int arg2, int arg3) {
		    // TODO Auto-generated method stub
			  
				  Calendar c = Calendar.getInstance();
				  SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				  SimpleDateFormat dt = new SimpleDateFormat("HH:mm");
				   String Date = df.format(c.getTime());
				  String Time = dt.format(c.getTime());
				  String day = "";
				  String month = "";
				  String year = "";
				  if (arg3 < 10 ) day = "0" + Integer.toString(arg3);
				  else day = Integer.toString(arg3);
				  
				  if ((arg2+1) < 10 ) month = "0" + Integer.toString((arg2+1));
				  else month = Integer.toString((arg2+1));
				  
				  year = Integer.toString(arg1);
				  
				   txtDate.setText(Time + " "+day+ "-"+ (month) + "-"+arg1);
		   }
		  } );
		 
			  
			  
		  TimePicker tp = (TimePicker) popupView.findViewById(R.id.timePicker1);
		  Calendar c = Calendar.getInstance();
		  SimpleDateFormat dt = new SimpleDateFormat("HH:mm");
		  
		
	        
	        
		  tp.setIs24HourView(true) ;
		  tp.setCurrentHour(c.get(Calendar.HOUR_OF_DAY));
		  tp.setOnTimeChangedListener(new OnTimeChangedListener() {

	          public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
	        	 
	 			  Calendar c = Calendar.getInstance();
	 			 SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	 			  SimpleDateFormat dt = new SimpleDateFormat("HH:mm");
	 			   String Date = df.format(c.getTime());
	 			  String Time = dt.format(c.getTime());
	 			  
	 			  String hour = "";
				  String min = "";
				  if (hourOfDay < 10 ) hour = "0" + Integer.toString(hourOfDay);
				  else hour = Integer.toString(hourOfDay);
				  
				  if (minute < 10 ) min = "0" + Integer.toString(minute);
				  else min = Integer.toString(minute);
				  
				 // FuncDungChung.dayofweek = FuncDungChung.GetDayOfWeek(arg1 + "-" + month + "-" + day);
				  
	        	  txtDate.setText(hour + (":") + min + " " + Date  );
	          }
	      });
	 
	  
     popupWindow.showAtLocation(btnGhiChu, Gravity.CENTER, 0, 0);
     //popupWindow.setFocusable(true);
     //popupWindow.update();
	 back_dim_layout.setVisibility(View.VISIBLE);
	 return popupWindow;
	}
	
	
	public static PopupWindow ShowPopupAlarm(Context context,final RelativeLayout back_dim_layout,View btnGhiChu)
	{
	 LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
	 View popupView = layoutInflater.inflate(R.layout.remind, null);  
	 popupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  

	  
	 final TextView txtDate = (TextView)popupView.findViewById(R.id.txtDate);
	 final TextView txtAt = (TextView)popupView.findViewById(R.id.txtAt);
	 final TextView txtrepeat = (TextView)popupView.findViewById(R.id.txtrepeat);
	 final TextView txtSet = (TextView)popupView.findViewById(R.id.txtSet);
	 if (FuncDungChung.GetLanguage(context) == 0)
	 {
		 txtDate.setText("Set time to remind you at anytime");
		 txtAt.setText("At:");
		 txtrepeat.setText("Repeat:");
		 txtSet.setText("days 1 times");
	 }
	 

	
    
	 
	  
     popupWindow.showAtLocation(btnGhiChu, Gravity.CENTER, 0, 0);
     //popupWindow.setFocusable(true);
     //popupWindow.update();
	 back_dim_layout.setVisibility(View.VISIBLE);
	 return popupWindow;
	}
}
