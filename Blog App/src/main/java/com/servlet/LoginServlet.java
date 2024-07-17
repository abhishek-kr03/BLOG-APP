package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog_app", "root", "root");

            String sql = "SELECT * FROM users WHERE email = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	String role = resultSet.getString("role");
                String hashedPassword = resultSet.getString("password");
                if (BCrypt.checkpw(password, hashedPassword)) {
                	
                	if(resultSet.getString("password") != null && hashedPassword.equals(resultSet.getString("password"))) {            	
                    HttpSession session = request.getSession(true);
                    session.setAttribute("user", resultSet.getString("name"));
                    session.setAttribute("role", resultSet.getString("role"));
                	}
                	
                    if ("Admin".equals(role)) {
                        response.sendRedirect("dashboard.jsp");
                    } else {
                        response.sendRedirect("listposts");
                    }
    
                } else {
                    response.sendRedirect("login.jsp?error=Invalid credentials. Try again.");
                }
            } else {
                response.sendRedirect("login.jsp?error=Invalid credentials. Try again.");
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=Login failed. Try again.");
        }
    }
}
