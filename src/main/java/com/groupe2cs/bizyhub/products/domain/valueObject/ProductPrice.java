package com.groupe2cs.bizyhub.products.domain.valueObject;

import com.groupe2cs.bizyhub.products.domain.exception.ProductPriceNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ProductPrice implements Serializable {

    private Double price;

    public ProductPrice(Double price) {
        this.price = price;
    }

    public static ProductPrice create(Double price) {
        if (price == null) {
            throw new ProductPriceNotValid("Price is invalid");
        }
        return new ProductPrice(price);
    }

    public Double value() {
        return this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductPrice that)) return false;
        return this.price.equals(that.price);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(price);
    }

    @Override
    public String toString() {
        return String.valueOf(price);
    }
}
