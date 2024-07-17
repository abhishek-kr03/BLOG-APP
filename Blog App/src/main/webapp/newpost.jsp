<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create New Post</title>
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
    <main>
        <div class="post-form-container fade-in">
            <h2>Create New Post</h2>
            <form action="createpost" method="post" enctype="multipart/form-data">
                <label for="title">Title:</label>
                <input type="text" id="title" name="title" required>
                <label for="content">Content:</label>
                <textarea id="content" name="content" required></textarea>
                <label for="image">Image:</label>
                <input type="file" id="image" name="image">
                <label for="video">Video:</label>
                <input type="file" id="video" name="video">
                <button type="submit">Create Post</button>
            </form>
        </div>
    </main>
</body>
</html>
