package com.atp.moneymanager;

import android.app.Service;
import android.os.IBinder;
import android.widget.Toast;
import android.content.Intent;

public class AutoStartUp extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
		// do something when the service is created
	}

}