package com.groupe2cs.bizyhub.message.application.command;

import com.groupe2cs.bizyhub.message.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateMessageCommand implements Serializable {
	@TargetAggregateIdentifier
	private MessageId id;
	private MessageCode code;
	private MessageEmail email;
	private MessagePhone phone;
	private MessageContent content;
	private MessagePlateforme plateforme;
	private MessageSource source;
	private MessageAgent agent;
	private MessageStatus status;
	private MessageDescription description;
	private MessageIsActive isActive;
	private MessageIsDefault isDefault;
	private MessageRemoteId remoteId;
	private MessageLocalId localId;
	private MessageDepotAt depotAt;
	private MessageSyncAt syncAt;
	private MessageCreatedBy createdBy;
	private MessageTenant tenant;


}
