package com.atp.moneymanager.fragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;













import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;










import nAdapter.VayNoAdapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;








import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.DoiTuong.DoiTuongLoaiHinhChi;
import com.atp.moneymanager.DoiTuong.DoiTuongVayNo;
import com.atp.moneymanager.activity.SlideMenuAttribute;
import com.atp.moneymanager.activity.themvayno;
import com.atp.moneymanager.R;
public class vayno extends Fragment {
	


	    View view;
	    
	    public static VayNoAdapter adapter;
	    public static RelativeLayout  anhien;
	    public static ListView list1;
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
	}
	@SuppressWarnings("deprecation")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.vayno, container, false);
		
		
		 final Button btThem=(Button)view.findViewById(R.id.Them);
	        btThem.setOnClickListener(new View.OnClickListener(){

	        	   @Override
	        	   public void onClick(View arg0) {
	        		   
	        		   
	        		     Intent mainactivity = new Intent(getActivity(), themvayno.class);
	        		     getActivity().startActivity(mainactivity);
	        	
	        	   }});
	        
	        
		final ArrayList<DoiTuongVayNo> list = FuncDungChung.GetAllVayNo();
		anhien = ( RelativeLayout )view.findViewById( R.id.layoutan );  // List defined in XML ( See Below )
		list1 = ( ListView )view.findViewById( R.id.listView1 );  // List defined in XML ( See Below )
		
		if (list.size() == 0)
		{
			anhien.setVisibility(View.VISIBLE);
			list1.setVisibility(View.GONE);
			if (FuncDungChung.GetLanguage(getActivity()) == 0)
    		{
				TextView textView1 = (TextView)view.findViewById(R.id.textView1);
				textView1.setText("No Data");
    		}
		
		}
		
		int coutbandangno = 0;
		int coutdangnoban = 0;
		
		
			for(int i = 0;i<list.size();i++)
			{
				if (list.get(i).GetTrangThai() == 1)  coutbandangno++;
				if (list.get(i).GetTrangThai() == 2)  coutdangnoban++;
			}
		
		
		
		
		
		adapter = new VayNoAdapter( getActivity(),list,coutbandangno,coutdangnoban);
        list1.setAdapter( adapter );
        
        list1.setOnItemClickListener( new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> arg0, View arg1, int myItemInt, long arg3) {
	        	int mypos = adapter.myPos.get(myItemInt);
	        	if (mypos != -1)
	        	{
	        		int _id = list.get(mypos).GetId();
		        	int xloai_hinh = list.get(mypos).GetTrangThai();
		        	String loai_hinh = "";
		        	if (FuncDungChung.GetLanguage(getActivity()) == 0)
		    		{
		        		if (xloai_hinh == 1) loai_hinh = "You are Owning!";
			        	else loai_hinh = "Who is Owning";
		    		}
		        	else
		        	{
		        		if (xloai_hinh == 1) loai_hinh = "Bạn Đang Nợ";
			        	else loai_hinh = "Đang Nợ Bạn";
		        	}
		        	
		        	String who = list.get(mypos).GetTen();
		        	String Tien = Integer.toString(list.get(mypos).GetTien());
		        	String ghi_chu = list.get(mypos).GetGhiChu();
		        	String date = list.get(mypos).GetDate();
		        	
		        	
		        	FuncDungChung.popupWindow = FuncDungChung.ShowPopupVayNo(getActivity(),list1,SlideMenuAttribute.back_dim_layout,adapter,_id,loai_hinh,who,Tien,ghi_chu,date,xloai_hinh);
		        }
	        	//DoiTuongVayNo vayno = (DoiTuongVayNo)adapter.getItem(myItemInt);
	        //	int mypos = adapter.myPos.get(myItemInt);
	        //	if (mypos != -1) System.out.println(list.get(mypos).GetTen());
	        }
	        });
		
      
       
        	   
        	   
		return view;
	}
	
	
	
}
