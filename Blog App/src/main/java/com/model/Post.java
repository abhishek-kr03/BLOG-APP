package com.model;

import java.sql.Timestamp;

public class Post {
    private int id;
    private String title;
    private String content;
    private String imageUrl;
    private String videoUrl;
    private Timestamp createdAt;

    public Post() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", imageUrl=" + imageUrl + ", videoUrl="
				+ videoUrl + ", createdAt=" + createdAt + "]";
	}
	
	
	
}
