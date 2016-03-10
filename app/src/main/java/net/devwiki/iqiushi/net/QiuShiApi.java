package net.devwiki.iqiushi.net;

import net.devwiki.iqiushi.bean.QiuShiResult;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 糗事获取的API
 * Created by zyz on 2016/3/9.
 */
public class QiuShiApi {

    private static final String BASE_URL = "http://m2.qiushibaike.com";

    private final QiuShiService qiuShiService;

    public QiuShiApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        qiuShiService = retrofit.create(QiuShiService.class);
    }

    public Call<QiuShiResult> getTextContent(int page, int count){
        return qiuShiService.getTextContent(page, count);
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
                Call<QiuShiResult> call = qiuShiService.getTextContent(page, count);
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
    public Observable<QiuShiResult> getPicQiuShi(int page, int count){
        return qiuShiService
                .getAllPic(page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
