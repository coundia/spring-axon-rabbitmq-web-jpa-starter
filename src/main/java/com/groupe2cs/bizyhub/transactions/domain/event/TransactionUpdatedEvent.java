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
public class TransactionUpdatedEvent implements Serializable {

	private TransactionId id;
	private TransactionAmount amount;
	private TransactionDateOperation dateOperation;
	private TransactionDescription description;
	private TransactionReference reference;
	private TransactionIsRecurring isRecurring;
	private TransactionIsExcluToRapport isExcluToRapport;
	private TransactionStatus status;
	private TransactionBalance balance;
	private TransactionCategory category;
	private TransactionUpdatedAt updatedAt;
	private TransactionCreatedAt createdAt;
	private TransactionCreatedBy createdBy;
	private TransactionTenant tenant;



}
