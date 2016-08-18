package com.atp.moneymanager.activity;


import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.app.Activity;
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
import android.view.Window;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.OnClickPopupListener;
import com.atp.moneymanager.ShowPopupMsgbox;
import com.atp.moneymanager.DoiTuong.DoiTuongEdit;
import com.atp.moneymanager.activity.SlideMenuAttribute;
import com.atp.moneymanager.activity.chonloaihinhthu;
import com.atp.moneymanager.activity.chonngansach;
import com.atp.moneymanager.activity.themvayno;
import com.atp.moneymanager.R;

public class edit extends Activity {



	public static PopupWindow popupWindow;
	public static RelativeLayout back_dim_layout;
	TextView txtpopupTien;
	public static TextView txtMucthu;
	public static int ma_thu = 0;
	TextView txtNganSach;
	static String msg = "Đã Thêm";
	static String Notifycation = "Thông báo";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.edit);
		
		
		Bundle extras = getIntent().getExtras(); 
		final int dang = extras.getInt("dang");
		final int id = extras.getInt("id");
		back_dim_layout = (RelativeLayout)findViewById(R.id.bac_dim_layout);
		final DoiTuongEdit edit = FuncDungChung.GetDoiTuongEdit(id,dang);
		
		final TextView txtcurrency = (TextView)findViewById(R.id.currency);
        txtcurrency.setText(FuncDungChung.currency);
        final TextView txt1 = (TextView)findViewById(R.id.textView1);
        final TextView txt2 = (TextView)findViewById(R.id.textView2);
        final TextView txt3 = (TextView)findViewById(R.id.textView3);
        final TextView txt4 = (TextView)findViewById(R.id.textView4);
        
        
        final TextView txttien = (TextView)findViewById(R.id.txtTien);
        final TextView txtGhiChu = (TextView)findViewById(R.id.txtGhiChu);
        final TextView txtDate = (TextView)findViewById(R.id.txtDate);
        txtNganSach = (TextView)findViewById(R.id.txtNganSach);
        txtMucthu = (TextView)findViewById(R.id.txtMucthu);
        txtNganSach.setText(FuncDungChung.getNganSach(edit.ma_ngan_sach));
        txtGhiChu.setText(edit.ghi_chu);
        txttien.setText(FuncDungChung.formatso(Integer.toString(edit.Tien)));
       
        if (dang == 0)
    	{
    		txtMucthu.setText("Lương");
    	}
    	
    	if (dang == 1)
    	{
    		txtMucthu.setText("Đi Ăn");
    	}
        if (FuncDungChung.GetLanguage(this) == 0)
		{
        	txt1.setText("Category");
        	txt2.setText("Note");
        	txt3.setText("To Account");
        	txt4.setText("Date");
        	if (dang == 0)
        	{
        		txtMucthu.setText("Salary");
        	}
        	
        	if (dang == 1)
        	{
        		txtMucthu.setText("Eat");
        	}
        	
        	
        	
        	msg = "Saved";
        	Notifycation = "Notification";
        	txttien.setHint("Amount");
		}
        
        if (dang == 3 || dang == 4)
    	{
        	if (FuncDungChung.GetLanguage(this) == 0)
    		{
        		txt1.setText("Who");
    		}
        	else
        	{
        		txt1.setText("Tên");
        	}
    		txtMucthu.setText(edit.mucorwho);
    	}
        
        txtDate.setText(edit.date);
        
        final Button Save =(Button)findViewById(R.id.Save);
        Save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				ShowPopupMsgbox msgbox = new ShowPopupMsgbox();
        		msgbox.setOnClickPopup(new OnClickPopupListener(){

					@Override
					public void onClickOk() {
						
						if (dang == 0)
						{
							String Tien = txttien.getText().toString().replace(".", "");
							//trả vĐ tiền ngân sách lúc đầu
							int Tien_NganSach = Integer.parseInt(FuncDungChung.getTienNganSach(edit.ma_ngan_sach));
							int myTien = edit.Tien;
							int newTien = Tien_NganSach - myTien;
							FuncDungChung.EditDataNganSach(edit.ma_ngan_sach, newTien);
							//delete record
							FuncDungChung.DeleteRecords(id, "thu");
							//luu vào nội dung mới
							FuncDungChung.UpdateDataThuNganSach(FuncDungChung.ma_ngan_sach,Integer.parseInt(Tien));
							FuncDungChung.InsertDataThu(txtDate.getText().toString(),Integer.parseInt(Tien),ma_thu,txtGhiChu.getText().toString(),FuncDungChung.ma_ngan_sach);
							String tachdate[] = txtDate.getText().toString().split(" ");		
							FuncDungChung.CreateDate(tachdate[1]);
							
							BackToMain();
						}
						
						if (dang == 1)
						{
							String Tien = txttien.getText().toString().replace(".", "");
							//trả vĐ tiền ngân sách lúc đầu
							int Tien_NganSach = Integer.parseInt(FuncDungChung.getTienNganSach(edit.ma_ngan_sach));
							int myTien = edit.Tien;
							int newTien = Tien_NganSach + myTien;
							FuncDungChung.EditDataNganSach(edit.ma_ngan_sach, newTien);
							//delete record
							FuncDungChung.DeleteRecords(id, "thu");
							//luu vào nội dung mới
							FuncDungChung.UpdateDataThuNganSach(FuncDungChung.ma_ngan_sach,Integer.parseInt(Tien));
							FuncDungChung.InsertDataThu(txtDate.getText().toString(),Integer.parseInt(Tien),ma_thu,txtGhiChu.getText().toString(),FuncDungChung.ma_ngan_sach);
							String tachdate[] = txtDate.getText().toString().split(" ");		
							FuncDungChung.CreateDate(tachdate[1]);
							
							BackToMain();
						}
						
						if (dang == 3)
						{
							String Tien = txttien.getText().toString().replace(".", "");
							int Tien_NganSach = Integer.parseInt(FuncDungChung.getTienNganSach(edit.ma_ngan_sach));
							int myTien = edit.Tien;
							int newTien = Tien_NganSach - myTien;
							FuncDungChung.EditDataNganSach(edit.ma_ngan_sach, newTien);
							FuncDungChung.DeleteRecords(id, "vay_no");
							FuncDungChung.UpdateDataThuNganSach(FuncDungChung.ma_ngan_sach,Integer.parseInt(Tien));
							FuncDungChung.InsertDataVayNo(txtDate.getText().toString(),Integer.parseInt(Tien),txtMucthu.getText().toString(),txtGhiChu.getText().toString(),1,1,FuncDungChung.ma_ngan_sach);
							String tachdate[] = txtDate.getText().toString().split(" ");		
							FuncDungChung.CreateDate(tachdate[1]);
							
							BackToMain();
						}
						
						if (dang == 4)
						{
							String Tien = txttien.getText().toString().replace(".", "");
							int Tien_NganSach = Integer.parseInt(FuncDungChung.getTienNganSach(edit.ma_ngan_sach));
							int myTien = edit.Tien;
							int newTien = Tien_NganSach + myTien;
							FuncDungChung.EditDataNganSach(edit.ma_ngan_sach, newTien);
							FuncDungChung.DeleteRecords(id, "vay_no");
							
							FuncDungChung.UpdateDataChiNganSach(FuncDungChung.ma_ngan_sach,Integer.parseInt(Tien));
							FuncDungChung.InsertDataVayNo(txtDate.getText().toString(),Integer.parseInt(Tien),txtMucthu.getText().toString(),txtGhiChu.getText().toString(),2,1,FuncDungChung.ma_ngan_sach);
							String tachdate[] = txtDate.getText().toString().split(" ");		
							FuncDungChung.CreateDate(tachdate[1]);
							
							BackToMain();
						}
						
					}

					@Override
					public void onClickCancel() {
						popupWindow.dismiss();
						back_dim_layout.setVisibility(View.GONE);
					}
        			
        		});
        		if (FuncDungChung.GetLanguage(edit.this) == 0)
        		{
        			popupWindow = msgbox.ShowPopupThongBao(edit.this, Save, back_dim_layout, "Are you sure update ?", "Notification");
        		}
        		else
        		{
        			popupWindow = msgbox.ShowPopupThongBao(edit.this, Save, back_dim_layout, "Bạn có chắc chắn update không ?", "Thông Báo");
        		}
			}
        });
        
        
        final Button Delete =(Button)findViewById(R.id.Delete);
        Delete.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				ShowPopupMsgbox msgbox = new ShowPopupMsgbox();
        		msgbox.setOnClickPopup(new OnClickPopupListener(){

					@Override
					public void onClickOk() {
						if (dang == 0)
						{
							int Tien_NganSach = Integer.parseInt(FuncDungChung.getTienNganSach(edit.ma_ngan_sach));
							int Tien = edit.Tien;
							int newTien = Tien_NganSach - Tien;
							FuncDungChung.EditDataNganSach(edit.ma_ngan_sach, newTien);
							FuncDungChung.DeleteRecords(id, "thu");
							BackToMain();
						}
						
						if (dang == 1)
						{
							int Tien_NganSach = Integer.parseInt(FuncDungChung.getTienNganSach(edit.ma_ngan_sach));
							int Tien = edit.Tien;
							int newTien = Tien_NganSach + Tien;
							FuncDungChung.EditDataNganSach(edit.ma_ngan_sach, newTien);
							FuncDungChung.DeleteRecords(id, "chi");
							BackToMain();
						}
						
						if (dang == 3)
						{
							int Tien_NganSach = Integer.parseInt(FuncDungChung.getTienNganSach(edit.ma_ngan_sach));
							int Tien = edit.Tien;
							int newTien = Tien_NganSach - Tien;
							FuncDungChung.EditDataNganSach(edit.ma_ngan_sach, newTien);
							FuncDungChung.DeleteRecords(id, "vay_no");
							BackToMain();
						}
						
						if (dang == 4)
						{
							int Tien_NganSach = Integer.parseInt(FuncDungChung.getTienNganSach(edit.ma_ngan_sach));
							int Tien = edit.Tien;
							int newTien = Tien_NganSach + Tien;
							FuncDungChung.EditDataNganSach(edit.ma_ngan_sach, newTien);
							FuncDungChung.DeleteRecords(id, "vay_no");
							BackToMain();
						}
					}

					@Override
					public void onClickCancel() {
						popupWindow.dismiss();
						back_dim_layout.setVisibility(View.GONE);
					}
        			
        		});
        		
        		
        		if (FuncDungChung.GetLanguage(edit.this) == 0)
        		{
        			popupWindow = msgbox.ShowPopupThongBao(edit.this, Delete, back_dim_layout, "Are you sure delete ?", "Notification");
        		}
        		else
        		{
        			popupWindow = msgbox.ShowPopupThongBao(edit.this, Delete, back_dim_layout, "Bạn có chắc chắn xóa không ?", "Thông Báo");
        		}
        		
        		
				
			}
		});
		
		
		
        final RelativeLayout back=(RelativeLayout)findViewById(R.id.back);
		back.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				BackToMain();
			}
		});
		
		final RelativeLayout btnGhiChu = (RelativeLayout)findViewById(R.id.btnGhiChu);
        btnGhiChu.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (FuncDungChung.GetLanguage(edit.this) == 0)
				     popupWindow = FuncDungChung.ShowPopupGhichu(edit.this,back_dim_layout,btnGhiChu,txtGhiChu,"Note");
				else
					popupWindow = FuncDungChung.ShowPopupGhichu(edit.this,back_dim_layout,btnGhiChu,txtGhiChu,"Ghi Chú");
			
			}
		});
        
        final RelativeLayout btnNganSach = (RelativeLayout)findViewById(R.id.btnNganSach);
        btnNganSach.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (dang == 0 || dang == 3) FuncDungChung.thu_chi = 0;
				if (dang == 1 || dang == 4) FuncDungChung.thu_chi = 1;
				
				Intent mainactivity = new Intent(edit.this, chonngansach.class);
				mainactivity.putExtra("fromedit", 1);
				startActivity(mainactivity);
			}
		});
        
		final RelativeLayout btnDate = (RelativeLayout)findViewById(R.id.btnDate);
        btnDate.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				popupWindow = FuncDungChung.ShowPopupDate(edit.this,back_dim_layout,btnDate,txtDate);
			}
		});
        
        
		final LinearLayout btnTien = (LinearLayout)findViewById(R.id.btnTien);
		btnTien.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				
				LayoutInflater layoutInflater  = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
       	    View popupView = layoutInflater.inflate(R.layout.popupbanphim, null);  
       	    popupWindow = new PopupWindow( popupView,  LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  
       	    popupWindow.showAtLocation(btnTien, Gravity.CENTER, 0, 0);
       	    back_dim_layout.setVisibility(View.VISIBLE);
       	    
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
    			 popupWindow.dismiss();
    			 back_dim_layout.setVisibility(View.GONE);
    		 }});
    	 
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

    @Override
	public void onResume() {
    	txtNganSach.setText(FuncDungChung.Ngan_Sach);
		super.onResume();
	}
    
    void BackToMain()
	{
		super.onBackPressed();
	}
   
}

