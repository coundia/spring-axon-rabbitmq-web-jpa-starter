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

	@Schema(description = "", example = "c439d621-9d87-4b64-b9fd-a48681205550")
	private String name;
	@Schema(description = "", example = "7460.3")
	private Double amount;
	@Schema(description = "", example = "906e5d78-2258-4aee-bfa1-ce807b394e3d")
	private String remoteId;
	@Schema(description = "", example = "8bb7ecb7-aabe-48c6-91d4-4042d99f8a2a")
	private String localId;
	@Schema(description = "", example = "0138da6d-2eeb-4514-a72c-7c3080bf76a5")
	private String details;
	@Schema(description = "", example = "true")
	private Boolean isActive;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "a149923c-313a-4cb1-bc8d-e1266dd384db")
	private String account;
	@Schema(description = "", example = "8dbe2607-98ab-49d1-98ad-9e5ce182b006")
	private String category;
	@Schema(description = "", example = "48b630c5-48d0-4d0e-81fa-7a18db7f0130")
	private String typeEntry;
	@Schema(description = "", example = "b79c5aef-54e2-47f8-b0fd-83d826434eab")
	private String typeTransactionRaw;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;

}
