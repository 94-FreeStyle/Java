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
import java.util.logging.Level;
import java.util.logging.Logger;
import lut.gp.jbw.model.ReturnRecord;
import lut.gp.jbw.util.dao.ConnectionPoolManager;
import org.apdplat.word.segmentation.Word;

/**
 *
 * @author vincent Apr 30, 2017 12:13:37 AM
 */
public class ExecuteQuery {

    private static final Connection conn = ConnectionPoolManager.getInstance().getConnection();
    private static String sql = "";

    /**
     *
     * @param words
     * @return (url,tf-idf)
     */
    public static Map<String, Double> selectIndex(List<Word> words) {
        Map<String, Double> res = new HashMap<>();
        try {
            for (Word word : words) {
                sql = "select page_url, tf_idf from inverted_index where word ='" + word.getText() + "'";
                Statement sta = conn.createStatement();
                ResultSet rs = sta.executeQuery(sql);
                while (rs.next()) {
                    String pageURL = rs.getString("page_url");
                    double tfidf = rs.getDouble("tf_idf");
                    res.put(pageURL, tfidf);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public static Map<String, Double> selectRank(Set<String> urls) {
        Map<String, Double> res = new HashMap<>();
        try {
            for (String url : urls) {
                sql = "select page_rank from page_con where url ='" + url + "'";
                Statement sta = conn.createStatement();
                ResultSet rs = sta.executeQuery(sql);
                while (rs.next()) {
                    double pageRank = rs.getDouble("page_rank");
                    res.put(url, pageRank);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public static List<ReturnRecord> selectPageCon(List<String> urls) {
        List<ReturnRecord> res = new ArrayList<>();
        try {
            for (String url : urls) {
                sql = "select title, keywords, con, cre_date from page_con where url = '" + url + "'";
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
            Logger.getLogger(ExecuteQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}
