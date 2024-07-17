package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Post;

public class PostDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/blog_app";
    private String dbUser = "root";
    private String dbPassword = "root";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
    }

    public List<Post> getPosts(int offset, int limit) {
        List<Post> posts = new ArrayList<>();
        String query = "SELECT * FROM posts LIMIT ? OFFSET ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, limit);
            preparedStatement.setInt(2, offset);
            ResultSet resultSet = preparedStatement.executeQuery();

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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    public int getPostCount() {
        String query = "SELECT COUNT(*) FROM posts";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
