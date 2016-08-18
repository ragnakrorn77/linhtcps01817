package nAdapter;

import java.util.ArrayList;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.DoiTuong.DoiTuongMenu;
import com.atp.moneymanager.DoiTuong.DoiTuongNganSach;
import com.atp.moneymanager.DoiTuong.DoiTuongThongkeDetail;
import com.atp.moneymanager.DoiTuong.DoiTuongVayNo;
import com.atp.moneymanager.activity.thongkedetail;
import com.atp.moneymanager.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ThongkeDetailAdapter extends BaseAdapter{
	

   
    Context mcontext;
    ArrayList<DoiTuongThongkeDetail> list;
    static String Thu = "Thu: ";
    static String Chi = "Chi: ";
    static String a = "Bạn đang nợ: ";
	public ArrayList<DoiTuongThongkeDetail> myPos = new ArrayList<DoiTuongThongkeDetail>();
    public ThongkeDetailAdapter(Context context,ArrayList<DoiTuongThongkeDetail> list)
    {
         this.mcontext = context;
         this.list = list;
       
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
        System.out.println(list.get(position).dang);
        if (list.get(position).section == 1)
        {
        	view =  inflater.inflate(R.layout.textview, parent, false); 
        	TextView tv = (TextView) view.findViewById(R.id.textView1);
        	tv.setText(list.get(position).ten_section);
        }
        else
        {
        	if (list.get(position).dang == 0)
        	{
	        	view =  inflater.inflate(R.layout.buttonthongke, parent, false); 
	        	TextView tv = (TextView) view.findViewById(R.id.ten);
	        	tv.setText(list.get(position).date);
	        	TextView tien = (TextView) view.findViewById(R.id.textView1);
	        	
	        	if (FuncDungChung.GetLanguage(mcontext) == 0)
	    		{
	        		Thu = "Income: ";
	    		}
	        	tien.setText(Thu + FuncDungChung.formatso(list.get(position).tien) + " " + FuncDungChung.GetCurrency());
	        	tien.setTextColor(0xFF028d05);
	        	final Button xem = (Button)view.findViewById(R.id.view);
	        	 if (FuncDungChung.GetLanguage(mcontext)==0)
	             {
	             	xem.setText("View");
	             }
	        	xem.setOnClickListener(new Button.OnClickListener(){

	        		@Override
	        		public void onClick(View v) {
	        		thongkedetail.popupWindow = FuncDungChung.ShowPopupDetail(mcontext, xem, thongkedetail.back_dim_layout, Thu, list.get(position).date
	        				, FuncDungChung.formatso(list.get(position).tien), list.get(position).ghichu, list.get(position).ngansach,list.get(position).dang,list.get(position).id);
	     
	        	}});
        	}
        	
        	if (list.get(position).dang == 1)
        	{
        		
	        	view =  inflater.inflate(R.layout.buttonthongke, parent, false); 
	        	TextView tv = (TextView) view.findViewById(R.id.ten);
	        	tv.setText(list.get(position).date);
	        	TextView tien = (TextView) view.findViewById(R.id.textView1);
	        	
	        	if (FuncDungChung.GetLanguage(mcontext) == 0)
	    		{
	        		Chi = "Expense: ";
	    		}
	        	
	        	tien.setText(Chi + FuncDungChung.formatso(list.get(position).tien) + " " + FuncDungChung.GetCurrency());
	        	tien.setTextColor(0xFFb50101);
	        	
	        	final Button xem = (Button)view.findViewById(R.id.view);
	        	 if (FuncDungChung.GetLanguage(mcontext)==0)
	             {
	             	xem.setText("View");
	             }
	        	xem.setOnClickListener(new Button.OnClickListener(){

	        		@Override
	        		public void onClick(View v) {
	        		thongkedetail.popupWindow = FuncDungChung.ShowPopupDetail(mcontext, xem, thongkedetail.back_dim_layout, Chi, list.get(position).date
	        				, FuncDungChung.formatso(list.get(position).tien), list.get(position).ghichu, list.get(position).ngansach,list.get(position).dang,list.get(position).id);
	     
	        	}});
        	}
        	
        	if (list.get(position).dang == 3)
        	{
        		
	        	view =  inflater.inflate(R.layout.buttondetailvayno, parent, false); 
	        	TextView tv = (TextView) view.findViewById(R.id.ten);
	        	tv.setText(list.get(position).date);
	        	TextView tien = (TextView) view.findViewById(R.id.textView1);
	        	
	        	String swho = "Tên: ";
	        	if (FuncDungChung.GetLanguage(mcontext) == 0)
	    		{
	        		a = "You are owed: ";
	        		swho = "Who: ";
	    		}
	        	
	        	
	        	tien.setText(a + FuncDungChung.formatso(list.get(position).tien) + " " + FuncDungChung.GetCurrency());
	        	tien.setTextColor(0xFF028d05);
	        	TextView who = (TextView) view.findViewById(R.id.textView2);
	        	who.setText(swho + list.get(position).who);
	        	
	        	final Button xem = (Button)view.findViewById(R.id.view);
	        	 if (FuncDungChung.GetLanguage(mcontext)==0)
	             {
	             	xem.setText("View");
	             }
	        	xem.setOnClickListener(new Button.OnClickListener(){

	        		@Override
	        		public void onClick(View v) {
	        		thongkedetail.popupWindow = FuncDungChung.ShowPopupDetail(mcontext, xem, thongkedetail.back_dim_layout, a, list.get(position).date
	        				, FuncDungChung.formatso(list.get(position).tien), list.get(position).ghichu, list.get(position).ngansach,list.get(position).dang,list.get(position).id);
	     
	        	}});
        	}
        	
        	if (list.get(position).dang == 4)
        	{
        		
	        	view =  inflater.inflate(R.layout.buttondetailvayno, parent, false); 
	        	TextView tv = (TextView) view.findViewById(R.id.ten);
	        	tv.setText(list.get(position).date);
	        	TextView tien = (TextView) view.findViewById(R.id.textView1);
	        	a = "Đang Nợ Bạn: ";
	        	String swho = "Tên: ";
	        	if (FuncDungChung.GetLanguage(mcontext) == 0)
	    		{
	        		a = "Owe your money: ";
	        		swho = "Who: ";
	    		}
	        	
	        	tien.setText(a + FuncDungChung.formatso(list.get(position).tien) + " " + FuncDungChung.GetCurrency());
	        	tien.setTextColor(0xFFb50101);
	        	TextView who = (TextView) view.findViewById(R.id.textView2);
	        	who.setText(swho + list.get(position).who);
	        	
	        	final Button xem = (Button)view.findViewById(R.id.view);
	        	 if (FuncDungChung.GetLanguage(mcontext)==0)
	             {
	             	xem.setText("View");
	             }
	        	xem.setOnClickListener(new Button.OnClickListener(){

	        		@Override
	        		public void onClick(View v) {
	        		thongkedetail.popupWindow = FuncDungChung.ShowPopupDetail(mcontext, xem, thongkedetail.back_dim_layout, a, list.get(position).date
	        				, FuncDungChung.formatso(list.get(position).tien), list.get(position).ghichu, list.get(position).ngansach,list.get(position).dang,list.get(position).id);
	     
	        	}});
	        	
        	}
        }
       
        
     
        return view;
    }



	@Override
	public Object getItem(int position) {
		
		return position;
	}
	
	
	
}
