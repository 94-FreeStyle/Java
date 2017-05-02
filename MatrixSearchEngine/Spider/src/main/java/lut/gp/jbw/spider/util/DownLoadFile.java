package lut.gp.jbw.spider.util;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import lut.gp.jbw.spider.dao.StoreToMySQL;
import lut.gp.jbw.spider.pojo.ResponseCT;
import org.apache.log4j.Logger;

/**
 *
 * @author vincent Apr 2, 2017 2:22:59 PM
 */
public class DownLoadFile {

    private static final Logger logger = Logger.getLogger(DownLoadFile.class);

    /**
     * 根据 URL 和网页类型生成需要保存的网页的文件名， 去除 URL 中的非文件名字符
     *
     * @param url
     * @param contentType
     * @return
     */
    public String getFileNameByUrl(String ourl, String contentType) {
        String url = ourl;
        if (ourl == null || contentType == null) {
            return url.replaceAll("[\\?/:*|<>\"]", "_");
        }
        //移除http:
        url = url.substring(7);
        //text/html类型
        if (contentType.contains("html")) {
            url = url.replaceAll("[\\?/:*|<>\"]", "_") + ".html";
            StoreToMySQL.storeURL(ourl, url);
            return url;
        } else {
            //如application/pdf类型
            return url.replaceAll("[\\?/:*|<>\"]", "_") + "." + contentType.substring(contentType.lastIndexOf("/") + 1);
        }
    }

    /**
     * 保存网页字节数组到本地文件， filePath 为要保存的文件的相对地址
     */
    private void saveToLocal(byte[] data, String filePath) {
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(new FileOutputStream(new File(filePath)));
            for (int i = 0; i < data.length; i++) {
                out.write(data[i]);
            }
            out.flush();
        } catch (FileNotFoundException ex) {
            logger.error("", ex);
        } catch (IOException ex) {
            logger.error("", ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                logger.error("", ex);
            }
        }
    }

    // 下载 URL 指向的网页
    public ResponseCT downloadFile(String url, String filePath) throws IOException, URISyntaxException {
        ResponseCT res = HttpClientUtil.httpGetRequest(url);
        if (res != null) {
            String savePath = filePath + getFileNameByUrl(url, res.getType());
            saveToLocal(res.getCon(), savePath);
        }
        return res;
    }
}
