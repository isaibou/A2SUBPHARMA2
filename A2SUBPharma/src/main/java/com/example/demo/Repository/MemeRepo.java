package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.Medoc;
import com.example.demo.Entity.Meme;

public interface MemeRepo extends JpaRepository<Meme, Long> {

	public List<Meme> findByNom(String cip);
	List<Meme> findByPrincip(String name);
	
	@Query("select m from Meme m where m.nom like :x")
	public List<Meme> chercherMEdoc(@Param("x") String n);
	
	List<Meme> findByNomContaining(String username);
}
 