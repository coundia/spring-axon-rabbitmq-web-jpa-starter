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

	@Schema(description = "", example = "976d8084-ea00-456a-8a0f-0c8ce099bf70")
	private String name;
	@Schema(description = "", example = "5fec770c-7f95-4389-8d93-8f0655177a05")
	private String remoteId;
	@Schema(description = "", example = "24c575e2-2cf6-4ec5-a4c9-1c8cdf5f564a")
	private String localId;
	@Schema(description = "", example = "122fd679-b0ee-49b6-aee2-2ee7af59bad9")
	private String transaction;
	@Schema(description = "", example = "1a0ca178-0588-4314-8c9b-6b0616484b2e")
	private String user;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "e559345c-be72-4cd3-8fc0-efef215d87fa")
	private String username;
	@Schema(description = "", example = "885a2fab-9c52-4b48-bc91-d1cf6b22625c")
	private String details;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
