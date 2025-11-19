<%@ page import="java.util.*, dao.NoticeDAO, dao.RequestDAO, model.Notice, model.Request, model.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null || !"admin".equals(user.getRole())) {
        response.sendRedirect("index.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard - CampusConnect</title>
    <style>
        body { font-family: Arial; padding: 20px; }
        .box { border: 1px solid #ccc; padding: 20px; margin-bottom: 25px; }
        input, textarea { width: 100%; padding: 10px; margin-top: 10px; }
        button { padding: 10px; margin-top: 10px; background: #2d8b00; color: white; border: none; cursor: pointer; }
        .title { font-size: 20px; margin-bottom: 10px; }
        a.logout { float: right; text-decoration: none; color: red; font-weight: bold; }
    </style>
</head>

<body>

<h2>Welcome Admin: <%= user.getUsername() %></h2>
<a class="logout" href="LogoutServlet">Logout</a>
<br><br>

<!-- Add Notice -->
<div class="box">
    <div class="title">Publish New Notice</div>
    <form action="AddNoticeServlet" method="post">
        <input type="text" name="title" placeholder="Notice Title" required>
        <textarea name="message" placeholder="Notice Message" rows="4" required></textarea>
        <button type="submit">Publish Notice</button>
    </form>
</div>

<!-- View Notices -->
<div class="box">
    <div class="title">All Notices</div>

    <%
        NoticeDAO ndao = new NoticeDAO();
        List<Notice> notices = ndao.getAllNotices();
        for (Notice n : notices) {
    %>
        <div style="border-bottom:1px solid #ddd; padding:10px 0;">
            <b><%= n.getTitle() %></b><br>
            <%= n.getMessage() %><br>
            <small><i><%= n.getDateCreated() %></i></small>
        </div>
    <% } %>
</div>

<!-- View Student Requests -->
<div class="box">
    <div class="title">Student Requests</div>

    <%
        RequestDAO rdao = new RequestDAO();
        List<Request> reqList = rdao.getAllRequests();
        for (Request r : reqList) {
    %>
        <div style="border-bottom:1px solid #ddd; padding:10px 0;">
            <b>Subject: </b> <%= r.getSubject() %> <br>
            <b>Description: </b> <%= r.getDescription() %> <br>
            <small>Request ID: <%= r.getRequestId() %> | Student ID: <%= r.getStudentId() %></small>
        </div>
    <% } %>
</div>

</body>
</html>
