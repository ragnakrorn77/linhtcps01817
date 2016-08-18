package com.atp.moneymanager.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.activity.SlideMenuAttribute;
import com.atp.moneymanager.activity.chonloaihinhchi;
import com.atp.moneymanager.activity.chonloaihinhthu;
import com.atp.moneymanager.activity.chonngansach;
import com.atp.moneymanager.activity.naptien;
import com.atp.moneymanager.R;

public class Chi extends Fragment {

	

	public static TextView txtMucChi; 
	public static int ma_chi;
	TextView txtpopupTien;
	TextView txtNganSach;
	static String msg = "Đã Thêm";
	static String Notifycation = "Thông báo";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.chi, container, false);
        final TextView txtcurrency = (TextView)rootView.findViewById(R.id.currency);
        txtcurrency.setText(FuncDungChung.currency);
        final TextView txt1 = (TextView)rootView.findViewById(R.id.textView1);
        final TextView txt2 = (TextView)rootView.findViewById(R.id.textView2);
        final TextView txt3 = (TextView)rootView.findViewById(R.id.textView3);
        final TextView txt4 = (TextView)rootView.findViewById(R.id.textView4);
        final TextView txtGhiChu = (TextView)rootView.findViewById(R.id.txtGhiChu);
        final TextView txttien = (TextView)rootView.findViewById(R.id.txtTien);
        final TextView txtDate = (TextView)rootView.findViewById(R.id.txtDate);
        txtMucChi = (TextView)rootView.findViewById(R.id.txtMucChi);
        txtDate.setText(FuncDungChung.Date);
        txtNganSach = (TextView)rootView.findViewById(R.id.txtNganSach);
        txtNganSach.setText(FuncDungChung.Ngan_Sach);
        if (FuncDungChung.GetLanguage(getActivity()) == 0)
		{
        	txt1.setText("Category");
        	txt2.setText("Note");
        	txt3.setText("To Account");
        	txt4.setText("Date");
        	txtMucChi.setText("Eat");
        	txtGhiChu.setText("Eat with friend");
        	msg = "Saved";
        	Notifycation = "Notification";
        	txttien.setHint("Amount");
		}
        
        
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
        
        final Button btnSave = (Button)rootView.findViewById(R.id.Save);
        btnSave.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String Tien = txttien.getText().toString().replace(".", "");
				
				if (Integer.parseInt(Tien) > Integer.parseInt(FuncDungChung.getTienNganSach(FuncDungChung.ma_ngan_sach)))
				{
					if (FuncDungChung.GetLanguage(getActivity()) == 0)
					{
						FuncDungChung.popupWindow = FuncDungChung.ShowPopupThongBao(getActivity(),btnSave, SlideMenuAttribute.back_dim_layout,"This budget no money",Notifycation);
					}
					else
					{
						FuncDungChung.popupWindow = FuncDungChung.ShowPopupThongBao(getActivity(),btnSave, SlideMenuAttribute.back_dim_layout,"Ngân Sách Này Không Đủ Tiền",Notifycation);
					}
					
					return;
				}
				
				FuncDungChung.UpdateDataChiNganSach(FuncDungChung.ma_ngan_sach,Integer.parseInt(Tien));
				FuncDungChung.InsertDataChi(txtDate.getText().toString(),Integer.parseInt(Tien),ma_chi,txtGhiChu.getText().toString(),FuncDungChung.ma_ngan_sach);
				String tachdate[] = txtDate.getText().toString().split(" ");		
				FuncDungChung.CreateDate(tachdate[1]);
				FuncDungChung.popupWindow = FuncDungChung.ShowPopupThongBao(getActivity(), btnSave, SlideMenuAttribute.back_dim_layout, msg, Notifycation);
				
			}
		});
        
        
        final RelativeLayout btnOpenLoaiHinhChi = (RelativeLayout)rootView.findViewById(R.id.btnOpenLoaiHinhChi);
        btnOpenLoaiHinhChi.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				Intent mainactivity = new Intent(getActivity(), chonloaihinhchi.class);
				getActivity().startActivity(mainactivity);
			}
		});
        
        final RelativeLayout btnNganSach = (RelativeLayout)rootView.findViewById(R.id.btnNganSach);
        btnNganSach.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				FuncDungChung.thu_chi = 1;
				Intent mainactivity = new Intent(getActivity(), chonngansach.class);
				getActivity().startActivity(mainactivity);
			}
		});
        
        
        final RelativeLayout btnDate = (RelativeLayout)rootView.findViewById(R.id.btnDate);
        btnDate.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
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
                   
                    txtpopupTien.setText(FuncDungChung.formatso(cleanString));
                   
                    txtpopupTien.addTextChangedListener(this);
                }                           
            }
        });
       	 txtDate.setText(FuncDungChung.Date);
         
         
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
   	public void onStart() {
    	
   		super.onResume();
   	}
	
    @Override
   	public void onResume() {
    	
       	txtNganSach.setText(FuncDungChung.Ngan_Sach);
   		super.onResume();
   	}
}


