package lut.gp.jbw.parsepage;

import lut.gp.jbw.utils.ParseHtmlUtil;
import lut.gp.jbw.utils.WordSegmenterUtil;
import lut.gp.jbw.parsepage.pojo.ParsedFileEntity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.htmlparser.util.ParserException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lut.gp.jbw.dao.SearchURL;

/**
 *
 * @author vincent Apr 2, 2017 5:24:31 PM
 */
public class HtmlFileParser {

    private final File file;//html文件
    private ParsedFileEntity entity;

    public HtmlFileParser(File file) {
        this.file = file;
    }

    private String readHtmlFile() {
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

    public ParsedFileEntity parseHtml() {
        entity = new ParsedFileEntity();
        try {
            String con = readHtmlFile();

            //title
            this.entity.setTitle(ParseHtmlUtil.getTitle(con));
            //keywords
            this.entity.setKeywords(ParseHtmlUtil.getKeywords(con));
            //url
            String fileName = this.file.getName();
            this.entity.setUrl(SearchURL.serachURL(fileName));
            //con
            String curString = ParseHtmlUtil.html2Text(con);
            this.entity.setCon(curString);
            //links
            this.entity.setLinks(ParseHtmlUtil.extracLinks(con));
            //wc  
            this.entity.setWc(WordSegmenterUtil.wordCountToMap(WordSegmenterUtil.segmenter(curString)));
            //date
            this.entity.setDate(ParseHtmlUtil.getDate(con));
        } catch (ParserException ex) {
            Logger.getLogger(HtmlFileParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.entity;
    }
}
