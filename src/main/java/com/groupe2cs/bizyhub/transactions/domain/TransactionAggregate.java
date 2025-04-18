package com.groupe2cs.bizyhub.transactions.domain;

import com.groupe2cs.bizyhub.transactions.application.command.CreateTransactionCommand;
import com.groupe2cs.bizyhub.transactions.application.command.DeleteTransactionCommand;
import com.groupe2cs.bizyhub.transactions.application.command.UpdateTransactionCommand;
import com.groupe2cs.bizyhub.transactions.domain.event.TransactionCreatedEvent;
import com.groupe2cs.bizyhub.transactions.domain.event.TransactionDeletedEvent;
import com.groupe2cs.bizyhub.transactions.domain.event.TransactionUpdatedEvent;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionAmount;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionId;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Aggregate
public class TransactionAggregate {

    @AggregateIdentifier
    private TransactionId id;
    private TransactionReference reference;
    private TransactionAmount amount;


    @CommandHandler
    public TransactionAggregate(CreateTransactionCommand command) {
        apply(new TransactionCreatedEvent(
                command.getId(),
                command.getReference(),
                command.getAmount()
        ));
    }

    @CommandHandler
    public void handle(DeleteTransactionCommand command) {
        apply(new TransactionDeletedEvent(
                command.getId()
        ));
    }

    @CommandHandler
    public void handle(UpdateTransactionCommand command) {
        apply(new TransactionUpdatedEvent(
                command.getId(),
                command.getReference(),
                command.getAmount()
        ));
    }

    @EventSourcingHandler
    public void on(TransactionCreatedEvent event) {
        this.id = event.getId();
        this.reference = event.getReference();
        this.amount = event.getAmount();
    }

    @EventSourcingHandler
    public void on(TransactionDeletedEvent event) {
        this.id = event.getId();
    }

    @EventSourcingHandler
    public void on(TransactionUpdatedEvent event) {
        this.id = event.getId();
        this.reference = event.getReference();
        this.amount = event.getAmount();
    }

}
