package nAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.DoiTuong.DoiTuongDay;
import com.atp.moneymanager.DoiTuong.DoiTuongLoaiHinhChi;
import com.atp.moneymanager.DoiTuong.DoiTuongVayNo;
import com.atp.moneymanager.activity.ThongKeTheoMonth;
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

public class AlldateAdapter extends BaseAdapter{
	

   
    Context mcontext;
    ArrayList<String> list;
    
    public AlldateAdapter(Context context,ArrayList<String> list)
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
        view =  inflater.inflate(R.layout.textview_button, parent, false); 
        final TextView txt1 = (TextView)view.findViewById(R.id.textView1);
        txt1.setText(list.get(position));
        
        Button xem = (Button)view.findViewById(R.id.view);
        
        if (FuncDungChung.GetLanguage(mcontext)==0)
        {
        	xem.setText("View");
        }
        xem.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				FuncDungChung.theomonth = list.get(position);
				Intent mainactivity = new Intent(mcontext, ThongKeTheoMonth.class);
				mcontext.startActivity(mainactivity);
				System.out.println((int) getItemId(position));
			}
			
		});
        
        
        return view;
    }



	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	
	
}
