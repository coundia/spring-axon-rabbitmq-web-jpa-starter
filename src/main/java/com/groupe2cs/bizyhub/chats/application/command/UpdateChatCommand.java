package com.groupe2cs.bizyhub.chats.application.command;

import com.groupe2cs.bizyhub.chats.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import java.util.Date;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.util.UUID;


import java.time.*;
import java.util.*;

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
