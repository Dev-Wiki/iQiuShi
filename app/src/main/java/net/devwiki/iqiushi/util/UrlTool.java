package net.devwiki.iqiushi.util;

import android.text.TextUtils;

import net.devwiki.iqiushi.constant.QiuShiUrl;

/**
 * 处理糗事链接的工具类
 * Created by Asia on 2016/3/13 0013.
 */
public class UrlTool {

    private static final String ERROR_URL = "http://m.baidu.com";

    /**
     * 获取头像的URL,格式为:http://pic.qiushibaike.com/system/avtnew/3050/30501066/medium/20151022202752.jpg
     * @param uuid 用户的uuid
     * @param headName 用户头像文件名称(带后缀)
     * @return 头像的URL
     */
    public static String getHeadUrl(String uuid, String headName){
        if (TextUtils.isEmpty(uuid)){
            return ERROR_URL;
        }

        String dirName;
        if (uuid.length() == 7){
            dirName = uuid.substring(0, 3);
        } else if (uuid.length() == 8){
            dirName = uuid.substring(0, 4);
        } else {
            dirName = "";
        }

        if (headName == null){
            headName = "";
        }
        return QiuShiUrl.PIC_HOST + QiuShiUrl.HEAD_PATH + dirName + "/" + uuid + "/medium/" + headName;
    }

    /**
     * 获取头像的URL,格式为:http://pic.qiushibaike.com/system/pictures/11527/115271396/medium/app115271396.jpg
     * @param uuid 用户的uuid
     * @param imageName 图片文件名称(带后缀)
     * @return 头像的URL
     */
    public static String getPicUrl(String uuid, String imageName){
        if (TextUtils.isEmpty(uuid)){
            return ERROR_URL;
        }

        String dirName;
        if (uuid.length() == 7){
            dirName = uuid.substring(0, 2);
        } else if (uuid.length() == 8){
            dirName = uuid.substring(0, 3);
        } else {
            dirName = "";
        }

        if (imageName == null){
            imageName = "";
        }
        return QiuShiUrl.PIC_HOST + QiuShiUrl.PIC_PATH + dirName + "/" + uuid + "/medium/" + imageName;
    }
}
