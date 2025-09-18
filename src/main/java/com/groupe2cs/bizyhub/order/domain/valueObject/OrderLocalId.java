package com.groupe2cs.bizyhub.order.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.order.domain.exception.OrderIdNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderProductIdNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderUserIdNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderIdentifiantNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderTelephoneNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderMailNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderVilleNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderRemoteIdNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderLocalIdNotValid;

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
public class OrderLocalId implements Serializable {

private String localId;

public OrderLocalId(String localId) {
this.localId = localId;
}

public static OrderLocalId create(String localId) {

	return new OrderLocalId(localId);
}

public String value() {
return this.localId;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof OrderLocalId that)) return false;
return this.localId.equals(that.localId);
}

@Override
public int hashCode() {
return java.util.Objects.hash(localId);
}

@Override
public String toString() {
return String.valueOf(localId);
}
}
