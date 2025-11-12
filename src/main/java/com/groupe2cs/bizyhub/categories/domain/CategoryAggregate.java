package com.groupe2cs.bizyhub.categories.domain;

import com.groupe2cs.bizyhub.categories.application.command.CreateCategoryCommand;
import com.groupe2cs.bizyhub.categories.application.command.DeleteCategoryCommand;
import com.groupe2cs.bizyhub.categories.application.command.UpdateCategoryCommand;
import com.groupe2cs.bizyhub.categories.domain.event.CategoryCreatedEvent;
import com.groupe2cs.bizyhub.categories.domain.event.CategoryDeletedEvent;
import com.groupe2cs.bizyhub.categories.domain.event.CategoryUpdatedEvent;
import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
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
public class CategoryAggregate {

	@AggregateIdentifier
	private CategoryId id;
	private CategoryCode code;
	private CategoryName name;
	private CategoryRemoteId remoteId;
	private CategoryLocalId localId;
	private CategoryAccount account;
	private CategoryStatus status;
	private CategoryIsPublic isPublic;
	private CategoryDescription description;
	private CategoryTypeEntry typeEntry;
	private CategoryVersion version;
	private CategorySyncAt syncAt;
	private CategoryCreatedBy createdBy;
	private CategoryTenant tenant;


	@CommandHandler
	public CategoryAggregate(CreateCategoryCommand command) {
		apply(new CategoryCreatedEvent(
				command.getId(),
				command.getCode(),
				command.getName(),
				command.getRemoteId(),
				command.getLocalId(),
				command.getAccount(),
				command.getStatus(),
				command.getIsPublic(),
				command.getDescription(),
				command.getTypeEntry(),
				command.getVersion(),
				command.getSyncAt(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@CommandHandler
	public void handle(DeleteCategoryCommand command) {
		apply(new CategoryDeletedEvent(
				command.getId()
		));
	}

	@CommandHandler
	public void handle(UpdateCategoryCommand command) {
		apply(new CategoryUpdatedEvent(
				command.getId(),
				command.getCode(),
				command.getName(),
				command.getRemoteId(),
				command.getLocalId(),
				command.getAccount(),
				command.getStatus(),
				command.getIsPublic(),
				command.getDescription(),
				command.getTypeEntry(),
				command.getVersion(),
				command.getSyncAt(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@EventSourcingHandler
	public void on(CategoryCreatedEvent event) {
		this.id = event.getId();
		this.code = event.getCode();
		this.name = event.getName();
		this.remoteId = event.getRemoteId();
		this.localId = event.getLocalId();
		this.account = event.getAccount();
		this.status = event.getStatus();
		this.isPublic = event.getIsPublic();
		this.description = event.getDescription();
		this.typeEntry = event.getTypeEntry();
		this.version = event.getVersion();
		this.syncAt = event.getSyncAt();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

	@EventSourcingHandler
	public void on(CategoryDeletedEvent event) {
		this.id = event.getId();
	}

	@EventSourcingHandler
	public void on(CategoryUpdatedEvent event) {
		this.id = event.getId();
		this.code = event.getCode();
		this.name = event.getName();
		this.remoteId = event.getRemoteId();
		this.localId = event.getLocalId();
		this.account = event.getAccount();
		this.status = event.getStatus();
		this.isPublic = event.getIsPublic();
		this.description = event.getDescription();
		this.typeEntry = event.getTypeEntry();
		this.version = event.getVersion();
		this.syncAt = event.getSyncAt();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

}
