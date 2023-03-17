package com.shan83.classfinder.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name="cities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name_en")
    private String nameEn;
    private String name_si;
    private String name_ta;
    private String sub_name_en;
    private String sub_name_si;
    private String sub_name_ta;
    private String postcode;
    private BigDecimal latitude;
    private BigDecimal longitude;
    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;
}
