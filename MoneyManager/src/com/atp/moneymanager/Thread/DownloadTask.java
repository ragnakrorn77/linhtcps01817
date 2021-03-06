package com.atp.moneymanager.Thread;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.activity.SlideMenuAttribute;
import com.atp.moneymanager.activity.createngansach;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class DownloadTask extends AsyncTask<String, Integer, String> {

    private Context context;
    private String file_name;
    RelativeLayout loading;
	LinearLayout linearLayout1;
	private String user;
    public DownloadTask(Context context,String file_name,String user,RelativeLayout loading,LinearLayout linearLayout1) {
        this.context = context;
        this.file_name = file_name;
        this.loading = loading;
		this.linearLayout1 = linearLayout1;
		this.user = user;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        
    }

    
    
    @Override
    protected String doInBackground(String... sUrl) {
        InputStream input = null;
        OutputStream output = null;
        HttpURLConnection connection = null;
        try {
            URL url = new URL(sUrl[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            // expect HTTP 200 OK, so we don't mistakenly save error report
            // instead of the file
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                return "Server returned HTTP " + connection.getResponseCode()
                        + " " + connection.getResponseMessage();
            }

            // this will be useful to display download percentage
            // might be -1: server did not report the length
            int fileLength = connection.getContentLength();

            // download the file
            input = connection.getInputStream();
            output = new FileOutputStream(file_name);

            byte data[] = new byte[4096];
            long total = 0;
            int count;
            while ((count = input.read(data)) != -1) {
                // allow canceling with back button
                if (isCancelled()) {
                    input.close();
                    return null;
                }
                total += count;
                // publishing the progress....
                if (fileLength > 0) // only if total length is known
                    publishProgress((int) (total * 100 / fileLength));
                output.write(data, 0, count);
            }
        } catch (Exception e) {
            return e.toString();
        } finally {
            try {
                if (output != null)
                    output.close();
                if (input != null)
                    input.close();
            } catch (IOException ignored) {
            }

            if (connection != null)
                connection.disconnect();
        }
        return null;
    }
    
    @Override
    protected void onPostExecute(String result) {
        System.out.println("download xong");
        FuncDungChung.SetUser(user);
        uploadafterdangky reg = new uploadafterdangky(context,"dsadsad",loading,linearLayout1);
		reg.execute();
       // loading.setVisibility(View.GONE);
		//linearLayout1.setVisibility(View.VISIBLE);
		//
    	//Intent localIntent = new Intent(context, SlideMenuAttribute.class);
    	//context.startActivity(localIntent);
    }

}
