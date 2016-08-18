package com.atp.moneymanager;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.widget.Toast;

public class BootComplete extends BroadcastReceiver {
	final public static String ONE_TIME = "onetime";
	public static int landau = 0;
	@Override
	public void onReceive(Context context, Intent intent) {
		
		if (intent.getAction().equalsIgnoreCase(Intent.ACTION_BOOT_COMPLETED)) {
			//Intent serviceIntent = new Intent(context, AutoStartUp.class);
			//context.startService(serviceIntent);
			SetAlarm(context);
		}
		
		
		
	}
	
	
	public void SetAlarm(Context context)
    {
		
		String remind[] = FuncDungChung.getstateremind().split("/");
		String time[] = remind[1].split(":");
		if (Integer.parseInt(remind[0]) == 1 )
		{
			Calendar calendar = Calendar.getInstance();
	        calendar.setTimeInMillis(System.currentTimeMillis());
	        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time[0]));
	        calendar.set(Calendar.MINUTE, Integer.parseInt(time[1]));
	
	        
	        AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
	        Intent intent = new Intent(context, AlarmManagerBroadcastReceiver.class);
	        intent.putExtra(ONE_TIME, Boolean.FALSE);
	        PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
	        //After after 30 seconds
	        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000 * 60 * 60 * 24 * Integer.parseInt(remind[2]) , pi); 
		}
	}

    public void CancelAlarm(Context context)
    {
        Intent intent = new Intent(context, AlarmManagerBroadcastReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender);
    }
    public void setOnetimeTimer(Context context){
    	AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmManagerBroadcastReceiver.class);
        intent.putExtra(ONE_TIME, Boolean.TRUE);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
        am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pi);
    }
}