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

	@Schema(description = "", example = "9e6c5d67-72af-41b1-aa73-d777502e2034")
	private String messages;

	@Schema(description = "", example = "b3cb1833-3ce9-446c-9337-6fb267ab9f39")
	private String responses;

	@Schema(description = "", example = "ca16aa72-66e9-409b-8095-3c5d9e9b169c")
	private String state;

	@Schema(description = "", example = "74e4e312-5791-4dd3-a710-640f8600bc09")
	private String account;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "f2ee4e10-894d-4d6a-9fd5-c57adab7c6cb")
	private String reference;


}
