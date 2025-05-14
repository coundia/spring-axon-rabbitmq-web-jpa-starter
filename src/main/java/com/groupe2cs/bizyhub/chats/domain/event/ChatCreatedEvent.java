package com.groupe2cs.bizyhub.chats.domain.event;

	import com.groupe2cs.bizyhub.chats.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatCreatedEvent implements Serializable {

	private ChatId id;
	private ChatMessages messages;
	private ChatResponses responses;
	private ChatState state;
	private ChatAccount account;
	private ChatUpdatedAt updatedAt;
	private ChatReference reference;
	private ChatCreatedBy createdBy;
	private ChatTenant tenant;



}
