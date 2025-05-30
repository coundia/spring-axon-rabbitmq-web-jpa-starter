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
	private ChatAccount account;
	private ChatFiles files;
	private ChatCreatedBy createdBy;
	private ChatTenant tenant;

	public CreateChatCommand(

			ChatMessages messages,
			ChatResponsesJson responsesJson,
			ChatResponses responses,
			ChatState state,
			ChatAccount account,
			ChatFiles files,
			ChatCreatedBy createdBy,
			ChatTenant tenant
	) {
		this.id = ChatId.create(UUID.randomUUID().toString());

		this.messages = messages;
		this.responsesJson = responsesJson;
		this.responses = responses;
		this.state = state;
		this.account = account;
		this.files = files;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
