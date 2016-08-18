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
import com.atp.moneymanager.activity.dangky;
import com.atp.moneymanager.activity.deletedata;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class AsyncDelete extends AsyncTask<String,Void,String>{

	Context mContext;
	String email;
	RelativeLayout loading;
	LinearLayout linearLayout1;
	public AsyncDelete(Context mContext,String email,RelativeLayout loading,LinearLayout linearLayout1)
	{
		this.mContext = mContext;
		this.email = email;
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
			 
	            
	            
	         String link = FuncDungChung.linkhost + "deletadata.php?email=" + this.email;
	         
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
		
		
			
			
			if (result.indexOf("success") > -1)
			{
				new DownloadDeleteTask(mContext,this.email,FuncDungChung.PATH_EXTERNAL + FuncDungChung.FOLDER +  "/thuchi.db",loading,linearLayout1).execute(FuncDungChung.linkhost + this.email + "/" + "thuchi.db");
			}
			else
			{
				if (FuncDungChung.GetLanguage(mContext) == 0)
				{
					deletedata.popupWindow = FuncDungChung.ShowPopupThongBao(mContext, deletedata.back_dim_layout,deletedata.back_dim_layout, "Don't Complete,Please check your internet", "Error");
					
				}
				else
				{
					deletedata.popupWindow = FuncDungChung.ShowPopupThongBao(mContext, deletedata.back_dim_layout, deletedata.back_dim_layout, "Không thành công,vui lòng kiểm tra mạng", "Thông báo");
				}
				loading.setVisibility(View.GONE);
				linearLayout1.setVisibility(View.VISIBLE);
			}
			
			
	     	System.out.println(result);
	   }
	
}
