/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lut.gp.jbw.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lut.gp.jbw.model.ReturnRecord;
import org.apdplat.word.segmentation.Word;
import org.junit.Test;

/**
 *
 * @author vincent
 */
public class ExecuteQueryTest {

    /**
     * Test of selectRank method, of class ExecuteQuery.
     */
    @Test
    public void testSelectRank() {
        System.out.println("selectRank");
        Set<String> urls = new HashSet<>();
        urls.add("www.baidu.com");
        Map<String, Double> result = ExecuteQuery.selectRank(urls);
        for (String k : result.keySet()) {
            System.out.println(k + ":" + result.get(k));
        }
    }

    /**
     * Test of selectPageCon method, of class ExecuteQuery.
     */
    @Test
    public void testSelectPageCon() {
        System.out.println("selectPageCon");
        List<String> urls = new ArrayList<>();
        urls.add("www.baidu.com");
        List<ReturnRecord> result = ExecuteQuery.selectPageCon(urls);
        for (ReturnRecord rec : result) {
            System.out.println(rec.toString());
        }
    }
}
