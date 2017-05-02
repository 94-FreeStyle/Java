package lut.gp.jbw.spider.util;

import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

/**
 *
 * @author vincent Apr 2, 2017 3:14:43 PM
 */
public class ExtractLinksFromHtml {

    private static final Logger logger = Logger.getLogger(ExtractLinksFromHtml.class);

    // 获取一个网页上的链接， filter 用来过滤链接
    public static Set<String> extracLinks(String con, LinkFilter filter) throws ParserException {
        Set<String> links = new HashSet<>();
        try {
            //Parser parser = new Parser(url);
            Parser parser = Parser.createParser(con, "utf-8");
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
                    if (RegExpValidatorUtils.IsUrl(linkUrl) && filter.accept(linkUrl)) {
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
                        if (RegExpValidatorUtils.IsUrl(frameUrl) && filter.accept(frameUrl)) {
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
}
