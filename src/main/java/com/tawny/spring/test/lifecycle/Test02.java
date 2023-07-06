package com.tawny.spring.test.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lifecycle/test02")
@RestController
public class Test02 {
	
	@ResponseBody
	@RequestMapping("/1")
	public List<Map<String, Object>> movieList() {
		
		// Map을 List에 저장 
		List<Map<String, Object>> movie = new ArrayList<>();
		
		Map<String, Object> movie1 = new HashMap<>();
		movie1.put("rete", 15);
		movie1.put("director", "봉준호");
		movie1.put("time", 131);
		movie1.put("title", "기생충");
		movie.add(movie1);
		
		Map<String, Object> movie2 = new HashMap<>();
		movie2.put("rete", 0);
		movie2.put("director", "로베르토");
		movie2.put("time", 116);
		movie2.put("title", "인생은 아름다워");
		movie.add(movie2);
		
		Map<String, Object> movie3 = new HashMap<>();
		movie3.put("rete", 12);
		movie3.put("director", "크리스퍼 놀란");
		movie3.put("time", 147);
		movie3.put("title", "인셉션");
		movie.add(movie3);
		
		Map<String, Object> movie4 = new HashMap<>();
		movie4.put("rete", 15);
		movie4.put("director", "프란시스 로렌스");
		movie4.put("time", 137);
		movie4.put("title", "헝거게임");
		movie.add(movie4);
		
		return movie;
	}
	
	@ResponseBody
	@RequestMapping("/2")
	public List<Post> postList() {
		List<Post> postList = new ArrayList<>();
		Post post = new Post("안녕하세요 가입인사 드립니다.", "dnjsdudeh", "안녕하세요 앞으로 잘 부탁드립니다.");
		postList.add(post);
		return postList;
	}
	
	
}
