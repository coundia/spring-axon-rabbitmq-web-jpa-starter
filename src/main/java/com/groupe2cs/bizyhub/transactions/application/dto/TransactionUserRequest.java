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

	@Schema(description = "", example = "535c8d25-e0e0-4993-aa35-888bf0222ad5")
	private String name;
	@Schema(description = "", example = "e46ecea5-52e0-4b5a-8e31-ecb4ad0be6ca")
	private String transaction;
	@Schema(description = "", example = "f767e528-3750-44bf-8832-425986307bca")
	private String user;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "45df1cd7-abbd-4302-8c06-74b4c516d287")
	private String username;
	@Schema(description = "", example = "8ef9638b-9457-4390-bc43-faaf5d383122")
	private String details;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
