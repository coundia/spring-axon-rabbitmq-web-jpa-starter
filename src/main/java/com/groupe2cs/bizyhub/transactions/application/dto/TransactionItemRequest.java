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

	@Schema(description = "", example = "a8d54928-07c4-4122-88ed-34aecd2105a4")
	private String transaction;
	@Schema(description = "", example = "39af2b0a-8d4d-4050-870d-8447eb66e5b2")
	private String product;
	@Schema(description = "", example = "3a5908cd-e375-4da9-81ff-2f57ff57d95e")
	private String label;
	@Schema(description = "", example = "37")
	private Integer quantity;
	@Schema(description = "", example = "1f3b0795-5496-4234-8d72-72f925fa667c")
	private String unit;
	@Schema(description = "", example = "1cf337af-4846-41e6-a30a-3fbf1cabfa6e")
	private String remoteId;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "205.59")
	private Double unitPrice;
	@Schema(description = "", example = "2368.62")
	private Double total;
	@Schema(description = "", example = "405f3e76-56cb-4520-b2b4-56ab0ea9f47f")
	private String notes;

}
