/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lut.gp.jbw.tfidf;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static lut.gp.jbw.tfidf.TFIDF.tfidf;

/**
 *
 * @author vincent
 */
public class TFIDFTest {

    /**
     * Test of tfidf method, of class TFIDF.
     */
    @Test
    public void testTfidf() {
        System.out.println("-------------------------tfidf test------------------------");
        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();
        Map<String, Integer> m3 = new HashMap<>();
        m1.put("hello", 2);
        m1.put("word", 10);
        m2.put("hello", 4);
        m2.put("rich", 6);
        m3.put("rich", 89);
        m3.put("bitch", 33);
        m3.put("hello", 7);
        Map<String, Map<String, Integer>> data = new HashMap<>();
        data.put("baidu.com", m1);
        data.put("duban.com", m2);
        data.put("porn.com", m3);
        Map<String, Map<String, Double>> res = tfidf(data);
        res.keySet().forEach((url) -> {
            Map<String, Double> ss = res.get(url);
            ss.keySet().forEach((word) -> {
                System.out.println(url + ":" + word + ":" + ss.get(word));
            });
        });
    }
}
