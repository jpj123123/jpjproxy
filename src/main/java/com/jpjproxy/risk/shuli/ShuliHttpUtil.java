package com.jpjproxy.risk.shuli;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.MediaType;

import java.net.URLDecoder;

/**
 * @Author: jingpj
 * @Date：creste in 2018/12/5
 */
@Slf4j
public class ShuliHttpUtil {
    public static String httpPost(String url, String jsonStr){
        String str = "";
        try{

            HttpClient client = HttpClients.createDefault();
            HttpPost method = new HttpPost(url);
            method.addHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
            method.addHeader("Accept", MediaType.APPLICATION_JSON.toString());
            if (null != jsonStr) {
                //解决中文乱码问题
                StringEntity entity = new StringEntity(jsonStr.toString(), "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                method.setEntity(entity);
            }
            HttpResponse result = client.execute(method);
            /**请求发送成功，并得到响应**/

            if (result.getStatusLine().getStatusCode() == 200) {
                try {
                    /**读取服务器返回过来的json字符串数据**/
                    str = EntityUtils.toString(result.getEntity());
                } catch (Exception e) {
                    log.error("post请求提交失败:" + url, e);
                }
            }
        } catch (Exception e) {
             log.error("post请求提交失败:" + url, e);
        }
        return str;
    }

    public static String httpPost(String url, String jsonStr, Header header){
        //post请求返回结果
        String str = "";

        try {
            HttpClient httpClient = HttpClients.createDefault();
            JSONObject jsonResult = null;
            HttpPost method = new HttpPost(url);
            if (null != jsonStr) {
                //解决中文乱码问题
                StringEntity entity = new StringEntity(jsonStr.toString(), "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                method.setEntity(entity);
            }
            method.addHeader("Accept","application/json");
            method.addHeader("Content-Type","application/json;charset=UTF-8");
            method.addHeader(header);

            HttpResponse result = httpClient.execute(method);
            url = URLDecoder.decode(url, "UTF-8");
            /**请求发送成功，并得到响应**/

            if (result.getStatusLine().getStatusCode() == 200) {
                try {
                    /**读取服务器返回过来的json字符串数据**/
                    str = EntityUtils.toString(result.getEntity());
                } catch (Exception e) {
                    //log.error("post请求提交失败:" + url, e);
                }
            }
        } catch (Exception e) {
            // log.error("post请求提交失败:" + url, e);
        }
        return str;
    }
}
