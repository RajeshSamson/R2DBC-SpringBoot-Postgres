package com.techpastors.demoreactiverdbms.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;

@Data
@ToString
public class Product implements Persistable<Integer> {

    @Id
    private Integer id;
    private String description;
    private Double price;

    @Transient
    private boolean newProduct;

    @Override
    @Transient
    public boolean isNew() {
        return this.newProduct || id == null;
    }

    public Product setAsNew() {
        this.newProduct = true;
        return this;
    }
}
