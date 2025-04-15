package com.groupe2cs.bizyhub.products.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double price;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<com.groupe2cs.bizyhub.sales.infrastructure.entity.Sale> sales = new ArrayList<>();

    public Product(String id) {
        this.id = id;
    }

}
