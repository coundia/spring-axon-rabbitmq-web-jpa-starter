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
public class UpdateTransactionCommand implements Serializable {
@TargetAggregateIdentifier
	private TransactionId id;
 	private TransactionName name;
 	private TransactionAmount amount;
 	private TransactionRemoteId remoteId;
 	private TransactionLocalId localId;
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


}
