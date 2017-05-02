package lut.gp.jbw.tfidf;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vincent Apr 29, 2017 4:27:40 PM
 */
public class TFIDF {

    /**
     * 当前文档中当前单词出现总次数/当前文档所有单词总次数 * log(文档总数/包含当前单词的文档总数,10)
     *
     * @param data（url,(word，count)）
     * @return （url,(word,tfidf)）
     */
    public static Map<String, Map<String, Double>> tfidf(Map<String, Map<String, Integer>> data) {
        Map<String, Map<String, Double>> res = new HashMap<>();
        double docNums = data.size();
        data.keySet().forEach((url) -> {
            Map<String, Integer> wc = data.get(url);
            Map<String, Double> rr = new HashMap<>();
            wc.keySet().forEach((word) -> {
                double curWordNums = wc.get(word);
                double allWordNums = wc.values().stream().reduce((x1, x2) -> x1 + x2).get();
                double containDocNums = getContainWordDocNums(word, data);
                double tfidf = curWordNums / allWordNums * Math.log10(docNums / containDocNums);
                rr.put(word, tfidf);
            });
            res.put(url, rr);
        });
        return res;
    }

    private static int getContainWordDocNums(String word, Map<String, Map<String, Integer>> data) {
        int res = 0;
        res = data.keySet().stream().map((url) -> data.get(url)).filter((wc) -> (wc.containsKey(word))).map((_item) -> 1).reduce(res, Integer::sum);
        return res;
    }
}
