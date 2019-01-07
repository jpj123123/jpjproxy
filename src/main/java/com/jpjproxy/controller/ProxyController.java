package com.jpjproxy.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import util.HttpClient4Utils;
import util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: jingpj
 * @Date：creste in 2018/7/10
 */
@Slf4j
@Controller
public class ProxyController {
//    private String postJsonBodyStr;
//    //private JSONObject postJsonBody;
//    private Map<String, String> postUrlMap;
    @RequestMapping("/")
    @ResponseBody
    public Object proxy(HttpServletRequest request){
//        Map<String,String> params = new HashMap<String,String>();
//        Map requestParams = request.getParameterMap();
//        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
//            String name = (String) iter.next();
//            String[] values = (String[]) requestParams.get(name);
//            String valueStr = "";
//            for (int i = 0; i < values.length; i++) {
//                valueStr = (i == values.length - 1) ? valueStr + values[i]
//                        : valueStr + values[i] + ",";
//            }
//            //乱码解决，这段代码在出现乱码时使用。
//            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
//            params.put(name, valueStr);
//        }
//        log.info("请求数据：{}", params);
//        log.info(request.getParameter("name"));
        String postJsonBodyStr = "";
        try {
            postJsonBodyStr = IOUtils.toString(request.getInputStream(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info(postJsonBodyStr);
        Map<String, String> postUrlMap = handlerPostUrlParameter(request.getQueryString());

        String Url = postUrlMap.get("_URL");
        System.out.println(request.getMethod());

        StringBuffer buffer = new StringBuffer();
        for (Map.Entry<String,String> entry : postUrlMap.entrySet()){
            if(!entry.getKey().equals("_URL")){
                try {
                    buffer.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), "UTF8")).append("&");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        String requrl = buffer.toString();
        if(StringUtils.isNotBlank(requrl)){
            Url = Url + "?" + requrl.substring(0, requrl.length()-1);
        }
        String res;
        if(StringUtils.equalsIgnoreCase("post", request.getMethod())) {
            res = HttpClient4Utils.httpPost(Url, postJsonBodyStr);
        }else{
            res = HttpClient4Utils.httpGet(Url);
        }
        return res;
    }


    @RequestMapping("/testform")
    @ResponseBody
    public void testform(HttpServletRequest request){
        log.info("请求数据：{}", request.getParameterMap());
        Map<String,String[]> reqs = request.getParameterMap();

        try {
            log.info("请求体：{}",  IOUtils.toString(request.getInputStream(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    /**
//     * 将request中inputStream 解析为JSONObject
//     */
//    private void parse(HttpServletRequest request) {
//
//        try {
//            postJsonBodyStr = IOUtils.toString(request.getInputStream(), "UTF-8");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        this.postUrlMap = handlerPostUrlParameter(request.getQueryString());
//
//
//
//    }
    /**
     * 处理post url参数
     */
    private HashMap<String, String> handlerPostUrlParameter(String queryString) {

        /**
         * 没必要使用线程安全的办法 比如synchronized 或者 concurrenthashmap
         * context使用ThreadLocal 只是当前线程在使用 顺序执行
         */
        HashMap<String, String> map = new HashMap<String, String>();
        String splitStr = null;
        String key = null;
        String value = null;
        int i = 0;
        int j = 0;
        while (true) {
            i = queryString.indexOf("&");
            if (i < 0) {
                j = queryString.indexOf("=");
                map.put(queryString.substring(0, j), queryString.substring(j + 1));
                break;
            }
            splitStr = queryString.substring(0, i);
            j = splitStr.indexOf("=");
            map.put(splitStr.substring(0, j), splitStr.substring(j + 1));
            queryString = queryString.substring(i + 1);
        }
        return map;
    }
}
