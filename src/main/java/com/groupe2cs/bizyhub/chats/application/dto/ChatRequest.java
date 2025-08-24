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

	@Schema(description = "", example = "b772254f-04bc-48c8-849a-26dd75294132")
	private String messages;
	@Schema(description = "", example = "728b36b1-5b7d-4ca3-9972-ee35272cb86f")
	private String responsesJson;
	@Schema(description = "", example = "6a20c4bb-1390-4891-9d31-9294416690be")
	private String responses;
	@Schema(description = "", example = "cc5e2cb1-9f2b-4fde-be1d-ef4397fb0e6d")
	private String state;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "e6d330fb-9431-4a01-ab1d-f6115a8ae773")
	private String remoteId;
	@Schema(description = "", example = "fb0a76d9-8105-46d7-8f05-d5065c96e752")
	private String localId;
	@Schema(description = "", example = "0e2879b2-a6c8-4cc4-a8f5-233b247f9a22")
	private String account;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;

}
