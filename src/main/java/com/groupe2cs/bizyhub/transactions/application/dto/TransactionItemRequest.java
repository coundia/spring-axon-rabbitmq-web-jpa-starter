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

	@Schema(description = "", example = "a54b08c5-119f-478d-bf72-db84886ba566")
	private String transaction;
	@Schema(description = "", example = "4f3d2d73-5c7f-4291-b9e9-82f03564b982")
	private String product;
	@Schema(description = "", example = "906fe416-aff8-4e3d-a83b-97ce3d6a74f1")
	private String label;
	@Schema(description = "", example = "46")
	private Integer quantity;
	@Schema(description = "", example = "c4d3a7da-3563-4e46-b28f-aa915c1f96cc")
	private String unit;
	@Schema(description = "", example = "862114d3-337c-4f64-82ca-0fbe396b1ed3")
	private String account;
	@Schema(description = "", example = "16060674-75bf-4165-8b81-789b83ec9b07")
	private String remoteId;
	@Schema(description = "", example = "3e38f002-de43-48cd-99ed-099a3df7d47c")
	private String localId;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "8070.51")
	private Double unitPrice;
	@Schema(description = "", example = "4991.69")
	private Double total;
	@Schema(description = "", example = "cbc9bf24-2dcc-40f0-b6d3-8d95bbb10a3b")
	private String notes;

}
