package net.devwiki.iqiushi.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import net.devwiki.iqiushi.R;
import net.devwiki.iqiushi.bean.QiuShi;
import net.devwiki.iqiushi.bean.WordQiuShi;
import net.devwiki.iqiushi.bean.net.ItemsEntity;
import net.devwiki.iqiushi.bean.net.UserEntity;
import net.devwiki.iqiushi.constant.QiuShiConstant;
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
    private List<QiuShi> qiuShiList;

    public QiuShiAdapter(Context context, List<QiuShi> qiuShiList){
        this.context = context;
        this.qiuShiList = qiuShiList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_qiushi, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        QiuShi qiuShi = qiuShiList.get(position);
        holder.nameView.setText(qiuShi.getPubName());
        String headUrl = UrlTool.getHeadUrl(String.valueOf(qiuShi.getPubUid()), qiuShi.getPubHead());
        Log.i(TAG, "url:" + headUrl);
        Picasso.with(context)
                .load(headUrl)
                .transform(new CropSquareTransformation())
                .into(holder.headView);
        if (qiuShi.getFormat().equals(QiuShiConstant.Format.WORD)){
            WordQiuShi wordQiuShi = (WordQiuShi) qiuShi;
            holder.contentView.setText(wordQiuShi.getContent());
        } else {

        }
    }

    @Override
    public int getItemCount() {
        return qiuShiList==null ? 0 : qiuShiList.size();
    }
}
