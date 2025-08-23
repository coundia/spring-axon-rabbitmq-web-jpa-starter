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

	@Schema(description = "", example = "c336f3d9-0733-4c68-99fa-1c4d3c79c1ab")
	private String typeStockMovement;
	@Schema(description = "", example = "15")
	private Integer quantity;
	@Schema(description = "", example = "0f65a658-c374-4f45-8fdd-c0b2d90be7a5")
	private String company;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "40edaf09-922f-41ae-b6d5-95a07fb57976")
	private String productVariant;
	@Schema(description = "", example = "246b707e-171f-4ff7-97ca-745f7e209948")
	private String orderLineId;
	@Schema(description = "", example = "336f28b9-bc7e-43ae-bff2-41a69b19967e")
	private String discriminator;

}
