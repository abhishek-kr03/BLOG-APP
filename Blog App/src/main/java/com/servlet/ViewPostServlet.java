package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Post;

@WebServlet("/viewpost")
public class ViewPostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int postId = Integer.parseInt(request.getParameter("id"));
        Post post = null;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog_app", "root", "root");

            String sql = "SELECT * FROM posts WHERE id = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, postId);

            rs = statement.executeQuery();
            if (rs.next()) {
                post = new Post();
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setImageUrl(rs.getString("image_url"));
                post.setVideoUrl(rs.getString("video_url"));
                post.setCreatedAt(rs.getTimestamp("created_at"));
            } else {
                // Handle case where post with given ID is not found
                response.getWriter().println("Post not found.");
                return; // Exit method
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions properly (e.g., log, show error page)
            response.getWriter().println("Error retrieving post details.");
            return; // Exit method
        } finally {
            try {
                if (rs != null) rs.close();
                if (statement != null) statement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        request.setAttribute("post", post);
        request.getRequestDispatcher("viewpost.jsp").forward(request, response);
    }
}
