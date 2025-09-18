package com.groupe2cs.bizyhub.fileManager.domain;

import com.groupe2cs.bizyhub.fileManager.domain.valueObject.*;
import com.groupe2cs.bizyhub.fileManager.domain.event.*;
import com.groupe2cs.bizyhub.fileManager.application.command.*;
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
public class FileManagerAggregate {

@AggregateIdentifier
private FileManagerId id;
private FileManagerName name;
private FileManagerDetails details;
private FileManagerObjectId objectId;
private FileManagerObjectName objectName;
private FileManagerOriginalName originalName;
private FileManagerMimeType mimeType;
private FileManagerSize size;
private FileManagerPath path;
private FileManagerUri uri;
private FileManagerIsPublic isPublic;
private FileManagerCreatedBy createdBy;
private FileManagerTenant tenant;


@CommandHandler
public FileManagerAggregate(CreateFileManagerCommand command) {
apply(new FileManagerCreatedEvent(
		command.getId(),
		command.getName(),
		command.getDetails(),
		command.getObjectId(),
		command.getObjectName(),
		command.getOriginalName(),
		command.getMimeType(),
		command.getSize(),
		command.getPath(),
		command.getUri(),
		command.getIsPublic(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@CommandHandler
public void handle(DeleteFileManagerCommand command) {
	apply(new FileManagerDeletedEvent(
		command.getId()
	));
}

@CommandHandler
public void handle(UpdateFileManagerCommand command) {
apply(new FileManagerUpdatedEvent(
		command.getId(),
		command.getName(),
		command.getDetails(),
		command.getObjectId(),
		command.getObjectName(),
		command.getOriginalName(),
		command.getMimeType(),
		command.getSize(),
		command.getPath(),
		command.getUri(),
		command.getIsPublic(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@EventSourcingHandler
public void on(FileManagerCreatedEvent event) {
	this.id = event.getId();
	this.name = event.getName();
	this.details = event.getDetails();
	this.objectId = event.getObjectId();
	this.objectName = event.getObjectName();
	this.originalName = event.getOriginalName();
	this.mimeType = event.getMimeType();
	this.size = event.getSize();
	this.path = event.getPath();
	this.uri = event.getUri();
	this.isPublic = event.getIsPublic();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

@EventSourcingHandler
public void on(FileManagerDeletedEvent event) {
this.id = event.getId();
}

@EventSourcingHandler
public void on(FileManagerUpdatedEvent event) {
this.id = event.getId();
	this.name = event.getName();
	this.details = event.getDetails();
	this.objectId = event.getObjectId();
	this.objectName = event.getObjectName();
	this.originalName = event.getOriginalName();
	this.mimeType = event.getMimeType();
	this.size = event.getSize();
	this.path = event.getPath();
	this.uri = event.getUri();
	this.isPublic = event.getIsPublic();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

}
