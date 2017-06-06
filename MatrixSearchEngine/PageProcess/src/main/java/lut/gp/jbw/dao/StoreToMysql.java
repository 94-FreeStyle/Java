package lut.gp.jbw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Set;
import lut.gp.jbw.util.dao.ConnectionPoolManager;
import lut.gp.jbw.parsepage.pojo.ParsedFileEntity;
import org.apache.log4j.Logger;

/**
 *
 * @author vincent Apr 29, 2017 4:31:57 PM
 */
public class StoreToMysql {

    private static final Logger logger = Logger.getLogger(StoreToMysql.class);
    private static final Connection conn = ConnectionPoolManager.getInstance().getConnection();
    private static String sql = "";

    public static void storePageCon(ParsedFileEntity entity) {
        try {
            sql = "insert into page_info(url, title, keywords, con, cre_date, got_time) values(?,?,?,?,?,?)";
            if (entity.getCon() == null) {
                entity.setCon("NULL");
            }
            PreparedStatement sta = conn.prepareStatement(sql);
            sta.setString(1, entity.getUrl());
            sta.setString(2, entity.getTitle());
            sta.setString(3, entity.getKeywords());
            sta.setString(4, entity.getCon());
            sta.setString(5, entity.getDate());
            sta.setTimestamp(6, new Timestamp(entity.getGotTime()));
            sta.executeUpdate();
        } catch (SQLException ex) {
            logger.error("", ex);
        }
    }

    public static void storePageLinks(String url, Set<String> links) {
        try {
            sql = "insert into page_links(url,link) values(?,?)";
            PreparedStatement sta = conn.prepareStatement(sql);
            for (String link : links) {
                sta.setString(1, url);
                sta.setString(2, link);
                sta.addBatch();
            }
            sta.executeBatch();
            sta.clearBatch();
        } catch (SQLException ex) {
            logger.error("", ex);
        }
    }

    public static void storePageRank(double pagerank, String url) {
        try {
            sql = "update page_info set page_rank = ? where url = ?";
            PreparedStatement sta = conn.prepareStatement(sql);
            sta.setDouble(1, pagerank);
            sta.setString(2, url);
            sta.executeUpdate();
        } catch (SQLException ex) {
            logger.error("", ex);
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
            logger.error("", ex);
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
            logger.error("", ex);
        }
    }

    public static void loadIndex(String localPath) {
        logger.info("connected! starting deleting...");
        deleteIndex();
        logger.info("deleted! starting store...");
        try {
            sql = "LOAD DATA LOCAL INFILE '" + localPath + "' INTO TABLE inverted_index "
                    + "FIELDS TERMINATED BY ',' "
                    + "OPTIONALLY ENCLOSED BY \"\" "
                    + "LINES TERMINATED BY '\n'";
            Statement sta = conn.createStatement();
            sta.executeUpdate(sql);
            logger.info("stored !!!");
        } catch (SQLException ex) {
            logger.error("", ex);
        }
    }

    private static void deleteIndex() {
        try {
            sql = "delete from inverted_index";
            Statement sta = conn.createStatement();
            sta.executeUpdate(sql);
        } catch (SQLException ex) {
            logger.error("", ex);
        }
    }
}
