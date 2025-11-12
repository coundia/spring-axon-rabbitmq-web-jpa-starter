package com.groupe2cs.bizyhub.categories.domain.event;

import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCreatedEvent implements Serializable {

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


}
