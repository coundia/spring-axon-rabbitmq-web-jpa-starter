package com.groupe2cs.bizyhub.chats.application.command;

import com.groupe2cs.bizyhub.chats.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateChatCommand implements Serializable {
	@TargetAggregateIdentifier
	private ChatId id;
	private ChatMessages messages;
	private ChatResponsesJson responsesJson;
	private ChatResponses responses;
	private ChatState state;
	private ChatSyncAt syncAt;
	private ChatRemoteId remoteId;
	private ChatLocalId localId;
	private ChatAccount account;
	private ChatDateTransaction dateTransaction;
	private ChatCreatedBy createdBy;
	private ChatTenant tenant;


}
