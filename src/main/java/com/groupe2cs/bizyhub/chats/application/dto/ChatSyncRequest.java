package com.groupe2cs.bizyhub.chats.application.dto;

import java.util.List;
import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;

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

