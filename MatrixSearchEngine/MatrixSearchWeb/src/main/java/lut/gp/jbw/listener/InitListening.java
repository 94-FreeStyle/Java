package lut.gp.jbw.listener;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import lut.gp.jbw.model.CacheKey;
import lut.gp.jbw.model.CacheValue;
import lut.gp.jbw.service.ProcessCache;
import org.apache.log4j.Logger;

/**
 *
 * @author vincent May 9, 2017 2:28:38 PM
 */
public class InitListening implements ServletContextListener {

    private static final Logger logger = Logger.getLogger(InitListening.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //相当于为系统初始化一个缓存，更新规则是LRU
        final Map<CacheKey, CacheValue> searchpbPB = new ConcurrentHashMap<>();
        sce.getServletContext().setAttribute("searchPB", searchpbPB);
        ProcessCache.processCache(searchpbPB);
        logger.info("init application and add cache and start scheduling update cache thread!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("application destroyed!");
    }
}
