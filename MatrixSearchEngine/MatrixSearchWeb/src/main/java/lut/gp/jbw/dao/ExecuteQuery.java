package lut.gp.jbw.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import lut.gp.jbw.model.ReturnRecord;
import lut.gp.jbw.util.dao.ConnectionPoolManager;
import org.apache.log4j.Logger;

/**
 *
 * @author vincent Apr 30, 2017 12:13:37 AM
 */
public class ExecuteQuery {

    private static final Logger logger = Logger.getLogger(ExecuteQuery.class);
    private static final Connection conn = ConnectionPoolManager.getInstance().getConnection();
    private static String sql = "";

    public static Map<String, List<String>> selectFromIndex(List<String> words) {
        Map<String, List<String>> res = new ConcurrentHashMap<>();
        try {
            for (String word : words) {
                sql = "select page_url, word, tf_idf from inverted_index where word ='" + word + "'";
                Statement sta = conn.createStatement();
                ResultSet rs = sta.executeQuery(sql);
                while (rs.next()) {
                    String pageURL = rs.getString("page_url");
                    if (!res.containsKey(pageURL)) {
                        res.put(pageURL, new ArrayList<String>());
                    }
                    String w = rs.getString("word");
                    double tfidf = rs.getDouble("tf_idf");
                    res.get(pageURL).add(w + "\1" + tfidf);
                }
            }
        } catch (SQLException ex) {
            logger.error("", ex);
        }
        return res;
    }

    public static Map<String, Double> selectRank(Set<String> urls) {
        Map<String, Double> res = new HashMap<>();
        try {
            for (String url : urls) {
                sql = "select page_rank from page_info where url ='" + url + "'";
                Statement sta = conn.createStatement();
                ResultSet rs = sta.executeQuery(sql);
                while (rs.next()) {
                    double pageRank = rs.getDouble("page_rank");
                    res.put(url, pageRank);
                }
            }
        } catch (SQLException ex) {
            logger.error("", ex);
        }
        return res;
    }

    public static List<ReturnRecord> selectPageCon(List<String> urls) {
        List<ReturnRecord> res = new ArrayList<>();
        try {
            for (String url : urls) {
                sql = "select title, keywords, con, cre_date from page_info where url = '" + url + "'";
                Statement sta = conn.createStatement();
                ResultSet rs = sta.executeQuery(sql);
                ReturnRecord rec = new ReturnRecord();
                rec.setUrl(url);
                while (rs.next()) {
                    rec.setTitle(rs.getString("title"));
                    rec.setKeywords(rs.getString("keywords"));
                    rec.setCon(rs.getString("con"));//记得添加content的关键内容处理
                    rec.setDate(rs.getString("cre_date"));
                }
                res.add(rec);
            }
        } catch (SQLException ex) {
            logger.error("", ex);
        }
        return res;
    }
}
