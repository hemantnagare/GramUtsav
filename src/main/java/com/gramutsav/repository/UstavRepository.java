package com.gramutsav.repository;

import com.gramutsav.entity.Ustav;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UstavRepository extends JpaRepository<Ustav, Integer> {

}
