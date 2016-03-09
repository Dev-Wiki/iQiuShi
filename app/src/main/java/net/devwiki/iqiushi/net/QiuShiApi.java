package net.devwiki.iqiushi.net;

import net.devwiki.iqiushi.bean.QiuShiResult;

import retrofit2.Retrofit;
import rx.Observable;
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
                .build();
        qiuShiService = retrofit.create(QiuShiService.class);
    }

    /**
     * 获取纯文糗事
     * @param page 页数
     * @param count 每页数量,默认为30
     * @return
     */
    public Observable<QiuShiResult> getTextQiuShi(int page, int count){
        return qiuShiService
                .getAllText(page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
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
