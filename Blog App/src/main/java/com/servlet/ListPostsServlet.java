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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.model.Post;

@WebServlet("/listposts")
public class ListPostsServlet extends HttpServlet {
	private static final long serialVersionUID = 2698194270731226755L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Post> posts = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog_app", "root", "root");

            String sql = "SELECT * FROM posts ORDER BY created_at DESC";
            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Post post = new Post();
                post.setId(resultSet.getInt("id"));
                post.setTitle(resultSet.getString("title"));
                post.setContent(resultSet.getString("content"));
                post.setImageUrl(resultSet.getString("image_url"));
                post.setVideoUrl(resultSet.getString("video_url"));
                post.setCreatedAt(resultSet.getTimestamp("created_at"));
                posts.add(post);
            }
            conn.close();

            request.setAttribute("posts", posts);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("index.jsp?error=Failed to load posts.");
        }
    }
}
