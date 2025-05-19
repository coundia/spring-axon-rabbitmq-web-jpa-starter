package com.groupe2cs.bizyhub.categories.domain;

import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
import com.groupe2cs.bizyhub.categories.domain.event.*;
import com.groupe2cs.bizyhub.categories.application.command.*;
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
public class CategoryAggregate {

@AggregateIdentifier
private CategoryId id;
private CategoryName name;
private CategoryTypeCategoryRaw typeCategoryRaw;
private CategoryDetails details;
private CategoryIsActive isActive;
private CategoryUpdatedAt updatedAt;
private CategoryReference reference;
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
		command.getUpdatedAt(),
		command.getReference(),
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
		command.getUpdatedAt(),
		command.getReference(),
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
	this.updatedAt = event.getUpdatedAt();
	this.reference = event.getReference();
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
	this.updatedAt = event.getUpdatedAt();
	this.reference = event.getReference();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

}
