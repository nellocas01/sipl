package com.example.dao.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name = "status_name")
@Data
public class StatusName {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "status_name_id")
    private int statusNameId;
    @Basic
    @Column(name = "status_name")
    private String statusName;


}
