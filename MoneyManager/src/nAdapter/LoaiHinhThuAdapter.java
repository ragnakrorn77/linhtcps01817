package nAdapter;

import java.util.ArrayList;

import com.atp.moneymanager.DoiTuong.DoiTuongLoaiHinhThu;
import com.atp.moneymanager.DoiTuong.DoiTuongVayNo;
import com.atp.moneymanager.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class LoaiHinhThuAdapter extends BaseAdapter{
	

   
    Context mcontext;
    ArrayList<DoiTuongLoaiHinhThu> list;
    int currentdangnoban = 0;
    int coutbandangno = 0;
	int coutdangnoban = 0;
	int coutlist = 0;
	int settextbandangno = 0;
    public LoaiHinhThuAdapter(Context context,ArrayList<DoiTuongLoaiHinhThu> list)
    {
         this.mcontext = context;
         this.list = list;
         
    }
    @Override
    public int getCount() {
        return list.size();
    }

    public void setData(ArrayList<DoiTuongLoaiHinhThu> listdata)
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
        view =  inflater.inflate(R.layout.buttonloaihinhthu, parent, false); 
        
        
        
        	TextView tv = (TextView) view.findViewById(R.id.txtLoaiHinhThu);
        	tv.setText(list.get(position).GetTen());
       
        return view;
    }



	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	
	
}
