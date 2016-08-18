package nAdapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class DragableFragmentPagerAdapter extends FragmentPagerAdapter  {
	private Context mContext;

	public DragableFragmentPagerAdapter(Context context, FragmentManager fm) {
		super(fm);
		mContext = context;
	}

	@Override
	public Fragment getItem(int position) {
		if (position == 0) return Fragment.instantiate(mContext,"com.atp.moneymanager.fragment.thuchi");
		if (position == 1) return Fragment.instantiate(mContext,"com.atp.moneymanager.fragment.vayno");
		if (position == 2) return Fragment.instantiate(mContext,"com.atp.moneymanager.fragment.tietkiem");
		if (position == 3) return Fragment.instantiate(mContext,"com.atp.moneymanager.fragment.thongke");
		if (position == 4) return Fragment.instantiate(mContext,"com.atp.moneymanager.fragment.menu");
		
		         
		return null;
	}

	@Override
	public int getCount() {
		return 5;
	}

}
