INSERT INTO users (name, email, password, role) VALUES 
('John Doe', 'john@example.com', 'password123', 'Admin'),
('Jane Smith', 'jane@example.com', 'password456', 'Viewer'),
('Alice Johnson', 'alice@example.com', 'password789', 'Viewer');


INSERT INTO posts (title, content, image_url, video_url, created_at) VALUES 
('Welcome to My Blog', 'This is the first post on my new blog. Stay tuned for more updates!', 'images/welcome.jpg', NULL, '2024-07-01 10:00:00'),
('Exploring the Mountains', 'I recently went hiking in the mountains. Here are some pictures from the trip.', 'images/mountains.jpg', NULL, '2024-07-05 14:30:00'),
('Cooking Tips for Beginners', 'Cooking can be fun and easy. Here are some tips for beginners to get started.', 'images/cooking.jpg', NULL, '2024-07-10 09:15:00'),
('My First Vlog', 'Check out my first video blog where I talk about my daily routine.', NULL, 'videos/vlog.mp4', '2024-07-12 18:00:00'),
('Top 10 Travel Destinations', 'Here are my top 10 travel destinations you must visit!', 'images/travel.jpg', 'videos/travel.mp4', '2024-07-15 20:00:00');
