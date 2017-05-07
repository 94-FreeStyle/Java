package lut.gp.jbw.utils;

import java.util.Stack;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author vincent May 6, 2017 9:50:41 PM
 */
public class GetPageContent {

    public static String GetDocContent(Document doc) {
        String content = null;
        if (doc.body() != null) {
            Elements divs = doc.body().getElementsByTag("div");
            int max = -1;
            if (divs != null) {
                for (int i = 0; i < divs.size(); i++) {
                    Element div = (Element) divs.get(i);
                    String divContent = GetDivContent(div);
                    if (divContent.length() > max) {
                        max = divContent.length();
                        content = divContent;
                    }
                }
            }
        }
        return content;
    }

    private static String GetDivContent(Element div) {
        StringBuilder sb = new StringBuilder();
        //考虑div里标签内容的顺序，对div子树进行深度优先搜索  
        Stack<Element> sk = new Stack<>();
        sk.push(div);
        while (!sk.empty()) {
            Element e = sk.pop();
            //对于div中的div过滤掉  
            if (e != div && e.tagName().equals("div")) {
                continue;
            }
            //考虑正文被包含在p标签中的情况，并且p标签里不能含有a标签  
            if (e.tagName().equals("p") && e.getElementsByTag("a").isEmpty()) {
                String className = e.className();
                if (className.length() != 0 && className.equals("pictext")) {
                    continue;
                }
                sb.append(e.text());
                sb.append("\n");
                continue;
            } else if (e.tagName().equals("td")) {
                //考虑正文被包含在td标签中的情况  
                if (!e.getElementsByTag("div").isEmpty()) {
                    continue;
                }
                sb.append(e.text());
                sb.append("\n");
                continue;
            }
            //将孩子节点加入栈中  
            Elements children = e.children();
            for (int i = children.size() - 1; i >= 0; i--) {
                sk.push((Element) children.get(i));
            }
        }
        return sb.toString();
    }
}
