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
@Schema(name = "TransactionEntryRequest", description = "Request payload for TransactionEntry operations")
public class TransactionEntryRequest implements Serializable {

	@Schema(description = "", example = "a1cf04dd-7a61-4433-ac1e-68ec54b135fe")
	private String remoteId;
	@Schema(description = "", example = "9b7b63e2-370a-4576-ae35-f1782f982f1f")
	private String localId;
	@Schema(description = "", example = "eba2b2a9-91e5-4182-8221-63bbd36ce483")
	private String code;
	@Schema(description = "", example = "1f3df4e6-9cb1-473d-97c4-3796cb912bd9")
	private String description;
	@Schema(description = "", example = "3630.17")
	private Double amount;
	@Schema(description = "", example = "3663292d-098c-4611-b8ee-37436d0bbf33")
	private String typeEntry;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;
	@Schema(description = "", example = "792d1199-9219-40bd-bdf8-75b68fd8122e")
	private String status;
	@Schema(description = "", example = "c1913aa1-4261-4705-915b-a2f7b064ff1e")
	private String entityName;
	@Schema(description = "", example = "8f065e09-26fa-49ae-9864-54a949a0c02a")
	private String entityId;
	@Schema(description = "", example = "1f872867-5200-4258-a9e7-094043fe5cfc")
	private String account;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "ff4d65d2-966a-4c8e-80b5-87c25fa4b27f")
	private String category;
	@Schema(description = "", example = "00def889-e4df-4e45-a6e0-ee6cef35a28f")
	private String company;
	@Schema(description = "", example = "81e0feaa-431f-4bd6-8484-35f68d5402d9")
	private String customer;
	@Schema(description = "", example = "7fd8dd2b-4f5d-4459-8ede-009faa39c58c")
	private String debt;

}
