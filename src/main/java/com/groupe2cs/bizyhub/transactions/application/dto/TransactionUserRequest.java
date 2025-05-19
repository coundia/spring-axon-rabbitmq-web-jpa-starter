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

	@Schema(description = "", example = "40431673-7b7b-4c7e-8881-93dc815541d7")
	private String name;

	@Schema(description = "", example = "de134e88-7ed6-4b32-b0d7-8174824b0c90")
	private String transaction;

	@Schema(description = "", example = "3a903529-c46d-4283-813d-1db9e9d3ac7c")
	private String user;

	@Schema(description = "", example = "bec01e55-dad8-44c7-981f-0574a0d9e4d5")
	private String username;

	@Schema(description = "", example = "c72109dd-3951-4880-92cf-9292badc956d")
	private String details;

	@Schema(description = "", example = "false")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "14a6590e-a74d-4072-b6f9-fda5dcf58edb")
	private String reference;


}
