package com.groupe2cs.bizyhub.products.domain.valueObject;

import com.groupe2cs.bizyhub.products.domain.exception.ProductSalesNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ProductSales implements Serializable {

    private String sales;

    public ProductSales(String sales) {
        this.sales = sales;
    }

    public static ProductSales create(String sales) {
        if (sales == null || sales.isBlank()) {
            throw new ProductSalesNotValid("Sales is invalid");
        }
        return new ProductSales(sales);
    }

    public String value() {
        return this.sales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductSales that)) return false;
        return this.sales.equals(that.sales);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(sales);
    }

    @Override
    public String toString() {
        return String.valueOf(sales);
    }
}
