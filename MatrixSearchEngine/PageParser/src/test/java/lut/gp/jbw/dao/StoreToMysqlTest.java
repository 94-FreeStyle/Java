/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lut.gp.jbw.dao;

import lut.gp.jbw.parsepage.pojo.ParsedFileEntity;
import org.junit.Test;

/**
 *
 * @author vincent
 */
public class StoreToMysqlTest {

    /**
     * Test of storePageCon method, of class StoreToMysql.
     */
    @Test
    public void testStorePageCon() {
        System.out.println("storePageCon");
        String url = "www.baidu.com";
        String con = "hello, i am baidu, my boss is li yan hong, his english name is robbin!";
        String title = "vincent";
        ParsedFileEntity entity = new ParsedFileEntity();
        entity.setCon(con);
        entity.setUrl(url);
        entity.setTitle(title);
        StoreToMysql.storePageCon(entity);
    }

    /**
     * Test of storePageRank method, of class StoreToMysql.
     */
    @Test
    public void testStorePageRank() {
        System.out.println("storePageRank");
        double pagerank = 0.54367828;
        String url = "www.baidu.com";
        StoreToMysql.storePageRank(pagerank, url);
    }

    /**
     * Test of storeInvertedIndex method, of class StoreToMysql.
     */
    @Test
    public void testStoreInvertedIndex() {
        System.out.println("storeInvertedIndex");
        String word = "name";
        String url = "www.baidu.com";
        StoreToMysql.storeInvertedIndex(word, url);
    }

    /**
     * Test of storeTFIDF method, of class StoreToMysql.
     */
    @Test
    public void testStoreTFIDF() {
        System.out.println("storeTFIDF");
        double tfidf = 0.2357843278;
        String word = "name";
        String url = "www.baidu.com";
        StoreToMysql.storeTFIDF(tfidf, word, url);
    }

    @Test
    public void testSerachURL() {
        String localPath = "www.cnblogs.com_kmsfan_.html";
        String res = SearchURL.serachURL(localPath);
        System.out.println("url:" + res);
    }
}
