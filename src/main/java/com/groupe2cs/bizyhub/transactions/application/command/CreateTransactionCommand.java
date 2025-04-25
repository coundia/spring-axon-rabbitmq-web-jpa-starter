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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTransactionCommand implements Serializable {
@TargetAggregateIdentifier
	@Builder.Default
	private TransactionId id = TransactionId.create(UUID.randomUUID().toString());
 	private TransactionReference reference;
 	private TransactionAmount amount;
 	private TransactionCreatedBy createdBy;
 	private TransactionTenant tenant;
	public CreateTransactionCommand(
 
   TransactionReference reference , 
   TransactionAmount amount , 
   TransactionCreatedBy createdBy , 
   TransactionTenant tenant  
		){
			this.id = TransactionId.create(UUID.randomUUID().toString());
 
  this.reference = reference ; 
  this.amount = amount ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
