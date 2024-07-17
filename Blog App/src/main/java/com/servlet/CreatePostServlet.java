package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/createpost")
@MultipartConfig
public class CreatePostServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Part imagePart = request.getPart("image");
        Part videoPart = request.getPart("video");

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

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog_app", "root", "root");

            String sql = "INSERT INTO posts (title, content, image_url, video_url) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, content);
            statement.setString(3, imageUrl);
            statement.setString(4, videoUrl);

            statement.executeUpdate();
            conn.close();

            response.sendRedirect("dashboard.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("newpost.jsp?error=Failed to create post. Try again.");
        }
    }
}
