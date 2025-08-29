package com.groupe2cs.bizyhub.transactions.domain.event;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionUserId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionUserDeletedEvent implements Serializable {


	private TransactionUserId id;

}
