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
	private CategoryName name;
	private CategoryTypeCategoryRaw typeCategoryRaw;
	private CategoryDetails details;
	private CategoryIsActive isActive;
	private CategoryCreatedBy createdBy;
	private CategoryTenant tenant;


	@CommandHandler
	public CategoryAggregate(CreateCategoryCommand command) {
		apply(new CategoryCreatedEvent(
				command.getId(),
				command.getName(),
				command.getTypeCategoryRaw(),
				command.getDetails(),
				command.getIsActive(),
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
				command.getName(),
				command.getTypeCategoryRaw(),
				command.getDetails(),
				command.getIsActive(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@EventSourcingHandler
	public void on(CategoryCreatedEvent event) {
		this.id = event.getId();
		this.name = event.getName();
		this.typeCategoryRaw = event.getTypeCategoryRaw();
		this.details = event.getDetails();
		this.isActive = event.getIsActive();
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
		this.name = event.getName();
		this.typeCategoryRaw = event.getTypeCategoryRaw();
		this.details = event.getDetails();
		this.isActive = event.getIsActive();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

}
