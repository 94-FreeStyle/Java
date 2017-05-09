package lut.gp.jbw.control;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lut.gp.jbw.model.CacheKey;
import lut.gp.jbw.model.CacheValue;
import lut.gp.jbw.model.PageBean;
import lut.gp.jbw.util.WordSegmenterUtil;
import lut.gp.jbw.service.ProcessInnerSearch;

/**
 *
 * @author vincent Apr 2, 2017 7:41:21 PM
 */
public class InnerSearch extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        long startTime = System.nanoTime();
        //依据search的内容分词查询
        String requestParams = request.getParameter("search").replaceAll("(?m)^\\s*$(\\n|\\r\\n)", "");//去掉所有空客
        String url = "/paging";
        if (requestParams.length() != 0) {
            if (requestParams.length() > 65) {
                requestParams = requestParams.substring(0, 64);
            }
            List<String> searchCon = WordSegmenterUtil.segmenterWithStopWords(requestParams);
            //判断缓存中是否存在，若缓存命不中才继续处理
            Map<CacheKey, CacheValue> cache = (Map<CacheKey, CacheValue>) this.getServletContext().getAttribute("searchPB");
            if (!cache.containsKey(new CacheKey(searchCon))) {
                PageBean pb = new PageBean();
                List<String> sortedRes = ProcessInnerSearch.process(searchCon);
                pb.setSortedUrls(sortedRes);
                int yu = sortedRes.size() % pb.getPAGESIZE();
                int ss = sortedRes.size() / pb.getPAGESIZE();
                int totalPage = yu == 0 ? ss : ss + 1;
                pb.setTotalSize(totalPage);
                request.setAttribute("starttime", startTime);
                //设定缓存大小为可以存储最近的500个查询，定义缓存更新策略，这里先采用移除时移除最早加入的
                //或者设置一个时间阈值（比如30min），把当前时间减去缓存的addTime如果大于阈值则删除，这个更科学一点，但是怕内存受不了
                //应当在系统启动的时候启动一个线程专门处理更新缓存比每一次查询是就更新更合理
                cache.put(new CacheKey(searchCon), new CacheValue(System.currentTimeMillis(), 0, pb));
            }
            String con = "";
            for (int i = 0; i < searchCon.size(); i++) {
                if (i == searchCon.size() - 1) {
                    con += searchCon.get(i);
                } else {
                    con += searchCon.get(i) + "\1";
                }
            }
            request.setAttribute("con", con);
        } else {
            url = "index.html";
        }
        request.getRequestDispatcher(url).forward(request, response);
    }
}
