# Blog App

## Introduction

Blog App is a web application designed for users to create, view, and manage blog posts. It utilizes Java Servlet technology, JSP (JavaServer Pages), MySQL database for data storage, and front-end technologies like HTML, CSS, and JavaScript.

## Features

- **User Authentication**: Sign up and login functionality for users to manage their posts.
- **Create and Edit Posts**: Users can create new blog posts with titles, content, images, and videos. They can also edit existing posts.
- **Media Uploads**: Support for uploading images and videos to enhance blog posts.
- **Search Functionality**: A responsive search bar for finding posts based on keywords.
- **Security Enhancements (Backend)**: 
  - Implemented secure password hashing and storage using BCrypt algorithm.
  - Validated user input to prevent SQL injection attacks (used prepared statements).
- **Viewer Functionalities**:
  - Search funtionality of blog posts by using title or date.
  - Implemented pagination and sorting for search results.
  - View individual blog posts in detail, opening them in a new tab.

## Technologies Used

### Back-end

- **Java Servlet**: Handles HTTP requests and responses.
- **JSP (JavaServer Pages)**: Renders dynamic web content.
- **MySQL**: Relational database for storing user data and blog posts.

### Front-end

- **HTML5 and CSS3**: Structure and style the web pages.
- **JavaScript**: Enhances user interactivity and performs front-end validation.

### Tools and Platforms

- **Eclipse IDE**: Development environment for Java projects.
- **Apache Tomcat**: Web server for deploying Java Servlets and JSPs.
- **GitHub**: Version control and collaboration platform.

## Project Structure (DOM)

```
Blog App/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── dao/
│   │   │   │   ├── PostDAO.java (for pagination)
│   │   │   ├── model/
│   │   │   │   ├── Post.java
│   │   │   │   ├── User.java
│   │   │   ├── servlets/
│   │   │   │   ├── CreatePostServlet.java
│   │   │   │   ├── ListPostsServlet.java
│   │   │   │   ├── LoginServlet.java
│   │   │   │   ├── RegisterServlet.java
│   │   │   │   ├── DeleteServlet.java
│   │   │   │   ├── LogoutServlet.java
│   │   │   │   ├── SearchServlet.java
│   │   │   │   ├── UpdatePostServlet.java
│   │   │   │   ├── ViewPostServlet.java
│   ├── webapp/
│   │   ├── CSS/
│   │   │   ├── dashboard.css
│   │   │   ├── newpost.css
│   │   │   ├── signin.css
│   │   │   ├── styles.css
│   │   │   ├── viewpost.css
│   │   ├── WEB-INF/
│   │   │   ├── web.xml
│   │   ├── index.jsp
│   │   ├── register.jsp
│   │   ├── login.jsp
│   │   ├── dashboard.jsp
│   │   ├── newpost.jsp
│   │   ├── search.jsp
│   │   ├── update.jsp
│   │   ├── viewpost.jsp
├── pom.xml
```

## Installation and Setup

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/BlogApp.git
   ```

2. **Import into Eclipse**
   - Open Eclipse IDE.
   - Select `File > Import > Existing Projects into Workspace`.
   - Choose the cloned repository folder.

3. **Set Up the Database**
   - Create a MySQL database named `blog_app`.
   - Run the provided SQL script to create tables for `users` and `posts`. Update database connection details in servlets.

   **Database SQL Script:**
   ```sql
   CREATE TABLE `users` (
       `id` INT AUTO_INCREMENT PRIMARY KEY,
       `name` VARCHAR(100),
       `email` VARCHAR(100) UNIQUE,
       `password` VARCHAR(255),
       `role` ENUM('Admin', 'Viewer')
   );

   CREATE TABLE `posts` (
       `id` INT AUTO_INCREMENT PRIMARY KEY,
       `title` VARCHAR(255),
       `content` TEXT,
       `image_url` VARCHAR(255),
       `video_url` VARCHAR(255),
       `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
   );
   ```

4. **Update Database Connection**
   - Open servlets (`CreatePostServlet.java`, `ListPostsServlet.java`, etc.) and update the database connection URL, username, and password as per your MySQL setup.

   **Example Database Connection in Servlets:**
   ```java
   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog_app", "root", "your-password");
   ```

5. **Deploy and Run**
   - Right-click on the project in Eclipse and select `Run As > Run on Server`.
   - Choose Apache Tomcat as the server and click `Finish`.

6. **Access the Application**
   - Open a web browser and go to `http://localhost:8080/BlogApp`.

## Usage

1. **Home Page**
   - Landing page with a hero section and navigation links.
   
2. **Sign Up**
   - New users can register with their details.

3. **Login**
   - Registered users can log in to access their dashboard.

4. **Dashboard**
   - View and manage posts.

5. **Create Post**
   - Users can create new posts with titles, content, images, and videos.

6. **View Posts**
   - Display posts with multimedia content.

7. **Search Posts**
   - Users can search for posts using keywords.

8. **Update Post**
   - Admin can update the posts.

## Contributions

Contributions are welcome! Fork the repository, make changes, and submit pull requests for enhancements, bug fixes, or new features.

---

Feel free to further customize this README to include specific instructions, screenshots, or additional sections based on your project's needs. This version includes the necessary database setup details for clarity.

---

SAMPLE IMAGES : 

![Screenshot 2024-07-18 005822](https://github.com/user-attachments/assets/61208af3-0011-4326-9a04-0ddce98f55cb)

![Screenshot 2024-07-18 005844](https://github.com/user-attachments/assets/9d5dc708-bc05-47c2-94db-0e6f581a651a)

![Screenshot 2024-07-18 005910](https://github.com/user-attachments/assets/1e73f34b-2a6f-4a91-add9-64ca95bf1499)

![Screenshot 2024-07-18 005942](https://github.com/user-attachments/assets/13eb0e65-c95b-49f0-a7b8-27960047d95b)

![Screenshot 2024-07-18 010003](https://github.com/user-attachments/assets/d387ec60-4e75-4b57-8ef0-d9389d485e96)

![Screenshot 2024-07-18 010031](https://github.com/user-attachments/assets/22ddea6d-0e5e-46a9-9a61-11e13a99ba38)

![image](https://github.com/user-attachments/assets/6bbe9fbe-2845-4e37-8ad7-c426ab7dd20c)

![Screenshot 2024-07-18 010139](https://github.com/user-attachments/assets/a5c6d75f-8118-4204-9f78-1e49d0295bd3)

![Screenshot 2024-07-18 010204](https://github.com/user-attachments/assets/b6e012e3-ec24-4018-96a2-eeb1c9c4b135)









