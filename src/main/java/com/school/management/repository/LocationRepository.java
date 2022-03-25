package com.school.management.repository;

import com.school.management.model.Location;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    
}
