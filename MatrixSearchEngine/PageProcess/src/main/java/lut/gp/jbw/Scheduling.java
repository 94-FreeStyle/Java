package lut.gp.jbw;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

/**
 *
 * @author vincent May 7, 2017 2:00:31 PM
 */
public class Scheduling {

    private static final Logger logger = Logger.getLogger(Scheduling.class);

    public static void main(String[] args) {
        //一周计算更新一次PageRank 
        Runnable pagerank = () -> {
            CalculatePageRank.calculate();
        };
        ScheduledExecutorService PRService = Executors.newSingleThreadScheduledExecutor();
        PRService.scheduleAtFixedRate(pagerank, 0, 7, TimeUnit.DAYS);

        //一天计算更新一次TF-IDF
        Runnable tfidf = () -> {
            CalculateTFIDF.calculate();
        };
        ScheduledExecutorService TIService = Executors.newSingleThreadScheduledExecutor();
        TIService.scheduleAtFixedRate(tfidf, 0, 1, TimeUnit.DAYS);

        //一小时更新一次索引
        Runnable index = () -> {
            CalculateIndex.calculate();
        };
        ScheduledExecutorService IndexService = Executors.newSingleThreadScheduledExecutor();
        IndexService.scheduleAtFixedRate(index, 0, 1, TimeUnit.HOURS);

        //半小时处理一次爬取到本地的数据解析入库
        Runnable parser = () -> {
            ParseAndStoreToDB.store();
        };
        ScheduledExecutorService ParserService = Executors.newSingleThreadScheduledExecutor();
        ParserService.scheduleAtFixedRate(parser, 0, 30, TimeUnit.MINUTES);
    }
}
