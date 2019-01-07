package com.jpjproxy.risk.shuli;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import util.DateUtils;
import util.StringUtils;

import java.util.*;


/**
 * @Author: jingpj
 * @Date：creste in 2018/12/5
 */
//@Component
public class ShuLiRiskApi {
    private static long starttime;
    private static String token;
    static final String url = "https://openapi.shulidata.com";
//    static final String url = "https://bds-openapi.shulidata.com";
    public static String getAccessToken() throws Exception {
        final String URI = url + "/auth/token";
        final String ACCESS_ID = "BD20170920094605";
        final String ACCESS_KEY = "5ZtqEU5ryCickuLRQwE5sHnuvQnx879hKLLY1c4Ejg4s";
//        final String ACCESS_KEY = "F9BWenR8QdPU6qy1nUCS1rC6ksHximPBQyXxWbmx6XQC";

        Map<String, String> postParameters = new HashMap<>();
        postParameters.put("accessId", ACCESS_ID);
        postParameters.put("grantType","client");
        postParameters.put("timestamp", String.valueOf(System.currentTimeMillis()));
        // 获取签名文本
        String content = ShuliUtil.SignContent(postParameters);
        // 签名
        postParameters.put("sign", ShuliUtil.HMACSHA256(content,ACCESS_KEY));

        System.out.println("请求参数:" + JSONObject.toJSONString(postParameters));

        String rs = ShuliHttpUtil.httpPost(URI, ShuliUtil.getRequestContent(postParameters));

        System.out.println("oauth授权结果：" + rs);
        return rs;
    }
    public static String getAccessTokenByCache() throws Exception {
        Long now = System.currentTimeMillis();
        if(StringUtils.isBlank(token)){
            starttime = now;
            String rs = getAccessToken();
            JSONObject object = JSON.parseObject(rs);
            token = object.getJSONObject("bizContent").getString("accessToken");
        }
        if (now - starttime >= 7200000) {
            token = null;
            return getAccessTokenByCache();
        }
        return token;
    }

    public static String getRisk(String body) throws Exception {
        String token = getAccessTokenByCache();
        final String URI = url + "/report/v1/dp_operator";

//        System.out.println("请求参数:" + body);

        Header header = new BasicHeader("Authorization", "Bearer " +token);
        String rs = ShuliHttpUtil.httpPost(URI, body, header);
//        System.out.println("oauth授权结果：" + rs);
        return rs;
    }

    public static void main(String[] args) {
        try {
            getAccessToken();
//            String body = "{\n" +
//                    "  \"orgBizNo\" : \"1231231235\",\n" +
//                    "  \"sceneId\" : \"BIZ_TYPE\",\n" +
//                    "  \"params\" : {\n" +
//                    "         \"phoneNo\" : \"18458131697\",\n" +
//                    "         \"name\" : \"荆朋举\",\n" +
//                    "         \"idCard\" : \"412827199308063095\",\n" +
//                    "         \"backDate\" : \"2018-12-01 12:00:00\"\n" +
//                    "  }\n" +
//                    "}";
//            getRisk(body);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
