package com.groupe2cs.bizyhub.categories.application.command;

import com.groupe2cs.bizyhub.categories.domain.valueObject.*;

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
public class CreateCategoryCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private CategoryId id = CategoryId.create(UUID.randomUUID().toString());
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

	public CreateCategoryCommand(

			CategoryCode code,
			CategoryName name,
			CategoryRemoteId remoteId,
			CategoryLocalId localId,
			CategoryAccount account,
			CategoryStatus status,
			CategoryIsPublic isPublic,
			CategoryDescription description,
			CategoryTypeEntry typeEntry,
			CategoryVersion version,
			CategorySyncAt syncAt,
			CategoryCreatedBy createdBy,
			CategoryTenant tenant
	) {
		this.id = CategoryId.create(UUID.randomUUID().toString());

		this.code = code;
		this.name = name;
		this.remoteId = remoteId;
		this.localId = localId;
		this.account = account;
		this.status = status;
		this.isPublic = isPublic;
		this.description = description;
		this.typeEntry = typeEntry;
		this.version = version;
		this.syncAt = syncAt;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
