/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lut.gp.jbw.parsepage;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import lut.gp.jbw.parsepage.pojo.ParsedFileEntity;
import org.junit.Test;

/**
 *
 * @author vincent
 */
public class HtmlFileParserTest {

    /**
     * Test of parseHtml method, of class HtmlFileParser.
     */
    @Test
    public void testParseHtml() {
        System.out.println("-----------------parseHtml--------------------");
        HtmlFileParser instance = new HtmlFileParser(new File("F:\\documents\\College\\gd\\data\\spider\\page\\blog.tianya.cn_post-863996-124163006-1.shtml.html"));
        ParsedFileEntity result = instance.parseHtml();
        System.out.println("title:" + result.getTitle());
        System.out.println("date:" + result.getDate());
        System.out.println("keywords:" + result.getKeywords());
        System.out.println("url:" + result.getUrl());
        System.out.println("con:" + result.getCon());
        result.getLinks().forEach(x -> System.out.print(x + "\t"));
        System.out.println("********************************");
        Map<String, Integer> wc = result.getWc();
        wc.keySet().forEach((word) -> {
            System.out.print(word + ":" + wc.get(word) + "\t");
        });
    }

    @Test
    public void testDisstinct() {
        Map<String, Set<String>> pageRankData = new ConcurrentHashMap<>();
        Set<String> s1 = new HashSet<>();
        s1.add("hello");
        s1.add("name");
        s1.add("age");
        s1.add("rich");
        Set<String> s2 = new HashSet<>();
        s2.add("rich");
        s2.add("bitch");
        pageRankData.put("hello", s2);
        pageRankData.put("rich", s1);
        pageRankData.keySet().forEach((url) -> {
            Iterator<String> it = pageRankData.get(url).iterator();
            while (it.hasNext()) {
                String link = it.next();
                if (!pageRankData.keySet().contains(link)) {
                    it.remove();
                }
            }
        });
        pageRankData.keySet().stream().map((key) -> {
            System.out.print(key + ":");
            return key;
        }).map((key) -> {
            pageRankData.get(key).forEach((v) -> {
                System.out.print(v + "\t");
            });
            return key;
        }).forEachOrdered((_item) -> {
            System.out.println("");
        });
    }

}
