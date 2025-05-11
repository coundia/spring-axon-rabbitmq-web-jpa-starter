package com.groupe2cs.bizyhub.balances.application.command;

import com.groupe2cs.bizyhub.balances.domain.valueObject.*;

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
public class CreateBalanceCommand implements Serializable {
@TargetAggregateIdentifier
	@Builder.Default
	private BalanceId id = BalanceId.create(UUID.randomUUID().toString());
 	private BalanceName name;
 	private BalanceCurrency currency;
 	private BalanceCurrentBalance currentBalance;
 	private BalancePreviousBalance previousBalance;
 	private BalanceLastUpdated lastUpdated;
 	private BalanceIsDefault isDefault;
 	private BalanceOrdre ordre;
 	private BalanceIsArchived isArchived;
 	private BalanceIsAllowDebit isAllowDebit;
 	private BalanceIsAllowCredit isAllowCredit;
 	private BalanceIsExcluTotal isExcluTotal;
 	private BalanceActivateNotification activateNotification;
 	private BalanceSyncedAt syncedAt;
 	private BalanceUpdatedAt updatedAt;
 	private BalanceReference reference;
 	private BalanceCreatedBy createdBy;
 	private BalanceTenant tenant;
	public CreateBalanceCommand(
 
   BalanceName name , 
   BalanceCurrency currency , 
   BalanceCurrentBalance currentBalance , 
   BalancePreviousBalance previousBalance , 
   BalanceLastUpdated lastUpdated , 
   BalanceIsDefault isDefault , 
   BalanceOrdre ordre , 
   BalanceIsArchived isArchived , 
   BalanceIsAllowDebit isAllowDebit , 
   BalanceIsAllowCredit isAllowCredit , 
   BalanceIsExcluTotal isExcluTotal , 
   BalanceActivateNotification activateNotification , 
   BalanceSyncedAt syncedAt , 
   BalanceUpdatedAt updatedAt , 
   BalanceReference reference , 
   BalanceCreatedBy createdBy , 
   BalanceTenant tenant  
		){
			this.id = BalanceId.create(UUID.randomUUID().toString());
 
  this.name = name ; 
  this.currency = currency ; 
  this.currentBalance = currentBalance ; 
  this.previousBalance = previousBalance ; 
  this.lastUpdated = lastUpdated ; 
  this.isDefault = isDefault ; 
  this.ordre = ordre ; 
  this.isArchived = isArchived ; 
  this.isAllowDebit = isAllowDebit ; 
  this.isAllowCredit = isAllowCredit ; 
  this.isExcluTotal = isExcluTotal ; 
  this.activateNotification = activateNotification ; 
  this.syncedAt = syncedAt ; 
  this.updatedAt = updatedAt ; 
  this.reference = reference ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
