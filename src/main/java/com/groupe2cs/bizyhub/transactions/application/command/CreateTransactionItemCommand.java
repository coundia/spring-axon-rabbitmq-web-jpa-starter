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
public class CreateTransactionItemCommand implements Serializable {
@TargetAggregateIdentifier
	@Builder.Default
	private TransactionItemId id = TransactionItemId.create(UUID.randomUUID().toString());
 	private TransactionItemTransaction transaction;
 	private TransactionItemProduct product;
 	private TransactionItemLabel label;
 	private TransactionItemQuantity quantity;
 	private TransactionItemUnit unit;
 	private TransactionItemRemoteId remoteId;
 	private TransactionItemLocalId localId;
 	private TransactionItemSyncAt syncAt;
 	private TransactionItemUnitPrice unitPrice;
 	private TransactionItemTotal total;
 	private TransactionItemNotes notes;
 	private TransactionItemCreatedBy createdBy;
 	private TransactionItemTenant tenant;
	public CreateTransactionItemCommand(
 
   TransactionItemTransaction transaction , 
   TransactionItemProduct product , 
   TransactionItemLabel label , 
   TransactionItemQuantity quantity , 
   TransactionItemUnit unit , 
   TransactionItemRemoteId remoteId , 
   TransactionItemLocalId localId , 
   TransactionItemSyncAt syncAt , 
   TransactionItemUnitPrice unitPrice , 
   TransactionItemTotal total , 
   TransactionItemNotes notes , 
   TransactionItemCreatedBy createdBy , 
   TransactionItemTenant tenant  
		){
			this.id = TransactionItemId.create(UUID.randomUUID().toString());
 
  this.transaction = transaction ; 
  this.product = product ; 
  this.label = label ; 
  this.quantity = quantity ; 
  this.unit = unit ; 
  this.remoteId = remoteId ; 
  this.localId = localId ; 
  this.syncAt = syncAt ; 
  this.unitPrice = unitPrice ; 
  this.total = total ; 
  this.notes = notes ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
