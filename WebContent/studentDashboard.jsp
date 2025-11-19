<%@ page import="java.util.*, dao.NoticeDAO, model.Notice, model.User, model.Student" %>
<%
    User user = (User) session.getAttribute("user");
    Student student = (Student) session.getAttribute("student");

    if (user == null || !"student".equals(user.getRole())) {
        response.sendRedirect("index.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Student Dashboard - CampusConnect</title>
    <style>
        body { font-family: Arial; padding: 20px; }
        .box { border: 1px solid #ccc; padding: 20px; margin-bottom: 25px; }
        input, textarea { width: 100%; padding: 10px; margin-top: 10px; }
        button { padding: 10px; margin-top: 10px; background: #0066cc; color: white; border: none; cursor: pointer; }
        .title { font-size: 20px; margin-bottom: 10px; }
        a.logout { float: right; text-decoration: none; color: red; font-weight: bold; }
    </style>
</head>

<body>

<h2>Welcome Student: <%= student.getName() %></h2>
<a class="logout" href="LogoutServlet">Logout</a>
<br><br>

<!-- Submit Request -->
<div class="box">
    <div class="title">Submit Request to Admin</div>
    <form action="AddRequestServlet" method="post">
        <input type="text" name="subject" placeholder="Request Subject" required>
        <textarea name="description" placeholder="Request Description" rows="4" required></textarea>
        <button type="submit">Submit</button>
    </form>
</div>

<!-- View Notices -->
<div class="box">
    <div class="title">College Notices</div>

    <%
        NoticeDAO dao = new NoticeDAO();
        List<Notice> notices = dao.getAllNotices();
        for (Notice n : notices) {
    %>
        <div style="border-bottom:1px solid #ddd; padding:10px 0;">
            <b><%= n.getTitle() %></b><br>
            <%= n.getMessage() %><br>
            <small><i><%= n.getDateCreated() %></i></small>
        </div>
    <% } %>
</div>

</body>
</html>
