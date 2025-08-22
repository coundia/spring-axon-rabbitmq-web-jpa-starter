package com.groupe2cs.bizyhub.chats.application.dto;

import com.groupe2cs.bizyhub.chats.domain.valueObject.*;
import java.util.UUID;
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
@Schema(name = "ChatRequest", description = "Request payload for Chat operations")
public class ChatRequest implements Serializable {

	@Schema(description = "", example = "2c05ea33-7d43-4a67-93f0-28140e2c4375")
	private String messages;
	@Schema(description = "", example = "a0fff4da-4d93-4a98-ab64-4f0757e46d85")
	private String responsesJson;
	@Schema(description = "", example = "1e8a2ace-83f8-418e-b7c6-e8c0be2993fe")
	private String responses;
	@Schema(description = "", example = "d0d76e4d-8843-4dd8-a8fc-442d97de566d")
	private String state;
	@Schema(description = "", example = "80c439e2-a81c-4abd-92e1-8746b1fe763e")
	private String account;

}
