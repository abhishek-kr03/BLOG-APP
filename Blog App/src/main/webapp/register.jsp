<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="CSS/signin.css">
</head>
<body>
    <header>
        <nav>
            <div class="logo">Blog</div>
            <ul class="nav-links">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="login.jsp">Login</a></li>
            </ul>
        </nav>
    </header>

    <div class="register-container">
        <h2>Register</h2>
        <form action="register" method="post">
            <label for="name">Full Name:</label>
            <input type="text" id="name" name="name" required>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            <label for="role">Role:</label>
            <select id="role" name="role" required>
                <option value="" disabled selected>Select Role</option>
                <option value="Admin">Admin</option>
                <option value="Viewer">Viewer</option>
            </select>
            <button type="submit">Register</button>
        </form>
    </div>
</body>
</html>
