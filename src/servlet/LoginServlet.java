package servlet;

import dao.UserDAO;
import dao.StudentDAO;
import model.User;
import model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDAO userDAO = new UserDAO();
        StudentDAO studentDAO = new StudentDAO();

        User user = userDAO.login(username, password);

        if (user == null) {
            req.setAttribute("error", "Invalid username or password");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            return;
        }

        HttpSession session = req.getSession();
        session.setAttribute("user", user);

        if (user.getRole().equals("admin")) {
            resp.sendRedirect("adminDashboard.jsp");
        } else if (user.getRole().equals("student")) {

            Student student = studentDAO.getStudentByUserId(user.getUserId());
            session.setAttribute("student", student);

            resp.sendRedirect("studentDashboard.jsp");
        }
    }
}
