<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="CSS/signin.css">
    <style>
	 	.login-container {
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
                <li><a href="register.jsp">Register</a></li>
            </ul>
        </nav>
    </header>

    <div class="login-container">
        <h2>Login</h2>
        <form action="login" method="post">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            <button type="submit">Login</button>
        </form>
        <p><a href="login.jsp">Forgot Password?</a></p>
        <p><a href="register.jsp">Don't have an account! Register</a></p>
    </div>
</body>
</html>
