package com.groupe2cs.bizyhub.security.domain;

import com.groupe2cs.bizyhub.security.application.command.CreateVerificationCodeCommand;
import com.groupe2cs.bizyhub.security.application.command.DeleteVerificationCodeCommand;
import com.groupe2cs.bizyhub.security.application.command.UpdateVerificationCodeCommand;
import com.groupe2cs.bizyhub.security.domain.event.VerificationCodeCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.event.VerificationCodeDeletedEvent;
import com.groupe2cs.bizyhub.security.domain.event.VerificationCodeUpdatedEvent;
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
public class VerificationCodeAggregate {

	@AggregateIdentifier
	private VerificationCodeId id;
	private VerificationCodeNotes notes;
	private VerificationCodeToken token;
	private VerificationCodeUsername username;
	private VerificationCodePhone phone;
	private VerificationCodeEmail email;
	private VerificationCodeCode code;
	private VerificationCodeStatus status;
	private VerificationCodeSource source;
	private VerificationCodeExpiration expiration;
	private VerificationCodeCreatedBy createdBy;
	private VerificationCodeTenant tenant;


	@CommandHandler
	public VerificationCodeAggregate(CreateVerificationCodeCommand command) {
		apply(new VerificationCodeCreatedEvent(
				command.getId(),
				command.getNotes(),
				command.getToken(),
				command.getUsername(),
				command.getPhone(),
				command.getEmail(),
				command.getCode(),
				command.getStatus(),
				command.getSource(),
				command.getExpiration(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@CommandHandler
	public void handle(DeleteVerificationCodeCommand command) {
		apply(new VerificationCodeDeletedEvent(
				command.getId()
		));
	}

	@CommandHandler
	public void handle(UpdateVerificationCodeCommand command) {
		apply(new VerificationCodeUpdatedEvent(
				command.getId(),
				command.getNotes(),
				command.getToken(),
				command.getUsername(),
				command.getPhone(),
				command.getEmail(),
				command.getCode(),
				command.getStatus(),
				command.getSource(),
				command.getExpiration(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@EventSourcingHandler
	public void on(VerificationCodeCreatedEvent event) {
		this.id = event.getId();
		this.notes = event.getNotes();
		this.token = event.getToken();
		this.username = event.getUsername();
		this.phone = event.getPhone();
		this.email = event.getEmail();
		this.code = event.getCode();
		this.status = event.getStatus();
		this.source = event.getSource();
		this.expiration = event.getExpiration();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

	@EventSourcingHandler
	public void on(VerificationCodeDeletedEvent event) {
		this.id = event.getId();
	}

	@EventSourcingHandler
	public void on(VerificationCodeUpdatedEvent event) {
		this.id = event.getId();
		this.notes = event.getNotes();
		this.token = event.getToken();
		this.username = event.getUsername();
		this.phone = event.getPhone();
		this.email = event.getEmail();
		this.code = event.getCode();
		this.status = event.getStatus();
		this.source = event.getSource();
		this.expiration = event.getExpiration();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

}
