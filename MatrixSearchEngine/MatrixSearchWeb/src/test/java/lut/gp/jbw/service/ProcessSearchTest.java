/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lut.gp.jbw.service;

import java.util.ArrayList;
import java.util.List;
import org.apdplat.word.segmentation.Word;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author vincent
 */
public class ProcessSearchTest {

    public ProcessSearchTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of process method, of class ProcessSearch.
     */
    @Test
    public void testProcess() {
        System.out.println("process");
        List<Word> con = new ArrayList<>();
        con.add(new Word("进来"));
        con.add(new Word("运维"));
        List<String> result = ProcessSearch.process(con);
        for (String s : result) {
            System.out.println(s);
        }
    }

    @Test
    public void test01() {
        System.out.println(Math.floor(0.0001));
        System.out.println(Math.ceil(1 / 60.0));
        System.out.println(Math.round(0.0001));
        String xx = "jahfjdahj";
        System.out.println(xx.substring(0, xx.length()));
    }

}
