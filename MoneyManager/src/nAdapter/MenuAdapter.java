package nAdapter;

import java.util.ArrayList;

import com.atp.moneymanager.DoiTuong.DoiTuongMenu;
import com.atp.moneymanager.DoiTuong.DoiTuongNganSach;
import com.atp.moneymanager.DoiTuong.DoiTuongVayNo;
import com.atp.moneymanager.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuAdapter extends BaseAdapter{
	

   
    Context mcontext;
    ArrayList<DoiTuongMenu> list;
    
	public ArrayList<Integer> myPos = new ArrayList<Integer>();
    public MenuAdapter(Context context,ArrayList<DoiTuongMenu> list)
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
    public View getView(int position, View convertView, ViewGroup parent) {
    	
        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       
        if (list.get(position).GetSection() == 1)
        {
        	view =  inflater.inflate(R.layout.textview, parent, false); 
        	TextView tv = (TextView) view.findViewById(R.id.textView1);
        	tv.setText(list.get(position).Gettenmenu());
        }
        else
        {
        	view =  inflater.inflate(R.layout.buttonmenu, parent, false); 
        	TextView tv = (TextView) view.findViewById(R.id.ten);
        	tv.setText(list.get(position).Gettenmenu());
        	ImageView img = (ImageView)view.findViewById(R.id.imageView1);
        	img.setImageBitmap(list.get(position).Geticon());
        }
       
        
     
        return view;
    }



	@Override
	public Object getItem(int position) {
		
		return position;
	}
	
	
	
}
