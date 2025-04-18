package com.groupe2cs.bizyhub.transactions.infrastructure.rabbitMq;

import com.groupe2cs.bizyhub.transactions.domain.event.TransactionCreatedEvent;
import com.groupe2cs.bizyhub.transactions.domain.event.TransactionDeletedEvent;
import com.groupe2cs.bizyhub.transactions.domain.event.TransactionUpdatedEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionEventPublisher {

	private final RabbitTemplate rabbitTemplate;

	@EventHandler
	public void on(TransactionCreatedEvent event) {
		rabbitTemplate.convertAndSend("transaction.exchange", "transaction.created", event);
	}

	@EventHandler
	public void on(TransactionUpdatedEvent event) {
		rabbitTemplate.convertAndSend("transaction.exchange", "transaction.updated", event);
	}

	@EventHandler
	public void on(TransactionDeletedEvent event) {
		rabbitTemplate.convertAndSend("transaction.exchange", "transaction.deleted", event);
	}
}
