package com.atp.moneymanager.activity;

import java.util.ArrayList;

import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView.OnItemClickListener;
import nAdapter.LoaiHinhChiAdapter;
import nAdapter.LoaiHinhThuAdapter;
import nAdapter.VayNoAdapter;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.DoiTuong.DoiTuongLoaiHinhChi;
import com.atp.moneymanager.DoiTuong.DoiTuongLoaiHinhThu;
import com.atp.moneymanager.fragment.Chi;
import com.atp.moneymanager.fragment.Thu;
import com.atp.moneymanager.fragment.vayno;
import com.atp.moneymanager.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
public class exchangerate extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exchangerate);	
		
		
		ArrayList<Float> arr = FuncDungChung.GetExchange_rate();
			final EditText edt1 = (EditText)findViewById(R.id.editText1);
		final EditText edt2 = (EditText)findViewById(R.id.editText2);
		final EditText edt3 = (EditText)findViewById(R.id.editText3);
		
        edt1.setText(arr.get(0).toString());
        edt2.setText(arr.get(1).toString());
        edt3.setText(arr.get(2).toString());
        final ImageView back=(ImageView)findViewById(R.id.back);
		back.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				BackToMain();
			}
		});
		
		final Button btnSave=(Button)findViewById(R.id.Save);
		btnSave.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				FuncDungChung.SetExchangerate(0, Float.parseFloat(edt1.getText().toString()));
				FuncDungChung.SetExchangerate(1, Float.parseFloat(edt2.getText().toString()));
				FuncDungChung.SetExchangerate(2, Float.parseFloat(edt3.getText().toString()));
				BackToMain();
			}
		});
      
	}
	
	
	void BackToMain()
	{
		super.onBackPressed();
	}
}
