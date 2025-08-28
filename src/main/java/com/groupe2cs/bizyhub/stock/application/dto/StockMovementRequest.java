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

	@Schema(description = "", example = "a1d8d9f4-cc57-4afa-b6e7-2db245df30c8")
	private String typeStockMovement;
	@Schema(description = "", example = "77")
	private Integer quantity;
	@Schema(description = "", example = "c01860a6-eb8a-4c6c-bf4e-483b4ee92419")
	private String remoteId;
	@Schema(description = "", example = "c564b443-3d21-4024-8f61-52d2054beb65")
	private String localId;
	@Schema(description = "", example = "aec83dd9-c7f8-4ad5-926f-6c3ea3988b04")
	private String account;
	@Schema(description = "", example = "8b149339-7c49-412f-b196-665bc621c818")
	private String company;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "0eb7029a-01e9-4d71-b513-1dcd3c2db576")
	private String productVariant;
	@Schema(description = "", example = "9b81fe7b-2e90-44f0-9aba-6fe431256a1f")
	private String orderLineId;
	@Schema(description = "", example = "2bbf26b0-02b4-46a7-bec4-31382262a33b")
	private String discriminator;

}
