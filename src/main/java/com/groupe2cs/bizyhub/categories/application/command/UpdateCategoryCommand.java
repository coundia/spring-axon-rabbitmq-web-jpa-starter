package com.groupe2cs.bizyhub.categories.application.command;

import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCategoryCommand implements Serializable {
	@TargetAggregateIdentifier
	private CategoryId id;
	private CategoryCode code;
	private CategoryName name;
	private CategoryRemoteId remoteId;
	private CategoryLocalId localId;
	private CategoryAccount account;
	private CategoryDescription description;
	private CategoryTypeEntry typeEntry;
	private CategoryVersion version;
	private CategorySyncAt syncAt;
	private CategoryCreatedBy createdBy;
	private CategoryTenant tenant;


}
