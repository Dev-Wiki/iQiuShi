package net.devwiki.iqiushi.util;

import net.devwiki.iqiushi.bean.QiuShi;
import net.devwiki.iqiushi.bean.net.ItemsEntity;

/**
 * JavaBean的转换工具类
 * Created by Asia on 2016/3/15 0015.
 */
public class BeanConvert {

    public static QiuShi itemsEntity2QiuShi(ItemsEntity entity){
        if (entity == null){
            return null;
        }
        QiuShi qiuShi = new QiuShi();

        return qiuShi;
    }
}
