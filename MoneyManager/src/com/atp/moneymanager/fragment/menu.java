package com.atp.moneymanager.fragment;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;































import nAdapter.MenuAdapter;
import nAdapter.childAdapterThuChi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;











import android.widget.AdapterView.OnItemClickListener;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.OnClickPopupListener;
import com.atp.moneymanager.ShowPopupMsgbox;
import com.atp.moneymanager.DoiTuong.DoiTuongMenu;
import com.atp.moneymanager.activity.SlideMenuAttribute;
import com.atp.moneymanager.activity.about;
import com.atp.moneymanager.activity.changepass;
import com.atp.moneymanager.activity.chonloaihinhthu;
import com.atp.moneymanager.activity.createpasscode;
import com.atp.moneymanager.activity.currency;
import com.atp.moneymanager.activity.deletedata;
import com.atp.moneymanager.activity.exchangerate;
import com.atp.moneymanager.activity.login;
import com.atp.moneymanager.activity.remind;
import com.atp.moneymanager.activity.sync;
import com.atp.moneymanager.R;
public class menu extends Fragment {
	
	



	    View view;
	   
	   

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);
			
		}
		@SuppressWarnings("deprecation")
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			view = inflater.inflate(R.layout.menu, container, false);
			
			String name = FuncDungChung.GetUser();
			ArrayList<DoiTuongMenu> menu = new ArrayList<DoiTuongMenu>();
			if (FuncDungChung.GetLanguage(getActivity()) == 1)
			{
				menu.add(new DoiTuongMenu("Cá Nhân",1,BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher)));
				menu.add(new DoiTuongMenu(name,0,BitmapFactory.decodeResource(getResources(), R.drawable.user)));
				menu.add(new DoiTuongMenu("Xóa Data",0,BitmapFactory.decodeResource(getResources(), R.drawable.delete)));
				menu.add(new DoiTuongMenu("Đổi Mật Khẩu",0,BitmapFactory.decodeResource(getResources(), R.drawable.change)));
				menu.add(new DoiTuongMenu("Đồng bộ dữ liệu",0,BitmapFactory.decodeResource(getResources(), R.drawable.refresh2)));
				menu.add(new DoiTuongMenu("Thoát",0,BitmapFactory.decodeResource(getResources(), R.drawable.logout2)));
				menu.add(new DoiTuongMenu("Tiền Tệ",1,BitmapFactory.decodeResource(getResources(), R.drawable.currency)));
				menu.add(new DoiTuongMenu("Chọn Loại Tiền",0,BitmapFactory.decodeResource(getResources(), R.drawable.currency)));
				menu.add(new DoiTuongMenu("Thiết lập",1,BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher)));
				menu.add(new DoiTuongMenu("Nhắc nhở",0,BitmapFactory.decodeResource(getResources(), R.drawable.alarm)));
				menu.add(new DoiTuongMenu("Ngôn ngữ",0,BitmapFactory.decodeResource(getResources(), R.drawable.language)));
				menu.add(new DoiTuongMenu("Mã bảo vệ",0,BitmapFactory.decodeResource(getResources(), R.drawable.passcode)));
				menu.add(new DoiTuongMenu("Ứng Dụng",1,BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher)));
				menu.add(new DoiTuongMenu("Thông tin sản phẩm",0,BitmapFactory.decodeResource(getResources(), R.drawable.information)));
			}
			else
			{
				menu.add(new DoiTuongMenu("Persional",1,BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher)));
				menu.add(new DoiTuongMenu(name,0,BitmapFactory.decodeResource(getResources(), R.drawable.user)));
				menu.add(new DoiTuongMenu("Delete Data",0,BitmapFactory.decodeResource(getResources(), R.drawable.delete)));
				menu.add(new DoiTuongMenu("Change Password",0,BitmapFactory.decodeResource(getResources(), R.drawable.change)));
				menu.add(new DoiTuongMenu("Sync Data",0,BitmapFactory.decodeResource(getResources(), R.drawable.refresh2)));
				menu.add(new DoiTuongMenu("Logout",0,BitmapFactory.decodeResource(getResources(), R.drawable.logout2)));
				menu.add(new DoiTuongMenu("Currency",1,BitmapFactory.decodeResource(getResources(), R.drawable.currency)));
				menu.add(new DoiTuongMenu("Default Currency",0,BitmapFactory.decodeResource(getResources(), R.drawable.currency)));
				menu.add(new DoiTuongMenu("Settings",1,BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher)));
				menu.add(new DoiTuongMenu("Reminder",0,BitmapFactory.decodeResource(getResources(), R.drawable.alarm)));
				menu.add(new DoiTuongMenu("Language",0,BitmapFactory.decodeResource(getResources(), R.drawable.language)));
				menu.add(new DoiTuongMenu("Passcode",0,BitmapFactory.decodeResource(getResources(), R.drawable.passcode)));
				menu.add(new DoiTuongMenu("App",1,BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher)));
				menu.add(new DoiTuongMenu("About",0,BitmapFactory.decodeResource(getResources(), R.drawable.information)));
				
			}
			
			
			
			final ListView lv = (ListView)view.findViewById(R.id.listView1);
			MenuAdapter adapter = new MenuAdapter(getActivity(),menu);
			lv.setAdapter(adapter);
			
			lv.setOnItemClickListener( new OnItemClickListener() {
		        public void onItemClick(AdapterView<?> arg0, View arg1, int myItemInt, long arg3) {
		        	
		        	if (myItemInt == 2)
		        	{
		        		
		        		Intent mainactivity = new Intent(getActivity(), deletedata.class);
						getActivity().startActivity(mainactivity);
		        	}
		        	
		        	if (myItemInt == 3)
		        	{
		        		
		        		Intent mainactivity = new Intent(getActivity(), changepass.class);
						getActivity().startActivity(mainactivity);
		        	}
		        	
		        	if (myItemInt == 4)
		        	{
		        		
		        		Intent mainactivity = new Intent(getActivity(), sync.class);
						getActivity().startActivity(mainactivity);
		        	}
		        	
		        	
		        	if (myItemInt == 5)
		        	{
		        		
		        		ShowPopupMsgbox msgbox = new ShowPopupMsgbox();
		        		msgbox.setOnClickPopup(new OnClickPopupListener(){

							@Override
							public void onClickOk() {
								File file = new File(FuncDungChung.PATH_EXTERNAL + FuncDungChung.FOLDER + "/thuchi.db");
				        		file.delete();
				        		Intent mainactivity = new Intent(getActivity(), login.class);
								getActivity().startActivity(mainactivity);
							}

							@Override
							public void onClickCancel() {
								FuncDungChung.popupWindow.dismiss();
								SlideMenuAttribute.back_dim_layout.setVisibility(View.GONE);
							}
		        			
		        		});
		        		if (FuncDungChung.GetLanguage(getActivity()) == 0)
		        		{
		        			FuncDungChung.popupWindow = msgbox.ShowPopupThongBao(getActivity(), lv, SlideMenuAttribute.back_dim_layout, "Are you sure sync before logout ?", "Notification");
		        		}
		        		else
		        		{
		        			FuncDungChung.popupWindow = msgbox.ShowPopupThongBao(getActivity(), lv, SlideMenuAttribute.back_dim_layout, "Bạn đã đồng bộ dữ liệu trước khi đăng xuất chưa", "Thông Báo");
		        		}
		        	
		        	}
		        	if (myItemInt == 7)
		        	{
		        		Intent mainactivity = new Intent(getActivity(), currency.class);
						getActivity().startActivity(mainactivity);
						
		        	}
		        	
		        	if (myItemInt == 9)
		        	{
		        		Intent mainactivity = new Intent(getActivity(), remind.class);
						getActivity().startActivity(mainactivity);
						
		        	}
		        	
		        	
		        	if (myItemInt == 10)
		        	{
		        		FuncDungChung.popupWindow = FuncDungChung.ShowPopupLanguage(getActivity(), lv, SlideMenuAttribute.back_dim_layout);
		        	}
		        	
		        	if (myItemInt == 11)
		        	{
		        		Intent mainactivity = new Intent(getActivity(), createpasscode.class);
						getActivity().startActivity(mainactivity);
		        	}
		        	
		        	
		        	
		        	if (myItemInt == 13)
		        	{
		        		Intent mainactivity = new Intent(getActivity(), about.class);
						getActivity().startActivity(mainactivity);
		        	}
		        	
		        	
		        }
		        });
			return view;
		}
		
	
	
	
}
