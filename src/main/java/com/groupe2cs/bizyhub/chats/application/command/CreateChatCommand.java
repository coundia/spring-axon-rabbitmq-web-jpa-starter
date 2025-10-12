package com.groupe2cs.bizyhub.chats.application.command;

import com.groupe2cs.bizyhub.chats.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateChatCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private ChatId id = ChatId.create(UUID.randomUUID().toString());
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

	public CreateChatCommand(

			ChatMessages messages,
			ChatResponsesJson responsesJson,
			ChatResponses responses,
			ChatState state,
			ChatSyncAt syncAt,
			ChatRemoteId remoteId,
			ChatLocalId localId,
			ChatAccount account,
			ChatDateTransaction dateTransaction,
			ChatCreatedBy createdBy,
			ChatTenant tenant
	) {
		this.id = ChatId.create(UUID.randomUUID().toString());

		this.messages = messages;
		this.responsesJson = responsesJson;
		this.responses = responses;
		this.state = state;
		this.syncAt = syncAt;
		this.remoteId = remoteId;
		this.localId = localId;
		this.account = account;
		this.dateTransaction = dateTransaction;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
