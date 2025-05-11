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

	@Schema(description = "", example = "0f07c17f-9914-4a0e-ab08-e9d5841003c5")
	private String name;

	@Schema(description = "", example = "80a6c2f7-a8a0-4852-a46e-44a87feddd6c")
	private String transaction;

	@Schema(description = "", example = "4d9ed5e9-a586-470c-a498-d7554bf48fd2")
	private String user;

	@Schema(description = "", example = "aeab719d-0b62-444b-b8cd-e2ab66bf659d")
	private String username;

	@Schema(description = "", example = "ac31aba7-7fd3-4758-9702-ca87098360ef")
	private String details;

	@Schema(description = "", example = "false")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "492eed68-1274-432a-b744-c4f1655e8714")
	private String reference;


}
