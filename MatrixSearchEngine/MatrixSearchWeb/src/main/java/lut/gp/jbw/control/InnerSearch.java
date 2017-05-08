package lut.gp.jbw.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lut.gp.jbw.model.PageBean;
import org.apdplat.word.segmentation.Word;
import lut.gp.jbw.util.WordSegmenterUtil;
import lut.gp.jbw.service.ProcessSearch;

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
            List<Word> searchCon = WordSegmenterUtil.segmenterWithStopWords(requestParams);
            List<String> sortedRes = ProcessSearch.process(searchCon);
            PageBean pb = new PageBean();
            pb.setSortedUrls(sortedRes);
            int yu = sortedRes.size() % pb.getPAGESIZE();
            int ss = sortedRes.size() / pb.getPAGESIZE();
            int totalPage = yu == 0 ? ss : ss + 1;
            pb.setTotalSize(totalPage);
            request.getSession().setAttribute("pagebean", pb);
            request.setAttribute("starttime", startTime);
        } else {
            url = "index.html";
        }
        request.getRequestDispatcher(url).forward(request, response);
    }
}
