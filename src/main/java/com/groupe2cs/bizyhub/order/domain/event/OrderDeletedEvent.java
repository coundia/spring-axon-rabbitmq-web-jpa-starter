package com.groupe2cs.bizyhub.order.domain.event;

import com.groupe2cs.bizyhub.order.domain.valueObject.OrderId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDeletedEvent implements Serializable {


	private OrderId id;

}
