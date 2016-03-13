package net.devwiki.iqiushi.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.devwiki.iqiushi.R;
import net.devwiki.iqiushi.bean.ItemsEntity;
import net.devwiki.iqiushi.bean.QiuShiResult;
import net.devwiki.iqiushi.constant.ContentType;
import net.devwiki.iqiushi.net.QiuShiApi;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;

/**
 * A placeholder fragment containing a simple view.
 */
public class ContentFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private static final String TAG = Fragment.class.getSimpleName();

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    @Bind(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    private int contentType = ContentType.ALL_TEXT;
    private int page = 1;

    private QiuShiApi qiuShiApi;
    private QiuShiAdapter qiuShiAdapter;
    private List<ItemsEntity> entityList;

    public ContentFragment(){}

    public ContentFragment(int contentType) {
        this.contentType = contentType;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    private void initData(){
        qiuShiApi = new QiuShiApi(getActivity());
        entityList = new ArrayList<>();
        qiuShiAdapter = new QiuShiAdapter(getContext(), entityList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, rootView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(qiuShiAdapter);

        refreshLayout.setColorSchemeColors(R.color.colorPrimary, R.color.colorAccent,
                R.color.colorPrimary, R.color.colorAccent);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }
        });

        return rootView;
    }

    private void refreshData(){
        qiuShiApi.getTextQiuShi(page, 30).subscribe(new Subscriber<QiuShiResult>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "compete");
                page++;
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "error:" + e.getMessage());
            }

            @Override
            public void onNext(QiuShiResult qiuShiResult) {
                Log.i(TAG, "count:" + qiuShiResult.getCount());
                if (qiuShiResult == null){
                    return;
                }
                entityList.addAll(qiuShiResult.getItems());
                qiuShiAdapter.notifyDataSetChanged();
                refreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
