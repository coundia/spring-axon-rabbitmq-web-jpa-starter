package com.groupe2cs.bizyhub.fileManager.application.command;

import com.groupe2cs.bizyhub.fileManager.domain.valueObject.FileManagerId;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteFileManagerCommand implements Serializable {
	@TargetAggregateIdentifier
	private FileManagerId id;


}
