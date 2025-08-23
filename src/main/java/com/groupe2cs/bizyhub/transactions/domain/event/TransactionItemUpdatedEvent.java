package com.groupe2cs.bizyhub.transactions.domain.event;

	import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;

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
public class TransactionItemUpdatedEvent implements Serializable {

	private TransactionItemId id;
	private TransactionItemTransaction transaction;
	private TransactionItemProduct product;
	private TransactionItemLabel label;
	private TransactionItemQuantity quantity;
	private TransactionItemUnit unit;
	private TransactionItemSyncAt syncAt;
	private TransactionItemUnitPrice unitPrice;
	private TransactionItemTotal total;
	private TransactionItemNotes notes;
	private TransactionItemCreatedBy createdBy;
	private TransactionItemTenant tenant;



}
