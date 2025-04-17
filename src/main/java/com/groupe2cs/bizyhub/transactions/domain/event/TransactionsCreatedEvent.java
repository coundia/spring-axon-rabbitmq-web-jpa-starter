package com.groupe2cs.bizyhub.transactions.domain.event;

	import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionsCreatedEvent implements Serializable {

	private TransactionsId id;
	private TransactionsReference reference;
	private TransactionsAmount amount;



}
