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

	@Schema(description = "", example = "4ec2a2cc-60bd-4a95-9614-017fd846e1f5")
	private String messages;

	@Schema(description = "", example = "934cde98-8fdd-44cf-a55d-521b9a32ea41")
	private String responses;

	@Schema(description = "", example = "9973915c-bc24-4519-8407-f1372b58c082")
	private String state;

	@Schema(description = "", example = "fc84edcf-3601-4231-934f-248766ddbb94")
	private String account;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "4f8e9a89-4e5b-4add-b216-6b0d3c40648e")
	private String reference;


}
