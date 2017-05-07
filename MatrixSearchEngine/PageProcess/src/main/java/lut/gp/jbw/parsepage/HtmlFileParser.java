package lut.gp.jbw.parsepage;

import lut.gp.jbw.utils.ParseHtmlUtil;
import lut.gp.jbw.parsepage.pojo.ParsedFileEntity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.htmlparser.util.ParserException;
import lut.gp.jbw.dao.SearchFromMysql;
import org.apache.log4j.Logger;

/**
 *
 * @author vincent Apr 2, 2017 5:24:31 PM
 */
public class HtmlFileParser {

    private static final org.apache.log4j.Logger logger = Logger.getLogger(HtmlFileParser.class);
    private final File file;//html文件
    private ParsedFileEntity entity;

    public HtmlFileParser(File file) {
        this.file = file;
    }

    private String readHtmlFile() {
        StringBuilder abstr = new StringBuilder();
        String result = null;
        try {
            //实例化默认编码方式的BufferefReader
            BufferedReader enCReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.file), "UTF-8"));
            String temp;
            while ((temp = enCReader.readLine()) != null) {//得到字符串格式的文件
                abstr.append(temp);
                abstr.append("\r\n");
            }
            enCReader.close();
            result = abstr.toString();
            String encoding = getEnc(result);
            //根据得到的编码方式实例化BufferedReader
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(this.file), encoding));
            StringBuilder abstrT = new StringBuilder();
            while ((temp = reader.readLine()) != null) {
                abstrT.append(temp);
                abstrT.append("\r\n");
            }
            reader.close();
            result = abstrT.toString();
        } catch (FileNotFoundException e) {
            logger.error("", e);
        } catch (IOException e) {
            logger.error("", e);
        }
        return result;
    }

    private String getEnc(String file) {//根据正则匹配得到页面编码
        String enC = "utf-8";
        Pattern p = Pattern.compile("(charset|Charset|CHARSET)\\s*=\\s*\"?\\s*([-\\w]*?)[^-\\w]");
        Matcher m = p.matcher(file);
        if (m.find()) {
            enC = m.group(2);
        }
        return enC;
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
            this.entity.setUrl(SearchFromMysql.serachURL(fileName));
            //con
            String curString = ParseHtmlUtil.getHtmlCon(con);
            this.entity.setCon(curString);
            //links
            this.entity.setLinks(ParseHtmlUtil.extracLinks(con));
            //date
            this.entity.setDate(ParseHtmlUtil.getDate(con));
            //got time
            this.entity.setGotTime(this.file.lastModified());
        } catch (ParserException ex) {
            logger.error("", ex);
        }
        return this.entity;
    }
}
