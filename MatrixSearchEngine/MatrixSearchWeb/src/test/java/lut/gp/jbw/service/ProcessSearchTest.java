package lut.gp.jbw.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.junit.Test;

/**
 *
 * @author vincent
 */
public class ProcessSearchTest {

    @Test
    public void testProcessSearch() {
        Map<String, Double> res = new TreeMap<>();
        res.put("ba", 0.2322);
        res.put("fsfs", 3232.8);
        res.put("fs", 893.9);
        Set<Map.Entry<String, Double>> set = res.entrySet();
        List<Map.Entry<String, Double>> sortedRes = new ArrayList(set);
        Collections.sort(sortedRes, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Map.Entry obj1 = (Map.Entry) o1;
                Map.Entry obj2 = (Map.Entry) o2;
                return ((Double) obj2.getValue()).compareTo((Double) obj1.getValue());
            }
        });
        for (Map.Entry<String, Double> entry : sortedRes) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
