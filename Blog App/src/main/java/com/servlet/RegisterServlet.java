package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog_app", "root", "root");

            String sql = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, hashedPassword);
            statement.setString(4, role);

            statement.executeUpdate();
            conn.close();

            response.sendRedirect("login.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("register.jsp?error=Registration failed. Try again.");
        }
    }
}
