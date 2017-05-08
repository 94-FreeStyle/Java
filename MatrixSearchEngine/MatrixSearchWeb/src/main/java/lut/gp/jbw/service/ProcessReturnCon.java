package lut.gp.jbw.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lut.gp.jbw.dao.ExecuteQuery;
import lut.gp.jbw.model.PageBean;
import lut.gp.jbw.model.ReturnRecord;

/**
 * 查询当前分页的文件记录
 *
 * @author vincent Apr 30, 2017 2:03:15 PM
 */
public class ProcessReturnCon {

    public static List<ReturnRecord> process(PageBean pb) {
        List<String> sortedRes = pb.getSortedUrls();//可能为空
        if (!sortedRes.isEmpty()) {
            Map<String, List<String>> uw = new HashMap<>();
            for (String s : sortedRes) {
                uw.put(s.split("\1")[0], Arrays.asList(s.split("\1")[1].split("\2")));
            }
            int curPageSize = pb.getCurrentPage() == pb.getTotalSize() ? sortedRes.size() % pb.getPAGESIZE() : pb.getPAGESIZE();
            pb.setCurPageSize(curPageSize);
            int startIndex = pb.getPAGESIZE() * (pb.getCurrentPage() - 1);
            int endIndex = startIndex + pb.getCurPageSize();
            List<String> searchUrls = new ArrayList<>();
            for (int i = startIndex; i < endIndex; i++) {
                searchUrls.add(sortedRes.get(i).split("\1")[0]);
            }
            List<ReturnRecord> searchRes = ExecuteQuery.selectPageCon(searchUrls);
            //处理内容（截取和关键字加颜色）  <em class="kw">kw</em>
            for (ReturnRecord rec : searchRes) {
                String url = rec.getUrl();
                String con = rec.getCon().replaceAll("(?m)^\\s*$(\\n|\\r\\n)", "");
                List<String> kws = uw.get(url);
                String res;
                if (con.length() > 180) {
                    int how = 180 / kws.size();
                    StringBuilder sb = new StringBuilder();
                    for (String kw : kws) {
                        int index = con.indexOf(kw);
                        int fb = how / 2;
                        int start = index - fb;
                        int end = index + fb;
                        String cc;
                        if (start <= 0) {
                            cc = con.substring(0, end);
                        } else if (end >= con.length()) {
                            cc = con.substring(start, con.length());
                        } else {
                            cc = con.substring(start, end);
                        }
                        sb.append(cc);
                    }
                    res = pstr(sb.toString(), kws);
                    System.out.println("con length:" + sb.length() + ":" + res);
                } else {
                    res = pstr(con, kws);
                }
                rec.setCon(res);
            }
            return searchRes;
        } else {
            return null;
        }
    }

    private static String pstr(String con, List<String> kws) {
        StringBuilder sb = new StringBuilder();
        int i = (int) Math.ceil(con.length() / 60.0);
        for (int j = 0; j < i; j++) {
            String cs;
            if (j == i - 1 || con.length() == 0) {
                cs = con + "...";
                if (j != 0) {
                    cs = con.substring(j * 60, con.length()) + "...";
                }
            } else {
                cs = con.substring(j * 60, j * 60 + 60) + "<br/>";
            }
            for (String kw : kws) {
                cs = cs.replaceAll(kw, "<em class=\"kw\">" + kw + "</em>");
            }
            sb.append(cs);
        }
        return sb.toString();
    }
}
