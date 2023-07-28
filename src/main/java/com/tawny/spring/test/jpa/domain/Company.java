package com.tawny.spring.test.jpa.domain;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 기본 생성자 사용
@AllArgsConstructor // 생성자 자동 생성(기본 생성자는 사라짐)
@Builder(toBuilder=true)
@Table(name="company") // entity 클래스가 어떤 테이블과 연결이 되는지 알려주는 클래스
@Getter // 맴버 변수 사용
@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String business;
	private int headcount;
	private String scale;
	
	@Column(name="createdAT", updatable=false)
	@UpdateTimestamp // null이 들어갈 수 있음을 방지
	private ZonedDateTime createdAT;
	
	@Column(name="updatedAT")
	@UpdateTimestamp
	private ZonedDateTime updatedAT;
}
