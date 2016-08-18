package com.atp.moneymanager.Thread;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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
import com.atp.moneymanager.activity.login;
import com.atp.moneymanager.activity.sync;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class upload extends AsyncTask<String,Void,String>{

	Context mContext;
	String email;
	RelativeLayout loading;
	LinearLayout linearLayout1;
	public upload(Context mContext,String email,RelativeLayout loading,LinearLayout linearLayout1)
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
	     
		uploadFile(FuncDungChung.PATH_EXTERNAL + FuncDungChung.FOLDER +  "/thuchi.db");
		 
		 
	     return "ok";
	      
	   }
	
	@Override
	   protected void onPostExecute(String result){
		
		if (FuncDungChung.GetLanguage(mContext) == 0)
		{
			sync.popupWindow = FuncDungChung.ShowPopupThongBao(mContext, sync.back_dim_layout, sync.back_dim_layout, "Sync Complete", "Thông báo");
			
		}
		else
		{
			sync.popupWindow = FuncDungChung.ShowPopupThongBao(mContext, sync.back_dim_layout, sync.back_dim_layout, "Đồng bộ thành công", "Thông báo");
		}
		
		
		
		loading.setVisibility(View.GONE);
		linearLayout1.setVisibility(View.VISIBLE);
	     	System.out.println(result);
	   }
	
	
public int uploadFile(String sourceFileUri) {
        
        
        String fileName = sourceFileUri;
        int serverResponseCode = 0;
        HttpURLConnection conn = null;
        DataOutputStream dos = null;  
        String lineEnd = "\r\n";
        String twoHyphens = "--";
        String boundary = "*****";
        int bytesRead, bytesAvailable, bufferSize;
        byte[] buffer;
        int maxBufferSize = 1 * 1024 * 1024; 
        File sourceFile = new File(sourceFileUri); 
         
        if (!sourceFile.isFile()) {
             
            
              
            
              
             return 0;
          
        }
        else
        {
             try { 
                  
                   // open a URL connection to the Servlet
                 FileInputStream fileInputStream = new FileInputStream(sourceFile);
                 URL url = new URL(FuncDungChung.linkhost + FuncDungChung.GetUser() + "/" + "UploadToServer.php");
                  System.out.println(FuncDungChung.linkhost + FuncDungChung.GetUser() + "/" + "UploadToServer.php");
                 // Open a HTTP  connection to  the URL
                 conn = (HttpURLConnection) url.openConnection(); 
                 conn.setDoInput(true); // Allow Inputs
                 conn.setDoOutput(true); // Allow Outputs
                 conn.setUseCaches(false); // Don't use a Cached Copy
                 conn.setRequestMethod("POST");
                 conn.setRequestProperty("Connection", "Keep-Alive");
                 conn.setRequestProperty("ENCTYPE", "multipart/form-data");
                 conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
                 conn.setRequestProperty("uploaded_file", fileName); 
                  
                 dos = new DataOutputStream(conn.getOutputStream());
        
                 dos.writeBytes(twoHyphens + boundary + lineEnd); 
                 dos.writeBytes("Content-Disposition: form-data; name=\"uploaded_file\";filename=\""
                                           + fileName + "\"" + lineEnd);
                  
                 dos.writeBytes(lineEnd);
        
                 // create a buffer of  maximum size
                 bytesAvailable = fileInputStream.available(); 
        
                 bufferSize = Math.min(bytesAvailable, maxBufferSize);
                 buffer = new byte[bufferSize];
        
                 // read file and write it into form...
                 bytesRead = fileInputStream.read(buffer, 0, bufferSize);  
                    
                 while (bytesRead > 0) {
                      
                   dos.write(buffer, 0, bufferSize);
                   bytesAvailable = fileInputStream.available();
                   bufferSize = Math.min(bytesAvailable, maxBufferSize);
                   bytesRead = fileInputStream.read(buffer, 0, bufferSize);   
                    
                  }
        
                 // send multipart form data necesssary after file data...
                 dos.writeBytes(lineEnd);
                 dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
        
                 // Responses from the server (code and message)
                 serverResponseCode = conn.getResponseCode();
                 String serverResponseMessage = conn.getResponseMessage();
                   
                 System.out.println("HTTP Response is : "
                         + serverResponseMessage + ": " + serverResponseCode);
                  
                 if(serverResponseCode == 200){
                      
                                 
                 }    
                  
                 //close the streams //
                 fileInputStream.close();
                 dos.flush();
                 dos.close();
                   
            } catch (MalformedURLException ex) {
                 
               
                ex.printStackTrace();
                 
              
                 
                Log.e("Upload file to server", "error: " + ex.getMessage(), ex);  
            } catch (Exception e) {
                 
             
                e.printStackTrace();
                 
                
                Log.e("Upload file to server Exception", "Exception : "  + e.getMessage(), e);  
            }
           
            return serverResponseCode; 
             
         } 
	}
	
}