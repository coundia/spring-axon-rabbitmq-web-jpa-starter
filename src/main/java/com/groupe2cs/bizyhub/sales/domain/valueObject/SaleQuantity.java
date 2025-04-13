package com.groupe2cs.bizyhub.sales.domain.valueObject;

import com.groupe2cs.bizyhub.sales.domain.exception.SaleQuantityNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class SaleQuantity implements Serializable {

    private Integer quantity;

    public SaleQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public static SaleQuantity create(Integer quantity) {
        if (quantity < 0) {
            throw new SaleQuantityNotValid("Quantity is invalid");
        }
        return new SaleQuantity(quantity);
    }

    public Integer value() {
        return this.quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SaleQuantity that)) return false;
        return this.quantity.equals(that.quantity);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(quantity);
    }

    @Override
    public String toString() {
        return String.valueOf(quantity);
    }
}
