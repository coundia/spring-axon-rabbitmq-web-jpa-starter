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

	@Schema(description = "", example = "061309ea-b91b-48dc-806a-2108639bb672")
	private String typeStockMovement;
	@Schema(description = "", example = "35")
	private Integer quantity;
	@Schema(description = "", example = "32fe4cc8-0070-4d45-a91c-6301c356d8b8")
	private String remoteId;
	@Schema(description = "", example = "96374164-848e-4e3d-a71b-3e060bf7e3be")
	private String company;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "cd576c80-fdc0-41c9-8320-b1721e75431f")
	private String productVariant;
	@Schema(description = "", example = "24dedb36-86cd-4a1b-918d-71352699f960")
	private String orderLineId;
	@Schema(description = "", example = "b84d7f1c-7b75-40bb-b336-935bc7a41715")
	private String discriminator;

}
