package net.devwiki.iqiushi.net;

import android.content.Context;

import net.devwiki.iqiushi.bean.QiuShiResult;
import net.devwiki.iqiushi.constant.QiuShiUrl;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Query;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 糗事获取的API
 * Created by zyz on 2016/3/9.
 */
public class QiuShiApi {

    private final QiuShiService qiuShiService;
    private Context context;
    private Retrofit retrofit;

    public QiuShiApi(Context context){
        this.context = context;
        retrofit = new Retrofit.Builder()
                .baseUrl(QiuShiUrl.QIUSHI_HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        qiuShiService = retrofit.create(QiuShiService.class);
    }

    /**
     * 获取纯文糗事
     * @param page 页数
     * @param count 每页数量,默认为30
     * @return
     */
    public Observable<QiuShiResult> getTextQiuShi(final int page, final int count){
        return Observable.create(new Observable.OnSubscribe<QiuShiResult>() {
            @Override
            public void call(Subscriber<? super QiuShiResult> subscriber) {
                Call<QiuShiResult> call = qiuShiService.getAllText(page, count);
                try {
                    Response<QiuShiResult> response = call.execute();
                    if (response.isSuccess()){
                        subscriber.onNext(response.body());
                        subscriber.onCompleted();
                    }
                } catch (Throwable e) {
                    subscriber.onError(new Throwable());
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 获取纯图糗事
     * @param page 页数
     * @param count 每页数量,默认为30
     * @return
     */
    public Observable<QiuShiResult> getPicQiuShi(final int page, final int count){
        return Observable.create(new Observable.OnSubscribe<QiuShiResult>() {
            @Override
            public void call(Subscriber<? super QiuShiResult> subscriber) {
                Call<QiuShiResult> call = qiuShiService.getAllPic(page, count);
                try {
                    Response<QiuShiResult> response = call.execute();
                    if (response.isSuccess()){
                        subscriber.onNext(response.body());
                        subscriber.onCompleted();
                    }
                } catch (Throwable e) {
                    subscriber.onError(new Throwable());
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
