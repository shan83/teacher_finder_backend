package com.shan83.classfinder.repository;

import com.shan83.classfinder.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository  extends JpaRepository<Teacher, Long> {

    @Query("SELECT distinct t FROM Teacher t " +
            "join t.districts as d " +
            "join t.mediums as m " +
            "join t.subjects as s " +
            "where :searchString is null " +
            "or t.name like %:searchString% " +
            "or d.nameEn like %:searchString% " +
            "or m.name like %:searchString% " +
            "or s.name like %:searchString%")
    List<Teacher> fetchBySearchString(String searchString);

    @Query("SELECT distinct t FROM Teacher t " +
            "join t.districts as d " +
            "where d.nameEn like %:district%" )
    List<Teacher> fetchByCity(String district);

}
