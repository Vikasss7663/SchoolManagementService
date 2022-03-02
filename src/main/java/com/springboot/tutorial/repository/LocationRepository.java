package com.springboot.tutorial.repository;

import com.springboot.tutorial.model.Location;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    
}
