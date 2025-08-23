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

	@Schema(description = "", example = "26346248-a8c5-44be-809a-28e87dffd5fa")
	private String name;
	@Schema(description = "", example = "3524.41")
	private Double amount;
	@Schema(description = "", example = "e8c23087-5302-47bb-855e-f420bbac8f85")
	private String details;
	@Schema(description = "", example = "true")
	private Boolean isActive;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "14bdbdff-39a9-4980-9d3e-516482a849ab")
	private String account;
	@Schema(description = "", example = "bbf9806b-deef-4966-845d-59b9f5e3440c")
	private String category;
	@Schema(description = "", example = "8f060197-6e92-4d60-a774-0be097da8817")
	private String typeTransactionRaw;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;

}
