package com.groupe2cs.bizyhub.transactions.application.command;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionAmount;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionId;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionReference;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTransactionCommand implements Serializable {
    @TargetAggregateIdentifier
    private TransactionId id;
    private TransactionReference reference;
    private TransactionAmount amount;

    public CreateTransactionCommand(

            TransactionReference reference,
            TransactionAmount amount
    ) {
        this.id = TransactionId.create(UUID.randomUUID().toString());

        this.reference = reference;
        this.amount = amount;
    }


}
