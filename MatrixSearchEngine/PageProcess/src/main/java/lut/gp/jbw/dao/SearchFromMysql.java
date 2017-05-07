package lut.gp.jbw.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import lut.gp.jbw.util.dao.ConnectionPoolManager;
import org.apache.log4j.Logger;

/**
 *
 * @author vincent May 1, 2017 4:44:11 PM
 */
public class SearchFromMysql {

    private static final Logger logger = Logger.getLogger(SearchFromMysql.class);
    private static final Connection conn = ConnectionPoolManager.getInstance().getConnection();
    private static String sql = "";

    public static String serachURL(String localPath) {
        String url = "";
        try {
            sql = "select url from mse.page_url where local_path='" + localPath + "'";
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                url = rs.getString("url");
            }
        } catch (SQLException ex) {
            logger.error("", ex);
        }
        return url;
    }

    public static Set<String> serachAllURL() {
        Set<String> urls = new HashSet<>();
        try {
            sql = "select url from mse.page_url";
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                urls.add(rs.getString("url"));
            }
        } catch (SQLException ex) {
            logger.error("", ex);
        }
        return urls;
    }

    public static Map<String, Set<String>> serachLinks() {
        Map<String, Set<String>> pageRankData = new ConcurrentHashMap<>();
        try {
            sql = "select url, link from mse.page_links";
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                String url = rs.getString("url");
                String link = rs.getString("link");
                if (!pageRankData.containsKey(url)) {
                    pageRankData.put(url, new HashSet<>());
                }
                pageRankData.get(url).add(link);
            }
        } catch (SQLException ex) {
            logger.error("", ex);
        }
        return pageRankData;
    }

    public static Map<String, String> serachUC(Timestamp time) {
        Map<String, String> urlCon = new HashMap<>();
        try {
            sql = "select url, con from mse.page_info where got_time > '" + time.toString() + "'";
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                String url = rs.getString("url");
                String con = rs.getString("con");
                urlCon.put(url, con);
            }
        } catch (SQLException ex) {
            logger.error("", ex);
        }
        return urlCon;
    }

    public static Timestamp serachLastUpdateTime(Timestamp time) {
        Timestamp lastTime = null;
        try {
            sql = "select max(got_time) from mse.page_info where got_time > '" + time.toString() + "'";
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                lastTime = rs.getTimestamp(1);
            }
        } catch (SQLException ex) {
            logger.error("", ex);
        }
        return lastTime;
    }

    public static Map<String, String> serachUC() {
        Map<String, String> urlCon = new HashMap<>();
        try {
            sql = "select url, con from mse.page_info";
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                String url = rs.getString("url");
                String con = rs.getString("con");
                urlCon.put(url, con);
            }
        } catch (SQLException ex) {
            logger.error("", ex);
        }
        return urlCon;
    }

    public static Map<String, Set<String>> processLinks() {
        Map<String, Set<String>> res = new HashMap<>();
        Map<String, Set<String>> pageRankData = serachLinks();
        Map<String, String> urlId = getUrlId();
        //调用计算PageRank(url, rank),计算时去除key中不存在的url
        pageRankData.keySet().forEach((url) -> {
            Iterator<String> it = pageRankData.get(url).iterator();
            while (it.hasNext()) {
                String link = it.next();
                if (!pageRankData.keySet().contains(link)) {
                    it.remove();
                }
            }
        });

        return res;
    }

    public static Map<String, String> getUrlId() {
        Map<String, String> urlCon = new HashMap<>();
        try {
            sql = "select id, url from mse.page_info";
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("id");
                String url = rs.getString("url");
                urlCon.put(url, id);
            }
        } catch (SQLException ex) {
            logger.error("", ex);
        }
        return urlCon;
    }
}
