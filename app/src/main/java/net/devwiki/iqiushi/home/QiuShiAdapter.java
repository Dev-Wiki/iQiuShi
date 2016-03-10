package net.devwiki.iqiushi.home;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import net.devwiki.iqiushi.bean.ItemsEntity;
import net.devwiki.iqiushi.bean.QiuShiResult;

import java.util.List;

/**
 * Created by zyz on 2016/3/10.
 */
public class QiuShiAdapter extends BaseAdapter {

    private Context context;
    private List<ItemsEntity> entityList;

    public QiuShiAdapter(Context context, List<ItemsEntity> itemsEntityList){
        this.context = context;
        this.entityList = itemsEntityList;
    }

    @Override
    public int getCount() {
        if (entityList == null){
            return 0;
        } else {
            return entityList.size();
        }
    }

    @Override
    public ItemsEntity getItem(int position) {
        return entityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
