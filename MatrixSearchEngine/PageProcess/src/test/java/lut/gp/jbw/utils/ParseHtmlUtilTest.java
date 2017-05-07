/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lut.gp.jbw.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import lut.gp.jbw.parsepage.HtmlFileParser;
import org.htmlparser.Parser;
import org.junit.Test;

/**
 *
 * @author vincent
 */
public class ParseHtmlUtilTest {

    String file = "F:\\documents\\College\\gd\\data\\spider\\dl.sina.com.cn_.html";

    /**
     * Test of getKeywords method, of class ParseHtmlUtil.
     */
    @Test
    public void testGetKeywords() throws Exception {
        System.out.println("getKeywords");
        String con = readHtmlFile(file);
        String result = ParseHtmlUtil.getKeywords(con);
        System.out.println(result);
    }

    /**
     * Test of getTitle method, of class ParseHtmlUtil.
     */
    @Test
    public void testGetTitle() throws Exception {
        System.out.println("getTitle");
        String con = readHtmlFile(file);
        String result = ParseHtmlUtil.getTitle(con);
        System.out.println(result);
    }

    private String readHtmlFile(String file) {
        StringBuilder abstr = new StringBuilder();
        //实例化默认编码方式的BufferefReader
        BufferedReader enCReader;
        try {
            enCReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String temp;
            while ((temp = enCReader.readLine()) != null) {//得到字符串格式的文件
                abstr.append(temp);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HtmlFileParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(HtmlFileParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HtmlFileParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return abstr.toString();
    }
}
