package com.groupe2cs.bizyhub.transactions.presentation.projection;

import com.groupe2cs.bizyhub.transactions.domain.event.TransactionCreatedEvent;
import com.groupe2cs.bizyhub.transactions.domain.event.TransactionDeletedEvent;
import com.groupe2cs.bizyhub.transactions.domain.event.TransactionUpdatedEvent;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TransactionProjection {

	private final TransactionRepository repository;

	public TransactionProjection(TransactionRepository repository) {
		this.repository = repository;
	}

	@EventHandler
	public void on(TransactionCreatedEvent event) {
		try {
			Transaction entity = new Transaction(
					event.getId().value(),
					event.getReference().value(),
					event.getAmount().value()
			);
			repository.save(entity);
			log.info("Transaction inserted: {}", entity);
		} catch (Exception e) {
			log.error("Error saving Transaction: {}", e.getMessage(), e);
		}
	}

	@EventHandler
	public void on(TransactionUpdatedEvent event) {
		try {
			Transaction entity = repository.findById(event.getId().value())
					.orElseThrow(() -> new RuntimeException("Transaction not found"));
			entity.setId(event.getId().value());
			entity.setReference(event.getReference().value());
			entity.setAmount(event.getAmount().value());
			repository.save(entity);
			log.info("Transaction updated successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error updating Transaction: {}", e.getMessage(), e);
		}
	}

	@EventHandler
	public void on(TransactionDeletedEvent event) {
		try {
			repository.deleteById(event.getId().value());
			log.info("Transaction deleted successfully: {}", event.getId().value());
		} catch (Exception e) {
			log.error("Error deleting Transaction: {}", e.getMessage(), e);
		}
	}
}
