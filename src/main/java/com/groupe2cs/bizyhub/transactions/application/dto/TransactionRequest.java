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

	@Schema(description = "", example = "d2d90088-f4d8-417a-8371-12b3b2bd939d")
	private String name;
	@Schema(description = "", example = "1564.12")
	private Double amount;
	@Schema(description = "", example = "80fee18d-26bf-4e4f-ac69-7e5d4ff08ed5")
	private String remoteId;
	@Schema(description = "", example = "5fe60f9a-9331-4dd6-b783-e59752033b50")
	private String details;
	@Schema(description = "", example = "true")
	private Boolean isActive;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "2340ca6a-94ce-4e73-a510-4c824ee5bf14")
	private String account;
	@Schema(description = "", example = "9769d07b-3742-4fa2-a2ff-7ff764b1014b")
	private String category;
	@Schema(description = "", example = "a0554c1b-97fa-4bc6-874f-e54f32ceac8d")
	private String typeEntry;
	@Schema(description = "", example = "e1b23846-518f-4a70-aa81-74d8fdb66201")
	private String typeTransactionRaw;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;

}
