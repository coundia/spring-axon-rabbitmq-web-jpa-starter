package com.groupe2cs.bizyhub.sync.application.command;

import com.groupe2cs.bizyhub.sync.domain.valueObject.ChangeLogId;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteChangeLogCommand implements Serializable {
	@TargetAggregateIdentifier
	private ChangeLogId id;


}
