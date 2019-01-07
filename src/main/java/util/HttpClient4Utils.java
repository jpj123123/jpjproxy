package util;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * Created by weh on 2017/7/3.
 */
//@Slf4j
public class HttpClient4Utils {

  /**
   * httpPost
   * @param url  路径
   * @param jsonStr 参数
   * @return
   */
  public static String httpPost(String url,String jsonStr){
    return httpPost(url, jsonStr, false ,0);
  }
  /**
   * httpPost
   * @param url  路径
   * @param jsonStr 参数
   * @return
   */
  public static String httpPost(String url,String jsonStr,int timeOut){
    return httpPost(url, jsonStr, false, timeOut);
  }
  /**
   * post请求
   * @param url         url地址
   * @param jsonStr     参数
   * @param noNeedResponse    不需要返回结果
   * @return
   */
  public static String httpPost(String url,String jsonStr, boolean noNeedResponse,int timeOut){
    //post请求返回结果
    String str = "";

    try {
    SSLContext sslcontext = createIgnoreVerifySSL();

    // 设置协议http和https对应的处理socket链接工厂的对象
    Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
        .register("http", PlainConnectionSocketFactory.INSTANCE)
        .register("https", new SSLConnectionSocketFactory(sslcontext))
        .build();
    PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
    HttpClients.custom().setConnectionManager(connManager);

    //创建自定义的httpclient对象
    CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connManager).build();
//      CloseableHttpClient client = HttpClients.createDefault();
//    DefaultHttpClient httpClient = new DefaultHttpClient();
    JSONObject jsonResult = null;
    HttpPost method = new HttpPost(url);
    if(timeOut > 0){
      RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeOut).setConnectTimeout(timeOut).build();//设置请求和传输超时时间
      method.setConfig(requestConfig);
    }
      if (null != jsonStr) {
        //解决中文乱码问题
        StringEntity entity = new StringEntity(jsonStr.toString(), "utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        method.setEntity(entity);
      }
      method.addHeader("Accept","application/json");
      method.addHeader("Content-Type","application/json;charset=UTF-8");
      HttpResponse result = httpClient.execute(method);
      url = URLDecoder.decode(url, "UTF-8");
      /**请求发送成功，并得到响应**/

      if (result.getStatusLine().getStatusCode() == 200) {
        try {
          /**读取服务器返回过来的json字符串数据**/
          str = EntityUtils.toString(result.getEntity());
          if (noNeedResponse) {
            return null;
          }
        } catch (Exception e) {
          //log.error("post请求提交失败:" + url, e);
        }
      }
    } catch (Exception e) {
     // log.error("post请求提交失败:" + url, e);
    }
    return str;
  }

  /**
   * post请求
   * @param url         url地址
   * @return
   */
  public static String httpGet(String url){
    //post请求返回结果
    String str = "";

    try {
      SSLContext sslcontext = createIgnoreVerifySSL();

      // 设置协议http和https对应的处理socket链接工厂的对象
      Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
              .register("http", PlainConnectionSocketFactory.INSTANCE)
              .register("https", new SSLConnectionSocketFactory(sslcontext))
              .build();
      PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
      HttpClients.custom().setConnectionManager(connManager);

      //创建自定义的httpclient对象
      CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connManager).build();
//      CloseableHttpClient client = HttpClients.createDefault();
//    DefaultHttpClient httpClient = new DefaultHttpClient();
      JSONObject jsonResult = null;
      HttpUriRequest request = new HttpGet(url);
      HttpResponse result = httpClient.execute(request);
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
  public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
    SSLContext sc = SSLContext.getInstance("SSLv3");

    // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
    X509TrustManager trustManager = new X509TrustManager() {
      @Override
      public void checkClientTrusted(
          java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
          String paramString) throws CertificateException {
      }

      @Override
      public void checkServerTrusted(
          java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
          String paramString) throws CertificateException {
      }

      @Override
      public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        return null;
      }
    };

    sc.init(null, new TrustManager[] { trustManager }, null);
    return sc;
  }

  /**
   * 获取Ip地址
   * @param request
   * @return
   */
  public static String getIpAdrress(HttpServletRequest request) {
    String Xip = request.getHeader("X-Real-IP");
    String XFor = request.getHeader("X-Forwarded-For");
    if(StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
      //多次反向代理后会有多个ip值，第一个ip才是真实ip
      int index = XFor.indexOf(",");
      if(index != -1){
        return XFor.substring(0,index);
      }else{
        return XFor;
      }
    }
    XFor = Xip;
    if(StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
      return XFor;
    }
    if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
      XFor = request.getHeader("Proxy-Client-IP");
    }
    if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
      XFor = request.getHeader("WL-Proxy-Client-IP");
    }
    if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
      XFor = request.getHeader("HTTP_CLIENT_IP");
    }
    if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
      XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
    }
    if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
      XFor = request.getRemoteAddr();
    }
    return XFor;
  }

}
