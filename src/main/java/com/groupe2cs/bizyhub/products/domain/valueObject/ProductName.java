package com.groupe2cs.bizyhub.products.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.products.domain.exception.ProductIdNotValid;
import com.groupe2cs.bizyhub.products.domain.exception.ProductNameNotValid;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ProductName implements Serializable {

private String name;

public ProductName(String name) {
this.name = name;
}

public static ProductName create(String name) {
if (name == null || name.isBlank()) {
throw new ProductNameNotValid("Name is invalid");
}
return new ProductName(name);
}

public String value() {
return this.name;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ProductName that)) return false;
return this.name.equals(that.name);
}

@Override
public int hashCode() {
return java.util.Objects.hash(name);
}

@Override
public String toString() {
return String.valueOf(name);
}
}
