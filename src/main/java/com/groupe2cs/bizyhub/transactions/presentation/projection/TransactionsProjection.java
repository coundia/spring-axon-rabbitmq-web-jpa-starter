package com.groupe2cs.bizyhub.transactions.presentation.projection;

import com.groupe2cs.bizyhub.transactions.domain.event.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
import org.axonframework.eventhandling.EventHandler;

import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TransactionsProjection {

private final TransactionsRepository repository;

public TransactionsProjection(TransactionsRepository repository) {
this.repository = repository;
}

@EventHandler
public void on(TransactionsCreatedEvent event) {
try {
Transactions entity = new Transactions(
		event.getId().value(),
		event.getReference().value(),
		event.getAmount().value()
);
repository.save(entity);
log.info("Transactions inserted: {}", entity);
} catch (Exception e) {
log.error("Error saving Transactions: {}", e.getMessage(), e);
}
}

@EventHandler
public void on(TransactionsUpdatedEvent event) {
try {
	Transactions entity = repository.findById(event.getId().value())
	.orElseThrow(() -> new RuntimeException("Transactions not found"));
	entity.setId(event.getId().value());
	entity.setReference(event.getReference().value());
	entity.setAmount(event.getAmount().value());
	repository.save(entity);
	log.info("Transactions updated successfully: {}", event.getId().value());
	} catch (Exception e) {
	log.error("Error updating Transactions: {}", e.getMessage(), e);
	}
}

@EventHandler
public void on(TransactionsDeletedEvent event) {
try {
repository.deleteById(event.getId().value());
log.info("Transactions deleted successfully: {}", event.getId().value());
} catch (Exception e) {
log.error("Error deleting Transactions: {}", e.getMessage(), e);
}
}
}
