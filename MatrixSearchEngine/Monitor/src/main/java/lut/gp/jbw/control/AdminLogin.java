package lut.gp.jbw.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author vincent
 */
public class AdminLogin extends HttpServlet {

    private static final Logger logger = Logger.getLogger(AdminLogin.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uname = request.getParameter("username");
        String pw = request.getParameter("pw");
        String URL = "AdminLogin.jsp";
        if (uname != null && !"".equals(uname) && pw != null && !"".equals(pw)) {
            if (uname.trim().equals("admin") && pw.trim().equals("123qwe")) {
                URL = "WEB-INF/monitor.jsp";
            }
        }
        request.getRequestDispatcher(URL).forward(request, response);
    }
}
