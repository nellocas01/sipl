package com.example.dao.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name = "country")
@Data
public class Country {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "country_id")
    private int Id;
    @Basic
    @Column(name = "country_name")
    private String name;
}
