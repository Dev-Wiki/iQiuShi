package net.devwiki.iqiushi.constant;

/**
 * 内容类别
 * Created by zyz on 2016/3/9.
 */
public interface ContentType {

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
