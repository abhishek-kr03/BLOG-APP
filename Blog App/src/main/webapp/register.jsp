<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="CSS/signin.css">
    <style>
    	.register-container {
		    background: #fff;
		    padding: 20px;
		    border-radius: 10px;
		    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
		    text-align: center;
		    width: 300px;
		    margin-top: 50px;
		    animation: fadeIn 1s ease-in-out;
			}			
		@keyframes fadeIn {
			    from { opacity: 0; transform: translateY(-20px); }
			    to { opacity: 1; transform: translateY(0); }
			}
    </style>
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

    <div class="register-container fade-in">
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
            <p><a href="login.jsp">Already have an account! Login</a></p>
        </form>
    </div>
</body>
</html>
