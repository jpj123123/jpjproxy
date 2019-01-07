package util;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by 姚磊 on 2017/11/13.
 */
public class RobotNoticeUtils {

  public static void sendNotice(String url, String content) {
    JSONObject jsonObject = new JSONObject();
    JSONObject text = new JSONObject();

    text.put("content", DateUtils.getNow()+"\n"+content);
    jsonObject.put("msgtype", "text");

    jsonObject.put("text", text);
    jsonObject.put("isAtAll", true);
    HttpClient4Utils.httpPost(url, jsonObject.toJSONString());

  }

}
