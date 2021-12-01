package com.example.demo.Repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Medoc;

public interface MedocRepository  extends  JpaRepository<Medoc, Long> {
	
	
	public List<Medoc> findByCIP(Long cIP);
	
	
}
