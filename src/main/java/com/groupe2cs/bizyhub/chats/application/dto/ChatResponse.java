package com.groupe2cs.bizyhub.chats.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "ChatResponse", description = "Response payload for Chat")
public class ChatResponse implements Serializable {

	@Schema(description = "", example = "")
	private String id;
	@Schema(description = "", example = "")
	private String messages;
	@Schema(description = "", example = "")
	private String responsesJson;
	@Schema(description = "", example = "")
	private String responses;
	@Schema(description = "", example = "")
	private String state;
	@Schema(description = "", example = "")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "")
	private String remoteId;
	@Schema(description = "", example = "")
	private String localId;
	@Schema(description = "", example = "")
	private String account;
	@Schema(description = "", example = "")
	private java.time.Instant dateTransaction;
	@Schema(description = "", example = "")
	private String createdBy;
	@Schema(description = "", example = "")
	private String tenant;

}
