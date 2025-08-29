package com.groupe2cs.bizyhub.stock.application.command;

import com.groupe2cs.bizyhub.stock.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateStockLevelCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private StockLevelId id = StockLevelId.create(UUID.randomUUID().toString());
	private StockLevelRemoteId remoteId;
	private StockLevelLocalId localId;
	private StockLevelStockOnHand stockOnHand;
	private StockLevelStockAllocated stockAllocated;
	private StockLevelAccount account;
	private StockLevelProductVariant productVariant;
	private StockLevelSyncAt syncAt;
	private StockLevelCompany company;
	private StockLevelCreatedBy createdBy;
	private StockLevelTenant tenant;

	public CreateStockLevelCommand(

			StockLevelRemoteId remoteId,
			StockLevelLocalId localId,
			StockLevelStockOnHand stockOnHand,
			StockLevelStockAllocated stockAllocated,
			StockLevelAccount account,
			StockLevelProductVariant productVariant,
			StockLevelSyncAt syncAt,
			StockLevelCompany company,
			StockLevelCreatedBy createdBy,
			StockLevelTenant tenant
	) {
		this.id = StockLevelId.create(UUID.randomUUID().toString());

		this.remoteId = remoteId;
		this.localId = localId;
		this.stockOnHand = stockOnHand;
		this.stockAllocated = stockAllocated;
		this.account = account;
		this.productVariant = productVariant;
		this.syncAt = syncAt;
		this.company = company;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
