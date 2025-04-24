package com.groupe2cs.bizyhub.security.domain;

import com.groupe2cs.bizyhub.security.application.command.CreateRefreshTokenCommand;
import com.groupe2cs.bizyhub.security.application.command.DeleteRefreshTokenCommand;
import com.groupe2cs.bizyhub.security.application.command.UpdateRefreshTokenCommand;
import com.groupe2cs.bizyhub.security.domain.event.RefreshTokenCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.event.RefreshTokenDeletedEvent;
import com.groupe2cs.bizyhub.security.domain.event.RefreshTokenUpdatedEvent;
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
public class RefreshTokenAggregate {

	@AggregateIdentifier
	private RefreshTokenId id;
	private RefreshTokenToken token;
	private RefreshTokenUsername username;
	private RefreshTokenExpiration expiration;
	private RefreshTokenCreatedBy createdBy;


	@CommandHandler
	public RefreshTokenAggregate(CreateRefreshTokenCommand command) {
		apply(new RefreshTokenCreatedEvent(
				command.getId(),
				command.getToken(),
				command.getUsername(),
				command.getExpiration(),
				command.getCreatedBy()
		));
	}

	@CommandHandler
	public void handle(DeleteRefreshTokenCommand command) {
		apply(new RefreshTokenDeletedEvent(
				command.getId()
		));
	}

	@CommandHandler
	public void handle(UpdateRefreshTokenCommand command) {
		apply(new RefreshTokenUpdatedEvent(
				command.getId(),
				command.getToken(),
				command.getUsername(),
				command.getExpiration(),
				command.getCreatedBy()
		));
	}

	@EventSourcingHandler
	public void on(RefreshTokenCreatedEvent event) {
		this.id = event.getId();
		this.token = event.getToken();
		this.username = event.getUsername();
		this.expiration = event.getExpiration();
		this.createdBy = event.getCreatedBy();
	}

	@EventSourcingHandler
	public void on(RefreshTokenDeletedEvent event) {
		this.id = event.getId();
	}

	@EventSourcingHandler
	public void on(RefreshTokenUpdatedEvent event) {
		this.id = event.getId();
		this.token = event.getToken();
		this.username = event.getUsername();
		this.expiration = event.getExpiration();
		this.createdBy = event.getCreatedBy();
	}

}
