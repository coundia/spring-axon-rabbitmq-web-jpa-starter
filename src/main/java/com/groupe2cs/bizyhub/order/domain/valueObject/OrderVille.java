package com.groupe2cs.bizyhub.order.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.order.domain.exception.OrderIdNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderProductIdNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderUserIdNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderIdentifiantNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderTelephoneNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderMailNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderVilleNotValid;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class OrderVille implements Serializable {

private String ville;

public OrderVille(String ville) {
this.ville = ville;
}

public static OrderVille create(String ville) {

	return new OrderVille(ville);
}

public String value() {
return this.ville;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof OrderVille that)) return false;
return this.ville.equals(that.ville);
}

@Override
public int hashCode() {
return java.util.Objects.hash(ville);
}

@Override
public String toString() {
return String.valueOf(ville);
}
}
