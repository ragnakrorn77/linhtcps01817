package com.atp.moneymanager.Thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.activity.changepass;
import com.atp.moneymanager.activity.dangky;
import com.atp.moneymanager.activity.login;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class AsyncChangePass extends AsyncTask<String,Void,String>{

	Context mContext;
	String email;
	RelativeLayout loading;
	LinearLayout linearLayout1;
	public AsyncChangePass(Context mContext,RelativeLayout loading,LinearLayout linearLayout1)
	{
		this.mContext = mContext;
		this.loading = loading;
		this.linearLayout1 = linearLayout1;
	}
	
	@Override
    protected void onPreExecute() {
        super.onPreExecute();
        loading.setVisibility(View.VISIBLE);
        linearLayout1.setVisibility(View.GONE);
    }
	
	@Override
	   protected String doInBackground(String... arg0) {
	     
		 try{
			 String username = (String)arg0[0];
	         String password = (String)arg0[1];
	         String newpassword = (String)arg0[2];
	            
	            
	         String link = FuncDungChung.linkhost + "/" + "changepass.php?email=" + username + "&pass=" + password + "&newpass=" + newpassword;
	         
	         URL url = new URL(link);
	         HttpClient client = new DefaultHttpClient();
	         HttpGet request = new HttpGet();
	         request.setURI(new URI(link));
	         HttpResponse response = client.execute(request);
	         BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

	           StringBuffer sb = new StringBuffer("");
	           String line="";
	           
	           while ((line = in.readLine()) != null) {
	              sb.append(line);
	              break;
	            }
	            in.close();
	            return sb.toString();
	         }
	         
	         catch(Exception e){
	            return new String("Exception: " + e.getMessage());
	         }
		 
		 
	     
	      
	   }
	
	@Override
	   protected void onPostExecute(String result){
		
		
			if (result.indexOf("error") > -1)
			{
				if (FuncDungChung.GetLanguage(mContext) == 0)
				{
					changepass.popupWindow = FuncDungChung.ShowPopupThongBao(mContext, changepass.back_dim_layout, changepass.back_dim_layout, "Your old password is wrong", "Error");
					
				}
				else
				{
					changepass.popupWindow = FuncDungChung.ShowPopupThongBao(mContext, changepass.back_dim_layout, changepass.back_dim_layout, "Mật khẩu cũ sai", "Thông báo");
				}
				
				
			}
			
			if (result.indexOf("success") > -1)
			{
				if (FuncDungChung.GetLanguage(mContext) == 0)
				{
					changepass.popupWindow = FuncDungChung.ShowPopupThongBao(mContext, changepass.back_dim_layout, changepass.back_dim_layout, "Success", "Error");
					
				}
				else
				{
					changepass.popupWindow = FuncDungChung.ShowPopupThongBao(mContext, changepass.back_dim_layout, changepass.back_dim_layout, "Thành Công", "Thông báo");
				}
			}
			loading.setVisibility(View.GONE);
			linearLayout1.setVisibility(View.VISIBLE);
	     	System.out.println(result);
	   }
	
}
