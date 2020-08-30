package httpClient;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.URI;

public class HttpClientTest {
    //下面的内容发出了一个Http的Get请求，返回的response是一个json。
    @Test
    public void doGetTestOne() throws Exception {
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("127.0.0.1")
                .setPort(8077)
                .setPath("/platform-manager/config/shortcut/list")
                .setParameter("token","9c39e388fcc082a8098459d363968586")
                .build();
        // 创建Get请求
       // HttpGet httpGet = new HttpGet("http://localhost:8077/platform-manager/config/shortcut/list");
        HttpGet httpGet = new HttpGet(uri);
        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void responseTest() {


    }
}
