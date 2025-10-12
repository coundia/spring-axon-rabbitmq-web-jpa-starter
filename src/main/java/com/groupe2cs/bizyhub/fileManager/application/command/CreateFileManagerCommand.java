package com.groupe2cs.bizyhub.fileManager.application.command;

import com.groupe2cs.bizyhub.fileManager.domain.valueObject.*;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

import java.util.Date;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;


import java.time.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateFileManagerCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private FileManagerId id = FileManagerId.create(UUID.randomUUID().toString());
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

	public CreateFileManagerCommand(

			FileManagerName name,
			FileManagerDetails details,
			FileManagerObjectId objectId,
			FileManagerObjectName objectName,
			FileManagerOriginalName originalName,
			FileManagerMimeType mimeType,
			FileManagerSize size,
			FileManagerPath path,
			FileManagerUri uri,
			FileManagerIsPublic isPublic,
			FileManagerCreatedBy createdBy,
			FileManagerTenant tenant
	) {
		this.id = FileManagerId.create(UUID.randomUUID().toString());

		this.name = name;
		this.details = details;
		this.objectId = objectId;
		this.objectName = objectName;
		this.originalName = originalName;
		this.mimeType = mimeType;
		this.size = size;
		this.path = path;
		this.uri = uri;
		this.isPublic = isPublic;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
