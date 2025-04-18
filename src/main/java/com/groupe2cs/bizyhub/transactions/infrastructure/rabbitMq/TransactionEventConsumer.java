package com.groupe2cs.bizyhub.transactions.infrastructure.rabbitMq;

import com.groupe2cs.bizyhub.transactions.infrastructure.repository.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction;
import com.groupe2cs.bizyhub.transactions.domain.event.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TransactionEventConsumer {

	private final TransactionRepository repository;

	@RabbitListener(queues = "transaction.created.queue")
	public void handleCreated(TransactionCreatedEvent e) {
	try {
	Transaction entity = Transaction.builder()
		.id(e.getId().value())
		.reference(e.getReference().value())
		.amount(e.getAmount().value())
	.build();
	repository.save(entity);
	log.info("Persisted from RabbitMQ: {}", entity);
	} catch (Exception ex) {
	log.error("Failed to persist created event: {}", ex.getMessage(), ex);
	}
	}

	@RabbitListener(queues = "transaction.updated.queue")
	public void handleUpdated(TransactionUpdatedEvent e) {
	try {
	repository.findById(e.getId().value()).ifPresentOrElse(existing -> {
		
		existing.setReference(e.getReference().value());
		existing.setAmount(e.getAmount().value());
	repository.save(existing);
	log.info("Updated from RabbitMQ: {}", existing);
	}, () -> log.warn("Transaction not found for update: {}", e.getId().value()));
	} catch (Exception ex) {
	log.error("Failed to process updated event: {}", ex.getMessage(), ex);
	}
	}

	@RabbitListener(queues = "transaction.deleted.queue")
	public void handleDeleted(TransactionDeletedEvent e) {
	try {
	repository.deleteById(e.getId().value());
	log.info("Deleted from RabbitMQ: {}", e.getId().value());
	} catch (Exception ex) {
	log.error("Failed to delete from RabbitMQ: {}", ex.getMessage(), ex);
	}
	}
}
