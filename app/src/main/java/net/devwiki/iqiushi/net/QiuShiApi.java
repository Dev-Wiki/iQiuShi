package net.devwiki.iqiushi.net;

import net.devwiki.iqiushi.bean.QiuShiResult;

import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zyz on 2016/3/9.
 */
public class QiuShiApi {

    private static final String BASE_URL = "http://m2.qiushibaike.com";

    private final QiuShiService qiuShiService;

    public QiuShiApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .build();
        qiuShiService = retrofit.create(QiuShiService.class);
    }

    public Observable<QiuShiResult> getTextQiuShi(int page, int count){
        return qiuShiService
                .getAllText(page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<QiuShiResult> getPicQiuShi(int page, int count){
        return qiuShiService
                .getAllPic(page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
