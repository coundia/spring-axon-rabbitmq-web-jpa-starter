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

	@Schema(description = "", example = "160f5c7d-e9f3-47e3-84bf-bf10b22addd8")
	private String remoteId;
	@Schema(description = "", example = "063f8827-b09b-495e-bf46-0dfe0ff77030")
	private String code;
	@Schema(description = "", example = "24574867-d1b6-468e-8988-904eaf61e217")
	private String description;
	@Schema(description = "", example = "2540.77")
	private Double amount;
	@Schema(description = "", example = "e9d0a524-d0da-4e6a-8943-d9e1cc9503ec")
	private String typeEntry;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;
	@Schema(description = "", example = "39f3e052-7247-4a04-9e0e-3ef918df3c46")
	private String status;
	@Schema(description = "", example = "49fa8b5b-359b-4be6-b4c6-749018939b67")
	private String entityName;
	@Schema(description = "", example = "1fd0a29c-f095-4436-bec1-730be887f0ab")
	private String entityId;
	@Schema(description = "", example = "4656c1cd-ea65-4cc1-94e3-2b247c35b5e8")
	private String account;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "07ca7ebb-0ff1-4b74-8edd-14a8b0488440")
	private String category;
	@Schema(description = "", example = "3d05389a-e92e-4fde-925d-3fcd930b8bca")
	private String company;
	@Schema(description = "", example = "b9747b01-7938-48fd-a52f-093abbe7cf52")
	private String customer;
	@Schema(description = "", example = "ba246795-7353-48c5-9c98-a6251244370b")
	private String debt;

}
