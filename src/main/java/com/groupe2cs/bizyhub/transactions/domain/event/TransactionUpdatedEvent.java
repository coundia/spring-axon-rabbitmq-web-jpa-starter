package com.groupe2cs.bizyhub.transactions.domain.event;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionAmount;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionId;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionUpdatedEvent implements Serializable {

    private TransactionId id;
    private TransactionReference reference;
    private TransactionAmount amount;


}
