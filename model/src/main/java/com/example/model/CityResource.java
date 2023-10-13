package com.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CityResource {
    private Integer id;
    private String name;
    private CountryResource country;
}
