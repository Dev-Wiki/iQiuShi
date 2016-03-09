package net.devwiki.iqiushi.net;

import net.devwiki.iqiushi.bean.QiuShiResult;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by zyz on 2016/3/9.
 */
public interface QiuShiService {

    @GET("/article/list/text")
    Observable<QiuShiResult> getAllText(@Query("page") int page, @Query("count") int count);

    @GET("/article/list/imgrank")
    Observable<QiuShiResult> getAllPic(@Query("page") int page, @Query("count") int count);
}
