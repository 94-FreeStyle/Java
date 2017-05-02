package lut.gp.jbw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lut.gp.jbw.util.dao.ConnectionPoolManager;
import lut.gp.jbw.parsepage.pojo.ParsedFileEntity;

/**
 *
 * @author vincent Apr 29, 2017 4:31:57 PM
 */
public class StoreToMysql {

    private static final Connection conn = ConnectionPoolManager.getInstance().getConnection();
    private static String sql = "";

    public static void storePageCon(ParsedFileEntity entity) {
        try {
            sql = "insert into page_con(url, title, keywords, con, cre_date) values(?,?,?,?,?)";
            PreparedStatement sta = conn.prepareStatement(sql);
            sta.setString(1, entity.getUrl());
            sta.setString(2, entity.getTitle());
            sta.setString(3, entity.getKeywords());
            sta.setString(4, entity.getCon());
            sta.setString(5, entity.getDate());
            sta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StoreToMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void storePageRank(double pagerank, String url) {
        try {
            sql = "update page_con set page_rank = ? where url = ?";
            PreparedStatement sta = conn.prepareStatement(sql);
            sta.setDouble(1, pagerank);
            sta.setString(2, url);
            sta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StoreToMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void storeInvertedIndex(String word, String url) {
        try {
            sql = "insert into inverted_index(word, page_url) values(?,?)";
            PreparedStatement sta = conn.prepareStatement(sql);
            sta.setString(1, word);
            sta.setString(2, url);
            sta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StoreToMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void storeTFIDF(double tfidf, String word, String url) {
        try {
            sql = "update inverted_index set tf_idf = ? where word = ? and page_url = ?";
            PreparedStatement sta = conn.prepareStatement(sql);
            sta.setDouble(1, tfidf);
            sta.setString(2, word);
            sta.setString(3, url);
            sta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StoreToMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
