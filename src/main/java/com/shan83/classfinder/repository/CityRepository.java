package com.shan83.classfinder.repository;

import com.shan83.classfinder.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {

    City findByNameEn(String name);
}
