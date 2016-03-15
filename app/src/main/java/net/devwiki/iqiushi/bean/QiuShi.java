package net.devwiki.iqiushi.bean;

/**
 * UI上展示的一条糗事
 * Created by Asia on 2016/3/15 0015.
 */
public class QiuShi {

    /**
     * 糗事的格式,参见{@link net.devwiki.iqiushi.constant.QiuShiConstant.Format}
     */
    private String format;

    private String type;

    private String pubUid;

    private String pubName;

    private String pubHead;

    private String pubDate;

    private int voteDown;

    private int voteUp;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPubUid() {
        return pubUid;
    }

    public void setPubUid(String pubUid) {
        this.pubUid = pubUid;
    }

    public String getPubName() {
        return pubName;
    }

    public void setPubName(String pubName) {
        this.pubName = pubName;
    }

    public String getPubHead() {
        return pubHead;
    }

    public void setPubHead(String pubHead) {
        this.pubHead = pubHead;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public int getVoteDown() {
        return voteDown;
    }

    public void setVoteDown(int voteDown) {
        this.voteDown = voteDown;
    }

    public int getVoteUp() {
        return voteUp;
    }

    public void setVoteUp(int voteUp) {
        this.voteUp = voteUp;
    }
}
