package lut.gp.jbw.spider.util;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author vincent Apr 2, 2017 2:16:15 PM
 */
public class LinkQueue {

    //已访问的 url 集合,线程安全的
    public static Set visitedUrl = ConcurrentHashMap.<String>newKeySet();
    //待访问的 url 集合
    private Queue unVisitedUrl;

    public LinkQueue() {
        unVisitedUrl = new Queue();
    }

    public LinkQueue(Queue unVisitedUrl) {
        this.unVisitedUrl = unVisitedUrl;
    }

    //获得URL队列
    public Queue getUnVisitedUrl() {
        return unVisitedUrl;
    }

    //添加到访问过的URL队列中
    public static void addVisitedUrl(String url) {
        visitedUrl.add(url);
    }

    //移除访问过的URL
    public static void removeVisitedUrl(String url) {
        visitedUrl.remove(url);
    }

    //未访问的URL出队列
    public Object unVisitedUrlDeQueue() {
        return unVisitedUrl.deQueue();
    }

    // 保证每个 URL 只被访问一次
    public void addUnvisitedUrl(String url) {
        if (url != null && !url.trim().equals("")
                && !visitedUrl.contains(url)
                && !unVisitedUrl.contians(url)) {
            unVisitedUrl.enQueue(url);
        }
    }

    //获得已经访问的URL数目
    public static int getVisitedUrlNum() {
        return visitedUrl.size();
    }

    //获得未访问的URL数目
    public int getUnVisitedUrlNum() {
        return unVisitedUrl.size();
    }

    //判断未访问的URL队列中是否为空
    public boolean unVisitedUrlsEmpty() {
        return unVisitedUrl.empty();
    }
}
