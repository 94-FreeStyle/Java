package lut.gp.jbw.spider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Set;
import lut.gp.jbw.spider.util.LinkQueue;
import lut.gp.jbw.spider.util.Queue;
import lut.gp.jbw.spider.util.SpiderThreadPool;
import org.apache.log4j.Logger;

/**
 *
 * @author vincent Apr 3, 2017 2:09:51 PM
 */
public class SpiderInit {

    private static final Logger logger = Logger.getLogger(SpiderInit.class);

    public static void init(String savePath, String backupPath) {
        File recoverDir = new File(backupPath);
        if (recoverDir.isDirectory()) {
            File[] ff = recoverDir.listFiles();
            if (ff.length != 0) {
                for (File f : ff) {
                    if (f.getName().equals("visited.dat")) {
                        LinkQueue.visitedUrl = (Set) SpiderBackup.unSerializableFromFile(f);
                    } else {
                    }
                    if (f.getName().startsWith("unvisited_")) {
                        LinkQueue lq = new LinkQueue((Queue) SpiderBackup.unSerializableFromFile(f));
                        SpiderThreadPool.addSpider(new Spider(lq, savePath));
                    }
                }
            } else {
                ClassLoader classLoader = SpiderInit.class.getClassLoader();
                URL resource = classLoader.getResource("seeds_url.txt");
                String seedsFileName = resource.getPath();
                try {
                    BufferedReader readerSeeds = new BufferedReader(new InputStreamReader(new FileInputStream(seedsFileName)));
                    String line;
                    while ((line = readerSeeds.readLine()) != null) {
                        SpiderThreadPool.addSpider(new Spider(line, savePath));
                    }
                } catch (FileNotFoundException ex) {
                    logger.error("", ex);
                } catch (IOException ex) {
                    logger.error("", ex);
                }
            }
        }
    }
}
