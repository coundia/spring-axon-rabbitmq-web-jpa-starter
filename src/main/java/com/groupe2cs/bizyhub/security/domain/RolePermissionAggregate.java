package com.groupe2cs.bizyhub.security.domain;

import com.groupe2cs.bizyhub.security.application.command.CreateRolePermissionCommand;
import com.groupe2cs.bizyhub.security.application.command.DeleteRolePermissionCommand;
import com.groupe2cs.bizyhub.security.application.command.UpdateRolePermissionCommand;
import com.groupe2cs.bizyhub.security.domain.event.RolePermissionCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.event.RolePermissionDeletedEvent;
import com.groupe2cs.bizyhub.security.domain.event.RolePermissionUpdatedEvent;
import com.groupe2cs.bizyhub.security.domain.valueObject.RolePermissionId;
import com.groupe2cs.bizyhub.security.domain.valueObject.RolePermissionPermission;
import com.groupe2cs.bizyhub.security.domain.valueObject.RolePermissionRole;
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
public class RolePermissionAggregate {

	@AggregateIdentifier
	private RolePermissionId id;
	private RolePermissionRole role;
	private RolePermissionPermission permission;


	@CommandHandler
	public RolePermissionAggregate(CreateRolePermissionCommand command) {
		apply(new RolePermissionCreatedEvent(
				command.getId(),
				command.getRole(),
				command.getPermission()
		));
	}

	@CommandHandler
	public void handle(DeleteRolePermissionCommand command) {
		apply(new RolePermissionDeletedEvent(
				command.getId()
		));
	}

	@CommandHandler
	public void handle(UpdateRolePermissionCommand command) {
		apply(new RolePermissionUpdatedEvent(
				command.getId(),
				command.getRole(),
				command.getPermission()
		));
	}

	@EventSourcingHandler
	public void on(RolePermissionCreatedEvent event) {
		this.id = event.getId();
		this.role = event.getRole();
		this.permission = event.getPermission();
	}

	@EventSourcingHandler
	public void on(RolePermissionDeletedEvent event) {
		this.id = event.getId();
	}

	@EventSourcingHandler
	public void on(RolePermissionUpdatedEvent event) {
		this.id = event.getId();
		this.role = event.getRole();
		this.permission = event.getPermission();
	}

}
