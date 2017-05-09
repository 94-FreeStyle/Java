package lut.gp.jbw.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author vincent Apr 2, 2017 7:41:21 PM
 */
public class GoURL extends HttpServlet {
    
    private static final Logger logger = Logger.getLogger(GoURL.class);
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requstURL = request.getParameter("url");
        logger.info("request:" + request.getRemoteAddr() + "\t" + requstURL);
        response.sendRedirect(requstURL);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
