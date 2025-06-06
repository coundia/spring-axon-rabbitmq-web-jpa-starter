package com.groupe2cs.bizyhub.settings.domain;

import com.groupe2cs.bizyhub.settings.application.command.CreateSettingCommand;
import com.groupe2cs.bizyhub.settings.application.command.DeleteSettingCommand;
import com.groupe2cs.bizyhub.settings.application.command.UpdateSettingCommand;
import com.groupe2cs.bizyhub.settings.domain.event.SettingCreatedEvent;
import com.groupe2cs.bizyhub.settings.domain.event.SettingDeletedEvent;
import com.groupe2cs.bizyhub.settings.domain.event.SettingUpdatedEvent;
import com.groupe2cs.bizyhub.settings.domain.valueObject.*;
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
public class SettingAggregate {

	@AggregateIdentifier
	private SettingId id;
	private SettingName name;
	private SettingValue value;
	private SettingLocale locale;
	private SettingDetails details;
	private SettingIsActive isActive;
	private SettingCreatedBy createdBy;
	private SettingTenant tenant;


	@CommandHandler
	public SettingAggregate(CreateSettingCommand command) {
		apply(new SettingCreatedEvent(
				command.getId(),
				command.getName(),
				command.getValue(),
				command.getLocale(),
				command.getDetails(),
				command.getIsActive(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@CommandHandler
	public void handle(DeleteSettingCommand command) {
		apply(new SettingDeletedEvent(
				command.getId()
		));
	}

	@CommandHandler
	public void handle(UpdateSettingCommand command) {
		apply(new SettingUpdatedEvent(
				command.getId(),
				command.getName(),
				command.getValue(),
				command.getLocale(),
				command.getDetails(),
				command.getIsActive(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@EventSourcingHandler
	public void on(SettingCreatedEvent event) {
		this.id = event.getId();
		this.name = event.getName();
		this.value = event.getValue();
		this.locale = event.getLocale();
		this.details = event.getDetails();
		this.isActive = event.getIsActive();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

	@EventSourcingHandler
	public void on(SettingDeletedEvent event) {
		this.id = event.getId();
	}

	@EventSourcingHandler
	public void on(SettingUpdatedEvent event) {
		this.id = event.getId();
		this.name = event.getName();
		this.value = event.getValue();
		this.locale = event.getLocale();
		this.details = event.getDetails();
		this.isActive = event.getIsActive();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

}
