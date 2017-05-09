package lut.gp.jbw.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lut.gp.jbw.dao.ExecuteQuery;

/**
 *
 * @author vincent Apr 30, 2017 12:39:28 AM
 */
public class ProcessInnerSearch {

    private static Map<List<String>, List<String>> situation = null;//每一种情况（OR）包括必须有的单词列表(AND)和不需要有的单词列表(NOT)

    public static List<String> process(List<String> con) {
        Map<List<String>, List<String>> searchCon = bool(con);
        //结果做集合运算（url:PR, (word:TI...)）...  排名对象（只要包含至少一个查询词）
        Map<String, List<String>> sortObj = new HashMap<>();
        for (List<String> andW : searchCon.keySet()) {
            Map<String, List<String>> and = ExecuteQuery.selectFromIndex(andW);
            if (!searchCon.get(andW).isEmpty()) {
                Map<String, List<String>> not = ExecuteQuery.selectFromIndex(searchCon.get(andW));
                for (String url : and.keySet()) {
                    if (not.containsKey(url)) {
                        and.remove(url);
                    }
                }
            }
            Map<String, Double> pageranks = ExecuteQuery.selectRank(and.keySet());
            for (String url : and.keySet()) {
                if (pageranks.get(url) != null) {
                    sortObj.put(url + "\1" + pageranks.get(url), and.get(url));
                } else {
                    sortObj.put(url + "\1" + 0, and.get(url));
                }
            }
        }
        //排名模型（是不是查询词都包含，都包含计算所有词TF-IDF的和，按照和排序，然后按照PR排，之后按照包含的词多少排）
        // size+sum(tfidf)+pr
        Map<String, List<String>> uw = new HashMap<>();
        Map<String, Double> waitSort = new HashMap<>();
        for (String url : sortObj.keySet()) {
            double value = sortObj.get(url).size() + Double.parseDouble(url.split("\1")[1]);
            List<String> ws = new ArrayList<>();
            for (String v : sortObj.get(url)) {
                double ti = Double.parseDouble(v.split("\1")[1]);
                ws.add(v.split("\1")[0]);
                value += ti;
            }
            waitSort.put(url.split("\1")[0], value);
            uw.put(url.split("\1")[0], ws);
        }
        List<Map.Entry<String, Double>> sortedObj = new ArrayList(waitSort.entrySet());
        Collections.sort(sortedObj, new Comparator() {  //从大到小排序
            @Override
            public int compare(Object o1, Object o2) {
                Map.Entry obj1 = (Map.Entry) o1;
                Map.Entry obj2 = (Map.Entry) o2;
                return ((Double) obj2.getValue()).compareTo((Double) obj1.getValue());
            }
        });
        List<String> returnRes = new ArrayList<>();
        for (Map.Entry entry : sortedObj) {
            List<String> wss = uw.get((String) entry.getKey());
            StringBuilder sb = new StringBuilder();
            sb.append("\1");
            for (String s : wss) {
                sb.append(s);
                sb.append("\2");
            }
            String ss = sb.toString();
            returnRes.add((String) entry.getKey() + ss.substring(0, ss.length() - 1));
        }
        return returnRes;
    }

    private static Map<List<String>, List<String>> bool(List<String> searchCon) {
        situation = new HashMap<>();
        //请求内容中解析AND OR NOT布尔运算 
        List<String> or = new ArrayList<>();
        //测试 "中国人名helloand AND good秦始皇天下 AND number历史任务 NOT not皇帝国家 OR or二手出卖主 NOT is比亚迪"
        for (int i = 0; i < searchCon.size(); i++) {
            or.add(searchCon.get(i));
            if (searchCon.get(i).equals("OR")) {
                pb(or, i);
            }
        }
        if (!or.isEmpty()) {
            pb(or, -1);
        }
        if (situation.isEmpty()) {
            situation.put(searchCon, new ArrayList<String>());
        }
        return situation;
    }

    private static void pb(List<String> or, int i) {
        if (i != -1) {
            or.remove(i);
        }
        List<String> and = new ArrayList<>();
        List<String> not = new ArrayList<>();
        boolean flag = true;
        for (int j = 0; j < or.size(); j++) {
            if (or.get(j).equals("AND")) {
                flag = true;
            }
            if (or.get(j).equals("NOT")) {
                flag = false;
            }
            if (flag && !or.get(j).equals("AND")) {
                and.add(or.get(j));
            } else if (!flag && !or.get(j).equals("NOT")) {
                not.add(or.get(j));
            }
        }
        situation.put(and, not);
        or.clear();
    }
}
