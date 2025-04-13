package com.groupe2cs.bizyhub.sales.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleIdNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleQuantityNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleTotal_priceNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleFactureNotValid;

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
public class SaleFacture implements Serializable {

private String facture;

public SaleFacture(String facture) {
this.facture = facture;
}

public static SaleFacture create(String facture) {
if (facture == null || facture.isBlank()) {
throw new SaleFactureNotValid("Facture is invalid");
}
return new SaleFacture(facture);
}

public String value() {
return this.facture;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SaleFacture that)) return false;
return this.facture.equals(that.facture);
}

@Override
public int hashCode() {
return java.util.Objects.hash(facture);
}

@Override
public String toString() {
return String.valueOf(facture);
}
}
