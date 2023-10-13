package com.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class SaleResource {
    private String id;
    private Float amount;
    private Date dateSale;
    private ProductResource product;
    private UsersResource user;
    private StoreResource store;
}
