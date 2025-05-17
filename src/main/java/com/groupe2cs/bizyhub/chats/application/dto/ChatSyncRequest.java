package com.groupe2cs.bizyhub.chats.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "ChatSyncRequest", description = "Request payload for synchronizing chats")
public class ChatSyncRequest implements Serializable {

	@Schema(description = "Batch of chat deltas")
	private List<ChatDeltaDto> deltas;
}

