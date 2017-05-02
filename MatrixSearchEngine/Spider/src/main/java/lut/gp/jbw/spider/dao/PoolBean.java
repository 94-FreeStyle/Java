package lut.gp.jbw.spider.dao;

/**
 *
 * @author vincent Apr 29, 2017 9:50:33 PM
 */
public class PoolBean {

    private String driverName;
    private String url;
    private String userName;
    private String password;
    private int minConnections;
    private int maxConnections;

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public void setMinConnections(int minConnections) {
        this.minConnections = minConnections;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDriverName() {
        return driverName;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public int getMinConnections() {
        return minConnections;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public String getUserName() {
        return userName;
    }
}
