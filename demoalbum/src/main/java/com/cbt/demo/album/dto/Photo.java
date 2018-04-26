package com.cbt.demo.album.dto;

/**
 * <p>Title: Photo</p>
 * <p>Description: DTO for storing Photo details.</p>
 *
 * @author Rachna Aggarwal
 * @version 1.0
 */
public class Photo
{
	private int id;
	private long createdAt;
	private String name;
	private String imageUrl;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "Photo [id=" + id + ", createdAt=" + createdAt + ", name=" + name + ", imageUrl=" + imageUrl + "]";
	}
	
}