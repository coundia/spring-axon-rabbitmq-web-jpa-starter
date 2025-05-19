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

	@Schema(description = "", example = "cad20903-b626-40e8-8262-6a2d673dbc7e")
	private String name;

	@Schema(description = "", example = "10cfe33f-ebf4-4981-aa97-2000711a34f5")
	private String transaction;

	@Schema(description = "", example = "d07a13e9-0223-4b5e-8fba-08e941fd280c")
	private String user;

	@Schema(description = "", example = "0f318158-fd2c-4ed9-87c8-57d9a5c6b4d5")
	private String username;

	@Schema(description = "", example = "10e42ebb-3211-4e4d-aede-610910875906")
	private String details;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "9ab10820-2a91-4aed-9003-ddb11769e47b")
	private String reference;


}
