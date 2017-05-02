package lut.gp.jbw.service;

import java.util.ArrayList;
import java.util.List;
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
            int curPageSize = pb.getCurrentPage() == pb.getTotalSize() ? sortedRes.size() % pb.getPAGESIZE() : pb.getPAGESIZE();
            pb.setCurPageSize(curPageSize);
            int startIndex = pb.getPAGESIZE() * (pb.getCurrentPage() - 1);
            int endIndex = startIndex + pb.getCurPageSize();
            List<String> searchUrls = new ArrayList<>();
            for (int i = startIndex; i < endIndex; i++) {
                searchUrls.add(sortedRes.get(i));
            }
            List<ReturnRecord> searchRes = ExecuteQuery.selectPageCon(searchUrls);
            return searchRes;
        } else {
            return null;
        }
    }
}
