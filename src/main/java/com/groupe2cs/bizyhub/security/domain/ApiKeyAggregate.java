package com.groupe2cs.bizyhub.security.domain;

import com.groupe2cs.bizyhub.security.application.command.CreateApiKeyCommand;
import com.groupe2cs.bizyhub.security.application.command.DeleteApiKeyCommand;
import com.groupe2cs.bizyhub.security.application.command.UpdateApiKeyCommand;
import com.groupe2cs.bizyhub.security.domain.event.ApiKeyCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.event.ApiKeyDeletedEvent;
import com.groupe2cs.bizyhub.security.domain.event.ApiKeyUpdatedEvent;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
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
public class ApiKeyAggregate {

	@AggregateIdentifier
	private ApiKeyId id;
	private ApiKeyAppKey appKey;
	private ApiKeyUsername username;
	private ApiKeyActive active;
	private ApiKeyCreatedAt createdAt;
	private ApiKeyExpiration expiration;
	private ApiKeyCreatedBy createdBy;
	private ApiKeyTenant tenant;


	@CommandHandler
	public ApiKeyAggregate(CreateApiKeyCommand command) {
		apply(new ApiKeyCreatedEvent(
				command.getId(),
				command.getAppKey(),
				command.getUsername(),
				command.getActive(),
				command.getCreatedAt(),
				command.getExpiration(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@CommandHandler
	public void handle(DeleteApiKeyCommand command) {
		apply(new ApiKeyDeletedEvent(
				command.getId()
		));
	}

	@CommandHandler
	public void handle(UpdateApiKeyCommand command) {
		apply(new ApiKeyUpdatedEvent(
				command.getId(),
				command.getAppKey(),
				command.getUsername(),
				command.getActive(),
				command.getCreatedAt(),
				command.getExpiration(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@EventSourcingHandler
	public void on(ApiKeyCreatedEvent event) {
		this.id = event.getId();
		this.appKey = event.getAppKey();
		this.username = event.getUsername();
		this.active = event.getActive();
		this.createdAt = event.getCreatedAt();
		this.expiration = event.getExpiration();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

	@EventSourcingHandler
	public void on(ApiKeyDeletedEvent event) {
		this.id = event.getId();
	}

	@EventSourcingHandler
	public void on(ApiKeyUpdatedEvent event) {
		this.id = event.getId();
		this.appKey = event.getAppKey();
		this.username = event.getUsername();
		this.active = event.getActive();
		this.createdAt = event.getCreatedAt();
		this.expiration = event.getExpiration();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

}
