/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lut.gp.jbw.index;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import static lut.gp.jbw.index.InvertedIndex.index;
import org.junit.Test;

/**
 *
 * @author vincent
 */
public class InvertedIndexTest {

    /**
     * Test of index method, of class InvertedIndex.
     */
    @Test
    public void testIndex() {
        System.out.println("---------------------index test-----------------------");
        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();
        m1.put("hello", 2);
        m1.put("word", 10);
        m2.put("hello", 4);
        m2.put("rich", 6);
        Map<String, Map<String, Integer>> data = new HashMap<>();
        data.put("baidu.com", m1);
        data.put("duban.com", m2);
        Map<String, Set<String>> res = index(data);
        res.keySet().stream().map((key) -> {
            System.out.print(key + ":");
            return key;
        }).map((key) -> {
            res.get(key).forEach((v) -> {
                System.out.print(v + ",");
            });
            return key;
        }).forEachOrdered((_item) -> {
            System.out.println();
        });
    }
}
