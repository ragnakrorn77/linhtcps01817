package com.atp.moneymanager.fragment;


import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.activity.SlideMenuAttribute;
import com.atp.moneymanager.activity.chonloaihinhthu;
import com.atp.moneymanager.activity.chonngansach;
import com.atp.moneymanager.activity.themvayno;
import com.atp.moneymanager.R;

public class Thu extends Fragment {



   
	TextView txtpopupTien;
	public static TextView txtMucthu;
	public static int ma_thu = 0;
	TextView txtNganSach;
	static String msg = "Đã Thêm";
	static String Notifycation = "Thông báo";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    	System.out.println("zo thu");
        View rootView = inflater.inflate(R.layout.thu, container, false);
        final TextView txtcurrency = (TextView)rootView.findViewById(R.id.currency);
        txtcurrency.setText(FuncDungChung.currency);
        final TextView txt1 = (TextView)rootView.findViewById(R.id.textView1);
        final TextView txt2 = (TextView)rootView.findViewById(R.id.textView2);
        final TextView txt3 = (TextView)rootView.findViewById(R.id.textView3);
        final TextView txt4 = (TextView)rootView.findViewById(R.id.textView4);
        
        
        final TextView txttien = (TextView)rootView.findViewById(R.id.txtTien);
        final TextView txtGhiChu = (TextView)rootView.findViewById(R.id.txtGhiChu);
        final TextView txtDate = (TextView)rootView.findViewById(R.id.txtDate);
        txtNganSach = (TextView)rootView.findViewById(R.id.txtNganSach);
        txtMucthu = (TextView)rootView.findViewById(R.id.txtMucthu);
        txtNganSach.setText(FuncDungChung.Ngan_Sach);
        if (FuncDungChung.GetLanguage(getActivity()) == 0)
		{
        	txt1.setText("Category");
        	txt2.setText("Note");
        	txt3.setText("To Account");
        	txt4.setText("Date");
        	txtMucthu.setText("Salary");
        	txtGhiChu.setText("October Salary");
        	msg = "Saved";
        	Notifycation = "Notification";
        	txttien.setHint("Amount");
		}
        
        
        
        txtDate.setText(FuncDungChung.Date);
        
