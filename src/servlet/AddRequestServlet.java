package servlet;

import dao.RequestDAO;
import model.Request;
import model.Student;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;

public class AddRequestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("index.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");

        if (!"student".equals(user.getRole())) {
            resp.sendRedirect("index.jsp");
            return;
        }

        Student student = (Student) session.getAttribute("student");

        String subject = req.getParameter("subject");
        String description = req.getParameter("description");

        Request r = new Request(0, student.getStudentId(), subject, description, new Date());

        RequestDAO dao = new RequestDAO();
        dao.addRequest(r);

        resp.sendRedirect("studentDashboard.jsp");
    }
}
