package lut.gp.jbw;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import lut.gp.jbw.dao.SearchFromMysql;
import lut.gp.jbw.dao.StoreToMysql;
import lut.gp.jbw.parsepage.HtmlFileParser;
import lut.gp.jbw.parsepage.pojo.ParsedFileEntity;
import org.apache.log4j.Logger;

/**
 *
 * @author vincent May 7, 2017 12:51:50 PM
 */
public class ParseAndStoreToDB {

    private static final Logger logger = Logger.getLogger(ParseAndStoreToDB.class);

    public static void store() {
        //得监听目录或者把处理过的文件删除，定时执行
        String fileDir = "E:/Document/College/gd/data/spider/page/";
        File dir = new File(fileDir);
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files.length != 0) {
                Set<String> urls = SearchFromMysql.serachAllURL();
                for (File file : files) {
                    if (file.getName().endsWith(".html") || file.getName().endsWith(".htm")) {
                        //解析每一个文件
                        ParsedFileEntity entity = new HtmlFileParser(file).parseHtml();
                        //文件内容
                        StoreToMysql.storePageCon(entity);
                        //链接信息入库
                        Set<String> links = new HashSet<>();
                        entity.getLinks().stream().filter((link) -> {
                            return urls.contains(link);
                        }).forEach(str -> links.add(str));
                        StoreToMysql.storePageLinks(entity.getUrl(), links);
                        logger.info("process file:" + file.getAbsolutePath());
                    }
                }
                //删除处理过的文件
                for (File file : files) {
                    if (!file.delete()) {
                        logger.error("file delete faild! " + file.getAbsolutePath());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        store();
    }
}
