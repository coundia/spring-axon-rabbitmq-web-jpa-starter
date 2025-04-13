package com.groupe2cs.bizyhub.products.domain.valueObject;

import com.groupe2cs.bizyhub.products.domain.exception.ProductIdNotValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ProductId implements Serializable {

    private String id;

    public ProductId(String id) {
        this.id = id;
    }

    public static ProductId create(String id) {
        if (id == null || id.isBlank()) {
            throw new ProductIdNotValid("Id is invalid");
        }
        return new ProductId(id);
    }

    public String value() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductId that)) return false;
        return this.id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
