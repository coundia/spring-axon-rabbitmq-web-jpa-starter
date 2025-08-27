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

	@Schema(description = "", example = "b79841d0-af0f-4d92-848c-13f5ff21bb69")
	private String transaction;
	@Schema(description = "", example = "031e7ecf-7884-4de3-a69f-be00a4387f45")
	private String product;
	@Schema(description = "", example = "ca4703c6-c209-4690-99eb-f9f635c30de3")
	private String label;
	@Schema(description = "", example = "78")
	private Integer quantity;
	@Schema(description = "", example = "8474d487-1c39-44ef-a7a2-e1bae6a0053c")
	private String unit;
	@Schema(description = "", example = "48cba7b0-45b9-43e3-969a-42c69273ea4b")
	private String remoteId;
	@Schema(description = "", example = "f4a17551-35bc-4e75-8798-bf3f77e503f9")
	private String localId;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "5277.17")
	private Double unitPrice;
	@Schema(description = "", example = "7298.49")
	private Double total;
	@Schema(description = "", example = "f2efafba-3855-46a8-acae-36d9fe3af378")
	private String notes;

}
