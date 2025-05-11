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
public class CreateTransactionUserCommand implements Serializable {
@TargetAggregateIdentifier
	@Builder.Default
	private TransactionUserId id = TransactionUserId.create(UUID.randomUUID().toString());
 	private TransactionUserName name;
 	private TransactionUserTransaction transaction;
 	private TransactionUserUser user;
 	private TransactionUserUsername username;
 	private TransactionUserDetails details;
 	private TransactionUserIsActive isActive;
 	private TransactionUserUpdatedAt updatedAt;
 	private TransactionUserReference reference;
 	private TransactionUserCreatedBy createdBy;
 	private TransactionUserTenant tenant;
	public CreateTransactionUserCommand(
 
   TransactionUserName name , 
   TransactionUserTransaction transaction , 
   TransactionUserUser user , 
   TransactionUserUsername username , 
   TransactionUserDetails details , 
   TransactionUserIsActive isActive , 
   TransactionUserUpdatedAt updatedAt , 
   TransactionUserReference reference , 
   TransactionUserCreatedBy createdBy , 
   TransactionUserTenant tenant  
		){
			this.id = TransactionUserId.create(UUID.randomUUID().toString());
 
  this.name = name ; 
  this.transaction = transaction ; 
  this.user = user ; 
  this.username = username ; 
  this.details = details ; 
  this.isActive = isActive ; 
  this.updatedAt = updatedAt ; 
  this.reference = reference ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
