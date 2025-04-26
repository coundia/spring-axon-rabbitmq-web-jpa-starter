package com.groupe2cs.bizyhub.security.domain;

import com.groupe2cs.bizyhub.security.application.command.CreatePermissionCommand;
import com.groupe2cs.bizyhub.security.application.command.DeletePermissionCommand;
import com.groupe2cs.bizyhub.security.application.command.UpdatePermissionCommand;
import com.groupe2cs.bizyhub.security.domain.event.PermissionCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.event.PermissionDeletedEvent;
import com.groupe2cs.bizyhub.security.domain.event.PermissionUpdatedEvent;
import com.groupe2cs.bizyhub.security.domain.valueObject.PermissionCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.PermissionId;
import com.groupe2cs.bizyhub.security.domain.valueObject.PermissionName;
import com.groupe2cs.bizyhub.security.domain.valueObject.PermissionTenant;
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
