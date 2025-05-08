package com.groupe2cs.bizyhub.sales.domain.event;

	import com.groupe2cs.bizyhub.sales.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleCreatedEvent implements Serializable {

	private SaleId id;
	private SaleName name;
	private SaleAmount amount;
	private SaleDetails details;
	private SaleIsActive isActive;
	private SaleAccount account;
	private SaleUpdatedAt updatedAt;
	private SaleReference reference;
	private SaleCreatedBy createdBy;
	private SaleTenant tenant;



}
