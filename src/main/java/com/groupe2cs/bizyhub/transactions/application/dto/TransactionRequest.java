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

	@Schema(description = "", example = "6a6e34b5-fe21-499b-bc7f-9d987546af02")
	private String name;

	@Schema(description = "", example = "8680.88")
	private Double amount;

	@Schema(description = "", example = "3f7d38fc-0232-49d4-a922-02210fe2368c")
	private String details;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "cf850086-88c0-4cd9-abd6-624d2e186b1f")
	private String account;

	@Schema(description = "", example = "73dac168-b6c5-4da4-a282-0745b9ec11db")
	private String category;

	@Schema(description = "", example = "4058bc96-3e28-48dc-aa1d-75710c7f7779")
	private String typeTransactionRaw;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "b9377029-95a7-4b5f-9ac8-0b445dfad595")
	private String reference;


}
