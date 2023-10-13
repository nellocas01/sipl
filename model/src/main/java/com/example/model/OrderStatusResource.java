package com.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class OrderStatusResource {
    private String id;
    private Date updateAt;
    private SaleResource sale;

}
