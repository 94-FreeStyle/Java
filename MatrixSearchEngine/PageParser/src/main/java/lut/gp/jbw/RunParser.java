package lut.gp.jbw;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import lut.gp.jbw.dao.StoreToMysql;
import lut.gp.jbw.index.InvertedIndex;
import lut.gp.jbw.pagerank.PageRank;
import lut.gp.jbw.parsepage.HtmlFileParser;
import lut.gp.jbw.parsepage.pojo.ParsedFileEntity;
import lut.gp.jbw.tfidf.TFIDF;

/**
 *
 * @author vincent Apr 29, 2017 3:28:24 PM
 */
public class RunParser {

    public static void main(String[] args) {
        //保存计算pagerank的数据（url,links）
        Map<String, Set<String>> pageRankData = new ConcurrentHashMap<>();
        //保存计算TF-IDF值得数据（url,(word，count)），也利用这个计算倒排索引
        Map<String, Map<String, Integer>> tfidfData = new HashMap<>();

        String fileDir = "F:\\documents\\College\\gd\\data\\spider";
        File dir = new File(fileDir);
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.getName().endsWith(".html") || file.getName().endsWith(".htm")) {
                    //解析每一个文件
                    ParsedFileEntity entity = new HtmlFileParser(file).parseHtml();
                    pageRankData.put(entity.getUrl(), entity.getLinks());
                    tfidfData.put(entity.getUrl(), entity.getWc());
                    //文件内容入库
                    StoreToMysql.storePageCon(entity);
                }
            }
            //调用计算InvertedIndex(word, urls)
            Map<String, Set<String>> index = InvertedIndex.index(tfidfData);
            //调用计算PageRank(url, rank),计算时去除key中不存在的url
            pageRankData.keySet().forEach((url) -> {
                Iterator<String> it = pageRankData.get(url).iterator();
                while (it.hasNext()) {
                    String link = it.next();
                    if (!pageRankData.keySet().contains(link)) {
                        it.remove();
                    }
                }
            });
            Map<String, Double> ranks = PageRank.pageRank(pageRankData);
            //调用计算TF-IDF(url,(word, value))
            Map<String, Map<String, Double>> tfidfs = TFIDF.tfidf(tfidfData);
            //统一入库（因为有外键约束，所以入库注意先后）
            //倒排索引入库
            index.keySet().forEach((word) -> {
                Set<String> urls = index.get(word);
                urls.forEach((url) -> {
                    StoreToMysql.storeInvertedIndex(word, url);
                });
            });
            //添加PageRank
            ranks.keySet().forEach((url) -> {
                double rank = ranks.get(url);
                StoreToMysql.storePageRank(rank, url);
            });
            //添加TF-IDF
            tfidfs.keySet().forEach((url) -> {
                Map<String, Double> wt = tfidfs.get(url);
                wt.keySet().forEach((word) -> {
                    StoreToMysql.storeTFIDF(wt.get(word), word, url);
                });
            });
        }
    }
}
