package lut.gp.jbw.utils;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;

/**
 *
 * @author vincent May 7, 2017 1:34:35 PM
 */
public class Test01 {

    @Test
    public void testFile() {
        File file = new File("F:\\work\\MD5.py");
        long time = file.lastModified();
        System.out.println("last modify:" + time);
        System.out.println("date:" + new Date(time));
        Timestamp t = new Timestamp(0);
        System.out.println("xxoo:" + t.toString());
    }
}
