<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="CSS/dashboard.css">
</head>
<body>
    <header>
        <nav>
            <div class="logo">Blog</div>
            <ul class="nav-links">
                <li><a href="listposts">Home</a></li>
                <li><a href="logout">Logout</a></li>
            </ul>
        </nav>
    </header>
    <main class="hero">
        <div class="dashboard-container fade-in">
            <h2>Dashboard</h2>
            <p>Welcome, <%= session.getAttribute("user") %>!</p>
            <p>Role: <%= session.getAttribute("role") %></p>
            <div class="dashboard-links">
                <a href="newpost.jsp" class="btn">New Posts</a>
                <a href="listposts" class="btn">View Posts</a>
            </div>
        </div>
    </main>
</body>
</html>
