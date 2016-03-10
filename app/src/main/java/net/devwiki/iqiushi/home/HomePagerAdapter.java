package net.devwiki.iqiushi.home;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import net.devwiki.iqiushi.R;
import net.devwiki.iqiushi.base.QiuShiApp;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class HomePagerAdapter extends FragmentPagerAdapter {

    private Context context;

    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
        this.context = QiuShiApp.getContext();
    }

    @Override
    public Fragment getItem(int position) {
        return ContentFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.page_title_all_text);
            case 1:
                return context.getString(R.string.page_title_all_pic);
        }
        return null;
    }
}
