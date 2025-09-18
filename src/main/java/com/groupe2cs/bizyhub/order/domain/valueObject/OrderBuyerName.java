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
import com.groupe2cs.bizyhub.order.domain.exception.OrderStatusNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderBuyerNameNotValid;

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
public class OrderBuyerName implements Serializable {

private String buyerName;

public OrderBuyerName(String buyerName) {
this.buyerName = buyerName;
}

public static OrderBuyerName create(String buyerName) {

	return new OrderBuyerName(buyerName);
}

public String value() {
return this.buyerName;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof OrderBuyerName that)) return false;
return this.buyerName.equals(that.buyerName);
}

@Override
public int hashCode() {
return java.util.Objects.hash(buyerName);
}

@Override
public String toString() {
return String.valueOf(buyerName);
}
}
