package com.groupe2cs.bizyhub.chats.domain.event;

import com.groupe2cs.bizyhub.chats.domain.valueObject.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatCreatedEvent implements Serializable {

	private ChatId id;
	private ChatMessages messages;
	private ChatResponsesJson responsesJson;
	private ChatResponses responses;
	private ChatState state;
	private ChatAccount account;
	private ChatUpdatedAt updatedAt;
	private ChatReference reference;
	private ChatCreatedBy createdBy;
	private ChatTenant tenant;


}
