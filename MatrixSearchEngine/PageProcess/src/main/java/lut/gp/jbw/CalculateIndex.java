package lut.gp.jbw;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lut.gp.jbw.dao.SearchFromMysql;
import lut.gp.jbw.dao.StoreToMysql;
import lut.gp.jbw.utils.WordSegmenterUtil;
import org.apache.log4j.Logger;
import org.apdplat.word.segmentation.Word;

/**
 *
 * @author vincent May 6, 2017 10:43:36 PM
 */
public class CalculateIndex {

    private static final Logger logger = Logger.getLogger(CalculateIndex.class);
    private static Timestamp lastProcessTime = new Timestamp(117, 5, 1, 13, 35, 0, 0);

    //每一个小时更新一次索引
    public static void calculate() {
        logger.info("update index");
        Map<String, String> data = SearchFromMysql.serachUC(lastProcessTime);
        lastProcessTime = SearchFromMysql.serachLastUpdateTime(lastProcessTime);
        data.keySet().forEach((url) -> {
            List<Word> words = WordSegmenterUtil.segmenter(data.get(url));
            Set<String> res = new HashSet<>();
            words.forEach((word) -> {
                res.add(word.getText());
            });
            res.forEach((word) -> {
                StoreToMysql.storeInvertedIndex(word, url);
                logger.info("update index:" + word + "->" + url);
            });
        });
    }

    public static void main(String[] args) {
        calculate();
    }
}
