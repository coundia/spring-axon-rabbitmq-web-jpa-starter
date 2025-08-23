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

	@Schema(description = "", example = "45df84cd-dac9-4f96-aa94-c2f6d6202ac9")
	private String transaction;
	@Schema(description = "", example = "44a46599-a5ca-4825-8faf-73c458429133")
	private String product;
	@Schema(description = "", example = "45512d88-eb64-426e-8428-ff5edc21732c")
	private String label;
	@Schema(description = "", example = "58")
	private Integer quantity;
	@Schema(description = "", example = "0eef2149-83a5-4a2b-adcb-bbd181eebdf5")
	private String unit;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "4268.37")
	private Double unitPrice;
	@Schema(description = "", example = "5672.48")
	private Double total;
	@Schema(description = "", example = "af0c9e04-fab7-4a73-924c-72703c1a5bee")
	private String notes;

}
