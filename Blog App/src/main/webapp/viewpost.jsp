<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.model.Post" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Post</title>
    <link rel="stylesheet" href="CSS/viewpost.css">
</head>
<body>
    <main>
        <section class="post-details fade-in">
            <%
                Post post = (Post) request.getAttribute("post");
                if (post != null) {
            %>
                <div class="post-item">
                    <h2><%= post.getTitle() %></h2>
                    <p><%= post.getContent() %></p>
                    <% if (post.getImageUrl() != null) { %>
                        <img src="<%= post.getImageUrl() %>" alt="Image">
                    <% } %>
                    <% if (post.getVideoUrl() != null) { %>
                        <video controls>
                            <source src="<%= post.getVideoUrl() %>" type="video/mp4">
                        </video>
                    <% } %>
                    <p>Posted on: <%= post.getCreatedAt() %></p>
                    <%-- Add more post details as needed --%>
                </div>
            <% 
                } else {
                    out.println("Post not found.");
                }
            %>
        </section>
    </main>
</body>
</html>
