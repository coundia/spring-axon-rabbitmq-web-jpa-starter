package com.groupe2cs.bizyhub.transactions.application.command;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateTransactionItemCommand implements Serializable {
	@TargetAggregateIdentifier
	private TransactionItemId id;
	private TransactionItemTransaction transaction;
	private TransactionItemProduct product;
	private TransactionItemLabel label;
	private TransactionItemQuantity quantity;
	private TransactionItemUnit unit;
	private TransactionItemAccount account;
	private TransactionItemRemoteId remoteId;
	private TransactionItemLocalId localId;
	private TransactionItemSyncAt syncAt;
	private TransactionItemUnitPrice unitPrice;
	private TransactionItemTotal total;
	private TransactionItemNotes notes;
	private TransactionItemCreatedBy createdBy;
	private TransactionItemTenant tenant;


}
