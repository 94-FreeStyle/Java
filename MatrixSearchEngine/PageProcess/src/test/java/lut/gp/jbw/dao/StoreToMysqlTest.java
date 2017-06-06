/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lut.gp.jbw.dao;

import org.junit.Test;

/**
 *
 * @author vincent
 */
public class StoreToMysqlTest {
    /**
     * Test of loadIndex method, of class StoreToMysql.
     */
    @Test
    public void testLoadIndex() {
        System.out.println("loadIndex");
        String localPath = "E:/index.csv";
        StoreToMysql.loadIndex(localPath);
    }
    
}
