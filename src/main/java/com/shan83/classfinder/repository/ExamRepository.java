package com.shan83.classfinder.repository;

import com.shan83.classfinder.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}
