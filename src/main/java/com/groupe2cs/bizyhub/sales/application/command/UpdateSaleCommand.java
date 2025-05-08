package com.groupe2cs.bizyhub.sales.application.command;

import com.groupe2cs.bizyhub.sales.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import java.util.Date;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.util.UUID;


import java.time.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateSaleCommand implements Serializable {
@TargetAggregateIdentifier
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
