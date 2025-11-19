<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>CampusConnect - Login</title>
    <style>
        body {
            font-family: Arial;
            background: #f3f3f3;
            padding: 50px;
        }
        .container {
            width: 350px;
            margin: auto;
            background: white;
            padding: 25px;
            border-radius: 8px;
            box-shadow: 0 0 10px #ccc;
        }
        input, button {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
        }
        button {
            background: #2b6be4;
            color: white;
            border: none;
            cursor: pointer;
        }
        .error { color: red; }
    </style>
</head>

<body>

<div class="container">
    <h2>CampusConnect Login</h2>

    <form action="LoginServlet" method="post">
        <input type="text" name="username" placeholder="Enter Username" required>
        <input type="password" name="password" placeholder="Enter Password" required>
        <button type="submit">Login</button>

        <% 
            String error = (String) request.getAttribute("error");
            if (error != null) { 
        %>
            <p class="error"><%= error %></p>
        <% } %>
    </form>
</div>

</body>
</html>
