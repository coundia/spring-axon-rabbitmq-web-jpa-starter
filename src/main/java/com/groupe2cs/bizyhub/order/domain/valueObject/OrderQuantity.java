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
import com.groupe2cs.bizyhub.order.domain.exception.OrderAddressNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderNotesNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderMessageNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderTypeOrderNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderPaymentMethodNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderDeliveryMethodNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderAmountCentsNotValid;
import com.groupe2cs.bizyhub.order.domain.exception.OrderQuantityNotValid;

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
public class OrderQuantity implements Serializable {

private Integer quantity;

public OrderQuantity(Integer quantity) {
this.quantity = quantity;
}

public static OrderQuantity create(Integer quantity) {

	return new OrderQuantity(quantity);
}

public Integer value() {
return this.quantity;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof OrderQuantity that)) return false;
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
