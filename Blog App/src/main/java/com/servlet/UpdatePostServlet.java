package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.model.Post;

@WebServlet("/updatepost")
@MultipartConfig
public class UpdatePostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/blog_app";
        String dbUser = "root";
        String dbPassword = "root";
        return DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
    }

    private Post getPostById(int id) {
        Post post = null;
        String query = "SELECT * FROM posts WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                post = new Post();
                post.setId(resultSet.getInt("id"));
                post.setTitle(resultSet.getString("title"));
                post.setContent(resultSet.getString("content"));
                post.setImageUrl(resultSet.getString("image_url"));
                post.setVideoUrl(resultSet.getString("video_url"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    private void updatePost(Post post) {
        String query = "UPDATE posts SET title = ?, content = ?, image_url = ?, video_url = ? WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, post.getTitle());
            preparedStatement.setString(2, post.getContent());
            preparedStatement.setString(3, post.getImageUrl());
            preparedStatement.setString(4, post.getVideoUrl());
            preparedStatement.setInt(5, post.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String postId = request.getParameter("id");
        System.out.println("Received post ID: " + postId); // Debug statement

        if (postId == null || postId.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing or invalid post ID.");
            return;
        }

        try {
            int id = Integer.parseInt(postId);
            Post post = getPostById(id);

            if (post == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Post not found.");
                return;
            }

            request.setAttribute("post", post);
            request.getRequestDispatcher("updatepost.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid post ID format.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        // File upload handling
        Part imagePart = request.getPart("imageUrl");
        Part videoPart = request.getPart("videoUrl");

        String imageUrl = null;
        String videoUrl = null;

     // Upload image and video files to the server
        if (imagePart != null && imagePart.getSize() > 0) {
            imageUrl = "uploads/" + imagePart.getSubmittedFileName();
            imagePart.write(getServletContext().getRealPath("/") + imageUrl);
        }
        if (videoPart != null && videoPart.getSize() > 0) {
            videoUrl = "uploads/" + videoPart.getSubmittedFileName();
            videoPart.write(getServletContext().getRealPath("/") + videoUrl);
        }

        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setContent(content);
        post.setImageUrl(imageUrl);
        post.setVideoUrl(videoUrl);

        updatePost(post);
        
        response.sendRedirect("listposts"); // Redirect to the post listing page after update
    }
}
