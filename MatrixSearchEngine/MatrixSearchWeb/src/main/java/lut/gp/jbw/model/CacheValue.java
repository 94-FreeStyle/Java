package lut.gp.jbw.model;

/**
 *
 * @author vincent May 9, 2017 3:10:51 PM
 */
public class CacheValue {

    private long addTime;
    private long searchTime;
    private PageBean pages;

    public CacheValue() {
    }

    public CacheValue(long addTime, long searchTime, PageBean pages) {
        this.addTime = addTime;
        this.searchTime = searchTime;
        this.pages = pages;
    }

    public void setSearchTime(long searchTime) {
        this.searchTime = searchTime;
    }

    public long getSearchTime() {
        return searchTime;
    }

    public long getAddTime() {
        return addTime;
    }

    public PageBean getPages() {
        return pages;
    }

    public void setAddTime(long addTime) {
        this.addTime = addTime;
    }

    public void setPages(PageBean pages) {
        this.pages = pages;
    }
}
