package com.shan83.classfinder.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="t_teacher")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private BigDecimal fees;
    private String contactNumber;
    private String whatsAppNumber;
    @Column(name = "createdDate", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdDate;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<District> districts;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Medium> mediums;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Subject> subjects;

}
