package lut.gp.jbw.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apdplat.word.segmentation.Word;

/**
 *
 * @author vincent Apr 30, 2017 12:39:28 AM
 */
public class ProcessSearch {

    public static Map<List<Word>, List<Word>> situation = new HashMap<>();//每一种情况（OR）包括必须有的单词列表(AND)和不需要有的单词列表(NOT)

    public static Map<List<Word>, List<Word>> bool(List<Word> searchCon) {
        //请求内容中解析AND OR NOT布尔运算 

        List<Word> or = new ArrayList<>();
        //"中国人名helloand AND good秦始皇天下 AND number历史任务 NOT not皇帝国家 OR or二手出卖主 NOT is比亚迪"
        for (int i = 0; i < searchCon.size(); i++) {
            or.add(searchCon.get(i));
            if (searchCon.get(i).getText().equals("OR")) {
                pb(or, i);
            }
        }
        if (!or.isEmpty()) {
            pb(or, -1);
        }
        if (situation.isEmpty()) {
            situation.put(searchCon, new ArrayList<Word>());
        }
        return situation;
    }

    private static void pb(List<Word> or, int i) {
        if (i != -1) {
            or.remove(i);
        }
        List<Word> and = new ArrayList<>();
        List<Word> not = new ArrayList<>();
        boolean flag = true;
        for (int j = 0; j < or.size(); j++) {
            if (or.get(j).getText().equals("AND")) {
                flag = true;
            }
            if (or.get(j).getText().equals("NOT")) {
                flag = false;
            }
            if (flag && !or.get(j).getText().equals("AND")) {
                and.add(or.get(j));
            } else if (!flag && !or.get(j).getText().equals("NOT")) {
                not.add(or.get(j));
            }
        }
        situation.put(and, not);
        or.clear();
    }
}
