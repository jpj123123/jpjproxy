package com.jpjproxy.paixu.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.GZIPOutputStream;

/**
 * httpclient jar的进一步封装
 */
public class HttpClientUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    /**
     * 直接返回字符串
     *
     * @param url
     * @param timeOutSecond
     * @return
     */
    public static String doGetRequest(String url, int timeOutSecond) {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        //请求超时配置
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(timeOutSecond * 1000).setSocketTimeout(timeOutSecond * 1000).build();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);
        String result = null;
        try {
            result = EntityUtils.toString(closeableHttpClient.execute(httpGet).getEntity(), "UTF-8");
        } catch (IOException e) {
            logger.error("get请求错误" + e.getMessage());
        } finally {
            HttpClientUtils.closeQuietly(closeableHttpClient);
        }
        return result;
    }

    public static String gzipDoPost(String url, String message) throws IOException {
        String resStr = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost =
                new HttpPost(url);
        httpPost.setHeader("Content-Encoding",
                "gzip");
        try {
            ByteArrayOutputStream
                    originalContent = new ByteArrayOutputStream();
            originalContent.write(message.getBytes(Charset.forName("UTF-8")));
            ByteArrayOutputStream
                    baos = new ByteArrayOutputStream();
            GZIPOutputStream
                    gzipOut = new GZIPOutputStream(baos);
            originalContent.writeTo(gzipOut);
            gzipOut.finish();
            httpPost.setEntity(new ByteArrayEntity(baos.toByteArray()));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        HttpResponse httpResponse = httpClient.execute(httpPost);
        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            resStr = EntityUtils.toString(httpResponse.getEntity());
        }
        return resStr;
    }
}
