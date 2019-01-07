package com.jpjproxy.risk.shuli;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @Author: jingpj
 * @Date：creste in 2018/12/5
 */
public class ShuliUtil {
    public static String SignContent(Map<String, String> sortedParams) {
        StringBuilder content = new StringBuilder();
        List<String> keys = new ArrayList(sortedParams.keySet());
        Collections.sort(keys);

        for(int i = 0; i < keys.size(); ++i) {
            String key = keys.get(i);
            String value = sortedParams.get(key);
            if (!"sign".equals(key) && !StringUtils.isAnyBlank(key,value)) {
                content.append(i == 0 ? "" : "&").append(key).append("=").append(value);
            }
        }

        return content.toString();
    }

    public static String getRequestContent(Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder content = new StringBuilder();
//        List<String> keys = new ArrayList(params.keySet());
//        Collections.sort(keys);
        Set<Map.Entry<String,String>> set = params.entrySet();
        Iterator<Map.Entry<String,String>> iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> entry = iterator.next();
            String key = entry.getKey();
            String value = entry.getValue();
            if (!StringUtils.isAnyBlank(key,value)) {
                content.append(key).append("=").append(URLEncoder.encode(value,"UTF-8")).append(iterator.hasNext() ? "&" : "");
            }
        }
        return content.toString();
    }

    public static String HMACSHA256(String content, String key) {
        try  {
            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);
            byte[] bytes = content.getBytes("UTF-8");
            return Base64.getEncoder().encodeToString(mac.doFinal(bytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
