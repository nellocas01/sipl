package com.example.dao.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "sale")
@Data
public class Sale {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "sale_id")
    private String saleId;
    @Basic
    @Column(name = "amount")
    private Float amount;
    @Basic
    @Column(name = "date_sale")
    private Date dateSale;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product productId;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Users userId;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    private Store storeId;

}
