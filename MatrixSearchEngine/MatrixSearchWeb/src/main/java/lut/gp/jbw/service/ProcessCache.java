package lut.gp.jbw.service;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lut.gp.jbw.model.CacheKey;
import lut.gp.jbw.model.CacheValue;
import org.apache.log4j.Logger;

/**
 *
 * @author vincent May 9, 2017 4:59:44 PM
 */
public class ProcessCache {

    private static final Logger logger = Logger.getLogger(ProcessCache.class);

    public static void processCache(final Map<CacheKey, CacheValue> searchpbPB) {
        Runnable processCache = new Runnable() {
            @Override
            public void run() {
                long curTime = System.currentTimeMillis();
                logger.info("current cache size is:" + searchpbPB.size());
                for (CacheKey k : searchpbPB.keySet()) {
                    //创建时间大于30min的缓存删除
                    if ((curTime - searchpbPB.get(k).getAddTime()) > (1000 * 60 * 30)) {
                        searchpbPB.remove(k);
                        logger.info("remove cache:" + k.toString());
                    }
                }
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(processCache, 2, 3, TimeUnit.MINUTES);
    }
}
