package nAdapter;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.atp.moneymanager.fragment.Chi;
import com.atp.moneymanager.fragment.Thu;
import com.atp.moneymanager.fragment.thangnay;
import com.atp.moneymanager.fragment.thangsau;
import com.atp.moneymanager.fragment.thangtruoc;
/**
 * Created by shahabuddin on 6/6/14.
 */
public class childAdapterThongKe extends FragmentPagerAdapter {
 
   
 
    SparseArray<Fragment> registeredFragments = new SparseArray<Fragment>();
 
    /**
     * Create pager adapter
     *
     * @param resources
     * @param fm
     */
    public childAdapterThongKe(FragmentManager fm) {
        super(fm);
       
    }
 
    @Override
    public Fragment getItem(int position) {
    	final Fragment result;
        switch (position) {
            case 0:
                // First Fragment of First Tab
                result = new thangtruoc();
                break;
            case 1:
                // First Fragment of Second Tab
                result = new thangnay();
                break;
            case 2:
                // First Fragment of Second Tab
                result = new thangsau();
                break;
            default:
                result = null;
                break;
        }
 
        return result;
    }
 
    @Override
    public int getCount() {
        return 3;
    }
 
   
 
    /**
     * On each Fragment instantiation we are saving the reference of that Fragment in a Map
     * It will help us to retrieve the Fragment by position
     *
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }
 
    /**
     * Remove the saved reference from our Map on the Fragment destroy
     *
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }
 
 
    /**
     * Get the Fragment by position
     *
     * @param position tab position of the fragment
     * @return
     */
    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }
}