package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Image;

public interface ImageReposiroty extends JpaRepository<Image, Long> {

}
