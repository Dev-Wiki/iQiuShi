package net.devwiki.iqiushi.bean;

/**
 * 一条糗事的投票
 * Created by zyz on 2016/3/9.
 */
public class VotesEntity {
    private int down;
    private int up;

    public void setDown(int down) {
        this.down = down;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public int getUp() {
        return up;
    }
}
