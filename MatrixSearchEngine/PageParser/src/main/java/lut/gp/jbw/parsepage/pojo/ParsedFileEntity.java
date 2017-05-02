package lut.gp.jbw.parsepage.pojo;

import java.util.Map;
import java.util.Set;

/**
 *
 * @author vincent Apr 3, 2017 9:32:13 PM
 */
public class ParsedFileEntity {

    private String url;
    private Set<String> links;
    private Map<String, Integer> wc;
    private String con;
    private String title;
    private String keywords;
    private String date;

    public ParsedFileEntity() {
        this.url = "NULL";
        this.links = null;
        this.wc = null;
        this.con = "NULL";
        this.title = "NULL";
        this.keywords = "NULL";
        this.date = "NULL";
    }

    public ParsedFileEntity(String url, Set<String> links, Map<String, Integer> wc, String con, String title, String keywords, String date) {
        this.url = url;
        this.links = links;
        this.wc = wc;
        this.con = con;
        this.title = title;
        this.keywords = keywords;
        this.date = date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public void setLinks(Set<String> links) {
        this.links = links;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setWc(Map<String, Integer> wc) {
        this.wc = wc;
    }

    public String getCon() {
        return con;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public Set<String> getLinks() {
        return links;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, Integer> getWc() {
        return wc;
    }
}
