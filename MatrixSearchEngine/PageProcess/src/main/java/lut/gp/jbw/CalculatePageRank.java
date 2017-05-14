package lut.gp.jbw;

import java.util.Map;
import java.util.Set;
import lut.gp.jbw.dao.SearchFromMysql;
import lut.gp.jbw.dao.StoreToMysql;
import lut.gp.jbw.pagerank.PageRank;
import org.apache.log4j.Logger;

/**
 *
 * @author vincent May 6, 2017 10:27:27 PM
 */
public class CalculatePageRank {

    private static final Logger logger = Logger.getLogger(CalculatePageRank.class);

    public static void calculate() {
        //保存计算pagerank的数据（url,links）
        Map<String, Set<String>> pageRankData = SearchFromMysql.serachLinks();
        logger.info("preprocess data finshed! start calculate...");
        logger.info("origin data size:" + pageRankData.size());
        Map<String, Double> ranks = PageRank.pageRank(pageRankData);
        //更新PageRank
        ranks.keySet().forEach((url) -> {
            double rank = ranks.get(url);
            StoreToMysql.storePageRank(rank, url);
            logger.info("update " + url + ": pagerank = " + rank);
        });
        logger.info("Calculate PageRank:link size--" + pageRankData.size());
    }

    public static void main(String[] args) {
        calculate();
    }
}
