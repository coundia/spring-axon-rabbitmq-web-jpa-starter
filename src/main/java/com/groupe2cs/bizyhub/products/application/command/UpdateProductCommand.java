package com.groupe2cs.bizyhub.products.application.command;

import com.groupe2cs.bizyhub.products.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateProductCommand implements Serializable {
	@TargetAggregateIdentifier
	private ProductId id;
	private ProductRemoteId remoteId;
	private ProductLocalId localId;
	private ProductCode code;
	private ProductName name;
	private ProductDescription description;
	private ProductBarcode barcode;
	private ProductUnit unit;
	private ProductSyncAt syncAt;
	private ProductCategory category;
	private ProductAccount account;
	private ProductDefaultPrice defaultPrice;
	private ProductStatuses statuses;
	private ProductPurchasePrice purchasePrice;
	private ProductCreatedBy createdBy;
	private ProductTenant tenant;


}
