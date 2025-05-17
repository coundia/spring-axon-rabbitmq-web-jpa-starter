package com.groupe2cs.bizyhub.accounts.application.command;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;

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
public class CreateAccountCommand implements Serializable {
@TargetAggregateIdentifier
	@Builder.Default
	private AccountId id = AccountId.create(UUID.randomUUID().toString());
 	private AccountName name;
 	private AccountCurrency currency;
 	private AccountCurrentBalance currentBalance;
 	private AccountPreviousBalance previousBalance;
 	private AccountDetails details;
 	private AccountIsActive isActive;
 	private AccountUpdatedAt updatedAt;
 	private AccountReference reference;
 	private AccountCreatedBy createdBy;
 	private AccountTenant tenant;
	public CreateAccountCommand(
 
   AccountName name , 
   AccountCurrency currency , 
   AccountCurrentBalance currentBalance , 
   AccountPreviousBalance previousBalance , 
   AccountDetails details , 
   AccountIsActive isActive , 
   AccountUpdatedAt updatedAt , 
   AccountReference reference , 
   AccountCreatedBy createdBy , 
   AccountTenant tenant  
		){
			this.id = AccountId.create(UUID.randomUUID().toString());
 
  this.name = name ; 
  this.currency = currency ; 
  this.currentBalance = currentBalance ; 
  this.previousBalance = previousBalance ; 
  this.details = details ; 
  this.isActive = isActive ; 
  this.updatedAt = updatedAt ; 
  this.reference = reference ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
