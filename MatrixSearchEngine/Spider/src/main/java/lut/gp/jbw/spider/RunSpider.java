package lut.gp.jbw.spider;

import java.util.List;
import lut.gp.jbw.spider.util.SpiderThreadPool;
import org.apache.log4j.Logger;

/**
 *
 * @author vincent Apr 9, 2017 2:12:30 PM
 */
public class RunSpider {

    private static final Logger logger = Logger.getLogger(Spider.class);

    public static void main(String[] args) {
        //设置爬取文件的存储路径和备份URL的路径
        String savePath = "F:/documents/College/gd/data/spider/page/";
        String backupPath = "F:/documents/College/gd/data/spider/backup/";
        //初始化爬虫线程
        SpiderInit.init(savePath, backupPath);
        //启动定时备份任务
        SpiderBackup.backup(backupPath);
        //启动定时检查线程状态并重启失败线程任务
        SpiderFailover.failover(backupPath, savePath);
        //启动爬虫所有线程
        List<Spider> spiders = SpiderThreadPool.getSpiders();
        spiders.forEach((s) -> {
            s.start();
        });
        spiders.forEach((s) -> {
            try {
                s.join();
            } catch (InterruptedException ex) {
                logger.error("", ex);
            }
        });
    }
}
