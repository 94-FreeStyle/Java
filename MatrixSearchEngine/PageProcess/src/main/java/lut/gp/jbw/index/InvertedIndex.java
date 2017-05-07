package lut.gp.jbw.index;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author vincent Apr 29, 2017 4:24:00 PM
 */
public class InvertedIndex {

    /**
     *
     * @param data（url,(word，count)）
     * @return （word,urls）
     */
    public static Map<String, Set<String>> index(Map<String, Map<String, Integer>> data) {
        Map<String, Set<String>> res = new HashMap<>();
        data.keySet().forEach((okey) -> {
            data.get(okey).keySet().stream().map((ikey) -> {
                if (!res.containsKey(ikey)) {
                    res.put(ikey, new HashSet<>());
                }
                return ikey;
            }).forEachOrdered((ikey) -> {
                res.get(ikey).add(okey);
            });
        });
        return res;
    }
}
