package net.devwiki.iqiushi.base;

import android.app.Application;
import android.content.Context;

/**
 * 全局的Application
 * Created by zyz on 2016/3/9.
 */
public class QiuShiApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    /**
     * 获取全局的Context
     * @return Content实例
     */
    public static Context getContext() {
        return context;
    }
}
