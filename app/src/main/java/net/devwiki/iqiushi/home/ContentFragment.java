package net.devwiki.iqiushi.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import net.devwiki.iqiushi.R;
import net.devwiki.iqiushi.bean.QiuShiResult;
import net.devwiki.iqiushi.constant.ContentType;
import net.devwiki.iqiushi.net.QiuShiApi;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;

/**
 * A placeholder fragment containing a simple view.
 */
public class ContentFragment extends Fragment {

    private static final String TAG = Fragment.class.getSimpleName();

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    @Bind(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    @Bind(R.id.root_layout)
    RelativeLayout rootLayout;

    private int contentType = ContentType.ALL_TEXT;
    private int page = 1;

    private QiuShiApi qiuShiApi;

    public ContentFragment(int position) {
        this.contentType = contentType;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    private void initData(){
        qiuShiApi = new QiuShiApi();
        qiuShiApi.getTextQiuShi(page, 0).subscribe(new Subscriber<QiuShiResult>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "compete");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(QiuShiResult qiuShiResult) {
                Log.i(TAG, "count:" + qiuShiResult.getCount());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
