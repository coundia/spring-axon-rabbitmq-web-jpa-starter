package com.groupe2cs.bizyhub.sync.domain;

import com.groupe2cs.bizyhub.sync.application.command.CreateSyncStateCommand;
import com.groupe2cs.bizyhub.sync.application.command.DeleteSyncStateCommand;
import com.groupe2cs.bizyhub.sync.application.command.UpdateSyncStateCommand;
import com.groupe2cs.bizyhub.sync.domain.event.SyncStateCreatedEvent;
import com.groupe2cs.bizyhub.sync.domain.event.SyncStateDeletedEvent;
import com.groupe2cs.bizyhub.sync.domain.event.SyncStateUpdatedEvent;
import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
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
public class SyncStateAggregate {

	@AggregateIdentifier
	private SyncStateId id;
	private SyncStateEntityTable entityTable;
	private SyncStateRemoteId remoteId;
	private SyncStateLocalId localId;
	private SyncStateAccount account;
	private SyncStateSyncAt syncAt;
	private SyncStateLastSyncAt lastSyncAt;
	private SyncStateLastCursor lastCursor;
	private SyncStateCreatedBy createdBy;
	private SyncStateTenant tenant;


	@CommandHandler
	public SyncStateAggregate(CreateSyncStateCommand command) {
		apply(new SyncStateCreatedEvent(
				command.getId(),
				command.getEntityTable(),
				command.getRemoteId(),
				command.getLocalId(),
				command.getAccount(),
				command.getSyncAt(),
				command.getLastSyncAt(),
				command.getLastCursor(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@CommandHandler
	public void handle(DeleteSyncStateCommand command) {
		apply(new SyncStateDeletedEvent(
				command.getId()
		));
	}

	@CommandHandler
	public void handle(UpdateSyncStateCommand command) {
		apply(new SyncStateUpdatedEvent(
				command.getId(),
				command.getEntityTable(),
				command.getRemoteId(),
				command.getLocalId(),
				command.getAccount(),
				command.getSyncAt(),
				command.getLastSyncAt(),
				command.getLastCursor(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@EventSourcingHandler
	public void on(SyncStateCreatedEvent event) {
		this.id = event.getId();
		this.entityTable = event.getEntityTable();
		this.remoteId = event.getRemoteId();
		this.localId = event.getLocalId();
		this.account = event.getAccount();
		this.syncAt = event.getSyncAt();
		this.lastSyncAt = event.getLastSyncAt();
		this.lastCursor = event.getLastCursor();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

	@EventSourcingHandler
	public void on(SyncStateDeletedEvent event) {
		this.id = event.getId();
	}

	@EventSourcingHandler
	public void on(SyncStateUpdatedEvent event) {
		this.id = event.getId();
		this.entityTable = event.getEntityTable();
		this.remoteId = event.getRemoteId();
		this.localId = event.getLocalId();
		this.account = event.getAccount();
		this.syncAt = event.getSyncAt();
		this.lastSyncAt = event.getLastSyncAt();
		this.lastCursor = event.getLastCursor();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

}
