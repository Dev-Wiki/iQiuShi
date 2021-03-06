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
import net.devwiki.iqiushi.bean.QiuShi;
import net.devwiki.iqiushi.bean.net.ItemsEntity;
import net.devwiki.iqiushi.bean.net.QiuShiResult;
import net.devwiki.iqiushi.constant.QiuShiConstant;
import net.devwiki.iqiushi.net.QiuShiApi;
import net.devwiki.iqiushi.net.QiuShiManager;

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

    private static final String QIUSHI_FORMAT = "qiuShiFormat";

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    @Bind(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    private int qiuShiFormat = QiuShiConstant.Format.ALL_TEXT;
    private int page = 1;

    private QiuShiManager qiuShiManager;
    private QiuShiAdapter qiuShiAdapter;
    private List<QiuShi> qiuShiList;

    public ContentFragment newInstance(int qiuShiFormat){
        ContentFragment fragment = new ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(QIUSHI_FORMAT, qiuShiFormat);
        fragment.setArguments(bundle);
        return fragment;
    }

    public ContentFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    private void initData(){
        qiuShiFormat = getArguments().getInt(QIUSHI_FORMAT, QiuShiConstant.Format.ALL_TEXT);
        qiuShiManager = QiuShiManager.getManager(getContext());
        qiuShiList = new ArrayList<>();
        qiuShiAdapter = new QiuShiAdapter(getContext(), qiuShiList);
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
        qiuShiManager.getWordQiuShi(page, 30)
                .
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
