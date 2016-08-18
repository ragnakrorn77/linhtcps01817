package com.atp.moneymanager.activity;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import nAdapter.DragableFragmentPagerAdapter;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.format.DateFormat;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.atp.moneymanager.BootComplete;
import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.HomeWatcher;
import com.atp.moneymanager.OnHomePressedListener;
import com.atp.moneymanager.UnderlinePageIndicator;
import com.atp.moneymanager.fragment.vayno;
import com.atp.moneymanager.R;

public class SlideMenuAttribute extends FragmentActivity{


	Bundle mybundle;
	@Override
	protected void onDestroy() {
		System.out.println("onDestroy");
		super.onDestroy();
	}
	@Override
	protected void onPause() {
		
		super.onPause();
	}
	@Override
	protected void onResume() {
		super.onResume();
		System.out.println("onResume");
		
	}
	@Override
	protected void onStart() {
		increaseNumberOfOpenning();
		

		if (FuncDungChung.isrunning == false)
		{
			if (FuncDungChung.getStatePasscode())
			{
				Intent localIntent = new Intent(SlideMenuAttribute.this, passcode.class);
				SlideMenuAttribute.this.startActivity(localIntent);
				finish();
			}
			FuncDungChung.isrunning = true;
		}
		super.onStart();
	}
	@Override
	protected void onStop() {
		System.out.println("onStop");
		FuncDungChung.isUserIsOnHomeScreen(this);
		super.onStop();
	}
	
	@Override
	public void onBackPressed() {
	
	super.onBackPressed();
	}
	
	
	
		public void increaseNumberOfOpenning() {
		SharedPreferences sp = this.getSharedPreferences("OPENING_APP_COUNT",
		Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.putInt("numOfOpenning", getNumOfOpenningApp() + 1);
		editor.commit();
		}

		public int getNumOfOpenningApp() {
		SharedPreferences sp = this.getSharedPreferences("OPENING_APP_COUNT",
		Activity.MODE_PRIVATE);
		int numOfOpenningSetting = sp.getInt("numOfOpenning", 0);
		return numOfOpenningSetting;

		}
	
	UnderlinePageIndicator mIndicator;
	public static ViewPager viewPager;
	public static RelativeLayout back_dim_layout;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		mybundle = savedInstanceState;
	
		
		setContentView(R.layout.layout_slidemenu_attribute);
		
	
		
    	
		BootComplete alarm = new BootComplete();
		 alarm.SetAlarm(this);		 
		 
		 
		FuncDungChung.currency = FuncDungChung.GetCurrency();
		Calendar cal = Calendar.getInstance(); 

	
		  Calendar c = Calendar.getInstance();
		  SimpleDateFormat df = new SimpleDateFormat("HH:mm dd-MM-yyyy");
		  FuncDungChung.Date = df.format(c.getTime());
		  
		  FuncDungChung.Ngan_Sach = FuncDungChung.getNganSach(FuncDungChung.ma_ngan_sach);
		  
		  TextView txt1 = (TextView)findViewById(R.id.textView1);
		  TextView txt2 = (TextView)findViewById(R.id.textView2);
		  TextView txt3 = (TextView)findViewById(R.id.textView3);
		  TextView txt4 = (TextView)findViewById(R.id.textView4);
		  TextView txt5 = (TextView)findViewById(R.id.textView5);
		
		  if (FuncDungChung.GetLanguage(this) == 0)
		  {
			  txt1.setText("Records");
			  txt2.setText("Loan - Owe");
			  txt3.setText("Saving Up");
			  txt4.setText("Report");
			  txt5.setText("Menu");
		  }
		 viewPager = (ViewPager) findViewById(R.id.pager);
		viewPager.setAdapter(new DragableFragmentPagerAdapter(this,getSupportFragmentManager()));
		viewPager.setCurrentItem(0, false);
		mIndicator = (UnderlinePageIndicator) findViewById(R.id.indicator);
		mIndicator.setFades(false);
		mIndicator.setViewPager(viewPager);
		
		back_dim_layout = (RelativeLayout)findViewById(R.id.bac_dim_layout);
		
		back_dim_layout.setOnClickListener(new View.OnClickListener(){

	     	   @Override
	     	   public void onClick(View arg0) {
	     		  System.out.println("zo");
	     		  FuncDungChung.popupWindow.dismiss();
	     		  back_dim_layout.setVisibility(View.GONE);
	     		 
	     	   }
	        });
		
		
		final LinearLayout layout2=(LinearLayout)findViewById(R.id.RelativeLayout2);
		layout2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				viewPager.setCurrentItem(0);
			}
		});
		
		final LinearLayout layout3=(LinearLayout)findViewById(R.id.RelativeLayout3);
		layout3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				viewPager.setCurrentItem(1);
			}
		});
		final LinearLayout layout4=(LinearLayout)findViewById(R.id.RelativeLayout4);
		layout4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				viewPager.setCurrentItem(2);
			}
		});
		final LinearLayout layout5=(LinearLayout)findViewById(R.id.RelativeLayout5);
		layout5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				viewPager.setCurrentItem(3);
			}
		});
		
		final LinearLayout layout6=(LinearLayout)findViewById(R.id.RelativeLayout6);
		layout6.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				viewPager.setCurrentItem(4);
			}
		});
		
		System.out.println("vao oncreate");
		
	
		
		HomeWatcher mHomeWatcher = new HomeWatcher(this);
		mHomeWatcher.setOnHomePressedListener(new OnHomePressedListener() {
		    @Override
		    public void onHomePressed() {
		    	System.out.println("home press");
		    }
		    @Override
		    public void onHomeLongPressed() {
		    }
		});
		mHomeWatcher.startWatch();
	}
	
	
	  

	
}
