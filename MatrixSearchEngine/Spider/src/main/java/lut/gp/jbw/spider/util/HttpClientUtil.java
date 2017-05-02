package lut.gp.jbw.spider.util;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.List;
import javax.net.ssl.SSLException;
import lut.gp.jbw.spider.Spider;
import lut.gp.jbw.spider.pojo.ResponseCT;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author vincent Apr 3, 2017 12:17:02 PM
 */
public class HttpClientUtil {

    private static final Logger logger = Logger.getLogger(HttpClientUtil.class);
    private static PoolingHttpClientConnectionManager cm;
    private static final String UTF_8 = "UTF-8";
    private static final LaxRedirectStrategy redirectStrategy = new LaxRedirectStrategy();
    private static final HttpRequestRetryHandler myRetryHandler = (IOException exception, int executionCount, HttpContext context) -> {
        if (executionCount >= 5) {
            return false;
        }
        if (exception instanceof InterruptedIOException) {
            return false;
        }
        if (exception instanceof UnknownHostException) {
            return false;
        }
        if (exception instanceof ConnectTimeoutException) {
            return false;
        }
        if (exception instanceof SSLException) {
            return false;
        }
        HttpClientContext clientContext = HttpClientContext.adapt(context);
        HttpRequest request = clientContext.getRequest();
        boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
        if (idempotent) {
            return true;
        }
        return false;
    };

    private static void init() {
        if (cm == null) {
            cm = new PoolingHttpClientConnectionManager();
            cm.setMaxTotal(100);// 整个连接池最大连接数  
            cm.setDefaultMaxPerRoute(10);// 每路由最大连接数，默认值是2  
        }
    }

    /**
     * 通过连接池获取HttpClient
     *
     * @return
     */
    private static CloseableHttpClient getHttpClient() {
        init();
        CloseableHttpClient chc = HttpClients.custom()
                .setRetryHandler(myRetryHandler)
                .setRedirectStrategy(redirectStrategy)
                .setConnectionManager(cm)
                .build();
        logger.info("get one httpclient:" + cm.getTotalStats());
        return chc;
    }

    private static HttpRequestBase requestConfig(HttpRequestBase request) {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(100000)
                .setRedirectsEnabled(false)
                .setSocketTimeout(600000)
                .setConnectTimeout(100000)
                .setCircularRedirectsAllowed(false)
                .build();
        String userAgent = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; QQDownload 1.7; .NET CLR 1.1.4322; CIBA; .NET CLR 2.0.50727)";
        request.setHeader("User-Agent", userAgent);
        request.setConfig(requestConfig);
        return request;
    }

    /**
     *
     * @param url
     * @return
     */
    public static ResponseCT httpGetRequest(String url) {
        HttpGet httpGet = (HttpGet) requestConfig(new HttpGet(url));
        return getResult(httpGet);
    }

    /**
     * 处理Http请求
     *
     * @param request
     * @return
     */
    private static ResponseCT getResult(HttpRequestBase request) {
        CloseableHttpClient httpClient = getHttpClient();
        ResponseCT result = new ResponseCT();
        try {
            HttpClientContext context = HttpClientContext.create();
            CloseableHttpResponse response = httpClient.execute(request, context);
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {       //正常返回处理
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    // long len = entity.getContentLength();// -1 表示长度未知  
                    result.setCon(EntityUtils.toByteArray(entity));
                    result.setType(entity.getContentType().getValue());
                }
                response.close();
            } else if (status >= 300 && status < 400) {    //重定向处理
                HttpHost target = context.getTargetHost();
                List<URI> redirectLocations = context.getRedirectLocations();
                URI location = URIUtils.resolve(request.getURI(), target, redirectLocations);
                String url = location.toASCIIString();
                //把新的URL加入到visit队列中
                if (RegExpValidatorUtils.IsUrl(location.toASCIIString())) {
                    Spider cs = (Spider) Thread.currentThread();
                    cs.getLq().addUnvisitedUrl(url);
                    logger.info("Add Redirect Locations '" + url + "' to " + cs.getName() + " status code is " + status);
                }
                response.close();
                result = null;
            } else {
                logger.error("error:status code more than 400! is " + status);
                response.close();
                result = null;
            }
        } catch (ClientProtocolException e) {
            logger.error("", e);
        } catch (IOException | URISyntaxException e) {
            logger.error("", e);
        } finally {
            request.abort();
        }
        return result;
    }
}
