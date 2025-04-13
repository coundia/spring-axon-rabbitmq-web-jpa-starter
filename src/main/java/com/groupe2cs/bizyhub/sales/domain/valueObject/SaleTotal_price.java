package com.groupe2cs.bizyhub.sales.domain.valueObject;

import com.groupe2cs.bizyhub.sales.domain.exception.SaleTotal_priceNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class SaleTotal_price implements Serializable {

    private Double total_price;

    public SaleTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public static SaleTotal_price create(Double total_price) {
        if (total_price == null) {
            throw new SaleTotal_priceNotValid("Total_price is invalid");
        }
        return new SaleTotal_price(total_price);
    }

    public Double value() {
        return this.total_price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SaleTotal_price that)) return false;
        return this.total_price.equals(that.total_price);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(total_price);
    }

    @Override
    public String toString() {
        return String.valueOf(total_price);
    }
}
