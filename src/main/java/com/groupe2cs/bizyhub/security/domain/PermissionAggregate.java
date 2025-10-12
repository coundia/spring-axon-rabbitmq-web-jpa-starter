package com.groupe2cs.bizyhub.security.domain;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.domain.event.*;
import com.groupe2cs.bizyhub.security.application.command.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Aggregate
public class PermissionAggregate {

	@AggregateIdentifier
	private PermissionId id;
	private PermissionName name;
	private PermissionCreatedBy createdBy;
	private PermissionTenant tenant;


	@CommandHandler
	public PermissionAggregate(CreatePermissionCommand command) {
		apply(new PermissionCreatedEvent(
				command.getId(),
				command.getName(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@CommandHandler
	public void handle(DeletePermissionCommand command) {
		apply(new PermissionDeletedEvent(
				command.getId()
		));
	}

	@CommandHandler
	public void handle(UpdatePermissionCommand command) {
		apply(new PermissionUpdatedEvent(
				command.getId(),
				command.getName(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@EventSourcingHandler
	public void on(PermissionCreatedEvent event) {
		this.id = event.getId();
		this.name = event.getName();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

	@EventSourcingHandler
	public void on(PermissionDeletedEvent event) {
		this.id = event.getId();
	}

	@EventSourcingHandler
	public void on(PermissionUpdatedEvent event) {
		this.id = event.getId();
		this.name = event.getName();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

}
