package lut.gp.jbw.model;

import java.util.List;

/**
 *
 * @author vincent Apr 30, 2017 2:37:11 PM
 */
public class PageBean {

    private final int PAGESIZE = 10;
    private int totalSize;
    private int currentPage;
    private int curPageSize;
    private List<String> sortedUrls;

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setCurPageSize(int curPageSize) {
        this.curPageSize = curPageSize;
    }

    public void setSortedUrls(List<String> sortedUrls) {
        this.sortedUrls = sortedUrls;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPAGESIZE() {
        return PAGESIZE;
    }

    public int getCurPageSize() {
        return curPageSize;
    }

    public List<String> getSortedUrls() {
        return sortedUrls;
    }

    public int getTotalSize() {
        return totalSize;
    }

}
