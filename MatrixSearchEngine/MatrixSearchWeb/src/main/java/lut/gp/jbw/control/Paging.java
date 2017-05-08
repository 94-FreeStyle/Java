package lut.gp.jbw.control;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        String url = "main.jsp";
        String pagenumS = request.getParameter("page");
        int pagenum = 1;
        if (pagenumS != null) {
            pagenum = Integer.parseInt(pagenumS.trim());
        }
        PageBean pb = (PageBean) request.getSession().getAttribute("pagebean");
        pb.setCurrentPage(pagenum);
        List<ReturnRecord> returnRes = ProcessReturnCon.process(pb);
        if (returnRes != null) {
            if (request.getAttribute("starttime") != null) {
                long startTime = (Long) request.getAttribute("starttime");
                long endTime = System.nanoTime();
                request.getSession().setAttribute("time", (endTime - startTime) / 1000000);
            }
            request.setAttribute("res", returnRes);
            request.setAttribute("pb", pb);
            request.setAttribute("flag", 1);
        } else {
            request.setAttribute("flag", 0);
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
