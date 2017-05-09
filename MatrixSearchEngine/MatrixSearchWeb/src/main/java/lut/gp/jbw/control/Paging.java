package lut.gp.jbw.control;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lut.gp.jbw.model.CacheKey;
import lut.gp.jbw.model.CacheValue;
import lut.gp.jbw.model.PageBean;
import lut.gp.jbw.model.ReturnRecord;
import lut.gp.jbw.service.ProcessReturnCon;

/**
 *
 * @author vincent
 */
@WebServlet(name = "Paging", urlPatterns = {"/paging"})
public class Paging extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String url = "main.jsp";
        String pagenumS = request.getParameter("page");
        String searchCon = request.getParameter("con");
        if (searchCon == null) {
            searchCon = (String) request.getAttribute("con");
        }
        List<String> ws = Arrays.asList(searchCon.split("\1"));
        int pagenum = 1;
        if (pagenumS != null) {
            pagenum = Integer.parseInt(pagenumS.trim());
        }
        Map<CacheKey, CacheValue> searchpbPB = (Map<CacheKey, CacheValue>) this.getServletContext().getAttribute("searchPB");
        PageBean pb = searchpbPB.get(new CacheKey(ws)).getPages();
        pb.setCurrentPage(pagenum);
        List<ReturnRecord> returnRes = ProcessReturnCon.process(pb);
        if (returnRes != null) {
            if (request.getAttribute("starttime") != null) {
                long startTime = (Long) request.getAttribute("starttime");
                long endTime = System.nanoTime();
                searchpbPB.get(new CacheKey(ws)).setSearchTime((endTime - startTime) / 1000000);
            }
            request.setAttribute("res", returnRes);
            request.setAttribute("pb", pb);
            request.setAttribute("flag", 1);
            request.setAttribute("time", searchpbPB.get(new CacheKey(ws)).getSearchTime());
            request.setAttribute("con", searchCon);
        } else {
            request.setAttribute("flag", 0);
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}
