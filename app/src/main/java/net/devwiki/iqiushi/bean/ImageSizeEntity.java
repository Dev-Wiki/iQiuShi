package net.devwiki.iqiushi.bean;

import java.util.List;

/**
 * 一条糗事的图片列表
 * Created by zyz on 2016/3/9.
 */
public class ImageSizeEntity {
    private List<Integer> s;
    private List<Integer> m;

    public void setS(List<Integer> s) {
        this.s = s;
    }

    public void setM(List<Integer> m) {
        this.m = m;
    }

    public List<Integer> getS() {
        return s;
    }

    public List<Integer> getM() {
        return m;
    }
}
