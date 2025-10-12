package com.groupe2cs.bizyhub.transactions.domain.event;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionItemId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionItemDeletedEvent implements Serializable {


	private TransactionItemId id;

}
