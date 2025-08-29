package com.groupe2cs.bizyhub.transactions.domain.event;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionItemUpdatedEvent implements Serializable {

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
