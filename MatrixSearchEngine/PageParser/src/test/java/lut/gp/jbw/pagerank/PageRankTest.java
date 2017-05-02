/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lut.gp.jbw.pagerank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import static lut.gp.jbw.pagerank.PageRank.pageRank;
import org.junit.Test;

/**
 *
 * @author vincent
 */
public class PageRankTest {

    /**
     * Test of pageRank method, of class PageRank.
     */
    @Test
    public void testPageRank() {
        System.out.println("--------------------------pageRank test--------------------------");
        Map<String, Set<String>> data = new HashMap<>();
        Set<String> s1 = new HashSet<>();
        s1.add("B");
        s1.add("C");
        s1.add("D");
        data.put("A", s1);
        Set<String> s2 = new HashSet<>();
        s2.add("D");
        s2.add("E");
        data.put("B", s2);
        Set<String> s3 = new HashSet<>();
        s3.add("E");
        data.put("C", s3);
        Set<String> s4 = new HashSet<>();
        s4.add("E");
        data.put("D", s4);
        Set<String> s5 = new HashSet<>();
        s5.add("A");
        data.put("E", s5);
        Map<String, Double> ranks = pageRank(data);
        ranks.keySet().forEach((url) -> {
            System.out.println(url + ":" + ranks.get(url));
        });
    }
}
