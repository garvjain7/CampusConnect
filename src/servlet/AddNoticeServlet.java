package servlet;

import dao.NoticeDAO;
import model.Notice;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;

public class AddNoticeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("index.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");

        if (!"admin".equals(user.getRole())) {
            resp.sendRedirect("index.jsp");
            return;
        }

        String title = req.getParameter("title");
        String message = req.getParameter("message");

        Notice notice = new Notice(0, title, message, new Date());

        NoticeDAO dao = new NoticeDAO();
        dao.addNotice(notice);

        resp.sendRedirect("adminDashboard.jsp");
    }
}
