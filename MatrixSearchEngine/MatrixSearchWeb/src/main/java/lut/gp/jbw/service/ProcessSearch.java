package lut.gp.jbw.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apdplat.word.segmentation.Word;
import lut.gp.jbw.dao.ExecuteQuery;

/**
 *
 * @author vincent Apr 30, 2017 12:39:28 AM
 */
public class ProcessSearch {

    public static List<String> process(List<Word> con) {
        Map<String, Double> indexs = ExecuteQuery.selectIndex(con);
        Set<String> urls = indexs.keySet();
        Map<String, Double> pageranks = ExecuteQuery.selectRank(urls);

        Map<String, Double> res = new TreeMap<>();
        for (String url : urls) {
            double tfidf = indexs.get(url);
            double pagerank = pageranks.get(url);
            res.put(url, tfidf + pagerank);
        }
        List<Map.Entry<String, Double>> sortedRes = new ArrayList(res.entrySet());
        Collections.sort(sortedRes, new Comparator() {  //从大到小排序
            @Override
            public int compare(Object o1, Object o2) {
                Map.Entry obj1 = (Map.Entry) o1;
                Map.Entry obj2 = (Map.Entry) o2;
                return ((Double) obj2.getValue()).compareTo((Double) obj1.getValue());
            }
        });
        List<String> returnRes = new ArrayList<>();
        for (Map.Entry entry : sortedRes) {
            returnRes.add((String) entry.getKey());
        }
        return returnRes;
    }
    
    //必须为大写的单词，防止正真使用这些单词
    public static Map<String,List<Word>> processSearchCon(String con){
        Map<String,List<Word>> res = new HashMap<>();
        
        return res;
    }
}
