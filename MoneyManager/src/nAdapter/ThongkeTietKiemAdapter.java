package nAdapter;

import java.util.ArrayList;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.DoiTuong.DoiTuongMenu;
import com.atp.moneymanager.DoiTuong.DoiTuongNganSach;
import com.atp.moneymanager.DoiTuong.DoiTuongThongkeDetail;
import com.atp.moneymanager.DoiTuong.DoiTuongThongkeTietKiem;
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

public class ThongkeTietKiemAdapter extends BaseAdapter{
	

   
    Context mcontext;
    ArrayList<DoiTuongThongkeTietKiem> list;
    static String Thu = "Thu: ";
    static String Chi = "Chi: ";
    static String a = "Bạn đang nợ: ";
	 public ThongkeTietKiemAdapter(Context context,ArrayList<DoiTuongThongkeTietKiem> list)
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
        view =  inflater.inflate(R.layout.textview_tietkiem, parent, false); 
        TextView date = (TextView)view.findViewById(R.id.ten);
        TextView tien = (TextView)view.findViewById(R.id.textView1);
        date.setText(list.get(position).date);
        String Gui = "Gửi: ";
        String Rut = "Rút: ";
        
        if (FuncDungChung.GetLanguage(mcontext) == 0)
        {
        	Gui = "Add Money: ";
        	Rut = "Withdraw: ";
        }
        if (list.get(position).rut_gui == 0)
        {
        	tien.setText(Gui + FuncDungChung.formatso(list.get(position).tien) + " " + FuncDungChung.GetCurrency());
        	tien.setTextColor(0xFF028d05);
        }
        else
        {
        	tien.setText(Rut + FuncDungChung.formatso(list.get(position).tien) + " " + FuncDungChung.GetCurrency());
        	tien.setTextColor(0xFFb50101);
        }
        
     
        return view;
    }



	@Override
	public Object getItem(int position) {
		
		return position;
	}
	
	
	
}
