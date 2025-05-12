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

	@Schema(description = "", example = "4f18eae8-4f12-4d04-84fb-76a32250445f")
	private String name;

	@Schema(description = "", example = "164.41")
	private Double amount;

	@Schema(description = "", example = "c466b64e-6fb9-4f5a-afa1-2fe10ce0e5d8")
	private String details;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "84894832-aa22-4f5c-9a2f-64274bf1a607")
	private String account;

	@Schema(description = "", example = "66a4403a-3389-4939-b8d7-106a001af527")
	private String category;

	@Schema(description = "", example = "71ab1fa4-8f78-44f2-aa66-d8c4990681ba")
	private String typeTransactionRaw;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "2088715c-b4f8-4ab6-8ea0-e6b51d579ab6")
	private String reference;


}
