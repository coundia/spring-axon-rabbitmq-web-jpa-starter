package com.groupe2cs.bizyhub.products.domain.valueObject;


public class ProductId {
    private final String id;

    public ProductId(String id) {
        this.id = id;
    }

    public static ProductId create(String string) {
        return new ProductId(string);
    }

    public String value() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductId)) return false;
        return id.equals(((ProductId) o).id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return id;
    }


}
