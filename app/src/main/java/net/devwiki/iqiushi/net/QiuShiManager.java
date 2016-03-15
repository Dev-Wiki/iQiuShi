package net.devwiki.iqiushi.net;

import android.content.Context;

import net.devwiki.iqiushi.bean.QiuShi;

import rx.Observable;

/**
 * Created by Asia on 2016/3/15 0015.
 */
public class QiuShiManager {

    private static QiuShiManager manager;

    public static QiuShiManager getManager(Context context){
        if (manager == null){
            synchronized (QiuShiManager.class){
                if (manager == null){
                    manager = new QiuShiManager(context);
                }
            }
        }
        return manager;
    }

    private Context context;
    private QiuShiService qiuShiService;

    private QiuShiManager(Context context){
        this.context = context;
        qiuShiService = new QiuShiApi().getQiuShiService();
    }

    public Observable<QiuShi> getWordQiuShi(int page, int count){
        return qiuShiService.getText(page, count);
    }
}
