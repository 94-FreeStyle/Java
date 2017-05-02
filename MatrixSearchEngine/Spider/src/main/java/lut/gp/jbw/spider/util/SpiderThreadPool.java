package lut.gp.jbw.spider.util;

import java.util.List;
import java.util.Vector;
import lut.gp.jbw.spider.Spider;

/**
 *
 * @author vincent Apr 4, 2017 9:43:46 PM
 */
public class SpiderThreadPool {

    private static List<Spider> spiders = new Vector<>();

    public static List<Spider> getSpiders() {
        return spiders;
    }

    public static void addSpider(Spider s) {
        spiders.add(s);
    }
}
