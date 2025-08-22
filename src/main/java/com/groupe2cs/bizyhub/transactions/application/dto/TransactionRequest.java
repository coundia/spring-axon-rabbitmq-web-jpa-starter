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
@Schema(name = "TransactionRequest", description = "Request payload for Transaction operations")
public class TransactionRequest implements Serializable {

	@Schema(description = "", example = "25efecad-0494-4918-94ed-ce51d774f34a")
	private String name;
	@Schema(description = "", example = "8933.52")
	private Double amount;
	@Schema(description = "", example = "7b38909f-67ae-40ca-9cc5-17f24b701fd0")
	private String details;
	@Schema(description = "", example = "true")
	private Boolean isActive;
	@Schema(description = "", example = "0803e657-d70b-4b22-81f6-1f61f58491c7")
	private String account;
	@Schema(description = "", example = "5c2ea2b9-bd7c-45d9-b96d-dc4a2191969c")
	private String category;
	@Schema(description = "", example = "04822c99-57be-429c-816a-40cbb2c41551")
	private String typeTransactionRaw;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;

}
