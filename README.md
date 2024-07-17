# Blog App

## Introduction
Blog App is a simple yet powerful web application designed to allow users to create, view, and manage blog posts. This project showcases the use of Java Servlet technology, JSP, MySQL database, and front-end technologies such as HTML, CSS, and JavaScript.

## Features
- **User Authentication**: Users can sign up and log in to create and manage their posts.
- **Create and Edit Posts**: Authenticated users can create new blog posts with titles, content, images, and videos. They can also edit their existing posts.
- **Responsive Design**: The application features a clean and modern design that adapts to different screen sizes, ensuring a seamless experience across all devices.
- **Image and Video Uploads**: Users can upload images and videos to their posts, enhancing the multimedia experience.
- **Search Functionality**: A responsive search bar that expands on focus, allowing users to search for posts.

## Technologies Used
- **Back-end**:
  - Java Servlet: Used for handling HTTP requests and responses.
  - JSP (JavaServer Pages): Used for rendering dynamic web content.
  - MySQL: Relational database used for storing user data and blog posts.
- **Front-end**:
  - HTML5 and CSS3: For structuring and styling the web pages.
  - JavaScript: For enhancing user interactivity and front-end validation.
- **Tools and Platforms**:
  - Eclipse IDE: Development environment for building and debugging the application.
  - Apache Tomcat: Web server for deploying and running the Java Servlets and JSPs.
  - GitHub: Version control and repository hosting platform.

## Project Structure
```
Blog App/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── model/
│   │   │   │   ├── Post.java
│   │   │   │   ├── User.java
│   │   │   ├── servlet/
│   │   │   │   ├── CreatePostServlet.java
│   │   │   │   ├── ListPostsServlet.java
│   │   │   │   ├── LoginServlet.java
│   │   │   │   ├── RegisterServlet.java
│   │   ├── webapp/
│   │   │   ├── WEB-INF/
│   │   │   │   ├── web.xml
│   │   │   ├── index.jsp
│   │   │   ├── register.jsp
│   │   │   ├── login.jsp
│   │   │   ├── dashboard.jsp
│   │   │   ├── newpost.jsp
│   │   │   ├── styles.css
├── pom.xml

```

## Installation and Setup
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/BlogApp.git
   ```
2. **Import the Project into Eclipse**:
   - Open Eclipse IDE.
   - Select `File > Import > Existing Projects into Workspace`.
   - Select the cloned repository folder.

3. **Set Up the Database**:
   - Create a MySQL database named `blog_app`.
   - Run the following SQL script to create the necessary tables:
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
   - Update the database connection details in the `CreatePostServlet.java` file:
     ```java
     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog_app", "root", "your-password");
     ```

4. **Deploy and Run the Application**:
   - Right-click on the project in Eclipse and select `Run As > Run on Server`.
   - Choose Apache Tomcat as the server and click `Finish`.

5. **Access the Application**:
   - Open a web browser and navigate to `http://localhost:8080/BlogApp`.

## Usage
1. **Home Page**: The landing page with a welcoming hero section and navigation links.
2. **Sign Up**: New users can register by providing their full name, username, password, email, and role.
3. **Login**: Registered users can log in to access their dashboard.
4. **Dashboard**: Logged-in users can view their posts and access options to create new posts.
5. **Create Post**: Users can create new posts by entering the title, content, and optionally uploading images and videos.
6. **View Posts**: All posts are displayed in a gallery layout with smooth animations and transitions.

## Contributions
Contributions are welcome! Please fork this repository and submit pull requests for any enhancements, bug fixes, or new features.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

Feel free to customize this README template according to your project's specific details and requirements.
