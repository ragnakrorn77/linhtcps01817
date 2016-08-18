package nAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.DoiTuong.DoiTuongDay;
import com.atp.moneymanager.DoiTuong.DoiTuongLoaiHinhChi;
import com.atp.moneymanager.DoiTuong.DoiTuongVayNo;
import com.atp.moneymanager.activity.quenmatkhau;
import com.atp.moneymanager.activity.thongkedetail;
import com.atp.moneymanager.R;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ThongKeAdapter extends BaseAdapter{
	

   
    Context mcontext;
    ArrayList<DoiTuongDay> list;
    String Today="";
    private int xposition;
    public ThongKeAdapter(Context context,ArrayList<DoiTuongDay> list)
    {
         this.mcontext = context;
         this.list = list;
         
         Calendar c = Calendar.getInstance();
		  SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		  Today = df.format(c.getTime());
		  
		  
         
    }
    @Override
    public int getCount() {
        return list.size();
    }

  
    @Override
    public long getItemId(int position) {
        return position;
    }
    
    @Override
    public int getViewTypeCount() {
        return 2;
    }
    

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view =  inflater.inflate(R.layout.date, parent, false); 
        final TextView txt3 = (TextView)view.findViewById(R.id.textView3);
        final TextView txt4 = (TextView)view.findViewById(R.id.textView4);
        TextView date = (TextView)view.findViewById(R.id.textView2);
        TextView  txtThu = (TextView)view.findViewById(R.id.textView5);
        TextView txtChi = (TextView)view.findViewById(R.id.textView7);
        TextView txtthungay = (TextView)view.findViewById(R.id.textView1);
        final TextView txtcurrency = (TextView)view.findViewById(R.id.currency);
        txtcurrency.setText(FuncDungChung.currency);
        final TextView txtcurrency2 = (TextView)view.findViewById(R.id.currency2);
        txtcurrency2.setText(FuncDungChung.currency);
        
        xposition = position;
        Button xem = (Button)view.findViewById(R.id.view);
        if (FuncDungChung.GetLanguage(mcontext)==0)
        {
        	xem.setText("View");
        }
        xem.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				FuncDungChung.Datedetail = list.get((int) getItemId(position)).GetDate();
				Intent mainactivity = new Intent(mcontext, thongkedetail.class);
				mcontext.startActivity(mainactivity);
				//System.out.println((int) getItemId(position));
			}
			
		});
        if (FuncDungChung.GetLanguage(mcontext) == 0)
		{
        	
        	txt3.setText("Income");
        	txt4.setText("Expense");
        	
		}
        
        
        date.setText(list.get(position).Getdayofweek() + " " + list.get(position).GetDate());
        txtThu.setText(FuncDungChung.formatso(list.get(position).GetThu()));
        txtChi.setText(FuncDungChung.formatso(list.get(position).GetChi()));
        txtthungay.setText(FuncDungChung.TuThuNgaySangSo(list.get(position).Getdayofweek()));
        if (Today.equals(list.get(position).GetDate()))
        {
	        RelativeLayout layout =(RelativeLayout)view.findViewById(R.id.relativeLayout1);
	        layout.setBackgroundResource(R.drawable.round2);
	        date.setText("Today" + " " + list.get(position).GetDate());
        }
        
        
        return view;
    }



	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	
	
}
