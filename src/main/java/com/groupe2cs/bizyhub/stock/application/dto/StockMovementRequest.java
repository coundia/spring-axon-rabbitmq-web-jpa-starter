package com.groupe2cs.bizyhub.stock.application.dto;

import com.groupe2cs.bizyhub.stock.domain.valueObject.*;
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
@Schema(name = "StockMovementRequest", description = "Request payload for StockMovement operations")
public class StockMovementRequest implements Serializable {

	@Schema(description = "", example = "872e9b82-a178-4808-ab2f-4895c7720373")
	private String typeStockMovement;
	@Schema(description = "", example = "96")
	private Integer quantity;
	@Schema(description = "", example = "d9fb905e-06f5-45e4-974f-78a65fea3e57")
	private String remoteId;
	@Schema(description = "", example = "6238c71e-efd1-456c-8f7c-907e64ef6313")
	private String localId;
	@Schema(description = "", example = "30eee28a-2974-4ece-bc5b-fdefb6f86926")
	private String company;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "e4a9f81a-0e3f-4ca6-a7b1-ca18c28e3e89")
	private String productVariant;
	@Schema(description = "", example = "d54a6fae-5d20-4f1d-9764-6baf7ada707a")
	private String orderLineId;
	@Schema(description = "", example = "3dbbebac-3dd6-4054-b6f1-4956f1dce164")
	private String discriminator;

}
