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
@Schema(name = "TransactionItemRequest", description = "Request payload for TransactionItem operations")
public class TransactionItemRequest implements Serializable {

	@Schema(description = "", example = "eaba3b22-f72d-4376-8ce0-ec88232ee8ba")
	private String transaction;
	@Schema(description = "", example = "d55562bf-3513-4435-8339-082faf5fd7c7")
	private String product;
	@Schema(description = "", example = "e603ed61-8019-4c7f-94ca-6960026d20b7")
	private String label;
	@Schema(description = "", example = "28")
	private Integer quantity;
	@Schema(description = "", example = "c02dd6dd-5e2c-4507-a3ea-bcf919259ae5")
	private String unit;
	@Schema(description = "", example = "b012fad6-fe66-436f-a7ed-d6e74dab3b56")
	private String account;
	@Schema(description = "", example = "e8de08c1-3668-43e5-98cc-b3ee23dfbd01")
	private String remoteId;
	@Schema(description = "", example = "fca52e25-6a84-41c8-97b6-be2c2a498d64")
	private String localId;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "2466.81")
	private Double unitPrice;
	@Schema(description = "", example = "818.9")
	private Double total;
	@Schema(description = "", example = "1e414b28-04f8-47ba-84e8-774710cb5561")
	private String notes;

}
