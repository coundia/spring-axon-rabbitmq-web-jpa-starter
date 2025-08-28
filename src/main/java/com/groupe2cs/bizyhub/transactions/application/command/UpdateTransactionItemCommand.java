package com.groupe2cs.bizyhub.transactions.application.command;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;

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
