package nAdapter;

import java.util.ArrayList;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.DoiTuong.DoiTuongLoaiHinhThu;
import com.atp.moneymanager.DoiTuong.DoiTuongNganSach;
import com.atp.moneymanager.DoiTuong.DoiTuongVayNo;
import com.atp.moneymanager.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NganSachAdapter extends BaseAdapter{
	

   
    Context mcontext;
    ArrayList<DoiTuongNganSach> list;
    int currentdangnoban = 0;
    int coutbandangno = 0;
	int coutdangnoban = 0;
	int coutlist = 0;
	int settextbandangno = 0;
    public NganSachAdapter(Context context,ArrayList<DoiTuongNganSach> list)
    {
         this.mcontext = context;
         this.list = list;
         
    }
    @Override
    public int getCount() {
        return list.size();
    }

    public void setData(ArrayList<DoiTuongNganSach> listdata)
    {
    	list.clear();
    	list.addAll(listdata);
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
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view =  inflater.inflate(R.layout.buttonngansach, parent, false); 
        
        final TextView txtcurrency = (TextView)view.findViewById(R.id.currency);
        txtcurrency.setText(FuncDungChung.currency);
        
        	TextView txtNganSach = (TextView) view.findViewById(R.id.txtNganSach);
        	txtNganSach.setText(list.get(position).GetTen());
       
        	TextView txtTien = (TextView) view.findViewById(R.id.txtTien);
        	txtTien.setText(FuncDungChung.formatso(Integer.toString(list.get(position).GetTien())));
        return view;
    }



	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	
	
}
