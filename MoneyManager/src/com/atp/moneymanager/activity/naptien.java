package com.atp.moneymanager.activity;

import java.util.ArrayList;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.DoiTuong.DoiTuongVayNo;
import com.atp.moneymanager.fragment.vayno;
import com.atp.moneymanager.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
public class naptien extends Activity {
	
	public static PopupWindow popupWindow;
	
	public static RelativeLayout back_dim_layout;
	TextView txtNganSach;
	TextView txtpopupTien;
	static String msg = "Đã Thêm";
	static String Notifycation = "Thông báo";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.naptien);	
		
		
		final TextView txtDate = (TextView)findViewById(R.id.txtDate);
        txtDate.setText(FuncDungChung.Date);
		
		final TextView txttien = (TextView)findViewById(R.id.txtTien);
		final TextView txtGhiChu = (TextView)findViewById(R.id.txtGhiChu);
		
		
		final TextView txtcurrency = (TextView)findViewById(R.id.currency);
		final TextView title = (TextView)findViewById(R.id.title);
		
		
        txtcurrency.setText(FuncDungChung.currency);
        
		
		final RelativeLayout back=(RelativeLayout)findViewById(R.id.back);
		back.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				BackToMain();
			}
		});
		
		if (FuncDungChung.GetLanguage(this) == 0)
		{
			msg = "Saved";
        	Notifycation = "Notification";
        	title.setText("Add Money");
        	txttien.setHint("Amount");
		}
        
       
		
		final Button btnSave = (Button)findViewById(R.id.Save);
        btnSave.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				if ( txttien.getText().toString().equals(""))
				{
					if (FuncDungChung.GetLanguage(naptien.this) == 0)
					{
						popupWindow = FuncDungChung.ShowPopupThongBao(naptien.this, btnSave, back_dim_layout, "Please set your money", "Notification");
					}
					else
					{
						popupWindow = FuncDungChung.ShowPopupThongBao(naptien.this, btnSave, back_dim_layout, "Bạn Chưa ChĐn Tiền", "Thông Báo");
						
					}
					
					
					return;
				}
				
				String tien = txttien.getText().toString();
				tien = tien.replace(".", "");
				
				FuncDungChung.InsertDataTietKiem(txtDate.getText().toString(),Integer.parseInt(tien),txtGhiChu.getText().toString(),0);
				int tientietkiem = FuncDungChung.GetTienTietKiem();
				tientietkiem = tientietkiem + Integer.parseInt(tien);
				FuncDungChung.UpdateDataTietKiem(tientietkiem);
				BackToMain();
			}
		});
        
        
		
        
        
		 final RelativeLayout btnGhiChu = (RelativeLayout)findViewById(R.id.btnGhiChu);
	        btnGhiChu.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					
					if (FuncDungChung.GetLanguage(naptien.this) == 0)
						 popupWindow = FuncDungChung.ShowPopupGhichu(naptien.this,back_dim_layout,btnGhiChu,txtGhiChu,"Note");
					else
						popupWindow = FuncDungChung.ShowPopupGhichu(naptien.this,back_dim_layout,btnGhiChu,txtGhiChu,"Ghi Chú");
				
				}
			});
	        
	       
	        
		final RelativeLayout btnDate = (RelativeLayout)findViewById(R.id.btnDate);
        btnDate.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				System.out.println("dsdsad");
				popupWindow = FuncDungChung.ShowPopupDate(naptien.this,back_dim_layout,btnDate,txtDate);
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
		
		
		back_dim_layout = (RelativeLayout)findViewById(R.id.bac_dim_layout);
		
		back_dim_layout.setOnClickListener(new View.OnClickListener(){

	     	   @Override
	     	   public void onClick(View arg0) {
	     		  popupWindow.dismiss();
	     		 back_dim_layout.setVisibility(View.GONE);
	     	
	     	   }
	        });
		
		final TextView txt1 = (TextView)findViewById(R.id.textView1);
		final TextView txtdate = (TextView)findViewById(R.id.textdate);
		
		
		if (FuncDungChung.GetLanguage(this) == 0)
		{
        	txt1.setText("Note");
        	
        	txtdate.setText("Date");
        	
        	txtGhiChu.setText("October Salary");
        	FuncDungChung.Ngan_Sach = "Wallet";
        	
		}
	}
	
	@Override
	public void onResume() {
    	//txtNganSach.setText(FuncDungChung.Ngan_Sach);
		super.onResume();
	}
	
	void BackToMain()
	{
		super.onBackPressed();
	}
}
