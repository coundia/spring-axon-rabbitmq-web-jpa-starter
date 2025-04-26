package com.groupe2cs.bizyhub.security.domain;

import com.groupe2cs.bizyhub.security.application.command.CreatePasswordResetCommand;
import com.groupe2cs.bizyhub.security.application.command.DeletePasswordResetCommand;
import com.groupe2cs.bizyhub.security.application.command.UpdatePasswordResetCommand;
import com.groupe2cs.bizyhub.security.domain.event.PasswordResetCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.event.PasswordResetDeletedEvent;
import com.groupe2cs.bizyhub.security.domain.event.PasswordResetUpdatedEvent;
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
public class PasswordResetAggregate {

	@AggregateIdentifier
	private PasswordResetId id;
	private PasswordResetToken token;
	private PasswordResetUsername username;
	private PasswordResetExpiration expiration;
	private PasswordResetCreatedBy createdBy;
	private PasswordResetTenant tenant;


	@CommandHandler
	public PasswordResetAggregate(CreatePasswordResetCommand command) {
		apply(new PasswordResetCreatedEvent(
				command.getId(),
				command.getToken(),
				command.getUsername(),
				command.getExpiration(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@CommandHandler
	public void handle(DeletePasswordResetCommand command) {
		apply(new PasswordResetDeletedEvent(
				command.getId()
		));
	}

	@CommandHandler
	public void handle(UpdatePasswordResetCommand command) {
		apply(new PasswordResetUpdatedEvent(
				command.getId(),
				command.getToken(),
				command.getUsername(),
				command.getExpiration(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@EventSourcingHandler
	public void on(PasswordResetCreatedEvent event) {
		this.id = event.getId();
		this.token = event.getToken();
		this.username = event.getUsername();
		this.expiration = event.getExpiration();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

	@EventSourcingHandler
	public void on(PasswordResetDeletedEvent event) {
		this.id = event.getId();
	}

	@EventSourcingHandler
	public void on(PasswordResetUpdatedEvent event) {
		this.id = event.getId();
		this.token = event.getToken();
		this.username = event.getUsername();
		this.expiration = event.getExpiration();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

}
