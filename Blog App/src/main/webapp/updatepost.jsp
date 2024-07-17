<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.model.Post" %>
<%
    Post post = (Post) request.getAttribute("post");
    if (post == null) {
        throw new NullPointerException("Post object is null. Ensure the servlet sets the post attribute correctly.");
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Post</title>
    <link rel="stylesheet" href="CSS/newpost.css">
</head>
<body>
	 <header>
        <nav>
            <div class="logo">Blog</div>
            <ul class="nav-links">
                <li><a href="listposts">Home</a></li>
                <li><a href="logout">Logout</a></li>
            </ul>
        </nav>
    </header>
    <div class="post-form-container fade-in">
        <h2>Update Post</h2>
        <form action="updatepost" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="<%= post.getId() %>">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" value="<%= post.getTitle() %>" required>
            <label for="content">Content:</label>
            <textarea id="content" name="content" required><%= post.getContent() %></textarea>
            <label for="image">Image URL:</label>
            <input type="file" id="image" name="imageUrl" value="<%= post.getImageUrl() %>">
            <label for="video">Video URL:</label>
            <input type="file" id="video" name="videoUrl" value="<%= post.getVideoUrl() %>">
            <button type="submit">Update Post</button>
        </form>
    </div>
</body>
</html>