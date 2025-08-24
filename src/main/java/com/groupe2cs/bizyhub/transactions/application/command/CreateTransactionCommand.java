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
public class CreateTransactionCommand implements Serializable {
@TargetAggregateIdentifier
	@Builder.Default
	private TransactionId id = TransactionId.create(UUID.randomUUID().toString());
 	private TransactionName name;
 	private TransactionAmount amount;
 	private TransactionRemoteId remoteId;
 	private TransactionDetails details;
 	private TransactionIsActive isActive;
 	private TransactionSyncAt syncAt;
 	private TransactionAccount account;
 	private TransactionCategory category;
 	private TransactionTypeEntry typeEntry;
 	private TransactionTypeTransactionRaw typeTransactionRaw;
 	private TransactionDateTransaction dateTransaction;
 	private TransactionCreatedBy createdBy;
 	private TransactionTenant tenant;
	public CreateTransactionCommand(
 
   TransactionName name , 
   TransactionAmount amount , 
   TransactionRemoteId remoteId , 
   TransactionDetails details , 
   TransactionIsActive isActive , 
   TransactionSyncAt syncAt , 
   TransactionAccount account , 
   TransactionCategory category , 
   TransactionTypeEntry typeEntry , 
   TransactionTypeTransactionRaw typeTransactionRaw , 
   TransactionDateTransaction dateTransaction , 
   TransactionCreatedBy createdBy , 
   TransactionTenant tenant  
		){
			this.id = TransactionId.create(UUID.randomUUID().toString());
 
  this.name = name ; 
  this.amount = amount ; 
  this.remoteId = remoteId ; 
  this.details = details ; 
  this.isActive = isActive ; 
  this.syncAt = syncAt ; 
  this.account = account ; 
  this.category = category ; 
  this.typeEntry = typeEntry ; 
  this.typeTransactionRaw = typeTransactionRaw ; 
  this.dateTransaction = dateTransaction ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
