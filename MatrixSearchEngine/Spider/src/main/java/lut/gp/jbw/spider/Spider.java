package lut.gp.jbw.spider;

import lut.gp.jbw.spider.util.LinkFilter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;
import lut.gp.jbw.spider.pojo.ResponseCT;
import lut.gp.jbw.spider.util.DownLoadFile;
import lut.gp.jbw.spider.util.ExtractLinksFromHtml;
import lut.gp.jbw.spider.util.LinkQueue;
import org.apache.log4j.Logger;
import org.htmlparser.util.ParserException;

/**
 *
 * @author vincent Apr 2, 2017 2:08:29 PM
 */
public class Spider extends Thread {

    private static final Logger logger = Logger.getLogger(Spider.class);
    private LinkQueue lq = new LinkQueue();
    private String saveLocalPath = null;

    public Spider(String seed, String saveLocalPath) {
        this.saveLocalPath = saveLocalPath;
        lq.addUnvisitedUrl(seed);
    }

    public Spider(LinkQueue lq, String saveLocalPath) {
        this.saveLocalPath = saveLocalPath;
        this.lq = lq;
    }

    public LinkQueue getLq() {
        return lq;
    }

    /**
     * 抓取过程,每5min会把当前线程的待爬取队列写入磁盘
     */
    @Override
    public void run() {
        //定义过滤器
        LinkFilter filter = (String url) -> url.startsWith("");
        //循环条件：待抓取的链接不空
        while (!lq.unVisitedUrlsEmpty()) {
            //队头URL出队列
            String visitUrl = (String) lq.unVisitedUrlDeQueue();
            logger.info(Thread.currentThread().getName() + "#visiting:" + visitUrl + "$unn:" + lq.getUnVisitedUrlNum() + "%vin:" + LinkQueue.getVisitedUrlNum());
            DownLoadFile downLoader = new DownLoadFile();
            try {
                //下载网页
                ResponseCT res = downLoader.downloadFile(visitUrl, this.saveLocalPath);
                //该 URL 放入已访问的 URL 中
                LinkQueue.addVisitedUrl(visitUrl);
                //提取出下载的内容为html网页中的 URL
                if (res != null && res.getType().contains("html")) {
                    String con = new String(res.getCon(), "utf-8");
                    Set<String> links = ExtractLinksFromHtml.extracLinks(con, filter);
                    //新的未访问的 URL 入队
                    links.forEach((link) -> {
                        lq.addUnvisitedUrl(link);
                    });
                }
            } catch (IOException | URISyntaxException | ParserException ex) {
                logger.error("", ex);
            }
        }
    }
}
