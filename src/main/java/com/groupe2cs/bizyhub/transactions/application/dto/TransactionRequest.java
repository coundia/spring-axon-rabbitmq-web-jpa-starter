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

	@Schema(description = "", example = "79a0fadb-801c-4334-bca7-2cd8781eb54b")
	private String name;

	@Schema(description = "", example = "6122.16")
	private Double amount;

	@Schema(description = "", example = "e3e4cf67-0df3-44dc-ac08-ce059de6d8d6")
	private String details;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "a5aa8333-dc8a-472e-bc57-32aaac426f9d")
	private String account;

	@Schema(description = "", example = "b6237d92-90b2-4da8-92f4-faaa9891fdd8")
	private String category;

	@Schema(description = "", example = "023c3efe-7b1f-4a68-97b7-bf11407a4d73")
	private String typeTransactionRaw;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "043e28a7-58b7-4c50-8afd-b5106f72f53b")
	private String reference;


}
