<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.model.Post" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Results</title>
    <link rel="stylesheet" href="CSS/styles.css">
    <style type="text/css">
    
    .hero {
    text-align: center;
    display: flex;
    padding: 50px 50px;
    width: 100%;
    justify-content: space-around;
    
    </style>
</head>
<body>
    <header>
        <nav>
            <a href="listposts"><div class="logo">Blog</div></a>
            <ul class="nav-links">
            	<form action="searchservlet" method="GET" class="search-form">
	                    <input type="text" name="query" placeholder="Search blog posts..." class="search-bar">
	                    <button type="submit">Search</button>
	            </form>
                <li><a href="listposts">Home</a></li>
                <li><a href="logout">Logout</a></li>
            </ul>
        </nav>
    </header>
    <h1>Search Results</h1>
    <main>
        <section class="hero fade-in">
            <% List<Post> searchResults = (List<Post>) request.getAttribute("searchResults");
               if (searchResults != null && !searchResults.isEmpty()) {
                   for (Post post : searchResults) { %>
                       <div class="gallery-item">
                           <div class="gallery-item-info">
                               <h3><%= post.getTitle() %></h3>
                               <p><%= post.getContent() %></p>
                               <% if (post.getImageUrl() != null) { %>
                                    <img src="<%= post.getImageUrl() %>" alt="Image"> <br>
                                <% } %>
                                <% if (post.getVideoUrl() != null) { %>
                                    <video controls>
                                        <source src="<%= post.getVideoUrl() %>" type="video/mp4">
                                    </video>
                                <% } %>
                                <span>Posted on: <%= post.getCreatedAt() %></span>
                           </div>
                       </div>
            <%     }
               } else { %>
                   <p>No results found for "<%= request.getParameter("query") %>".</p>
            <% } %>
        </section>
    </main>
</body>
</html>
