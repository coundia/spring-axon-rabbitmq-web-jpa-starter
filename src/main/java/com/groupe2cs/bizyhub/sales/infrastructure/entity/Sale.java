package com.groupe2cs.bizyhub.sales.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sales")
public class Sale {

    @Id
    private String id;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private Double total_price;
    @Column(nullable = false)
    private String facture;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private com.groupe2cs.bizyhub.products.infrastructure.entity.Product product;

    public Sale(String id) {
        this.id = id;
    }

}
