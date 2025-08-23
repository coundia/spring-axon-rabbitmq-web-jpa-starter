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
public class CreateTransactionEntryCommand implements Serializable {
@TargetAggregateIdentifier
	@Builder.Default
	private TransactionEntryId id = TransactionEntryId.create(UUID.randomUUID().toString());
 	private TransactionEntryRemoteId remoteId;
 	private TransactionEntryCode code;
 	private TransactionEntryDescription description;
 	private TransactionEntryAmount amount;
 	private TransactionEntryTypeEntry typeEntry;
 	private TransactionEntryDateTransaction dateTransaction;
 	private TransactionEntryStatus status;
 	private TransactionEntryEntityName entityName;
 	private TransactionEntryEntityId entityId;
 	private TransactionEntryAccount account;
 	private TransactionEntrySyncAt syncAt;
 	private TransactionEntryCategory category;
 	private TransactionEntryCompany company;
 	private TransactionEntryCustomer customer;
 	private TransactionEntryDebt debt;
 	private TransactionEntryCreatedBy createdBy;
 	private TransactionEntryTenant tenant;
	public CreateTransactionEntryCommand(
 
   TransactionEntryRemoteId remoteId , 
   TransactionEntryCode code , 
   TransactionEntryDescription description , 
   TransactionEntryAmount amount , 
   TransactionEntryTypeEntry typeEntry , 
   TransactionEntryDateTransaction dateTransaction , 
   TransactionEntryStatus status , 
   TransactionEntryEntityName entityName , 
   TransactionEntryEntityId entityId , 
   TransactionEntryAccount account , 
   TransactionEntrySyncAt syncAt , 
   TransactionEntryCategory category , 
   TransactionEntryCompany company , 
   TransactionEntryCustomer customer , 
   TransactionEntryDebt debt , 
   TransactionEntryCreatedBy createdBy , 
   TransactionEntryTenant tenant  
		){
			this.id = TransactionEntryId.create(UUID.randomUUID().toString());
 
  this.remoteId = remoteId ; 
  this.code = code ; 
  this.description = description ; 
  this.amount = amount ; 
  this.typeEntry = typeEntry ; 
  this.dateTransaction = dateTransaction ; 
  this.status = status ; 
  this.entityName = entityName ; 
  this.entityId = entityId ; 
  this.account = account ; 
  this.syncAt = syncAt ; 
  this.category = category ; 
  this.company = company ; 
  this.customer = customer ; 
  this.debt = debt ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
