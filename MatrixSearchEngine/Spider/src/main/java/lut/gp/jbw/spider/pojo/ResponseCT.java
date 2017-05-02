package lut.gp.jbw.spider.pojo;

/**
 *
 * @author vincent Apr 3, 2017 1:27:04 PM
 */
public class ResponseCT {

    private byte[] con = null;
    private String type = null;

    public ResponseCT() {
    }

    public ResponseCT(byte[] con, String type) {
        this.con = con;
        this.type = type;
    }

    public byte[] getCon() {
        return con;
    }

    public String getType() {
        return type;
    }

    public void setCon(byte[] con) {
        this.con = con;
    }

    public void setType(String type) {
        this.type = type;
    }
}
