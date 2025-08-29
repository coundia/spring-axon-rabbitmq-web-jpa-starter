package com.groupe2cs.bizyhub.fileManager.application.command;

import com.groupe2cs.bizyhub.fileManager.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateFileManagerCommand implements Serializable {
	@TargetAggregateIdentifier
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


}
