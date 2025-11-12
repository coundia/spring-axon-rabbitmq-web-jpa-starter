package com.groupe2cs.bizyhub.message.application.command;

import com.groupe2cs.bizyhub.message.domain.valueObject.MessageId;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteMessageCommand implements Serializable {
	@TargetAggregateIdentifier
	private MessageId id;


}
