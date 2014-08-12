package com.vothuat.viet.data;

public class MContent {
	private int id;

	private int parentid;

	private String title;

	private String image;

	private String summary;

	private String fileName;

	public MContent(int id, String title, String urlImage, String summary,
			String fileName) {
		this.id = id;
		this.title = title;
		this.image = urlImage;
		this.summary = summary;
		this.fileName = fileName;
	}

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
