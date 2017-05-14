package lut.gp.jbw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lut.gp.jbw.dao.SearchFromMysql;
import lut.gp.jbw.dao.StoreToMysql;
import lut.gp.jbw.tfidf.TFIDF;
import lut.gp.jbw.utils.WordSegmenterUtil;
import org.apache.log4j.Logger;
import org.apdplat.word.segmentation.Word;

/**
 *
 * @author vincent May 6, 2017 10:45:17 PM
 */
public class CalculateTFIDF {

    private static final Logger logger = Logger.getLogger(CalculateTFIDF.class);

    public static void calculate() {
        Map<String, Map<String, Integer>> tfidfData = new HashMap<>();
        Map<String, String> data = SearchFromMysql.serachUC();
        data.keySet().forEach((url) -> {
            List<Word> words = WordSegmenterUtil.segmenter(data.get(url));
            tfidfData.put(url, WordSegmenterUtil.wordCountToMap(words));
        });
        logger.info("preprocess data finshed! start calculate...");
        //调用计算TF-IDF(url,(word, value))
        Map<String, Map<String, Double>> tfidfs = TFIDF.tfidf(tfidfData);
        //更新TF-IDF
        tfidfs.keySet().forEach((url) -> {
            Map<String, Double> wt = tfidfs.get(url);
            wt.keySet().forEach((word) -> {
                double value = wt.get(word);
                StoreToMysql.storeTFIDF(value, word, url);
                logger.info(word + ":" + url + ":" + value);
            });
        });
    }

    public static void main(String[] args) {
        calculate();
    }
}
