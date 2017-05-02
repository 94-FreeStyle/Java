package lut.gp.jbw.spider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import lut.gp.jbw.spider.util.LinkQueue;
import lut.gp.jbw.spider.util.Queue;
import lut.gp.jbw.spider.util.SpiderThreadPool;

/**
 *
 * @author vincent Apr 8, 2017 2:07:39 PM
 */
public class SpiderFailover {

    public static void failover(String backupPath, String savePath) {
        Runnable failover = () -> {
            try {
                PrintStream ps = new PrintStream(new File(backupPath + "stat.txt"));
                List<Spider> spiders = new Vector<>();
                //判断得到需要恢复的Spider
                SpiderThreadPool.getSpiders().stream().forEach((s) -> {
                    if (s.getState().toString().equals("TERMINATED")) {
                        String threadName = s.getName();
                        String threadFilePath = backupPath + "unvisited_" + threadName + ".dat";
                        LinkQueue lq = new LinkQueue((Queue) SpiderBackup.unSerializableFromFile(new File(threadFilePath)));
                        Spider spider = new Spider(lq, savePath);
                        spider.setName(threadName);
                        spiders.add(spider);
                    }
                });
                //删除已经死掉的Spider
                Iterator<Spider> it = SpiderThreadPool.getSpiders().iterator();
                while (it.hasNext()) {
                    Spider s = it.next();
                    if (s.getState().toString().equals("TERMINATED")) {
                        it.remove();
                    }
                }
                //启动并添加需要恢复的Spider
                spiders.stream().map((s) -> {
                    s.start();
                    return s;
                }).forEachOrdered((s) -> {
                    SpiderThreadPool.addSpider(s);
                });
                //输出状态
                SpiderThreadPool.getSpiders().forEach(s -> ps.println(s.getName() + ":" + s.getState()));
                ps.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SpiderFailover.class.getName()).log(Level.SEVERE, null, ex);
            }
        };

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        service.scheduleAtFixedRate(failover, 2, 2, TimeUnit.MINUTES);
    }
}
