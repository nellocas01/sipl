package com.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StatusNameResource {
    private Integer id;
    private String name;
}