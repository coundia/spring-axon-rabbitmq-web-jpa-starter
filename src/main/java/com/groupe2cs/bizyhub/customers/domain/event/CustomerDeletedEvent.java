package com.groupe2cs.bizyhub.customers.domain.event;

import com.groupe2cs.bizyhub.customers.domain.valueObject.CustomerId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDeletedEvent implements Serializable {


	private CustomerId id;

}
