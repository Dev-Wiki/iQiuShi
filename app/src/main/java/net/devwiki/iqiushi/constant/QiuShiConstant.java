package net.devwiki.iqiushi.constant;

/**
 * 糗事百科网站相关的常量
 * Created by Asia on 2016/3/15 0015.
 */
public interface QiuShiConstant {

    /**
     * 糗事的内容类型
     */
    interface Format{
        /**
         * 文字类型
         */
        String WORD = "word";

        /**
         * 图片类型
         */
        String IMAGE = "image";

        /**
         * 内容类别:纯文
         */
        int ALL_TEXT = 0;

        /**
         * 内容类别:纯图
         */
        int ALL_PIC = 1;

        /**
         * 内容类别:图文
         */
        int PIC_TEXT = 2;

        /**
         * 内容类别:视频
         */
        int VIDEO = 3;
    }

    /**
     * 糗事的分类类别
     */
    interface Type{

        /**
         * 热门糗事
         */
        String HOT = "hot";
    }

    interface URL{
        /**
         * 获取糗事的主机地址
         */
        String QIUSHI_HOST = "http://m2.qiushibaike.com";

        /**
         * 糗事中图片存储主机地址
         */
        String PIC_HOST = "http://pic.qiushibaike.com";

        /**
         * 糗事中图片存储的相对路径
         */
        String PIC_PATH = "/system/pictures/";

        /**
         * 糗事用户头像的存储相对路径
         */
        String HEAD_PATH = "/system/avtnew/";
    }
}
