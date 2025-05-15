package com.groupe2cs.bizyhub.chats.application.dto;

import com.groupe2cs.bizyhub.chats.domain.valueObject.*;
import com.groupe2cs.bizyhub.chats.infrastructure.entity.*;
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
	private String account;
	@Schema(description = "", example = "")
	private java.time.Instant updatedAt;
	@Schema(description = "", example = "")
	private String reference;

}
