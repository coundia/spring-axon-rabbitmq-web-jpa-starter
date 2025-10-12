package com.groupe2cs.bizyhub.products.application.command;

import com.groupe2cs.bizyhub.products.domain.valueObject.*;

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
public class CreateProductCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private ProductId id = ProductId.create(UUID.randomUUID().toString());
	private ProductRemoteId remoteId;
	private ProductLocalId localId;
	private ProductCode code;
	private ProductName name;
	private ProductDescription description;
	private ProductStatus status;
	private ProductIsPublic isPublic;
	private ProductHasSold hasSold;
	private ProductHasPrice hasPrice;
	private ProductLevel level;
	private ProductQuantity quantity;
	private ProductBarcode barcode;
	private ProductCompany company;
	private ProductUnit unit;
	private ProductSyncAt syncAt;
	private ProductCategory category;
	private ProductAccount account;
	private ProductDefaultPrice defaultPrice;
	private ProductStatuses statuses;
	private ProductPurchasePrice purchasePrice;
	private ProductCreatedBy createdBy;
	private ProductTenant tenant;

	public CreateProductCommand(

			ProductRemoteId remoteId,
			ProductLocalId localId,
			ProductCode code,
			ProductName name,
			ProductDescription description,
			ProductStatus status,
			ProductIsPublic isPublic,
			ProductHasSold hasSold,
			ProductHasPrice hasPrice,
			ProductLevel level,
			ProductQuantity quantity,
			ProductBarcode barcode,
			ProductCompany company,
			ProductUnit unit,
			ProductSyncAt syncAt,
			ProductCategory category,
			ProductAccount account,
			ProductDefaultPrice defaultPrice,
			ProductStatuses statuses,
			ProductPurchasePrice purchasePrice,
			ProductCreatedBy createdBy,
			ProductTenant tenant
	) {
		this.id = ProductId.create(UUID.randomUUID().toString());

		this.remoteId = remoteId;
		this.localId = localId;
		this.code = code;
		this.name = name;
		this.description = description;
		this.status = status;
		this.isPublic = isPublic;
		this.hasSold = hasSold;
		this.hasPrice = hasPrice;
		this.level = level;
		this.quantity = quantity;
		this.barcode = barcode;
		this.company = company;
		this.unit = unit;
		this.syncAt = syncAt;
		this.category = category;
		this.account = account;
		this.defaultPrice = defaultPrice;
		this.statuses = statuses;
		this.purchasePrice = purchasePrice;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
