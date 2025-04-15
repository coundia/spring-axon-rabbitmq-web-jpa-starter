package com.groupe2cs.bizyhub.sales.domain.valueObject;

import com.groupe2cs.bizyhub.sales.domain.exception.SaleProductNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class SaleProduct implements Serializable {

    private String Product;

    public SaleProduct(String Product) {
        this.Product = Product;
    }

    public static SaleProduct create(String Product) {
        if (Product == null || Product.isBlank()) {
            throw new SaleProductNotValid("Product is invalid");
        }
        return new SaleProduct(Product);
    }

    public String value() {
        return this.Product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SaleProduct that)) return false;
        return this.Product.equals(that.Product);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(Product);
    }

    @Override
    public String toString() {
        return String.valueOf(Product);
    }
}
