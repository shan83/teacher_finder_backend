package com.shan83.classfinder.repository;

import com.shan83.classfinder.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, Long> {

    @Query("SELECT d FROM City c" +
            " inner join c.district as d" +
            " where c.nameEn = :city")
    District searchByCitiesNameEn(String city);

    District findByNameEn(String name);
}
