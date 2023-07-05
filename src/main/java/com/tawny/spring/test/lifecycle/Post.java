package com.tawny.spring.test.lifecycle;

public class Post {
	// 사용자, 제목, 내용
	private String title;
	private String user;
	private String content;
	
	public Post(String title, String user, String content) {
		this.title = title;
		this.user = user;
		this.content = content;
	}
	
}
