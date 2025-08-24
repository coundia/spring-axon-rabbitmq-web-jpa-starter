package com.groupe2cs.bizyhub.transactions.application.dto;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
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
@Schema(name = "TransactionUserRequest", description = "Request payload for TransactionUser operations")
public class TransactionUserRequest implements Serializable {

	@Schema(description = "", example = "15de059d-0ace-4757-8743-f3e70c58e8bb")
	private String name;
	@Schema(description = "", example = "f6152eef-b8f9-4c71-b966-519243b11a1b")
	private String remoteId;
	@Schema(description = "", example = "2e7a71b6-66d7-41ab-8842-dcccc4466653")
	private String transaction;
	@Schema(description = "", example = "2992f0dc-17ba-4b22-9496-a64a17d4a918")
	private String user;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "d7c1f6a4-a010-472a-aa8e-1832591e1747")
	private String username;
	@Schema(description = "", example = "fced393f-5592-4617-8e33-94950a2c82c5")
	private String details;
	@Schema(description = "", example = "true")
	private Boolean isActive;

}
