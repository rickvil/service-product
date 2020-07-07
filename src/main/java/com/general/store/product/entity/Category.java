package com.general.store.product.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_category")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
}
