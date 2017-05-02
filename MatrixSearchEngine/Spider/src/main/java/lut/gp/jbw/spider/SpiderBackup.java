package lut.gp.jbw.spider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lut.gp.jbw.spider.util.LinkQueue;
import lut.gp.jbw.spider.util.SpiderThreadPool;
import org.apache.log4j.Logger;

/**
 *
 * @author vincent Apr 4, 2017 9:58:46 PM
 */
public class SpiderBackup {

    private static final Logger logger = Logger.getLogger(SpiderInit.class);

    public static void backup(String backupPath) {
        Runnable backup = new Runnable() {
            public void run() {
                List<Spider> spiders = SpiderThreadPool.getSpiders();
                spiders.forEach(s -> {
                    serializableToFile(backupPath + "unvisited_" + s.getName() + ".dat", s.getLq().getUnVisitedUrl());
                    logger.info("backup:" + s.getName() + ":" + s.getLq().getUnVisitedUrlNum());
                });
                serializableToFile(backupPath + "visited.dat", LinkQueue.visitedUrl);
                logger.info("backup:VisitedUrlNum:" + LinkQueue.getVisitedUrlNum());
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间  
        service.scheduleAtFixedRate(backup, 1, 1, TimeUnit.MINUTES);
    }

    private static void serializableToFile(String path, Object obj) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            file.createNewFile();
            oos.writeObject(obj);
            oos.flush();
            oos.close();
            fos.close();
        } catch (IOException e) {
            logger.error("", e);
        }
    }

    public static Object unSerializableFromFile(File path) {
        FileInputStream fis = null;
        Object obj = null;
        try {
            fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj = ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            logger.error("", ex);
        } catch (IOException | ClassNotFoundException ex) {
            logger.error("", ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                logger.error("", ex);
            }
        }
        return obj;
    }
}
