package nAdapter;

import java.util.ArrayList;

import com.atp.moneymanager.FuncDungChung;
import com.atp.moneymanager.DoiTuong.DoiTuongNganSach;
import com.atp.moneymanager.DoiTuong.DoiTuongVayNo;
import com.atp.moneymanager.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class VayNoAdapter extends BaseAdapter{
	

   
    Context mcontext;
    ArrayList<DoiTuongVayNo> list;
    int currentdangnoban = 0;
    int coutbandangno = 0;
	int coutdangnoban = 0;
	int coutlist = 0;
	int settextbandangno = 0;
	public ArrayList<Integer> myPos = new ArrayList<Integer>();
    public VayNoAdapter(Context context,ArrayList<DoiTuongVayNo> list,int coutbandangno,int coutdangnoban)
    {
         this.mcontext = context;
         this.list = list;
         this.coutbandangno = coutbandangno;
         this.coutdangnoban = coutdangnoban;
         
    }
    @Override
    public int getCount() {
        return (list.size() + 2);
    }

    

    @Override
    public long getItemId(int position) {
        return position;
    }
    
    @Override
    public int getViewTypeCount() {
        return 2;
    }
    
    public void setData(ArrayList<DoiTuongVayNo> listdata)
    {
    	list.clear();
    	list.addAll(listdata);
    	myPos.clear();
    	currentdangnoban = 0;
        coutbandangno = 0;
    	coutdangnoban = 0;
    	for(int i = 0;i<list.size();i++)
		{
			if (list.get(i).GetTrangThai() == 1)  coutbandangno++;
			if (list.get(i).GetTrangThai() == 2)  coutdangnoban++;
		}
    	coutlist = 0;
    	settextbandangno = 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	
        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       
        if (position == 0)
        {
        	view =  inflater.inflate(R.layout.textview, parent, false); 
        	TextView tv = (TextView) view.findViewById(R.id.textView1);
        	if (FuncDungChung.GetLanguage(mcontext) == 0)
    		{
        		tv.setText("Who is Owing");
    		}
        	else
        	{
        		tv.setText("ĐANG NỢ BẠN");
        	}
        	myPos.add(-1);
        }
        
        
        if (position > 0)
        {
        	if (currentdangnoban < coutdangnoban)
        	{
	        	view =  inflater.inflate(R.layout.buttonvayno, parent, false); 
	        	
	        	
	        	for(int i = coutlist;i<list.size();i++)
	        	{
	        		coutlist++;
	        		if (list.get(i).GetTrangThai() == 2)
	        		{
	        			TextView ten = (TextView) view.findViewById(R.id.ten);
	                    ten.setText(list.get(i).GetTen());
	                    myPos.add(i);
	                    TextView tien = (TextView) view.findViewById(R.id.tien);
	                    tien.setText(FuncDungChung.formatso(Integer.toString(list.get(i).GetTien())));
	                    currentdangnoban++;
	                    final TextView txtcurrency = (TextView)view.findViewById(R.id.currency);
	                    txtcurrency.setText(FuncDungChung.currency);
	        			break;
	        		}
	        	}
        	}
        	else
        	{
        		if (settextbandangno == 0)
        		{
	        		coutlist = 0;
	        		settextbandangno = 1;
	        		view =  inflater.inflate(R.layout.textview, parent, false); 
	            	TextView tv = (TextView) view.findViewById(R.id.textView1);
	            	if (FuncDungChung.GetLanguage(mcontext) == 0)
	        		{
	            		tv.setText("You are Owing");
	        		}
	            	else
	            	{
	            		tv.setText("BẠN ĐANG NỢ");
	            	}
	            	myPos.add(-1);
        		}
        		else
        		{
        			view =  inflater.inflate(R.layout.buttonvayno, parent, false);
        			for(int i = coutlist;i<list.size();i++)
    	        	{
    	        		coutlist++;
    	        		if (list.get(i).GetTrangThai() == 1)
    	        		{
    	        			TextView ten = (TextView) view.findViewById(R.id.ten);
    	                    ten.setText(list.get(i).GetTen());
    	                    myPos.add(i);
    	                    TextView tien = (TextView) view.findViewById(R.id.tien);
    	                    tien.setText(FuncDungChung.formatso(Integer.toString(list.get(i).GetTien())));
    	                    final TextView txtcurrency = (TextView)view.findViewById(R.id.currency);
    	                    txtcurrency.setText(FuncDungChung.currency);
    	                    currentdangnoban++;
    	        			break;
    	        		}
    	        	}
        		}
        	}
        }
        
        
     
        return view;
    }



	@Override
	public Object getItem(int position) {
		
		return position;
	}
	
	
	
}
