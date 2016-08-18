package com.atp.moneymanager;

import com.atp.moneymanager.HomeWatcher.InnerRecevier;
import com.atp.moneymanager.R;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ShowPopupMsgbox {
	private OnClickPopupListener mListener;
	private Context mContext;
	

	public void setOnClickPopup(OnClickPopupListener listener) {
        mListener = listener;
    }
	
	public PopupWindow ShowPopupThongBao(Context context,View handle,final RelativeLayout back_dim_layout,String msg,String title)
	{
	 LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
	 View popupView = layoutInflater.inflate(R.layout.popupokcancel, null);  
	 final PopupWindow popupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  
	 
	 Button btnOK = (Button)popupView.findViewById(R.id.btnok);
	 Button btnhuy = (Button)popupView.findViewById(R.id.btnhuy);
	 TextView txtMsg = (TextView)popupView.findViewById(R.id.txtMsg);
	 TextView txttitle = (TextView)popupView.findViewById(R.id.textView1);
	 txttitle.setText(title);
	 txtMsg.setText(msg);
     btnOK.setOnClickListener(new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
			mListener.onClickOk();
	}});
     
     btnhuy.setOnClickListener(new Button.OnClickListener(){

 		@Override
 		public void onClick(View v) {
 			mListener.onClickCancel();
 		
 	}});
     
     if (FuncDungChung.GetLanguage(context) == 0)
     {
    	 btnhuy.setText("Cancel");
     }
     popupWindow.showAtLocation(handle, Gravity.CENTER, 0, 0);
     
	 back_dim_layout.setVisibility(View.VISIBLE);
	 return popupWindow;
	}
	
}
