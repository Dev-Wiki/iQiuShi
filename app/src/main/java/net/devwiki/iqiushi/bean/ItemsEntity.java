package net.devwiki.iqiushi.bean;

/**
 * 代表一条糗事
 * Created by zyz on 2016/3/9.
 */
public class ItemsEntity {
    private String format;
    private String image;
    private int published_at;
    private String tag;
    /**
     * avatar_updated_at : 1455232409
     * uid : 5995818
     * last_visited_at : 1358487710
     * created_at : 1358487710
     * state : active
     * last_device : android_2.1.2
     * role : n
     * login : 手里的豆浆
     * id : 5995818
     * icon : 20160211231328.jpg
     */

    private UserEntity user;
    private ImageSizeEntity image_size;
    private int id;
    /**
     * down : -195
     * up : 6055
     */

    private VotesEntity votes;
    private int created_at;
    private String content;
    private String state;
    private int comments_count;
    private boolean allow_comment;
    private int share_count;
    private String type;

    public void setFormat(String format) {
        this.format = format;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPublished_at(int published_at) {
        this.published_at = published_at;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setImage_size(ImageSizeEntity image_size) {
        this.image_size = image_size;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVotes(VotesEntity votes) {
        this.votes = votes;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public void setAllow_comment(boolean allow_comment) {
        this.allow_comment = allow_comment;
    }

    public void setShare_count(int share_count) {
        this.share_count = share_count;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormat() {
        return format;
    }

    public String getImage() {
        return image;
    }

    public int getPublished_at() {
        return published_at;
    }

    public String getTag() {
        return tag;
    }

    public UserEntity getUser() {
        return user;
    }

    public ImageSizeEntity getImage_size() {
        return image_size;
    }

    public int getId() {
        return id;
    }

    public VotesEntity getVotes() {
        return votes;
    }

    public int getCreated_at() {
        return created_at;
    }

    public String getContent() {
        return content;
    }

    public String getState() {
        return state;
    }

    public int getComments_count() {
        return comments_count;
    }

    public boolean isAllow_comment() {
        return allow_comment;
    }

    public int getShare_count() {
        return share_count;
    }

    public String getType() {
        return type;
    }

}