        final Button btnSave = (Button)rootView.findViewById(R.id.Save);
        btnSave.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String Tien = txttien.getText().toString().replace(".", "");
				FuncDungChung.UpdateDataThuNganSach(FuncDungChung.ma_ngan_sach,Integer.parseInt(Tien));
				FuncDungChung.InsertDataThu(txtDate.getText().toString(),Integer.parseInt(Tien),ma_thu,txtGhiChu.getText().toString(),FuncDungChung.ma_ngan_sach);
				String tachdate[] = txtDate.getText().toString().split(" ");		
				FuncDungChung.CreateDate(tachdate[1]);
				FuncDungChung.popupWindow = FuncDungChung.ShowPopupThongBao(getActivity(), btnSave, SlideMenuAttribute.back_dim_layout, msg, Notifycation);
			}
		});
        
        
        final RelativeLayout btnGhiChu = (RelativeLayout)rootView.findViewById(R.id.btnGhiChu);
        btnGhiChu.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				if (FuncDungChung.GetLanguage(getActivity()) == 0)
					FuncDungChung.ShowPopupGhichu(getActivity(),btnGhiChu,txtGhiChu,"Note");
				else
					FuncDungChung.ShowPopupGhichu(getActivity(),btnGhiChu,txtGhiChu,"Ghi Chú");
		
			}
		});
		
        final RelativeLayout btnOpenLoaiHinhThu = (RelativeLayout)rootView.findViewById(R.id.btnOpenLoaiHinhThu);
        btnOpenLoaiHinhThu.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				Intent mainactivity = new Intent(getActivity(), chonloaihinhthu.class);
				getActivity().startActivity(mainactivity);
			}
		});
        
        final RelativeLayout btnNganSach = (RelativeLayout)rootView.findViewById(R.id.btnNganSach);
        btnNganSach.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				FuncDungChung.thu_chi = 0;
				Intent mainactivity = new Intent(getActivity(), chonngansach.class);
				getActivity().startActivity(mainactivity);
			}
		});
        
        
        final RelativeLayout btnDate = (RelativeLayout)rootView.findViewById(R.id.btnDate);
        btnDate.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				System.out.println("dsdsad");
				FuncDungChung.ShowPopupDate(getActivity(),btnDate,txtDate);
			}
		});
		
        final LinearLayout btnTien = (LinearLayout)rootView.findViewById(R.id.btnTien);
		btnTien.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
	
				
				LayoutInflater layoutInflater  = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
       	    View popupView = layoutInflater.inflate(R.layout.popupbanphim, null);  
       	    FuncDungChung.popupWindow = new PopupWindow( popupView,  LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  
       	    FuncDungChung.popupWindow.showAtLocation(btnTien, Gravity.CENTER, 0, 0);
       	 SlideMenuAttribute.back_dim_layout.setVisibility(View.VISIBLE);
       	    
       	 txtpopupTien = (TextView)popupView.findViewById(R.id.textView1);
       	txtpopupTien.addTextChangedListener(new TextWatcher() {
            private String current = "";
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {       

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                    int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().equals(current)) {
                	txtpopupTien.removeTextChangedListener(this);     

                   String cleanString = s.toString();  
                   cleanString = cleanString.replace(".", "");
                   if (cleanString.length() > 3 && cleanString.length() < 7)
                   {
                	   System.out.println("zo day");
                	   txtpopupTien.setText(tach_so_1(cleanString));
                   }
                   else if(cleanString.length() > 6 && cleanString.length() < 10)
                   {
                	   System.out.println("zo day 1");
                	   txtpopupTien.setText(tach_so_2(cleanString));
                   }
                   else
                   {
                    txtpopupTien.setText(cleanString);
                   }
                    txtpopupTien.addTextChangedListener(this);
                }                           
            }
        });
       	 
       	 Button btn7 = (Button)popupView.findViewById(R.id.button7);
       	 btn7.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View arg0) { String text = txtpopupTien.getText().toString();if (text.equals("0")) 
       		                     text = "";txtpopupTien.setText(text + "7");}});
       	 Button btn8 = (Button)popupView.findViewById(R.id.button8);
      	 btn8.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View arg0) { String text = txtpopupTien.getText().toString();if (text.equals("0")) 
      		                     text = "";txtpopupTien.setText(text + "8");}});
      	Button btn9 = (Button)popupView.findViewById(R.id.button9);
     	 btn9.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View arg0) { String text = txtpopupTien.getText().toString();if (text.equals("0")) 
     		                     text = "";txtpopupTien.setText(text + "9");}});
     	 Button btn4 = (Button)popupView.findViewById(R.id.button4);
    	 btn4.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View arg0) { String text = txtpopupTien.getText().toString();if (text.equals("0")) 
    		                     text = "";txtpopupTien.setText(text + "4");}});
    	 Button btn5 = (Button)popupView.findViewById(R.id.button5);
    	 btn5.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View arg0) { String text = txtpopupTien.getText().toString();if (text.equals("0")) 
    		                     text = "";txtpopupTien.setText(text + "5");}});
    	 Button btn6 = (Button)popupView.findViewById(R.id.button6);
    	 btn6.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View arg0) { String text = txtpopupTien.getText().toString();if (text.equals("0")) 
    		                     text = "";txtpopupTien.setText(text + "6");}});
    	 Button btn1 = (Button)popupView.findViewById(R.id.button1);
    	 btn1.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View arg0) { String text = txtpopupTien.getText().toString();if (text.equals("0")) 
    		                     text = "";txtpopupTien.setText(text + "1");}});
    	 Button btn2 = (Button)popupView.findViewById(R.id.button2);
    	 btn2.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View arg0) { String text = txtpopupTien.getText().toString();if (text.equals("0")) 
    		                     text = "";txtpopupTien.setText(text + "2");}});
    	 Button btn3 = (Button)popupView.findViewById(R.id.button3);
    	 btn3.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View arg0) { String text = txtpopupTien.getText().toString();if (text.equals("0")) 
    		                     text = "";txtpopupTien.setText(text + "3");}});
    	 Button btn0 = (Button)popupView.findViewById(R.id.button0);
    	 btn0.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View arg0) { String text = txtpopupTien.getText().toString();if (text.equals("0")) 
    		                     text = "";txtpopupTien.setText(text + "0");}});
    	 Button btn000 = (Button)popupView.findViewById(R.id.button000);
    	 btn000.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View arg0) { String text = txtpopupTien.getText().toString();if (text.equals("0")) 
    		                     text = "";txtpopupTien.setText(text + "000");}});
    	 Button btnC = (Button)popupView.findViewById(R.id.buttonC);
    	 btnC.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View arg0) { String text = txtpopupTien.getText().toString();
    		                     txtpopupTien.setText("0");}});
    	 Button btnxoa = (Button)popupView.findViewById(R.id.buttonxoa);
    	 btnxoa.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View arg0) { 
    		 		String text = txtpopupTien.getText().toString();if (text.equals("0")) return;
    		 		txtpopupTien.setText(FuncDungChung.DeleteCuoiString(text));}});
    	 
    	 Button btnOK = (Button)popupView.findViewById(R.id.buttonOK);
    	 btnOK.setOnClickListener(new View.OnClickListener(){
    		 @Override public void onClick(View arg0) { 
    			 String text = txtpopupTien.getText().toString();
    			 txttien.setText(text);
    			 FuncDungChung.popupWindow.dismiss();
    			 SlideMenuAttribute.back_dim_layout.setVisibility(View.GONE);
    		 }});
			}
		});
        return rootView;
    }

    @Override
	public void onResume() {
    	txtNganSach.setText(FuncDungChung.Ngan_Sach);
		super.onResume();
	}
    
    String tach_so_1(String so)
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
    
    String tach_so_2(String so)
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
}

