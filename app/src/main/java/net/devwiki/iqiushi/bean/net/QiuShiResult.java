package net.devwiki.iqiushi.bean.net;

import java.util.List;

/**
 * 从服务器获取的糗事结果
 * Created by zyz on 2016/3/9.
 */
public class QiuShiResult {

    /**
     * count : 30
     * err : 0
     * items : [{"format":"image","image":"app115449340.jpg","published_at":1457503502,"tag":"","user":{"avatar_updated_at":1455232409,"uid":5995818,"last_visited_at":1358487710,"created_at":1358487710,"state":"active","last_device":"android_2.1.2","role":"n","login":"手里的豆浆","id":5995818,"icon":"20160211231328.jpg"},"image_size":{"s":[220,189,16180],"m":[500,430,77305]},"id":115449340,"votes":{"down":-195,"up":6055},"created_at":1457495947,"content":"你呢到了吗","state":"publish","comments_count":206,"allow_comment":true,"share_count":402,"type":"hot"},{"format":"image","image":"app115448489.jpg","published_at":1457495103,"tag":"","user":{"avatar_updated_at":1454514044,"uid":31027697,"last_visited_at":1453735500,"created_at":1453735500,"state":"active","last_device":"android_9.1.0","role":"n","login":"不爽咬我","id":31027697,"icon":"20160203154043.jpg"},"image_size":{"s":[214,225,16353],"m":[214,225,18904]},"id":115448489,"votes":{"down":-207,"up":4404},"created_at":1457491932,"content":"天空飘过五个字\u2026\u2026","state":"publish","comments_count":92,"allow_comment":true,"share_count":324,"type":"hot"}]
     */

    private int count;
    private int err;
    /**
     * format : image
     * image : app115449340.jpg
     * published_at : 1457503502
     * tag :
     * user : {"avatar_updated_at":1455232409,"uid":5995818,"last_visited_at":1358487710,"created_at":1358487710,"state":"active","last_device":"android_2.1.2","role":"n","login":"手里的豆浆","id":5995818,"icon":"20160211231328.jpg"}
     * image_size : {"s":[220,189,16180],"m":[500,430,77305]}
     * id : 115449340
     * votes : {"down":-195,"up":6055}
     * created_at : 1457495947
     * content : 你呢到了吗
     * state : publish
     * comments_count : 206
     * allow_comment : true
     * share_count : 402
     * type : hot
     */

    private List<ItemsEntity> items;

    public void setCount(int count) {
        this.count = count;
    }

    public void setErr(int err) {
        this.err = err;
    }

    public void setItems(List<ItemsEntity> items) {
        this.items = items;
    }

    public int getCount() {
        return count;
    }

    public int getErr() {
        return err;
    }

    public List<ItemsEntity> getItems() {
        return items;
    }

}
