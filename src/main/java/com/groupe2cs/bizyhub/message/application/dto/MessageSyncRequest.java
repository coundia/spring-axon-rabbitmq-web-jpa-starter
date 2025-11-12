package com.groupe2cs.bizyhub.message.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Schema(name = "MessageSyncRequest", description = "Request payload for synchronizing messages")
public class MessageSyncRequest implements Serializable {

	@Schema(description = "Batch of message deltas")
	private List<MessageDeltaDto> deltas;
}

