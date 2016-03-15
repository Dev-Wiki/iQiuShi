package net.devwiki.iqiushi.net;

/**
 * Created by Asia on 2016/3/13 0013.
 */

import net.devwiki.iqiushi.constant.QiuShiConstant;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 糗事获取的API
 * Created by zyz on 2016/3/9.
 */
public class QiuShiApi {

    private final QiuShiService qiuShiService;
    private Retrofit retrofit;

    public QiuShiApi(){
        retrofit = new Retrofit.Builder()
                .baseUrl(QiuShiConstant.URL.QIUSHI_HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        qiuShiService = retrofit.create(QiuShiService.class);
    }

    public QiuShiService getQiuShiService(){
        return qiuShiService;
    }
}