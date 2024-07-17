<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.model.Post" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">	
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Blog Home</title>
    <link rel="stylesheet" href="CSS/styles.css">
</head>
<body>
     <% System.out.println(session.getAttribute("user"));
     if (session.getAttribute("user") == null) { %>
    <header>
        <nav>
            <div class="logo">Blog</div> 
            <ul class="nav-links"> 
              	<li><a href="index.jsp">Home</a></li>
                <li><a href="login.jsp">Login</a></li>
                <li><a href="register.jsp">Register</a></li>
     		</ul>
        </nav>
    </header>          
         <main>
        	 <section class="hero fade-in">
	            <h1>Welcome to the Blog</h1>
	            <p>Explore the latest blog posts from our community.</p>
	            <p>Your go-to platform for sharing ideas, stories, and experiences. Whether you're an avid writer or an enthusiastic reader, our community is the perfect place to explore and create engaging content.</p>
		        <h2>Why Blog App?</h2>
		        <ul>
		            <strong>Express Yourself:</strong><span> Share your thoughts and creativity with the world through compelling blog posts.</span> <br>
		            <strong>Discover New Ideas:</strong><span> Explore diverse topics and find inspiration from other bloggers.</span><br>
		            <strong>Stay Connected:</strong><span> Engage with a vibrant community of readers and writers.</span><br>
		        </ul>
		        <h2>Getting Started</h2>
		        <p>To begin your blogging journey, please log in or register:</p>
       		 </section>  
         </main>    
    
               <% } else { %>     
     <header>
      	<nav> 
      		<div class="logo">Blog</div>           
            <ul class="nav-links">    
                <!-- li><a href="newpost.jsp">Create New Post</a></li> -->
           		 <form action="searchservlet" method="GET" class="search-form">
                	<input type="text" name="query" placeholder="Search blog posts..." class="search-bar">
               	 	<button type="submit">Search</button>
            	</form>
                <li><a href="listposts">Home</a></li>
                <li><a href="logout">Logout</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <section class="hero fade-in">
            <h1>Welcome to the Blog</h1>
            <p>Explore the latest blog posts from our community.</p>
        </section>
        <% } %>
        <section class="gallery fade-in">
            	<%
                List<Post> posts = (List<Post>) request.getAttribute("posts");
                String role = (String) session.getAttribute("role");
                if (posts != null) {
                    for (Post post : posts) {
           		%>
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
                                <% if ("Admin".equals(role)) { %>
				    <br>
				    <a href="updatepost?id=<%= post.getId() %>" class="btn">Update</a>
				    <a href="deletepost?id=<%= post.getId() %>" class="btn" onclick="return confirmDelete();">Delete</a>
				<% } %>
				<br>
				<a href="viewpost?id=<%= post.getId() %>" class="btn" target="_blank">View Details</a> <!-- Opens in new tab -->	
                            </div>
                        </div>
           		<%
                    }
                }
            %>
        </section>
    </main>
    <script>
    function confirmDelete() {
        return confirm("Are you sure you want to delete this post?");
    }
	</script>
</body>
</html>
