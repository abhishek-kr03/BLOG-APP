package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Post;

@WebServlet("/searchservlet")
public class SearchServlet extends HttpServlet {
    // Database connection parameters
    private String url = "jdbc:mysql://localhost:3306/blog_app";
    private String username = "root";
    private String password = "root";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String query = request.getParameter("query");

        if (query != null && !query.isEmpty()) {
            List<Post> searchResults = searchPosts(query);

            request.setAttribute("searchResults", searchResults);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
        dispatcher.forward(request, response);
    }

    private List<Post> searchPosts(String query) {
        List<Post> posts = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM `posts` WHERE `title` LIKE ? OR `created_at` LIKE ?")) {
        	statement.setString(1, "%" + query + "%");
        	statement.setString(2, "%" + query + "%");
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }
}
