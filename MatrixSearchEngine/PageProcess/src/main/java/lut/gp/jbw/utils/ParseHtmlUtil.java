package lut.gp.jbw.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.tags.MetaTag;
import org.htmlparser.tags.TitleTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.jsoup.Jsoup;

/**
 *
 * @author vincent Apr 2, 2017 3:14:43 PM
 */
public class ParseHtmlUtil {

    private static final Logger logger = Logger.getLogger(ParseHtmlUtil.class);

    // 获取网页上的链接
    public static Set<String> extracLinks(String con) throws ParserException {
        Parser parser = Parser.createParser(con, "utf-8");
        Set<String> links = new HashSet<>();
        try {
            // 过滤 <frame >标签的 filter， 用来提取 frame 标签里的 src 属性
            NodeFilter frameFilter = (Node node) -> {
                return node.getText().startsWith("frame src=");
            };

            // OrFilter 来设置过滤 <a> 标签和 <frame> 标签
            OrFilter linkFilter = new OrFilter(new NodeClassFilter(LinkTag.class), frameFilter);
            // 得到所有经过过滤的标签
            NodeList list = parser.extractAllNodesThatMatch(linkFilter);
            for (int i = 0; i < list.size(); i++) {
                Node tag = list.elementAt(i);
                if (tag instanceof LinkTag) {// <a> 标签       
                    LinkTag link = (LinkTag) tag;
                    String linkUrl = link.getLink().trim();// URL
                    if (RegExpValidatorUtils.IsUrl(linkUrl)) {
                        links.add(linkUrl);
                    }
                } else {// <frame> 标签
                    // 提取 frame 里 src 属性的链接，如 <framesrc="test.html"/>
                    String frame = tag.getText();
                    int start = frame.indexOf("src=");
                    frame = frame.substring(start);
                    int end = frame.indexOf(" ");
                    if (end == -1) {
                        end = frame.indexOf(">");
                    }
                    if ((end - 1) >= 5) {
                        String frameUrl = frame.substring(5, end - 1).trim();
                        if (RegExpValidatorUtils.IsUrl(frameUrl)) {
                            links.add(frameUrl);
                        }
                    }
                }
            }
        } catch (ParserException e) {
            logger.error("", e);
        }
        return links;
    }

    //获取一个html文件中的文本信息
    public static String html2Text(String inputString) {
        String htmlStr = inputString; // 含html标签的字符串  
        String textStr = "";
        java.util.regex.Pattern p_script;
        java.util.regex.Matcher m_script;
        java.util.regex.Pattern p_style;
        java.util.regex.Matcher m_style;
        java.util.regex.Pattern p_html;
        java.util.regex.Matcher m_html;
        try {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>  
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>  
            String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式  
            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); // 过滤script标签  
            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); // 过滤style标签  
            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 过滤html标签  
            textStr = htmlStr;
        } catch (Exception e) {
            logger.error("", e);
        }
        //剔除空格行  
        textStr = textStr.replaceAll("[ ]+", " ");
        textStr = textStr.replaceAll("(?m)^\\s*$(\\n|\\r\\n)", "");
        return textStr.replaceAll("\\s*", "");// 返回文本字符串并去除所有空格 
    }

    public static String getHtmlCon(String inputString) {
        return GetPageContent.GetDocContent(Jsoup.parse(inputString));
    }

    // 将Meta下面的keywords和description过滤出来
    public static String getKeywords(String con) throws ParserException {
        Parser parser = Parser.createParser(con, "utf-8");
        NodeClassFilter metaFilter = new NodeClassFilter(MetaTag.class);
        NodeList metaList = parser.extractAllNodesThatMatch(metaFilter);
        Pattern p = Pattern.compile("\\b(description|keywords)\\b", Pattern.CASE_INSENSITIVE);
        String curString;
        String res = "";
        for (int i = 0; i < metaList.size(); i++) {
            MetaTag metaTag = (MetaTag) metaList.elementAt(i);
            curString = metaTag.getMetaTagName();
            if (curString == null) {
                continue;
            }
            Matcher m = p.matcher(curString); //正则匹配name是description或keyword的<meta>标签
            if (m.find()) {
                res += metaTag.getMetaContent();//提取其content
            }
        }
        return res;
    }

    //得到文件标题
    public static String getTitle(String con) throws ParserException {
        Parser parser = Parser.createParser(con, "utf-8");
        String title = "";
        NodeClassFilter titleFilter = new NodeClassFilter(TitleTag.class);
        NodeList titleList = parser.extractAllNodesThatMatch(titleFilter);
        for (int i = 0; i < titleList.size(); i++) {
            TitleTag titleTag = (TitleTag) titleList.elementAt(i);
            title += titleTag.getTitle();
        }
        return title;
    }

    // 将Meta下面的date过滤出来
    public static String getDate(String con) throws ParserException {
        Parser parser = Parser.createParser(con, "utf-8");
        NodeClassFilter metaFilter = new NodeClassFilter(MetaTag.class);
        NodeList metaList = parser.extractAllNodesThatMatch(metaFilter);
        Pattern p = Pattern.compile("\\b(date)\\b", Pattern.CASE_INSENSITIVE);
        String curString;
        String res = "";
        for (int i = 0; i < metaList.size(); i++) {
            MetaTag metaTag = (MetaTag) metaList.elementAt(i);
            curString = metaTag.getMetaTagName();
            if (curString == null) {
                continue;
            }
            Matcher m = p.matcher(curString); //正则匹配name是description或keyword的<meta>标签
            if (m.find()) {
                res = metaTag.getMetaContent();//提取其content
            }
        }
        return res;
    }
}
