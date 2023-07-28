package com.tawny.spring.test.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tawny.spring.test.jpa.domain.Company;

@Repository                                                     // 해당 컬럼에 id 형태 
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
