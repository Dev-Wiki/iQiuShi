package net.devwiki.iqiushi.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import net.devwiki.iqiushi.R;
import net.devwiki.iqiushi.bean.ItemsEntity;
import net.devwiki.iqiushi.bean.QiuShiResult;
import net.devwiki.iqiushi.bean.UserEntity;
import net.devwiki.iqiushi.util.UrlTool;
import net.devwiki.iqiushi.widget.CropSquareTransformation;

import java.util.List;

/**
 * Created by zyz on 2016/3/10.
 */
public class QiuShiAdapter extends RecyclerView.Adapter<QiuShiAdapter.ViewHolder> {

    private static final String TAG = QiuShiAdapter.class.getSimpleName();

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nameView;
        ImageView headView;
        TextView contentView;
        ImageView contentImg;

        public ViewHolder(View itemView) {
            super(itemView);
            nameView = (TextView) itemView.findViewById(R.id.user_name);
            headView = (ImageView) itemView.findViewById(R.id.user_head);
            contentView = (TextView) itemView.findViewById(R.id.content_text);
            contentImg = (ImageView) itemView.findViewById(R.id.content_img);
        }
    }

    private Context context;
    private List<ItemsEntity> entityList;

    public QiuShiAdapter(Context context, List<ItemsEntity> itemsEntityList){
        this.context = context;
        this.entityList = itemsEntityList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_qiushi, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemsEntity itemsEntity = entityList.get(position);
        if (itemsEntity == null){
            return;
        }
        UserEntity userEntity = itemsEntity.getUser();
        if (userEntity != null) {
            if (userEntity.getLogin() != null) {
                holder.nameView.setText(userEntity.getLogin());
            }

            if (userEntity.getIcon() != null) {
                String headUrl = UrlTool.getHeadUrl(String.valueOf(userEntity.getUid()), userEntity.getIcon());
                Log.i(TAG, "url:" + headUrl);
                Picasso.with(context)
                        .load(headUrl)
                        .transform(new CropSquareTransformation())
                        .into(holder.headView);
            }
        }

        if (itemsEntity.getContent() != null){
            holder.contentView.setText(itemsEntity.getContent());
        }
    }

    @Override
    public int getItemCount() {
        if (entityList == null){
            return 0;
        } else {
            return entityList.size();
        }
    }
}
