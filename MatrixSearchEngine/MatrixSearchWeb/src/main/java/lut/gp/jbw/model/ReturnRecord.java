package lut.gp.jbw.model;

/**
 *
 * @author vincent Apr 30, 2017 1:31:53 AM
 */
public class ReturnRecord {

    private String title;
    private String url;
    private String keywords;
    private String con;
    private String date;

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

    public String getUrl() {
        return url;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return this.con + "," + this.date + "," + this.keywords + "," + this.title + "," + this.url;
    }
}
