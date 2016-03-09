package net.devwiki.iqiushi.home;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import net.devwiki.iqiushi.R;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class HomePagerAdapter extends FragmentPagerAdapter {

    private Context context;

    public HomePagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return new ContentFragment(position);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.page_title_all_text);
            case 1:
                return context.getString(R.string.page_title_pic_text);
            case 2:
                return context.getString(R.string.page_title_all_pic);
            case 3:
                return context.getString(R.string.page_title_video);
        }
        return null;
    }
}
