package com.shan83.classfinder.repository;

import com.shan83.classfinder.model.Medium;
import com.shan83.classfinder.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediumRepository extends JpaRepository<Medium, Long> {

    Medium findByName(String name);
}
