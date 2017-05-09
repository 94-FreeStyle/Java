package lut.gp.jbw.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import lut.gp.jbw.model.PageBean;
import org.junit.Test;

/**
 *
 * @author vincent May 9, 2017 3:35:03 PM
 */
public class CacheRecordTest {

    @Test
    public void test() {
//        CacheRecord r1 = new CacheRecord();
//        r1.setAddTime(System.currentTimeMillis());
//        r1.setPages(new PageBean());
//        List<String> words1 = new ArrayList<>();
//        words1.add("good");
//        words1.add("world");
//        words1.add("nice");
//        r1.setWords(words1);
//        CacheRecord r2 = new CacheRecord();
//        r2.setAddTime(System.currentTimeMillis());
//        r2.setPages(new PageBean());
//        List<String> words2 = new ArrayList<>();
//        words2.add("good");
//        words2.add("world");
//        words2.add("nice");
//        r2.setWords(words2);
//        System.out.println("equals:" + r1.equals(r2));
//        Set<CacheRecord> cs = ConcurrentHashMap.<CacheRecord>newKeySet();
//        cs.add(r1);
//        cs.add(r2);
//        System.out.println("size:" + cs.size());
//        CacheRecord r3 = new CacheRecord();
//        r3.setAddTime(System.currentTimeMillis());
//        r3.setPages(new PageBean());
//        List<String> words3 = new ArrayList<>();
//        words3.add("good");
//        words3.add("world");
//        words3.add("nice");
//        r3.setWords(words3);
//        System.out.println("contains:" + cs.contains(r3));
        String s = "hello";
        System.out.println("size:" + s.split("\1").length);
    }
}
